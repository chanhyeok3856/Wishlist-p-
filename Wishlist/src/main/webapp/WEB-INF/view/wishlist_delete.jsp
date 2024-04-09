<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록 삭제</title>
</head>
<body>
<form action="./WishlistDelete.wi" method="post" id="DeleteForm" enctype="application/x-www-form-urlencoded"> 
      <div class="form-group row">
            <label for="userid" class="col-4 col-form-label pr-0">
             <i class="fas fa-user-plus mr-sm-1"></i>
           삭제할 상품번호 입력
            </label>
            <div class="col-8 pl-0">
             <input type="text" name="productnum" id="productnum" class="form-control">
            </div>
           </div>
 <button type="submit"> 제출
</body>
</html>