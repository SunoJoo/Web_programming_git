package crawler;

import org.jsoup.nodes.Element;

public interface Crawler_page_viewer {

		
	final int CRAWLPAGELIST= 10;
	//������ �Ѿ�鼭 Crawler_workspace�� �̿��� 15���� ��ȸ
		//1�� �������� 1���� �����尡 �۾� -> �ִ� ������ 10~20��
	public String[] crawlPageNum(String ref); 	
}
