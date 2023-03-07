package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequsetBodyStringServlet", urlPatterns = "/request-body-string")
public class RequsetBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();//꺼내는 방법
        String meesageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//바이트 코드를 스트링으로 바꿔야함
        System.out.println("meesageBody =  " + meesageBody);
        response.getWriter().write("ok");    //응답은
    }
}
