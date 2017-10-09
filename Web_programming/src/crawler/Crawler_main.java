package crawler;


import java.io.BufferedWriter;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Crawler_main extends Crawler_parent implements Crawler_page_viewer, Crawler_workspace, Crawler_news{
	private String urlTrue="";
	Document doc;
	
	public Crawler_main(String branch) {
		// TODO Auto-generated constructor stub
		super.branch = branch;
		urlTrue=super.URL+super.branch;		
		
		crawlerData = new String[crawlList.length];
		
		
		try {
			doc = Jsoup.connect(urlTrue).get();
			//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt"),"MS949"));
			//out.write(doc.text());
			//out.close();
			
			System.out.println(doc.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		crawlMainPage();
		crawlPageNum();
		crawlerData= crawlNewsData();
		
		//for(int i =0;i<crawlerData.length;i++)
			//System.out.println(crawlerData[i]);
	
	}
	
	public int rtCrawlerData() {
		return crawlerData.length;
	}
	
	
	@Override
	public void crawlMainPage() {
		for(int i = 0; i<crawlList.length;i++) {
			   //Element ele = doc.select("a.f_link_b").get(i);			
				Element ele = doc.select("strong.tit_thumb>a").get(i);
				String add = ele.attr("href");
				crawlList[i] = add;		   
		   }		
	}

	@Override
	public int rtListLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void crawlPageNum() {
		for(int i = 0; i<crawlPageList.length;i++) {
			   //Element ele = doc.select("a.f_link_b").get(i);
			   Element ele = doc.select("span.inner_paging a").get(i);
			   String add = mainUrl+ele.attr("href");
			   crawlPageList[i] = add;			   
		   }		
	}

	@Override
	public int rtpageNumLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public String[] crawlNewsData() {
		// TODO Auto-generated method stub
		String[] data = new String[crawlList.length];
		
		for(int i = 0; i<crawlList.length;i++) {
			try {
				doc = Jsoup.connect(crawlList[i]).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			data[i]=doc.text();
		   }	
		return data;
	}


	

	

}
