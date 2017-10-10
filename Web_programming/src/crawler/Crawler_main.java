package crawler;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class Crawler_main extends Crawler_parent implements Crawler_page_viewer, Crawler_workspace, Crawler_news, Runnable{
	
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
	public void run() {
		// TODO Auto-generated method stub
		if(task==0) 
			task_0_jop();	
		if(task>0) 
			task_1_jop();		
	}	
	
	public void task_0_jop() {
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
	
	public void task_1_jop() {
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
	public void exportFile(String[] data) {
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
	public String[] crawlPageNum(String ref) {
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
	
	public String[] crawlPageNumOne(String ref) {
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
	public String[] crawlMainPage(String ref) {
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
	public String[] crawlNewsData(String[] refs) {
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
	
	public String[] crawlNewsData(String refs) {
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


