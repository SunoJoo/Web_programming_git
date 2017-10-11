package crawler;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class Crawler_main extends Crawler_parent implements Crawler_page_viewer, Crawler_workspace, Crawler_news, Runnable{
	// 스레드 작업 객체
	private String[] crawlList=null;
	private String[] pageName=null;
	private String[] data;
	String branch;
	int task = 0;
	int offset = 0;
	int thNum = 0;
	public Crawler_main(String branch, int num, int thNum) {
		// TODO Auto-generated constructor stub
		this.branch = branch;	
		this.thNum = thNum;
		urlTrue=super.URL+super.branch;				
		crawlList = new String[10];				
		pageName = new String[CRAWLLIST];
		data = new String[CRAWLLIST];		
		task=num;
		
	}	
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
	@Override
	public void run() { // Runnable 메소드 오버라이드
		// TODO Auto-generated method stub
		if(task==0) 
			task_0_jop();	
		if(task>0) 
			task_1_jop();		
	}	
	
	public void task_0_jop() { // getaadr 에서 설명한 1번 페이지와 11번 이후의 페이지 포맷이 다른거 때문에 메소드를 2개 만듦
		data = crawlNewsData(branch);
		exportFile(data);
		System.out.println(branch);
		crawlList = crawlPageNumOne(branch);
		for(int i = 0; i<crawlList.length;i++) {
			System.out.println(crawlList[i]);
			pageName = crawlMainPage(crawlList[i]);
			data = crawlNewsData(pageName);
			exportFile(data);
		}
	}
	
	public void task_1_jop() { //11번 이후의 페이지를 크롤링하는 메소드
		data = crawlNewsData(branch);
		exportFile(data);
		System.out.println(branch);
		crawlList = crawlPageNum(branch);			
		for(int i = 0;i<crawlList.length;i++ ) {
			System.out.println(crawlList[i]);
			pageName = crawlMainPage(crawlList[i]);
			data = crawlNewsData(pageName);
			exportFile(data);
			}	
	}
	public void exportFile(String[] data) { // 파일 출력
		String[] texts = new String[data.length];
		texts = data;		
		try {
			FileWriter fw = new FileWriter("result_thread "+(task+1)+".txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			for(String line:texts)
				out.print(line);
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public String[] crawlPageNum(String ref) { // getaddr에서 얻은 1,11,21...의 각 요소안에 페이지 번호 주소를 크롤링 ex) 1번페이지에는 총 11페이지까지 있으므로 1~10페이지의 주소가 반환됨
		String[] datas = new String[CRAWLPAGELIST-1];		
		Document doc; 
		for(int i = 1; i<CRAWLPAGELIST;i++) {	
			try {
				doc = Jsoup.connect(ref).timeout(30000).get();
				
				Element ele = doc.select("span.inner_paging a").get(i);
				String add = mainUrl+ele.attr("href");
				datas[i-1] = add;				
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}			  		   
		   }
		return datas;		
	}
	
	public String[] crawlPageNumOne(String ref) { // 포맷이 다른 1페이지를 크롤링 하기 위한 메소드 
		String[] datas = new String[CRAWLPAGELIST-1];		
		Document doc; 
		for(int i = 0; i<CRAWLPAGELIST-1;i++) {	
			try {
				doc = Jsoup.connect(ref).timeout(30000).get();
				
				Element ele = doc.select("span.inner_paging a").get(i);
				String add = mainUrl+ele.attr("href");
				datas[i] = add;				
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}			  		   
		   }
		return datas;		
	}
	
	@Override
	public String[] crawlMainPage(String ref) { // 각 페이지 안에 있는 15개의 기사 제목 href값을 리턴하는 메소드
		String[] datas = new String[CRAWLLIST];
		Document doc; 
		for(int i = 0; i<CRAWLLIST;i++) {
				try {
					doc = Jsoup.connect(ref).timeout(30000).get();
					Element ele = doc.select("strong.tit_thumb>a").get(i);
					String add = ele.attr("href");
					datas[i] = add;	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					   
		   }
		return datas;		
	}
	


	@Override
	public String[] crawlNewsData(String[] refs) { // crawlMainPage에서 받은 값을 이용해 해당 뉴스 텍스트 전체를 긁어오는 메소드
		// TODO Auto-generated method stub
		String[] data = new String[CRAWLLIST];
		Document doc; 
		for(int i = 0; i<CRAWLLIST;i++) {
			try {
				doc = Jsoup.connect(refs[i]).timeout(30000).get();
				data[i]=doc.text();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		   }	
		return data;
	}
	
	public String[] crawlNewsData(String refs) { // crawlPageNum 메소드의 리턴값에는 1,11,21,31.. 에 대한 주소가 없어서 크롤링이 안되기에 임시방편으로 오버라이딩함 수정요망.
		// TODO Auto-generated method stub
		String[] data = new String[CRAWLLIST];
		Document doc; 
		for(int i = 0; i<CRAWLLIST;i++) {
			try {
				doc = Jsoup.connect(refs).timeout(30000).get();
				data[i]=doc.text();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		   }	
		return data;
	}
	
	
}


