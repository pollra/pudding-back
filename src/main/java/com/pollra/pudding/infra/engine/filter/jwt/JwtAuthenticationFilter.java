package com.pollra.pudding.infra.engine.filter.jwt;

import com.pollra.pudding.infra.engine.filter.jwt.wrapper.HttpRequestWithModifiableParameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author pollra
 * @description JwtAuthenticationFilter
 * @since 2021.02.23
 **********************************************************************************************************************/
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpRequestWithModifiableParameters param = new HttpRequestWithModifiableParameters(req);

        Enumeration parameterNames = request.getParameterNames();
        String paramName = "";
        String paramVal = "";

        while (parameterNames.hasMoreElements()) {
            paramName = (String) parameterNames.nextElement();
            String[] arrParamVal = request.getParameterValues(paramName);

            // 넘어온 param이 배열이 아님
            if (arrParamVal.length == 1) {
                paramVal = arrParamVal[0];
                log.debug("user_input[" + paramName + "]: " + paramVal);

                param.setParameter(paramName, paramVal); // 값 넣는다
            } else { // 넘어온 배열이 param 임

            }
        }

        // Read request.getBody() as many time you need
        chain.doFilter(request, response);
    }
}
