<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록 등록</title>
</head>
<body>
<form action="./WishlistInsert.wi" method="post" id="insertForm" enctype="application/x-www-form-urlencoded"> 
  <div class="form-group row">
            <label for="productname" class="col-4 col-form-label pr-0">
             <i class="fas fa-user-plus mr-sm-1"></i>
            상품명 등록
            </label>
            <div class="col-8 pl-0">
             <input type="text" name="productname" id="productname" class="form-control">
            </div>
           </div>
             <div class="form-group row">
            <label for="productnum" class="col-4 col-form-label pr-0">
             <i class="fas fa-user-plus mr-sm-1"></i>
             상품번호 등록
            </label>
            <div class="col-8 pl-0">
             <input type="text" name="productnum" id="productnum" class="form-control">
            </div>
           </div>
             <div class="form-group row">
            <label for="userid" class="col-4 col-form-label pr-0">
             <i class="fas fa-user-plus mr-sm-1"></i>
            유저 아이디 등록
            </label>
            <div class="col-8 pl-0">
             <input type="text" name="userid" id="userid" class="form-control">
            </div>
           </div>
 <button type="submit"> 제출
</form>
</body>
</html>