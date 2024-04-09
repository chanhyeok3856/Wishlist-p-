<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>찜 목록</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>


</head>
<body>
  <div class="col-md-6">
    <h1>
     <i class="fas fa-users"></i>
     찜 목록
      <button type="button" class="btn btn-outline-info mr-sm-1" onclick="location.href='./WishlistInsertView.wi'">
      찜 목록 등록
    <button type="button" class="btn btn-outline-info mr-sm-1" onclick="location.href='./WishlistDelete.wi'">
    찜 목록 삭제
    </h1>
   </div>
</body>
</html>