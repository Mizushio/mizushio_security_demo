package mizushio_security.demo.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
        httpServletResponse.setHeader("Content-Type","application/json;charset=utf-8");
        PrintWriter writer=httpServletResponse.getWriter();
        writer.write("{\"status\":\"error\",\"msg\":\"权限不足,不能看哦~\"} ");
        writer.flush();
        writer.close();
    }
}
