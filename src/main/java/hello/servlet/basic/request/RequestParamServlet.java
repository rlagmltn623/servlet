package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
     1. 파라미터 전송 기능
    http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paraName -> System.out.println( paraName + "=" + request.getParameter(paraName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] ");
        String age = request.getParameter("age");
        String username = request.getParameter("username");
        System.out.println("username =" + username);
        System.out.println("age  =" + age);
        System.out.println();

        //중복확인 방법
        //http://localhost:8080/request-param?username=hello&age=20&username=kim

        System.out.println("[이름이 같은 중복 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
            //response.getWriter().write(name);

        }

        //웝브라우저에 ok 메시지
        response.getWriter().write("ok");
    }
}
