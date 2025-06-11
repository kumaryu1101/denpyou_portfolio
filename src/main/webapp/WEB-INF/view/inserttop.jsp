<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録遷移画面</title>
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
.link {
        margin-top: 100px; 
        margin-bottom: 100px; 
        display: flex; /* 横並びにする */
        justify-content: center; /* 中央揃え */
        gap: 30px; /* ボタン間の余白 */
    }

    .link a {

        padding: 30px 30px;
        text-decoration: none;
        background-color: #888888;
        color: #ffffff;
        border-radius: 10px;
        font-size: 20px;
        border: none;

    }

    .link a:hover {
        background-color: #000077;
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
<h1>＜登録遷移画面＞</h1>

<div class="link">
商品登録を行う場合は、商品登録画面に遷移してください。
<a href="ItemInsertServlet"><h3>商品登録画面へ</h3></a>
伝票登録を行う場合は、伝票登録画面に遷移してください。
<a href="InsertServlet"><h3>伝票登録画面へ</h3></a>
</div>


<p><a href="TopServlet">Topに戻る</a>


</body>
</html>