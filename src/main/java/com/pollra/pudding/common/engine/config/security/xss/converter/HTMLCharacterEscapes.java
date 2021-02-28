package com.pollra.pudding.common.engine.config.security.xss.converter;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.LookupTranslator;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2021.02.20
 * @author pollra
 * @doc https://homoefficio.github.io/2016/11/21/Spring에서-JSON에-XSS-방지-처리-하기/
 * @description HTMLCharacterEscapes
 **********************************************************************************************************************/
public class HTMLCharacterEscapes extends CharacterEscapes {

    private final int[] asciiEscapes;
    private final CharSequenceTranslator translator;

    public HTMLCharacterEscapes() {
        // 1. XSS 방지 처리할 특수 문자 지정
        asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
        asciiEscapes['<' ] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['>' ] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['&' ] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\"'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['(' ] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes[')' ] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['#' ] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;

        Map<CharSequence, CharSequence> escapeSequence = new HashMap<>();
        escapeSequence.put("(", "&#40;");
        escapeSequence.put(")", "&#41;");
        escapeSequence.put("#", "&#35;");
        escapeSequence.put("'", "&#39;");
        // 2. XSS 방지 처리 특수 문자 인코딩 값 지정
        translator = new AggregateTranslator(
                 new LookupTranslator(EntityArrays.BASIC_ESCAPE          ) // <, >, &, " 는 여기에 포함됨
                ,new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE      ) // 발음기호 변경
                ,new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE) // 추가 문자 이스케이프
                ,new LookupTranslator(escapeSequence)
        );
    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        return new SerializedString(translator.translate(Character.toString((char) ch)));
    }
}
