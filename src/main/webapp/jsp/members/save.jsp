<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-03-09
  Time: 오후 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response는 그냥 사용가능
    MemberRepository memberRepository = MemberRepository.getInstance(); //얘를 불러와야 저장한거를 볼 수 있음

    System.out.println("MemberSaveServlet.service");
    String usernamme = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); //숫자는 인터저를 통해 해야함

    Member member = new Member(usernamme, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>id=<%=member.getUsername()%></li>
    <li>id=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
