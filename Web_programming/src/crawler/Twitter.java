package crawler;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Twitter {
   /*private WebDriver driver;
   private String tagSite, tagName, data, contexts;
   private BufferedWriter contextText;
   private String driverLink = "C:\\Users\\kingt\\Documents\\���̺귯�� ũ�ѷ�\\chromedriver.exe"; //chromedriver.exe ���
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
		   System.out.println("�±� " + tagName + " �� ���ؼ� Twitter�� ���� ã���� �Դϴ�.");
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
	   FullscrollDown(); //�ڵ����� ��ũ�� ����
	   System.out.println("sss");
	   ReadHtml(); //HTML�ڵ带 String Ÿ������ �޾ƿ�
	   System.out.println("Yyy");
	   getContext(); //���� String���� ���ϴ� �±׸� ã�� ������ ���Ͽ� �ۼ�
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
		   String pageSource = driver.getPageSource(); //������ �ҽ�(HTML)�� String ������ ����
		   data = new String(pageSource.getBytes(), "UTF-8"); //utf-8�� ���ڵ�
		   System.out.println(data);
		   
	   } catch (UnsupportedEncodingException e) {
		   e.printStackTrace();
	   }
   }

   public void FullscrollDown() {   
	   try {
		   Thread.sleep(3000);
		   JavascriptExecutor jse = (JavascriptExecutor) driver;
		   
		   //2000�� ��ũ���� ����
		   //2000���� �ϴ� ������ 2000������ ��ũ���� ������ ũ�� ������ �޸𸮰� ���� �� ��
		   //������ �޸𸮰� �� ���� �� �������� ���� �ʰ�, ���� �߻�
		   for (int cnt = 0; cnt < 10; cnt++) {
			   jse.executeScript("window.scrollBy(0,1500)", "");  //��ũ�� ����
			   Thread.sleep(500); //2�ʵ��� ����
		   }
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   }
	   System.out.println("��� �����͸� �о����ϴ�.");
   }
   
   public void getContext(){
	   try{
		   Document doc = Jsoup.parse(data); //HTML�� String���� �ٲ� ���� Document Ŭ���� ������ �°� �Ľ�
		   
		   //HTML ��ü �� <b> �±׸� ���� ������
		   //������ <b>�±׸��� �Ʒ��� �ڵ� ����
		   for (Element e : doc.select("b")) {
			   
			   contexts = e.toString(); //�±��� ������ String���� ��ȯ 
			   
			   while(contexts.indexOf("<")!=-1){
				   int i1 = contexts.indexOf("<"); // '<'�� �ε��� ���� ����
				   int i2 = contexts.indexOf(">"); // '>'�� �ε��� ���� ����
				   
				   String str1 = contexts.substring(0, i1); // '<' �տ� �ִ� ������� �߶�
				   String str2 = contexts.substring(i2+1,contexts.length()); // '>' �ڿ� �ִ� ������� �߶�
				   
				   //������ �߶� String �ΰ��� ��ħ
				   //'<'�� '>' �׸��� < > ������ ������ ������ ��
				   contexts = str1+str2; 
			   }
			   
			   contextText.write(contexts); //���Ͽ� ����
			   contextText.newLine(); //�� �ٲ�
		   }
		   contextText.close();   //���� close
		   System.out.println("Context ���� �Ϸ�.");
	   } catch (IOException er) {
		   er.printStackTrace();
	   }
   }*/

}