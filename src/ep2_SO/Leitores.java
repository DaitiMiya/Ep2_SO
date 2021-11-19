package ep2_SO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leitores extends ThreadsObj{
	
	private List<String> banco = new ArrayList<String>();
	
	public Leitores(List<String> bd) {
		super(bd);
		this.banco = bd;
	}

	@Override
	public void run() {
		try {
			Random r = new Random();
			//System.out.println(super.getName());
			for (int i = 0; i < 100; i++) {
				int posicao = r.nextInt(this.banco.size());
				String leu = this.banco.get(posicao);
				//System.out.println(leu);
			}
			//System.out.println(
				//	"-----------------------------------------------------------------------------------------------");
			Thread.sleep(1);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<String> getBanco() {
		return banco;
	}
}
