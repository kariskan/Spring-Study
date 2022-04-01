<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: zkfzp
  Date: 2022-03-25
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write(" <tr>\n");
            out.write(" <td>" + member.getId() + "</td>\n");
            out.write(" <td>" + member.getUsername() + "</td>\n");
            out.write(" <td>" + member.getAge() + "</td>\n");
            out.write(" </tr>\n");
        }
    %>
    </tbody>
</table>
</body>
</html>