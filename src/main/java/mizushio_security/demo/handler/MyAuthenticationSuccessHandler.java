package mizushio_security.demo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> roles= AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        System.out.println(httpServletRequest.getRemoteAddr());
        httpServletResponse.setHeader("Content-Type","application/json;charset=utf-8");
        httpServletResponse.getWriter().write("{'code':200}");
    }

}
