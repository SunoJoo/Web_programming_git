package crawler;

import org.jsoup.nodes.Element;

public interface Crawler_page_viewer {

		
	final int CRAWLPAGELIST= 10;
	//페이지 넘어가면서 Crawler_workspace를 이용해 15개씩 조회
		//1개 페이지는 1개의 스레드가 작업 -> 최대 스레드 10~20개
	public String[] crawlPageNum(String ref); 	
}
