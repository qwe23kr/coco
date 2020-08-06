<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setAttribute("str", "나 이제 나와요~");
session.setAttribute("str","난 세션 브라우저 끄기 전까지는 계속 유지됨");
RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/next.jsp");
rd.forward(request, response);
%>
</body>
</html>