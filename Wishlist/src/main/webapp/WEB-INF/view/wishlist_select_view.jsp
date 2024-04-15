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

<c:forEach var="wishlistDTO" items="${arrayList}">
    <p>상품 번호: ${wishlistDTO.productnum}</p>
    <button type="button" onclick="selectDetail('${wishlistDTO.productnum}')">상세보기</button>
    <button type="button" onclick="deleteDetail('${wishlistDTO.productnum}')">삭제하기</button>
</c:forEach>

<c:if test="${empty arrayList}">
    <tr>
        <script type="text/javascript">
			alert("상품이 존재하지 않습니다.")
			location.href="./wishlistindex.jsp"
		</script>
    </tr>
</c:if>

<script>
    function selectDetail(productnum) {
    
        window.location.href = "./WishlistSelectDetail.wi?productnum=" + productnum;
    }
    function deleteDetail(productnum) {
        
        window.location.href = "./WishlistDelete.wi?productnum=" + productnum;
    }
</script>

</body>
</html>