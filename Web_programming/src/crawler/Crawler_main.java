package crawler;


import java.io.BufferedWriter;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawler_main extends Crawler_parent implements Crawler_page_viewer, Crawler_workspace, Crawler_news, Runnable{
	private String urlTrue="";	
	private String[] crawlList=null;
	private String[] pageName=null;
	private String[] data;
	private static int searchRange;
	

	int task = 0;
	int offset = 0;
	
	public Crawler_main(String branch, int num) {
		// TODO Auto-generated constructor stub
		super.branch = branch;
		urlTrue=super.URL+super.branch;			
		searchRange = num;
		
		crawlList = new String[10];		
		nextPages = new String[num];
		pageName = new String[CRAWLLIST];
		data = new String[CRAWLLIST];
		
		//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"),"MS949"));
		//out.write(doc.text());
		//out.close();
		try {
			nextPages=crawlNewsPage();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	
		run();
		
		
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
		crawlList = crawlPageNumOne(nextPages[task]);
		if(task>1)
			crawlList = crawlPageNumOne(nextPages[task]);
		task++;
		pageName = crawlMainPage(crawlList[task]);
		data = crawlNewsData(pageName);
		for(int i = 0; i<data.length;i++) {
			System.out.println(data[i]); //Å×½ºÆ® À¯´Ö
			}
	}
	
	
	@Override
	public String[] crawlPageNum(String ref) {
		String[] datas = new String[CRAWLPAGELIST-1];		
		Document doc; 
		for(int i = 1; i<CRAWLPAGELIST;i++) {	
			try {
				doc = Jsoup.connect(ref).get();
				
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
				doc = Jsoup.connect(ref).get();
				
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
					doc = Jsoup.connect(ref).get();
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
				doc = Jsoup.connect(refs[i]).get();
				data[i]=doc.text();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		   }	
		return data;
	}
	
	public String[] crawlNewsPage() throws IOException {
		String[] nextPage = new String[searchRange];	
		nextPage[0] = urlTrue;	
		String add="";
		Document doc;
		for(int i=1;i<searchRange;i++) {
			doc = Jsoup.connect(nextPage[i-1]).get();
			Element ele;
			if(i==1) {
				ele = doc.select("span.inner_paging a").get(9);
				add = mainUrl+ele.attr("href");	
			}
			else {
				ele = doc.select("span.inner_paging a").get(10);
				add = mainUrl+ele.attr("href");	 
			}
			nextPage[i] = add;				
		}	
		return nextPage;		
	}
}


