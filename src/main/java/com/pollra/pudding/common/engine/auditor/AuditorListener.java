package com.pollra.pudding.common.engine.auditor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.persistence.Table;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since       2021.01.29
 * @author      pollra
 * @description AuditorListener
 **********************************************************************************************************************/
@Slf4j
@Component
public class AuditorListener {

    @EventListener
    public void onEvent(AuditorEvent event) {
        recursive(event.getSource());
    }

    public void recursive(Object source) {
        if(Objects.nonNull(source)) {
            List<Field> fieldsOfClass      = Arrays.asList(Optional.ofNullable(source.getClass().getDeclaredFields()).orElse(new Field[]{}));
            List<Field> fieldsOfSuperClass = Arrays.asList(Optional.ofNullable(source.getClass().getSuperclass().getDeclaredFields()).orElse(new Field[]{}));

            for(Field field : Stream.of(fieldsOfClass, fieldsOfSuperClass)
                    .flatMap(f -> f.stream())
                    .filter (f -> BooleanUtils.isFalse(f.getType().isEnum()))
                    .filter (f -> BooleanUtils.isFalse(f.getType().isPrimitive()))
                    .collect(Collectors.toList())) {
                ReflectionUtils.makeAccessible(field);
                setValueIfCreatedDate(field, source);
                executeRecursiveIfIncludedPackage(field, source);
            }
        }
    }

    private void setValueIfCreatedDate(Field field, Object source) {
        if(ObjectUtils.anyNotNull(field.getAnnotation(CreatedDate.class))) {
            ReflectionUtils.setField(field, source, LocalDateTime.now());
        }
    }

    @SneakyThrows
    private void executeRecursiveIfIncludedPackage(Field field, Object source) {
        Object object = field.get(source);
        if(Objects.nonNull(object)) {
            if(ObjectUtils.allNotNull(field.getType().getAnnotation(Table.class))) {
                recursive(field.get(source));
            }
        }
    }
}
