<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top page</title>
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
<h1>商品の登録に成功しました</h1>

<!--ここに商品一覧の表示をしてもいいと思う-->


<p><a href="TopServlet">Topに戻る</a>


</body>
</html>