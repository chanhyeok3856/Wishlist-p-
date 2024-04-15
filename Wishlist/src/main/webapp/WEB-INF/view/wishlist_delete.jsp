<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜 목록 삭제</title>
</head>
<body>
<form action="./WishlistDelete.wi" method="post" id="deleteForm" enctype="application/x-www-form-urlencoded"> 
  <div class="form-group row">
          
           <p> <label for="productnum" class="col-4 col-form-label pr-0">
             <i class="fas fa-user-plus mr-sm-1"></i>
            <h2>삭제할 상품번호 입력</h2> 
            </label></p>
            <div class="col-8 pl-0">
             <input type="text" name="productnum" id="productnum" class="form-control">
            </div>
           </div>
           
   <p><button type="submit"> 개별 삭제 </button></p>
  <p><button type="button" onclick="deleteAll()"> 전체 삭제 </button></p>



	<script>
	function deleteAll() {
	  if (confirm("정말로 전체 삭제하시겠습니까?")) {
	    var xhr = new XMLHttpRequest();
	    xhr.open("POST", "./WishlistDeleteAll.wi", true);
	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhr.onreadystatechange = function() {
	      if (xhr.readyState === 4 && xhr.status === 200) {
	        alert("전체 삭제가 완료되었습니다.");
	        window.location.href = "./wishlistindex.jsp";
	      }
	    };
	    xhr.send();
	  }
	 
	}
</script>
</form>
</body>
</html>
 
 
 

</form>
</body>
</html>