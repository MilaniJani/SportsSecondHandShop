<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SportsSpirit-SecondHandShop</title>

	<!-- Bootstrap core CSS -->
	<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap-theme.css"/>" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="<c:url value="/resources/css/shop-homepage.css"/>" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
	<script type="text/javascript">
		$('#login-modal').modal(
				{ keyboard: false, backdrop: 'static' } 
		)
	</script>
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
            <a class="nav-link" href="qnaContact/QnAPage">Q&A
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="product/goSellPage">Sell&Share
            <span class="sr-only">(current)</span>
            </a>
          </li>
	   	  <!--회원정보 페이지로 이동 -->
	      <li class="nav-item">
	      <a class="nav-link" href="member/updateForm">My Info
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
	      <!-- <li class="nav-item">
	      <a class="nav-link" href="product/gobuyComplete">My Order
	      <span class="sr-only">(current)</span>
	      </a>
	      </li> -->
	      <!--로그인 페이지로 이동 -->
	      <li class="nav-item">
	      <a class="nav-link" href="member/logout">ログアウト
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
	      <a class="nav-link" href="member/logout">ログアウト
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
	      		 </c:otherwise>
          	</c:choose>
          
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h2 class="my-4">Share Your Sports Spirits </h2>
        
        <div class="list-group">
       	  <a href="#" class="list-group-item">See All</a>
          <a href="#" class="list-group-item">Soccer</a>
          <a href="#" class="list-group-item">BaseBall</a>
          <a href="#" class="list-group-item">BasketBall</a>
          <a href="#" class="list-group-item">VollyBall</a>
          <a href="#" class="list-group-item">etc</a>
        </div>

      </div>
      
     
      <!-- /.col-lg-3  col-lg-4 col-md-6 mb-4-->   
      <div class="col-lg-9" style="padding-top: 25px;">
        <div class="row">
		　<c:forEach var="prd" items="${productList }">
         <div style="display: inline-block; width: 25%; padding: 5px">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card-body">
                <h5 class="card-title">
                  <a href="#">${prd.prod_name}</a>
                </h5>
                <h6>${prd.prod_price}</h6>
                <p class="card-text">${prd.prod_sellId}</p>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
              <input type="hidden" value="${prd.prod_num}" class="Prod_num" name="Prod_num">
            </div>
          </div>
　　		　</c:forEach>
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Share Your Sports 2019</p>
    </div>
    <!-- /.container -->
  </footer>

 
</body>

</html>
