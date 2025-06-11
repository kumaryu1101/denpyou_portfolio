<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert page</title>
<style>
.form {
    max-width: 600px;
    margin: 50px auto;
    background-color: #EEEEEE;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    text-align: center;  
}
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f9;
        text-align: center;
    }

    h1 {
        color: #333;
        margin-bottom: 20px;
    }
    .header {
  padding: 12px 24px;
  background-color: #fafafa;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.header-logo {
  font-weight: bold;
  font-size: 26px;
  margin-left: 5%;
}

.header-list {
  display: flex;
  align-items: center;
  gap: 32px;
  font-size: 17px;
  font-weight: bold;
}
.header-item {
  list-style: none;
}
.nav li {
  padding-left: 16px;
  position: relative;
  border-left: 2px solid #DDDDDD;
  border-height: 100%;
}

.nav a {
  text-decoration: none;
  color: #333;
  padding: 12px 12px;
  display: block;
}
</style>
</head>
<body>
<header class="header">
    <h1 class="header-logo">伝票管理システム</h1>
    <nav class="nav">
    
        <ul class="header-list">
            <li class="header-item"><a href="TopServlet">TOP</a></li>
            <li class="header-item"><a href="InsertTopServlet">登録</a></li>
            <li class="header-item"><a href="SelectTopServlet">検索</a></li>
        </ul>
    </nav>
</header>
<h1>＜伝票登録画面＞</h1>

<div class="form">
<form action="InsertServlet" method="post">
    
       <p> 伝票番号:
        <input type="text" name="id" ></p>
    
    
       <p> 商品番号(ID):
        <select name="itemId" required></p>
    	<option value="">選択してください</option>
        <c:forEach var="itemsdto" items="${itemsdtolist}">
<!--        value="ここにitemidをいれればidだけ送れる"-->
            <option value="${itemsdto.itemid}">${itemsdto.itemid}：${itemsdto.itemname}</option>
        </c:forEach>
        </select></p>
    
       <p> 数量:
        <input type="number" name="number" required></p>
    
    
       <p> 日付:
        <input type="date" name="date" required></p>
    
    
       <p> <input type="submit" value="登録"></p>
</form>


<h4>[※商品が選択できない場合、登録を行ってください]</h4>

</div>

<p><a href="TopServlet">Topに戻る</a>
</body>
</html>
