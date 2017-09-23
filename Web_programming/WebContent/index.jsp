<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> 다 찾아드림</title>
<STYLE>

#dva{margin-top:70px; margin-bottom: 5px; widt:100%; height:70px; text-align:center;padding:13px;font-size:70px;font-style: boid; }
#dvc{float:left;margin-top:200px; margin-bottom: 5px; width:85%; height:500px; text-align:center;font-size:30px;font-style: bold; background-color: #FFD9FA}
#dvci{float:right;margin-top:200px; margin-bottom: 5px; width:15%; height:500px; text-align:center;font-size:30px;font-style: italic; background-color: #E4F7BA}

</STYLE>
</head>
<body>
<div id = "dva"> Search </div>
<div id = "dvc"> 출력화면 

</div>

<form action="push.jsp" method="get">	
	<div id = "dvci"> 입력화면 <br>
		<div><input type="text" name="search_con" value="" size="15%"></div>		
		<div><input type="button" name="push_button" value="보내기"></div>
	</div>
</form>
</body>
</html>