package crawler;

import java.io.File;
import java.io.InputStream;

public class File_manager {
	File file;	
	InputStream is = null;
	public void deleteFile(int num){
	
		for(int i=1;i<=num;i++) {
			file = new File("result_thread "+i+".txt");
			if(file.isFile()) {
				if(file.delete())
					System.out.println("파일 삭제 성공");
				else
					System.out.println("파일이 없습니다.");
			}			
		}
	}
}
