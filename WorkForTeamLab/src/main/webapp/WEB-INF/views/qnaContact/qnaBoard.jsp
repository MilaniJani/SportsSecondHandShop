<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SportsSpirit-QnABoard</title>

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
	      <!-- Managerの画面設定	 -->
	      <li class="nav-item">
            <a class="nav-link" href="qnaContact/QnABoard">Q&A
            <span class="sr-only">(current)</span>
            </a>
          </li>
          <!--로그인 페이지로 이동 -->
	      <li class="nav-item">
	      <a class="nav-link" href="../member/logout">ログアウト
	      <span class="sr-only">(current)</span>
	      </a>
	      </li>
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
       	  <a href="#" class="list-group-item">QnA Board</a>
          <a href="#" class="list-group-item">See Member on LogIn</a>
          <a href="#" class="list-group-item">etc</a>
        </div>
      </div>
      <!-- /.col-lg-3 -->   
      
      
      <div class="col-lg-9">
        <br><br><br><br>
        
        <table class="table table-striped">
	        <thead>
		        <tr>
		        	<th>No.</th>
		        	<th>タイトル</th>
		        	<th>作成者</th>
		        	<th>依頼日付</th>
		        </tr>
	        </thead>
        	<tbody>
        	<c:forEach var="list" items="${qnaLists }">
        		<tr>
        			<td>${list.qna_num}</td>
        			<td>${list.qna_title}</td>
        			<td>${list.qna_ID}</td>
        			<td>${list.qna_writeDate}</td>
        		</tr>
        	</c:forEach>
        	</tbody>
		</table>
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
