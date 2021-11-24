package ep2_SO;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leitores extends ControlaThread {

	private List<String> banco = new ArrayList<String>();


	public Leitores(List<String> bd, int leitoresRodando, boolean escritorRodando) {
		super(bd, leitoresRodando, escritorRodando);
	}

	@Override
	public void run() {
		try  {
			comecarLeitura();
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
			pararLeitura();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getBanco() {
		return banco;
	}

	synchronized void comecarLeitura() {
		while (isEscritorRodando() == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setLeitoresRodando(getLeitoresRodando()+1);
	}
	
	/*tira um leitor ativo*/
	synchronized void pararLeitura() {
		setLeitoresRodando(getLeitoresRodando()-1);
		notifyAll();
	}
}
