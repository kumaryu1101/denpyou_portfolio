<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索された結果表示</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f9;
        text-align: center;
    }
    h1 {
        color: #333;
        margin-bottom: 20px;
    }
    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px;
        border: 1px solid #ddd;
    }
    th {
        background-color: #BAD3FF;
        color: black;
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
    
    #footer {
       position: fixed;
       bottom: 0;
       width: 100%; 
       background-color: #DDDDDD; 
       padding: 20px; 
       text-align: center; 
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
<h1>＜伝票一覧＞</h1>
<table class="design01">
    <tr>
      <th>伝票番号</th>
      <th>商品名</th>
      <th>単価</th>
      <th>個数</th>
      <th>日付</th>
    </tr>

    <c:choose>
        <c:when test="${empty itemslip}">
            <tr><td colspan="5">伝票がありません</td></tr>
        </c:when>
        <c:otherwise>
            <c:set var="total" value="0"/>
            <c:forEach var="slip" items="${itemslip}">
                <tr>
                    <td><form action="SelectDenpyouServlet" method="post">
					<input type="hidden" name="slipid" value="${slip.slipid}">
					<input type="submit" value="${slip.slipid}">
					</form></td>
                    <td>${slip.itemname}</td>
                    <td>${slip.price}</td>
                    <td>${slip.number}</td>
                    <td>${slip.date}</td>
                	<c:set var="total" value="${total + slip.price * slip.number}"/>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>

<div id ="footer">
    <h2>[合計金額：${total}円]</h2>
</div>

<p>
    <a href="TopServlet">TOPに戻る</a>
</p>

</body>
</html>