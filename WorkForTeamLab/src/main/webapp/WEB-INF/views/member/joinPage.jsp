<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/shop-homepage.css"/>" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<!-- Bootstrap core JavaScript -->
<script src="<c:url value="resources/js/bootstrap.js"/>"></script>

<title>会員登録</title>
<script type="text/javascript">
	$(function(){
		$('#inputId').on('blur', function(){
			var inputId = $('#inputId').val();
			if(inputId.length==0){
				alert('IDを入力してください。');
				return;
			}
			$.ajax({
				url : "idCheck",
				type : "post",
				data : {
					id : inputId
				},
				success : function(flag){
					
					if(flag){
						alert("使用可能です！");
					}else{
						alert("IDが重複されています。");
					}
				},
				error : function(){
					alert("Fail");
				}
			});
		});
	});
	function formCheck(){
		var password = document.getElementById("inputPw");
		var checkpassword = document.getElementById("checkPw");
		
		if(checkpassword.length == 0){
			alert("暗証番号を入力してください。");
			return false;
		}
		if(password.length <4){
			alert("暗証番号は4桁以上です。");
		}
		if(password.value !=checkpassword.value ){
			alert("入力した暗証番号と違います。")
			return false;
		}
		alert("会員登録完了");
		return true;
	}
</script>
</head>
<body>
	<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Share Your Sports - SecondHand Shop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="../">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Join</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="LoginPage">Login</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- //Navigation -->	
  
  <section class="jumbotron text-center">
	    <div class="container">
	        <h1 class="jumbotron-heading">Sports Spirits 会員登録</h1>
	        <p class="lead text-muted mb-0">会員加入_情報登録</p>
	    </div>
  </section>
  
  <div class="container">
	    <div class="row">
	        <div class="col">
	            <div class="card">
	                <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> 会員登録  </div>
	                <div class="card-body">
	                    <form action="join" id="joinForm" method="post" onsubmit="return formCheck()">
	                        <!-- ID -->
	                        <div class="form-group">
	                            <label for="member_id">Member ID</label>
	                            <input type="text" class="form-control" name="member_id" id="inputId" placeholder="IDを入力してください。" required>
	                        </div>
	                        <!-- PW -->
	                        <div class="form-group">
	                            <label for="title">Password</label>
	                            <input type="password" class="form-control" name="password" id="inputPw" placeholder="パスワードを入力してください。" required>
	                        </div>
	                        <!-- PW確認 -->
	                        <div class="form-group">
	                            <label for="title">Password Check</label>
	                            <input type="password" class="form-control" id="checkPw" placeholder="もう一度パスワードを入力してください。" required>
	                        </div>
	                        <!-- Email -->
	                        <div class="form-group">
	                            <label for="email">Email address</label>
	                            <input type="email" class="form-control" name="email" id="inputEmail" aria-describedby="emailHelp" placeholder="Your email @ email.com" required>
	                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	                        </div>
	                        
	                        <!-- 個人情報入力 (名前、生年月日、電話番号、住所、郵便番号) -->
	                        <!-- name -->
	                        <div class="form-group">
	                            <label for="message">Name</label>
	                            <input type="text" class="form-control" name="name" id="name" placeholder="お名前を入力してください。" required>
	                        </div>
	                        <!-- birth -->
	                        <div class="form-group">
	                            <label for="message">Birth</label>
	                            <input type="text" class="form-control" name="birthDate" id="birthDate" placeholder="お誕生日(yymmdd)" required>
	                        </div>
	                        <!-- phone number -->
	                        <div class="form-group">
	                            <label for="message">Phone</label>
	                            <input type="tel" class="form-control" name="phonenum" id="phone" placeholder="Ex)010-xxxx-xxxx" required>
	                        </div>
	                        <!-- Postal Code -->
	                        <div class="form-group">
	                            <label for="message">PostCode</label>
	                            <input type="text" class="form-control" name="postCode" id="postCode" placeholder="000-0000" required>
	                        </div>
	                        <!-- address -->
	                        <div class="form-group">
	                            <label for="message">Address</label>
	                            <input type="text" class="form-control" name="address" id="address" placeholder="ご住所を入力してください。" required>
	                        </div>
	                        
	                        <div class="mx-auto">
	                        <button type="submit" class="btn btn-primary text-right">Submit</button>
	                        <a href="../" class="btn btn-warning" id="cancelbttn">Cancel</a></div>	
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>	
		
</body>
</html>