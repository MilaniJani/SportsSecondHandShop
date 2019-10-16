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
            <a class="nav-link" href="../qnaContact/QnAPage">Q&A
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <!--商品登録ページに移動 -->
          <li class="nav-item">
            <a class="nav-link" href="#">Sell&Share
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
	
	<div class="container">
	    <div class="row">
	        <div class="col">
	            <div class="card">
	                <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> Share Your Experience
	                </div>
	                <div class="card-body">
	                    <form action="SellProduct" id="sellForm" method="post" onsubmit="return formCheck()" enctype="multipart/form-data">
	                        <div class="form-group">
	                            <label for="member_id">Seller ID</label>
	                            <input type="text" class="form-control" id="prod_sellId"  placeholder="${sessionScope.loginId}" readonly="readonly">
	                        	<input type="hidden" name="prod_sellId" id="prod_sellId" value="${sessionScope.loginId}">
	                        </div>
	                        <div class="form-group">
	                            <label for="Category">Category</label>
	                            <input type="text" class="form-control" name="prod_category" id="prod_category" placeholder="Enter category" required>
	                        </div>
	                        <div class="form-group">
	                            <label for="Name">Product Name</label>
	                            <input type="text" class="form-control" name="prod_name" id="prod_name"  placeholder="Enter name" required>
	                        </div>
	                        <div class="form-group">
	                            <label for="Price">Price</label>
	                            <input type="text" class="form-control" name="prod_price" id="prod_price" placeholder="Enter Price" required>
	                        </div>
	                        <div class="form-group">
	                            <label for="Information">Information</label>
	                            <textarea class="form-control" name="prod_info" id="prod_info" rows="6" required></textarea>
	                        </div>
	                        <div class="form-group">
	                            <label for="Prod_DeliType">商品郵便タイプ</label>
	                            <select class="form-control" name="prod_DeliType" id="prod_DeliType">
	                       			<option>Select郵便</option>
	                       			<option value="1">無料</option>
	                       			<option value="2">送料込み</option>
	                       			<option value="3">送料抜き</option>
	                       		</select>
	                        </div>
	                        <div class="form-group">
	                            <label for="Prod_Deliplace">発送地</label>
	                            <input type="text" class="form-control" name="prod_Deliplace" id="prod_Deliplace" placeholder="Enter 発送地" required>
	                        </div>
	                         <div class="form-group">
	                            <label for="Upload">Image Upload</label>
	                            <input type="file" class="form-control" name="upload">
	                        </div>
	                        
	                        <div class="mx-auto">
	                        <button type="submit" class="btn btn-primary text-right">Sell</button></div>
	                    </form>
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