package ep2_SO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Escritores extends ControlaThread {
	
	private List<String> banco = new ArrayList<String>();

	public Escritores(List<String> bd,int leitoresRodando, boolean escritorRodando) {
		super(bd,leitoresRodando,escritorRodando);
	}

	@Override
	public void run() {
		try {
			iniciaEscrita();
			//System.out.println(super.getName());
			Random r = new Random();
			for (int i = 0; i < 100; i++) {
				int posicao = r.nextInt(super.bd.size());
				String modificado = super.bd.get(posicao);
				super.bd.set(posicao, "MODIFICADO");
				System.out.println(modificado);
			}
			//System.out.println(
				//	"-----------------------------------------------------------------------------------------------");
			Thread.sleep(1);
			pararEscrita();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	synchronized void iniciaEscrita() {
		while (getLeitoresRodando() != 0 && isEscritorRodando() == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setEscritorRodando(true);
	}
	
	synchronized void pararEscrita() {
		setEscritorRodando(false);
		notifyAll();
	}
	
	public List<String> getBanco() {
		return banco;
	}
}
