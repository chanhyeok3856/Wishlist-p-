<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>찜 목록 등록</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" href="./css/bootstrap-datepicker.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/popper.min.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/validity.js" type="text/javascript"></script>
<script src="./js/bootstrap-datepicker.js"></script>
<script src="./js/bootstrap-datepicker.ko.js"></script>
</head>
<body>
<form action="./WishlistInsert.wi" method="post" id="insertForm" class="" enctype="application/x-www-form-urlencoded"> 
  <div class="form-group row">
            <label for="productname" class="col-2 col-form-label pr-0">
             
            <h4>상품명 등록</h4>
            </label>
            <div class="col-4 pl-0">
             <input type="text" name="productname" id="productname" class="form-control">
            </div>
           </div>
             <div class="form-group row">
            <label for="productnum" class="col-2 col-form-label pr-0">
             
             <h4>상품번호 등록</h4>
            </label>
            <div class="col-4 pl-0">
             <input type="text" name="productnum" id="productnum" class="form-control">
            </div>
           </div>
             <div class="form-group row">
            <label for="userid" class="col-2 col-form-label pr-0">
             
            <h4>유저 아이디 등록</h4>
            </label>
            <div class="col-4 pl-0">
             <input type="text" name="userid" id="userid" class="form-control">
            </div>
           </div>
 <button type="submit"> 등록하기
</form>
</body>
</html>