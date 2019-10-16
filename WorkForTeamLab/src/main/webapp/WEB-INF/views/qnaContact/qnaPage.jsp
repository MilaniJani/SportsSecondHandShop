<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/shop-homepage.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/qnaPage.css"/>" rel="stylesheet">

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<!-- Bootstrap core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<title> Q&A - Contact </title>
</head>
<body>
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
            <a class="nav-link" href="../">Home
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
          	<c:otherwise>	
          <!--QnAのページに移動 -->	
          <li class="nav-item">
            <a class="nav-link" href="#">Q&A
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <!--商品登録ページに移動 -->
          <li class="nav-item">
            <a class="nav-link" href="../product/goSellPage">Sell&Share
            <span class="sr-only">(current)</span>
            </a>
          </li>
	   	  <!--会員情報の確認・修正ページに移動 -->
	      <li class="nav-item">
	      <a class="nav-link" href="../member/updateForm">My Info
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
	      <!--ログアウト-->
	      <li class="nav-item">
	      <a class="nav-link" href="../member/logout">ログアウト
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
	        <h1 class="jumbotron-heading">Sports Spirits Q&A CONTACT</h1>
	        <p class="lead text-muted mb-0">Please Feel Free to Contact Us!</p>
	    </div>
	</section>
	
	<div class="container">
	    <div class="row">
	        <div class="col">
	            <div class="card">
	                <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> Contact us.
	                </div>
	                <div class="card-body">
	                    <form action="QnAInput" id="qnaForm" method="post" onsubmit="return formCheck()">
	                        <div class="form-group">
	                            <label for="member_id">Member ID</label>
	                            <input type="text" class="form-control" id="member_id" aria-describedby="emailHelp" placeholder="${sessionScope.loginId}" readonly="readonly">
	                        	<input type="hidden" name="qna_ID" id="qna_ID" value="${sessionScope.loginId}">
	                        </div>
	                        <div class="form-group">
	                            <label for="title">Title</label>
	                            <input type="text" class="form-control" name="qna_title" id="qna_title" aria-describedby="emailHelp" placeholder="Enter title" required>
	                        </div>
	                        <div class="form-group">
	                            <label for="email">Email address</label>
	                            <input type="email" class="form-control" name="qna_email" id="qna_email" aria-describedby="emailHelp" placeholder="Enter email" required>
	                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	                        </div>
	                        <div class="form-group">
	                            <label for="message">Message</label>
	                            <textarea class="form-control" name="qna_contents" id="qna_contents" rows="6" required></textarea>
	                        </div>
	                        <div class="mx-auto">
	                        <button type="submit" class="btn btn-primary text-right">Submit</button></div>
	                    </form>
	                </div>
	            </div>
	        </div>
	        <div class="col-12 col-sm-4">
	            <div class="card bg-light mb-3">
	                <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-home"></i> Address</div>
	                <div class="card-body">
	                    <p>3 rue des Champs Elysées</p>
	                    <p>75008 PARIS</p>
	                    <p>France</p>
	                    <p>Email : email@example.com</p>
	                    <p>Tel. +31 12 56 11 51 84</p>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	  
	<!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Share Your Sports 2019</p>
    </div>
    <!-- /.container -->
  </footer>
  
</body>
</html>