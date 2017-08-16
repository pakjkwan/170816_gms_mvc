<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학생관리시스템</title>
<link rel="stylesheet" href="${css}/member.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div id="wrapper">
<div id="container" style="margin-top:100px">
	<form id="login_box" name="login_box" > 
		<img src="${img}/login.jpg" alt="" /><br />
		<span id="login_id">ID</span>
		<input type="text" id="input_id" name="input_id" value="hong"/> <br />
		<span id="login_pass">PASSWORD</span> 
		<input type="text" id="input_pass" name="input_pass" value="2"/> <br /><br />
		<input type="submit" value="LOGIN" onclick="loginAlert()" />
		<input type="hidden" name="action" value="login" />
		<input type="hidden" name="page" value="main" />
		<input type="reset" value="CANCEL" />
	</form>
</div>
</div>
<script>
function loginAlert(){
	var input_id=document.getElementById('input_id').value;
	var input_pass=document.getElementById('input_pass').value;
	if(input_id===""){
		alert('ID 를 입력해 주세요');
		return false;
	}
	if(input_pass===""){
		alert('PASS 를 입력해 주세요');
		return false;
	}
	var form=document.getElementById('login_box');
	form.action="${ctx}/common.do";
	form.method="post";
	return true;
}
</script>
</body>
</html>










