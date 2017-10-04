package crawler;

import org.jsoup.nodes.Element;

public class Crawler_workspace extends Twitter {
	private String[] list;
	
	public Crawler_workspace(String branch) throws Exception {
		super(branch);
		// TODO Auto-generated constructor stub
	}
	
	public String[] crawlMainPage(){
		list = new String[15];
	for(int i = 0; i<15;i++) {
		   //Element ele = doc.select("a.f_link_b").get(i);
		   Element ele = doc.select("strong.tit_thumb>a").get(i);
		   String add = ele.attr("href");
		   list[i] = add;		   
	   }
	return list;
	}
}
