package crawler;

import org.jsoup.nodes.Element;

public class Crawler_page_viewer extends Twitter {
public Crawler_page_viewer(String branch) throws Exception {
	super(branch);
		// TODO Auto-generated constructor stub
	}

//페이지 넘어가면서 Crawler_workspace를 이용해 15개씩 조회
	//1개 페이지는 1개의 스레드가 작업 -> 최대 스레드 10~20개
	private String[] pageNum;
	
	public void crawlMainPage(){
		pageNum = new String[10];
	for(int i = 0; i<pageNum.length;i++) {
		   //Element ele = doc.select("a.f_link_b").get(i);
		   Element ele = doc.select("span.inner_paging a").get(i);
		   String add = mainUrl+ele.attr("href");
		   //System.out.println(add);
		   pageNum[i] = add;		   
	   }
	}

	public String[] getPageNum() {
		return pageNum;
	}

	public void setPageNum(String[] pageNum) {
		this.pageNum = pageNum;
	}
}
