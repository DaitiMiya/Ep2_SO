package ep2_SO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Escritores extends ThreadsObj {
	
	private List<String> banco = new ArrayList<String>();
	
	public Escritores(List<String> bd) {
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
				//String modificado = this.banco.get(posicao);
				this.banco.set(posicao, "MODIFICADO");
				//System.out.println(modificado);
			}
			//System.out.println(
			//		"-----------------------------------------------------------------------------------------------");
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
