<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>책제목</th>
<th>집필자</th>
<th>출판일</th>
<th>리뷰</th>
</tr>
	<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.b_title}</td>
				<td><a href="/book/view?b_num=${book.b_num}">${book.b_author}</a></td>
				
				<td>${book.b_credat}</td>
				<td>${book.b_desc}</td>
			</tr>
		</c:forEach>

</table>
<a href="/views/book/book-insert"><button>책추가</button></a>



</body>
</html>