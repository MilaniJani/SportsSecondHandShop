<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"> -->
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
		alert("会員情報修正完了");
		return true;
	}
</script>
</head>
<body>
	<!-- Navigation -->
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">SportsSpirits - SecondHand Shop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
         	<c:choose>
 		 	<c:when test="${loginId == null }">
          <li class="nav-item">
            <a class="nav-link" href="member/joinFormPage">Join
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
           <a class="nav-link" href="member/LoginPage">Login
           <span class="sr-only">(current)</span>
           </a>
          </li>
          	</c:when>
          	<c:when test="${areYouManager != 1 }">
         <!--ユーザーの画面設定	-->	
          <li class="nav-item">
            <a class="nav-link" href="../qnaContact/QnAPage">Q&A
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../product/goSellPage">Sell&Share
            <span class="sr-only">(current)</span>
            </a>
          </li>
	   	  <!--회원정보 페이지로 이동 -->
	      <li class="nav-item">
	      <a class="nav-link" href="#">My Info
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
	      <!--로그인 페이지로 이동 -->
	      <li class="nav-item">
	      <a class="nav-link" href="logout">ログアウト
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
	      	</c:when>
	     	<c:otherwise>
	      <!-- Managerの画面設定	 -->
	      <li class="nav-item">
            <a class="nav-link" href="qnaContact/QnABoard">Q&A
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <!--로그인 페이지로 이동 -->
	      <li class="nav-item">
	      <a class="nav-link" href="logout">ログアウト
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
	      	 </c:otherwise>
          	</c:choose>
          
        </ul>
      </div>
    </div>
  </nav>
  <!-- //Navigation -->	
  
  <section class="jumbotron text-center">
	    <div class="container">
	        <h1 class="jumbotron-heading">Sports Spirits 会員情報管理</h1>
	        <p class="lead text-muted mb-0">会員情報アップデート</p>
	    </div>
  </section>
  
  <div class="container">
	    <div class="row">
	        <div class="col">
	            <div class="card">
	                <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> 会員登録  </div>
	                <div class="card-body">
	                    <form action="updateInfo" id="joinForm" method="post" onsubmit="return formCheck()">
	                        <!-- ID -->
	                        <div class="form-group">
	                            <label for="member_id">Member ID</label>
	                            <input type="text" class="form-control" id="inputId" placeholder="${sessionScope.loginId}" readonly="readonly">
								<input type="hidden" name="member_id" id="member_id" value="${sessionScope.loginId}">	                        
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
	                            <input type="email" class="form-control" name="email" id="inputEmail" aria-describedby="emailHelp" value="${member.email }" required>
	                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	                        </div>
	                        
	                        <!-- 個人情報入力 (名前、生年月日、電話番号、住所、郵便番号) -->
	                        <!-- name -->
	                        <div class="form-group">
	                            <label for="message">Name</label>
	                            <input type="text" class="form-control" name="name" id="name" value="${member.name }" readonly="readonly">
	                        </div>
	                        <!-- birth -->
	                        <div class="form-group">
	                            <label for="message">Birth</label>
	                            <input type="text" class="form-control" name="birthDate" id="birthDate" value="${member.birthDate }" required>
	                        </div>
	                        <!-- phone number -->
	                        <div class="form-group">
	                            <label for="message">Phone</label>
	                            <input type="tel" class="form-control" name="phonenum" id="phone" value="${member.phonenum }" required>
	                        </div>
	                        <!-- Postal Code -->
	                        <div class="form-group">
	                            <label for="message">PostCode</label>
	                            <input type="text" class="form-control" name="postCode" id="postCode" value="${member.postCode }" required>
	                        </div>
	                        <!-- address -->
	                        <div class="form-group">
	                            <label for="message">Address</label>
	                            <input type="text" class="form-control" name="address" id="address" value="${member.address }" required>
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