package crawler;

public class Crawler_parent {
	 protected String mainUrl = "http://media.daum.net";
	 protected String URL = mainUrl+"/breakingnews/";	
	 protected String[] crawlerData;
	 protected String branch="";	
	 protected String[] nextPages;
	 
	public String[] getCrawlerData() {
		return crawlerData;
	}
	public void setCrawlerData(String[] crawlerData) {
		this.crawlerData = crawlerData;
	} 
}
