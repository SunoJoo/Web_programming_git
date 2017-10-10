package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawler_getaddr extends Crawler_parent {

	
	public String[] crawlNewsPage(String branch, int num) throws IOException {
		String[] nextPage = new String[num];			
		nextPage[0] = URL+branch;	
	
		String add="";
		Document doc;
		for(int i=1;i<num;i++) {
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
