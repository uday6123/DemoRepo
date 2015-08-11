<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Status</title>
<script src="/GetMeSeva/home/js/jquery.js"></script>
<link href="/GetMeSeva/home/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/GetMeSeva/home/js/bootstrap.min.js"></script>

</head>
<body>
<span stlye="padding-left:125px;"><H2> GET COMPLAINT STATUS</H2> </span>
<br/>

<form class="form-horizontal" role="form" method="post" action="/GetMeSeva/agent/getStatus.do">
							
							<div class="form-group">
								<label for="search_type" class="col-sm-3 control-label">Search By :</label>
								<div class="col-sm-9">
									<select id="search_type" name="search_type">
										<option value="mobile">MOBILE NUMBER</option>
										<option value="email">EMAIL ID</option>
										<option value="complaint_id">COMPLAINT ID</option>
									</select>
								</div>
							</div>

							
							<div class="form-group">
								<label for="search_key" class="col-sm-3 control-label">Value :</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="search_key" name="search_key"
										placeholder="Plese enter the value">
								</div>
							</div>
							
														

							<button type="submit" class="btn btn-default">Get 
								Status</button>
						</form>


</body>
</html>