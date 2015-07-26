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
<span stlye="padding-left:125px;"><H2> Agent Login</H2> </span>
<br/>

		<form class="form-horizontal" role="form" method="post" action="/GetMeSeva/doLogin.do">
							
							<div class="form-group">
								<label for="user_id" class="col-sm-3 control-label">User Name:</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="user_id" name="user_id"
										placeholder="Plese enter your User Name">
								</div>
							</div>
							
							<div class="form-group">
								<label for="agent_pwd" class="col-sm-3 control-label">Password  :</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="agent_pwd" name="agent_pwd"
										placeholder="Plese enter your password">
								</div>
							</div>

							<button type="submit" class="btn btn-default">Login</button>
						</form>


</body>
</html>