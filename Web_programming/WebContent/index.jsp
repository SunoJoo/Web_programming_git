
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>    
<%@ page import="crawler.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> Search</title>
<STYLE>

#dvt{margin-top:70px; text-align:center; margin-bottom: 5px; width:100%; height:70px;padding:13px;font-size:70px;}
#dvc{width:500px; height:500px; text-align:center;font-size:30px;font-style: italic;}
#dvci{width:140px; height:500px; text-align:center;font-size:30px;font-style: italic;}
#dvb{margin-top:20px; margin-bottom: 5px; width:100%; height:20px; text-align:center;padding:13px;font-size:70px;font-style: boid; font-size: 20px; font-style: italic; background-color: #EAEAEA}

</STYLE>

<script>

</script>
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
			<div id = "dvc" style="overflow-y:auto"> 출력화면 	
			<br>
			<%			
			String name = request.getParameter("category");
			String[] crawlNewsPage = new String[10];
			String[] bb = new String[15];
			int thNum = 10;
			if(name==null)
				out.print("");
			else{				
				Crawler_getaddr cg = new Crawler_getaddr();
				crawlNewsPage = cg.crawlNewsPage(name,10);
				File_manager fm = new File_manager();
				fm.deleteFile(10);
				Thread[] tr = new Thread[10];				
				Crawler_main cm;		
				for(int i = 0; i<tr.length;i++) {						
					tr[i] = new Thread(new Crawler_main(crawlNewsPage[i],i,thNum));
					tr[i].start();
					out.println("tr"+(i+1)+" On");				
				}			
				
				
			}
				
			%>
					
			</div> 
		</td> 	
		<td>
					
				<div id = "dvci"> 입력화면 <br>
				<form name="form_category" action="index.jsp" method="post" onsubmit="return check()">
					<!--  <input type="text" name="search_con" value="" size="15%">		-->
						<select name="category" size="7">
							<option value="" selected>-- 선택 --</option>
							<option value="society">사회</option>
							<option value="politics">정치</option>
							<option value="economic">경제</option>
							<option value="foreign">국제</option>
							<option value="culture">문화</option>
							<option value="entertain">연예</option>
							<option value="sports">스포츠</option>
							<option value="digital">IT</option>													
						</select>
						<input type="submit" name="push_button" value="찾기">
					</form>
				</div>
			
		</td>
	</tr>
</table>
<div id = "dvb"> Created by SearchTeam </div>
</body>
</html>