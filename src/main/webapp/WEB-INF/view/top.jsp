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
	<h1>＜トップページ＞</h1>
	<h3>伝票管理システムへようこそ！</h3>
	

	<p>
		<h3>以下のリンクから、登録や検索を行うことができます</h3>
		<div class="link">
		<br>
		<a href="SelectTopServlet">検索画面へ進む</a>
		
		<a href="InsertTopServlet">登録へ進む</a>
		</div>
	
</body>
</html>