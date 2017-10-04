package crawler;

public class Run {

	public static void main(String[] args) throws Exception {
		String tagsName[] = {"politics"};
		for(int i=0;i<tagsName.length;i++)
			new Twitter(tagsName[i]);
		
		Crawler_page_viewer cpv = new Crawler_page_viewer("politics");
		String[] aa = new String[10];
		aa = cpv.getPageNum();
		
		for(int i = 0 ; i<aa.length;i++) {
			aa[i]= new String();
			System.out.println(aa[i]);
		}
	}
}