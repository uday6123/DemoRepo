<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Status</title>
<script src="/GetMeSeva/js/jquery.js"></script>
<link href="/GetMeSeva/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/GetMeSeva/js/bootstrap.min.js"></script>

<script>
function getDistrictList(){
	var state = $('#state').val();
	$("#processingDiv").css("display","block");
	$.get('/GetMeSeva/getDistrictList.do', {
		state_id : state,
    }, function(responseText) {
		if(responseText.result){
			$("#processingDiv").css("display","none");
			var districts = responseText.result;
			var sel = document.getElementById('district');
			$("#district").empty();
			var opt = document.createElement('option');
			opt.innerHTML = "Select";
			opt.value = "";
			sel.appendChild(opt);
			for(var i = 0; i < districts.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = districts[i].name;
				opt.value = districts[i].ID;
				sel.appendChild(opt);
			}
		}else{
			$("#processingDiv").css("display","none");
			alert(responseText.errorMessage);
		}
    });
}
</script>
<style>
#processingDiv{height: 2057px; display:none; opacity: 0.6; position: fixed; top: 0px; left: 0px; width: 100%; z-index: 4000; background-color: rgb(0, 0, 0);}
.imgProcess{position:fixed;top:50%;left: 45%;}
</style>
</head>
<body>
<span stlye="padding-left:125px;"><H2> Register a Request/Complaint</H2> </span>
<br/>

<form class="form-horizontal" role="form" method="post" action="/GetMeSeva/showComplaintForm.do">
							
							<div class="form-group">
								<label for="state" class="col-sm-3 control-label">Select State :</label>
								<div class="col-sm-9">
									<select id="state" name="state" onchange="return getDistrictList();">
										<option value="">Select</option>
										<option value="1">Andhra Pradesh</option>
										<option value="2">Telangana</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="district" class="col-sm-3 control-label">Select District :</label>
								<div class="col-sm-9">
									<select id="district" name="district">
										<option value="">SELECT</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="deptList" class="col-sm-3 control-label">Select Department :</label>
								<div class="col-sm-9">
									<select id="deptList" name="deptList">
										<c:forEach items="${deptList}" var="dept">
											<option value="${dept.ID}">${dept.name}</option>									
										</c:forEach>
									</select>
								</div>
							</div>
							
							
														

							<button type="submit" class="btn btn-default">Register</button>
						</form>
<div id="processingDiv" style="diplay:none;"> <img width="45" height="45" src= "/GetMeSeva/home/images/processing.gif" class="imgProcess"> </div>

</body>
</html>