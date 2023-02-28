package hello.servlet.basic.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeadServlet", urlPatterns = "/request-header")
public class RequsetHeadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        System.out.println("request.getRequestURL() = " + request.getRequestURL()); // http://localhost:8080/request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());// /request-header
        System.out.println("request.getQueryString() = " + request.getQueryString()); //username=hi
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    //Header 모든 정보
    private void printHeaders(HttpServletRequest request) {     System.out.println("--- Headers - start ---");
/*
    Enumeration<String> headerNames = request.getHeaderNames();     while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        System.out.println(headerName + ": " + request.getHeader(headerName));     }
*/
        Enumeration<String> headerNanmes = request.getHeaderNames();
        
//        while (headerNanmes.hasMoreElements()){
//            String headerName = headerNanmes.nextElement();
//            System.out.println(headerName +  ":"  + headerName);
//
//        } 이걸 밑에 것 처럼 사용해서 쓰면된다.

        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerNanme -> System.out.println("headerNanmes = " + headerNanme));

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ":" + request.getHeader(headerName)));
                        System.out.println("--- Headers - end ---");     System.out.println();
    }

}
