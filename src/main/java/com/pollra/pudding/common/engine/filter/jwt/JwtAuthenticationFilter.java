package com.pollra.pudding.common.engine.filter.jwt;

import com.pollra.pudding.auth.bisiness.account.adapter.CredentialAdapter;
import com.pollra.pudding.common.engine.encrypt.jwt.algorithm.JsonWebTokenAlgorithm;
import com.pollra.pudding.common.engine.filter.jwt.domain.Credential;
import com.pollra.pudding.common.engine.filter.jwt.wrapper.HttpRequestWithModifiableParameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author pollra
 * @description JwtAuthenticationFilter
 * @since 2021.02.23
 **********************************************************************************************************************/
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {

    private static final String JWT_NAME = "pudding-syrup";
    private final JsonWebTokenAlgorithm jsonWebTokenAlgorithm;
    private final CredentialAdapter credentialAdapter;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpRequestWithModifiableParameters param = new HttpRequestWithModifiableParameters(req);

        Enumeration parameterNames = request.getParameterNames();
        String paramName = "";
        String paramVal = "";

        boolean whetherCookieExists = false;

        while (parameterNames.hasMoreElements()) {
            paramName = (String) parameterNames.nextElement();
            String[] arrParamVal = request.getParameterValues(paramName);

            // 넘어온 param이 배열이 아님
            if (arrParamVal.length == 1) {
                paramVal = arrParamVal[0];
                log.debug("SecuValidFilter => paramName: " + paramName + ", paramVal: " + paramVal);
                // 필터링 작업
                Cookie[] cookies = ((HttpServletRequest) request).getCookies();
                if(cookies == null) {
                    whetherCookieExists = false;
                    log.info("[cookie] 쿠키가 존재하지 않습니다. 응답 시 쿠키를 생성합니다.");
                    param.setParameter("credential.name", "GUEST");
                    param.setParameter("credential.role", "GUEST");
                    credentialAdapter.authentication(Credential.builder()
                            .name("GUEST")
                            .role()
                            .build());

                } else for (Cookie cookie : cookies) {
                    whetherCookieExists = true;
                    if( ! cookie.getName().equals(JWT_NAME)) continue;
                    Map<String, Object> stringObjectMap = jsonWebTokenAlgorithm.verifyJWT(cookie.getValue());
                    param.setParameter("credential.name", StringUtils.defaultIfBlank(stringObjectMap.get("user").toString(), ""));
                    param.setParameter("credential.role", StringUtils.defaultIfBlank(stringObjectMap.get("user").toString(), ""));
                }
                param.setParameter(paramName, paramVal); // 값 넣는다
            } else { // 넘어온 배열이 param 임

            }
        }

        request = (HttpServletRequest)param;
        parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            paramName = (String) parameterNames.nextElement();
            String[] arrParamVal = request.getParameterValues(paramName);

            if(arrParamVal.length == 1) {
                log.debug("TestFilter after =>>>>> request.get: "+request.getParameter(paramName));
            }
        }

        // Read request.getBody() as many time you need
        chain.doFilter(request, response);

        HttpServletResponse httpServletResponse = new HttpServletResponseWrapper((HttpServletResponse) response);

        if(whetherCookieExists) {
            Credential credential = Credential.builder()
                    .name()
                    .role()
                    .build();
            httpServletResponse.addCookie(new Cookie(JWT_NAME, jsonWebTokenAlgorithm.createToken(credential)));
        }
    }
}
