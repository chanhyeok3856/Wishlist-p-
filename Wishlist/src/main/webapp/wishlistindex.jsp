<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>찜 목록 </title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/popper.min.js" type="text/javascript"></script>
</head>
<body>
 <header id="main-header" class="py-2 bg-primary text-white">
  <div class="container">
   <div class="row mt-3 p-3">
    <div class="col-md-6"></div>
   </div>
  </div>
 </header>
 <section id="actions" class="py-4 mb-4 bg-light">
  <div class="container">
   <div class="row"></div>
  </div>
 </section>
 <section id="posts">
  <div class="container">
   <div class="row justify-content-center">
    <div class="col-md-3">
     <div class="card text-center bg-primary text-white mb-3">
      <div class="card-body">
       <h3>찜목록 보기</h3>
       <h4 class="display-4">
        <i class="fas fa-user-tag"></i>
       </h4>
   <c:choose>
  <c:when test="${!empty sessionScope.userid}">
    <button type="button" class="btn btn-outline-light btn-sm" onclick="location.href='./WishlistSelect.wi'">클릭</button>  
  </c:when>
  <c:otherwise>
    <button type="button" class="btn btn-outline-light btn-sm" onclick="showAlert()">클릭</button>
  </c:otherwise>
</c:choose>

<script>
function showAlert() {
  alert('찜 목록이 없습니다.');
  // 다른 동작을 추가하려면 여기에 코드를 작성하세요.
  // 예를 들어, 다른 페이지로 이동하거나 추가 작업을 수행할 수 있습니다.
  // location.href='./Product 페이지 등?
}
</script>

 </div>
 </div>
 </div>
 </div>
 </div>

 </section>

</body>
</html>