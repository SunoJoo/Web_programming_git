package crawler;

public class Run {

	public static void main(String[] args) {
		String tagsName[] = {"문재인"};
		for(int i=0;i<1;i++)
			new Twitter(tagsName[i]);
	}
}