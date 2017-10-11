package crawler;



public class Run {
	
	
	
	public static void main(String[] args) throws Exception {
		int thNum = 10;
		String[] crawlNewsPage1 = new String[10];
		Crawler_getaddr cg = new Crawler_getaddr(); 
		crawlNewsPage1 = cg.crawlNewsPage("economic",10); // 각 스레드에게 일을 할당할 시작 주소 구하기 ex)1,11,22,33 ... 91 				
		Thread[] tr = new Thread[10];
		File_manager fm = new File_manager(); 
		fm.deleteFile(10); // 파일 이어쓰기 문제때문에 시작할 때마다 파일 존재 여부 확인해서 있다면 삭제
	
		for(int i = 0; i<tr.length;i++) {				
			tr[i] = new Thread(new Crawler_main(crawlNewsPage1[i],i,thNum)); // 각 스레드에게 크롤러 객체와 시작주소 할당
			tr[i].start();
			System.out.println("tr"+(i+1)+" 켜짐");	
		}
		
		
		
	//R_connecting rc = new R_connecting();
	}

	
}