<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Status</title>
<link href="/GetMeSeva/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/GetMeSeva/js/bootstrap.min.js"></script>

</head>
<body>
<span stlye="padding-left:125px;"><H2> Register a Request/Complaint</H2> </span>
<br/>

<form class="form-horizontal" role="form" method="post" action="/GetMeSeva/showComplaintForm.do">
							
							<div class="form-group">
								<label for="stateList" class="col-sm-3 control-label">Select State :</label>
								<div class="col-sm-9">
									<select id="stateList" name="stateList">
										<option value="Andhra">Andhra Pradesh</option>
										<option value="Telangana">Telangana</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="districtList" class="col-sm-3 control-label">Select District :</label>
								<div class="col-sm-9">
									<select id="" name="districtList">
										<c:forEach items="${districtList}" var="dist">
											<option value="${dist}">${dist}</option>									
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="deptList" class="col-sm-3 control-label">Select Department :</label>
								<div class="col-sm-9">
									<select id="deptList" name="deptList">
										<option value="revenue">REVENUE</option>
										<option value="electricity">ELECTRICITY</option>
									</select>
								</div>
							</div>
							
							
														

							<button type="submit" class="btn btn-default">Register</button>
						</form>


</body>
</html>