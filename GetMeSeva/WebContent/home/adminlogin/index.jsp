<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Getmeseva Home</title>
</head>
<body>
<c:choose>
<c:when test="${isValidSession}">
<H4><a href="/GetMeSeva/user/showStatusForm.do"> Track a registered complaint</a> </H4>
<H4> <a href="/GetMeSeva/user/showRegisterForm.do">Register a new Request/Complaint </a></H4>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</body>
</html>