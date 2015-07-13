<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<span stlye="padding-left:125px;"><H2> GET COMPLAINT STATUS</H2> </span>
<br/>

		<form class="form-horizontal" role="form" method="post" action="/GetMeSeva/registerComlaint.do">
							
							<div class="form-group">
								<label for="name" class="col-sm-3 control-label">Name :</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="name" name="name"
										placeholder="Plese enter your name">
								</div>
							</div>
							
							<div class="form-group">
								<label for="mobile" class="col-sm-3 control-label">Mobile Number :</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="mobile" name="mobile"
										placeholder="Plese enter your mobile number">
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-3 control-label">Email Id :</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="email" name="email"
										placeholder="Plese enter your email id">
								</div>
							</div>
							<div class="form-group">
								<label for="req_desc" class="col-sm-3 control-label">Complaint description:</label>
								<div class="col-sm-9">
									<textarea rows="4" cols="50" id="req_desc" name="req_desc">
									</textarea>
								</div>
							</div>								
							<input type="hidden" name="dept" value="${dept}">
							<input type="hidden" name="state" value="${selectedState}">
							<input type="hidden" name="dist" value="${dist}">

							<button type="submit" class="btn btn-default">Register Complaint</button>
						</form>


</body>
</html>