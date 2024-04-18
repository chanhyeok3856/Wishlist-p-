<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>찜 목록 추가</title>
</head>
<body>
    <h1>찜 목록 추가</h1>
    
    <form action="./WishlistInsert.wi" method="post">
        <div>
            <label for="product_title">상품 이름:</label>
            <input type="text" id="product_title" name="product_title" required>
        </div>
        <div>
            <label for="product_number">상품 번호:</label>
            <input type="text" id="product_number" name="product_number" required>
        </div>
        <div>
            <label for="member_number">회원 번호:</label>
            <input type="text" id="member_number" name="member_number" required>
        </div>
        <div>
            <button type="submit" onclick="submitForm()">추가하기</button>
            
        </div>
    </form>
    <script>
    function submitForm(){
    	alert("찜 목록에 추가하였습니다.");
    }
    </script>
</body>
</html>