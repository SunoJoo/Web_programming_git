<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> 다 찾아드림</title>
<STYLE>

#dvt{margin-top:70px; text-align:center; margin-bottom: 5px; width:100%; height:70px;padding:13px;font-size:70px;}
#dvc{width:500px; height:500px; text-align:center;font-size:30px;font-style: italic;}
#dvci{width:140px; height:500px; text-align:center;font-size:30px;font-style: italic;}
#dvb{margin-top:20px; margin-bottom: 5px; width:100%; height:20px; text-align:center;padding:13px;font-size:70px;font-style: boid; font-size: 20px; font-style: italic; background-color: #EAEAEA}

</STYLE>
</head>
<body>
<script type="text/javascript">
function check() {
	if(f.search_con.value==""){
		alert("검색할 내용을 입력하세요");
		f.search_con.focus();
		return false;
	}
	if(f.search_con.value==" "){
		alert("공백으로 시작할 수 없습니다");
		f.search_con.focus();
		return false;
	}
	return true;
}
</script>
<div id = "dvt"> <img src="Images/title_image.png"/></div>
<br><br><br><br><br><br><br>
<table border="0" align="center" >
	<tr>
		<td> 
			<div id = "dvc"> 출력화면 </div> 
		</td> 	
		<td>
			<form name="f" action="push.jsp" method="get" onsubmit="return check()">		
				<div id = "dvci"> 입력화면 <br>
					<input type="text" name="search_con" value="" size="15%">		
					<input type="submit" name="push_button" value="찾기">
				</div>
			</form>
		</td>
	</tr>
</table>
<div id = "dvb"> Created by SearchTeam </div>
</body>
</html>