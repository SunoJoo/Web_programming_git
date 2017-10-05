package crawler;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;


public class Twitter {
   /*private WebDriver driver;
   private String tagSite, tagName, data, contexts;
   private BufferedWriter contextText;
   private String driverLink = ".\\Web_programming\\chromedriver.exe"; //chromedriver.exe 경로
   */
	protected String mainUrl;
	protected String URL;
	protected Document doc;
	
   public Twitter(String branch) throws Exception{
	   mainUrl = "http://media.daum.net";
	   URL = mainUrl+"/breakingnews/"+branch;
	   //String URL = "https://search.daum.net/search?w=news&nil_search=btn&DA=NTB&enc=utf8&cluster=y&cluster_page=1&q=%EB%AC%B8%EC%9E%AC%EC%9D%B8";
	   doc = Jsoup.connect(URL).get();
	   
	   
	   

	   
	   
	   
	   
	 
	   /*try {
		   tagName = string;
		   System.out.println("태그 " + tagName + " 에 대해서 Twitter를 통해 찾는중 입니다.");
		   tagSite = "https://www.twitter.com/search?q=%23" + tagName + "&src=typd&lang=ko";
		   //tagSite="https://search.naver.com/search.naver?sm=tab_hty.top&where=news&query="+tagName;
		   System.setProperty("webdriver.chrome.driver", driverLink);
		   driver = new ChromeDriver();		   
		  // driver.manage().window().maximize();	
		   driver.get(tagSite);
		   contextText = new BufferedWriter(new FileWriter(tagName + "'s Context(Twitter).txt"));
		   
		   Thread.sleep(5000);
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }*/
	   /*System.out.println("6");
	   FullscrollDown(); //자동으로 스크론 내림
	   System.out.println("sss");
	   ReadHtml(); //HTML코드를 String 타입으로 받아옴
	   System.out.println("Yyy");
	   getContext(); //위의 String에서 원하는 태그를 찾아 내용을 파일에 작성
	   */
	}
   
   

public String getURL() {
	return URL;
}

public void setURL(String uRL) {
	URL = uRL;
}

public Document getDoc() {
	return doc;
}

public void setDoc(Document doc) {
	this.doc = doc;
}

   /*public void ReadHtml() {
	   try {
		   String pageSource = driver.getPageSource(); //페이지 소스(HTML)을 String 변수에 저장
		   data = new String(pageSource.getBytes(), "UTF-8"); //utf-8로 인코딩
		   System.out.println(data);
		   
	   } catch (UnsupportedEncodingException e) {
		   e.printStackTrace();
	   }
   }

   public void FullscrollDown() {   
	   try {
		   Thread.sleep(3000);
		   JavascriptExecutor jse = (JavascriptExecutor) driver;
		   
		   //2000번 스크롤을 내림
		   //2000번을 하는 이유는 2000번정도 스크롤을 내리면 크롬 브라우저 메모리가 거의 꽉 참
		   //브라우저 메모리가 꽉 차면 웹 페이지가 뜨지 않고, 에러 발생
		   for (int cnt = 0; cnt < 10; cnt++) {
			   jse.executeScript("window.scrollBy(0,1500)", "");  //스크롤 내림
			   Thread.sleep(500); //2초동안 멈춤
		   }
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   }
	   System.out.println("모든 데이터를 읽었습니다.");
   }
   
   public void getContext(){
	   try{
		   Document doc = Jsoup.parse(data); //HTML을 String으로 바꾼 것을 Document 클래스 변수에 맞게 파싱
		   
		   //HTML 전체 중 <b> 태그를 전부 가져옴
		   //가져온 <b>태그마다 아래의 코드 실행
		   for (Element e : doc.select("b")) {
			   
			   contexts = e.toString(); //태그의 내용을 String으로 변환 
			   
			   while(contexts.indexOf("<")!=-1){
				   int i1 = contexts.indexOf("<"); // '<'의 인덱스 변수 저장
				   int i2 = contexts.indexOf(">"); // '>'의 인덱스 변수 저장
				   
				   String str1 = contexts.substring(0, i1); // '<' 앞에 있는 내용들을 잘라냄
				   String str2 = contexts.substring(i2+1,contexts.length()); // '>' 뒤에 있는 내용들을 잘라냄
				   
				   //위에서 잘라낸 String 두개를 합침
				   //'<'와 '>' 그리고 < > 사이의 내용이 빠지게 됨
				   contexts = str1+str2; 
			   }
			   
			   contextText.write(contexts); //파일에 쓰기
			   contextText.newLine(); //줄 바꿈
		   }
		   contextText.close();   //파일 close
		   System.out.println("Context 수집 완료.");
	   } catch (IOException er) {
		   er.printStackTrace();
	   }
   }*/

}