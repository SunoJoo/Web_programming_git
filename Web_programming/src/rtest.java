
import org.rosuda.JRI.Rengine;
import org.rosuda.JRI.REXP;


public class rtest
{
	public static void main(String[] args) {
		String[] Rargs = {"--vanilla"};
		Rengine re = new Rengine(Rargs, false, null);
		System.out.println("Create R Engine...");
		 
		if(!re.waitForR()) {
			System.out.println("Loading R engine was failed");
			return;
		}
		
		REXP a = re.eval("a<-10", true);
		System.out.println(a.asDouble());
	}
}