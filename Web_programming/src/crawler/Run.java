package crawler;



public class Run {
	
	
	
	public static void main(String[] args) throws Exception {
		int thNum = 10;
		String[] crawlNewsPage1 = new String[10];
		Crawler_getaddr cg = new Crawler_getaddr();
		crawlNewsPage1 = cg.crawlNewsPage("economic",10);					
		Thread[] tr = new Thread[10];
		
	
		for(int i = 0; i<tr.length;i++) {				
			tr[i] = new Thread(new Crawler_main(crawlNewsPage1[i],i,thNum));
			tr[i].start();
			System.out.println("tr"+(i+1)+" 켜짐");	
		}
		
		
		
	//R_connecting rc = new R_connecting();
	}

	public void rrr() {
		
	}
}