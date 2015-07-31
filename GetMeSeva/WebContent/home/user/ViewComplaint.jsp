<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Status</title>
<script src="/GetMeSeva/js/bootstrap.min.js"></script>
<style>
table { margin: 0 auto;   }
tr {text-align:center;}
 td { padding: 5px; }
</style>
</head>
<body>
	<H2>VIEW COMPLAINT STATUS</H2>
	
	<c:choose>
	 <c:when test="${noData == true}">
	  <H1> No Complaint found with the search criteria. Please retry.</H1>
	 </c:when>
	 <c:otherwise>

<c:forEach items="${complaintsList}" var="complaintInfo">
	<div>
		<table border="1">
			<tr>
				<td>Complaint Id</td>
				<td>${complaintInfo.complaintId}</td>
			</tr>
			<tr>
				<td>Complaint Status</td>
				<td>${complaintInfo.status}</td>
			</tr>
			<tr>
				<td>State</td>
				<td>${complaintInfo.district.state.name}</td>
			</tr>
			<tr>
				<td>District</td>
				<td>${complaintInfo.district.name}</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>${complaintInfo.dept.name}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${complaintInfo.description}</td>
			</tr>
			<tr>
				<td>Remarks</td>
				<td>${complaintInfo.remarks}</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td>${complaintInfo.userInfo.name}</td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td>${complaintInfo.userInfo.mobile}</td>
			</tr>

			<tr>
				<td>Email Id</td>
				<td>${complaintInfo.userInfo.email}</td>
			</tr>

		</table>
	</div>
	<br/> <br/>
</c:forEach>
</c:otherwise>
</c:choose>
</body>
</html>