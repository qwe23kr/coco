<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>사번</th>
		<th>사원명</th>
		<th>입사일</th>
		<th>월급</th>
		<th>직급</th>
	</tr>
	<c:if test="${empty empList }" >
		<tr>
			<td colspan="5">내용없음</td>
		</tr>
	</c:if>
	<c:forEach items="${empList}" var="emp">
		<tr>
			<td>${emp.emp_no}</td>
			<td>${emp.emp_name}</td>
			<td>${emp.emp_credat}</td>
			<td>${emp.emp_salary}</td>
			<td>
				<c:forEach items="${grdList}" var="grd">
					<c:if test="${emp.grd_no == grd.grd_no}">
						${grd.grd_name}
					</c:if>
				</c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>