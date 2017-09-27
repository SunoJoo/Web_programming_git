package crawler;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Twitter {
   private WebDriver driver;
   private String tagSite, tagName, data, contexts;
   private BufferedWriter contextText;
   private String driverLink = "C:\\Users\\2-001\\Desktop\\java\\crawler\\chromedriver.exe"; //chromedriver.exe ���
   
   public Twitter(String string) {
	   try {
		   tagName = string;
		   System.out.println("�±� " + tagName + " �� ���ؼ� Twitter�� ���� ã���� �Դϴ�.");
		   tagSite = "https://www.twitter.com/search?q=%23" + tagName + "&src=typd&lang=ko";
		   System.setProperty("webdriver.chrome.driver", driverLink);
		   driver = new ChromeDriver();		   
		   driver.manage().window().maximize();		  
		   driver.get(tagSite);
		   contextText = new BufferedWriter(new FileWriter(tagName + "'s Context(Twitter).txt"));
		   
		   Thread.sleep(10000);
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
	   System.out.println("6");
	   FullscrollDown(); //�ڵ����� ��ũ�� ����
	   System.out.println("sss");
	   ReadHtml(); //HTML�ڵ带 String Ÿ������ �޾ƿ�
	   System.out.println("Yyy");
	   getContext(); //���� String���� ���ϴ� �±׸� ã�� ������ ���Ͽ� �ۼ�
	}

   public void ReadHtml() {
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
		   for (int cnt = 0; cnt < 5; cnt++) {
			   jse.executeScript("window.scrollBy(0,1500)", "");  //��ũ�� ����
			   Thread.sleep(2000); //2�ʵ��� ����
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
   }

}
