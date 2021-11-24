

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockLeitores extends ControlaThread {

	private List<String> banco = new ArrayList<String>();


	public BlockLeitores(List<String> bd, int leitoresRodando, boolean escritorRodando) {
		super(bd, leitoresRodando, escritorRodando);
	}

	@Override
	public void run() {
		try  {
			super.bloqueia();
			Random r = new Random();
			//System.out.println(super.getName());
			
			for (int i = 0; i < 100; i++) {
		
				int posicao = r.nextInt(super.bd.size());
				String leu = super.bd.get(posicao);
				//System.out.println(leu);
			}
			// System.out.println(
			// "-----------------------------------------------------------------------------------------------");
			Thread.sleep(1);
			super.desbloqueia();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getBanco() {
		return banco;
	}

	
}
