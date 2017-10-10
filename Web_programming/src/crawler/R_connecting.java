package crawler;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class R_connecting {		
	    public R_connecting() {
	        String[] Rargs = {"--vanilla"};
	        Rengine re = new Rengine(Rargs, false, null);
	        System.out.println("Create R Engine...");
	        
	        if(!re.waitForR()){
	            System.out.println("Loading R engine was failed");
	            return;
	        }
	        REXP a = re.eval("a <- 20", true);
	        System.out.println(a.asDouble());
	    }	
}
