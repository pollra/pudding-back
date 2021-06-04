package com.pollra.pudding.domain.acl.entity;

import com.pollra.pudding.domain.acl.entity.enumerated.ResourceCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

/**
 * @since       2021.06.03
 * @author      pollra
 * @description 특정 자원에 대한 접근 권한을 부여하는 객체를 생성합니다.
 * @constructor
 *       @param @param resourceId    0이 입력될 경우 모든 자원에 접근할 수 있음을 의미합니다.
 *       @param @param resourceCode  커스텀 접근 제한을 부여할 자원 정보입니다.
 **********************************************************************************************************************/
@Embeddable
@NoArgsConstructor(access=AccessLevel.PROTECTED)
public class Resource {

    private Long resourceId;

    @Enumerated(EnumType.STRING)
    private ResourceCode resourceCode;

    protected Resource(final Long resourceId, final ResourceCode resourceCode) {
        if(Objects.isNull(resourceCode)) throw new IllegalArgumentException("접근 제한 리소스 코드는 Null 일 수 없습니다.");
        this.resourceId   = resourceId;
        this.resourceCode = resourceCode;
    }
}
