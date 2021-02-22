package com.pollra.pudding.common.engine.encrypt.jwt.algorithm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollra.pudding.common.engine.helper.property.PropertyHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pollra
 * @description JwtEncryptionAlgorithm
 * @since 2021.02.05
 **********************************************************************************************************************/
@Component
@RequiredArgsConstructor
public class JsonWebTokenAlgorithm {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public String createToken(Object data){

        Map<String, Object> headers = new HashMap<>();
        headers.put("type"      , "JWT"     );
        headers.put("algorithm" , "HS256"   );

        Map<String, Object> payloads = new HashMap<>();
        payloads.put("data", objectMapper.writeValueAsString(data));

        long expiredTime = 1000 * 60L * 60L * 2L;
        Date expiredDate = new Date();
        expiredDate.setTime(expiredDate.getTime() + expiredTime);

        return Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setSubject("test") // 토큰 용도
                .setExpiration(expiredDate) // 토큰 만료 시간
                .signWith(SignatureAlgorithm.HS256, PropertyHelper.getProperty().getJwt().getKey().getBytes()) // HS256과 Key로 Sign
                .compact(); // 토큰 생성
    }

    /**
     * 토큰 검증
     * @param jwt
     * @return
     * @throws UnsupportedEncodingException : 지원되지 않는 인코딩
     * @throws ExpiredJwtException          : 만료된 토큰
     */
    @SneakyThrows
    public Map<String, Object> verifyJWT(String jwt) {
        Map<String, Object> claimMap = null;
        Claims claims = Jwts.parser()
                .setSigningKey(PropertyHelper.getProperty().getJwt().getKey().getBytes("UTF-8")) // Set Key
                .parseClaimsJws(jwt) // 파싱 및 검증, 실패 시 에러
                .getBody();

        claimMap = claims;
        //Date expiration = claims.get("exp", Date.class);
        //String data = claims.get("data", String.class);
        return claimMap;
    }
}