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
<title> Sell & Share </title>
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
          <!--ログインしているかどうか確認 -->
         	<c:choose>
 		 	<c:when test="${loginId == null }">
 		 　<!--会員加入 -->	
          <li class="nav-item">
            <a class="nav-link" href="member/joinFormPage">Join
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <!--ログイン -->	
          <li class="nav-item">
           <a class="nav-link" href="member/LoginPage">Login
           <span class="sr-only">(current)</span>
           </a>
          </li>
          	</c:when>
          	<c:otherwise>	
          <!--QnAのページに移動 -->		
          <li class="nav-item">
            <a class="nav-link" href="../qnaContact/QnAPage">Q&A
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <!--商品登録ページに移動 -->
          <li class="nav-item">
            <a class="nav-link" href="goSellPage">Sell&Share
            <span class="sr-only">(current)</span>
            </a>
          </li>
	   	  <!--会員情報の確認・修正ページに移動 -->
	      <li class="nav-item">
	      <a class="nav-link" href="../member/updateForm">My Info
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
	      <!--ログアウト -->
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
	        <h1 class="jumbotron-heading">Sports Spirits Sell & Share </h1>
	        <p class="lead text-muted mb-0">Please Share Your Experience</p>
	    </div>
	</section>
	<div>
		<img alt="" src="<c:url value="download?pdNum=${vo.prod_num}"/>" width="200" height="250">
		<br>
		Category : ${vo.prod_category} <br>
		Seller : ${vo.prod_sellId}  <br>
		Product Name : ${vo.prod_name }<br> 
		Product Num: ${vo.prod_num} <br>
		Price  : ${vo.prod_price } <br>
		Product Info <br>
		<textarea rows="" cols="">${vo.prod_info }</textarea> <br>
		<c:choose>
		<c:when test="${vo.prod_DeliType == 1}">
		DeliveryType : 無料	<br>
		</c:when>
		<c:when test="${vo.prod_DeliType == 2}">
		DeliveryType : 送料込み	<br>
		</c:when>
		<c:otherwise>
		DeliveryType : 送料抜き	<br>
		</c:otherwise>
		</c:choose>
		DeliveryFrom : ${vo.prod_Deliplace }	<br>
		<br>
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