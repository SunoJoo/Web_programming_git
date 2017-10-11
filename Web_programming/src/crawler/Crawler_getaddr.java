package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawler_getaddr extends Crawler_parent {

	
	public String[] crawlNewsPage(String branch, int num) throws IOException {
		// 스레드에게 할당할 시작주소 구하기 1,11,21,31,41... 91
		String[] nextPage = new String[num];			
		nextPage[0] = URL+branch;	
	
		String add="";
		Document doc;
		for(int i=1;i<num;i++) {
			doc = Jsoup.connect(nextPage[i-1]).get();
			Element ele;
			if(i==1) { // 1번페이지와 11번 이후 페이지들은 포맷이 약간 달라서 1번 페이지를 예외적으로 코드 작성
				ele = doc.select("span.inner_paging a").get(9);
				add = mainUrl+ele.attr("href");	 // ele의 href값을 반환
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
