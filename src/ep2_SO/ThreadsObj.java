package ep2_SO;

import java.util.ArrayList;
import java.util.List;

public class ThreadsObj extends Thread{
	private List<String> bd = new ArrayList<String>(100);
	
	public ThreadsObj(List<String> bd) {
		this.bd = bd;
	}

	public List<String> getBd() {
		return bd;
	}
	
}
