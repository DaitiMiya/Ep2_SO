package ep2_SO;

import java.util.ArrayList;
import java.util.List;

public class ControlaThread extends Thread{
	protected List<String> bd = new ArrayList<String>();
	private int leitoresRodando;
	private boolean escritorRodando;
	
	
	public void setLeitoresRodando(int leitoresRodando) {
		this.leitoresRodando = leitoresRodando;
	}


	public void setEscritorRodando(boolean escritorRodando) {
		this.escritorRodando = escritorRodando;
	}


	public ControlaThread(List<String> bd, int leitoresRodando, boolean escritorRodando) {
		this.bd = bd;
		this.leitoresRodando = leitoresRodando;
		this.escritorRodando = escritorRodando;
	}


	public boolean isEscritorRodando() {
		return escritorRodando;
	}


	public int getLeitoresRodando() {
		return leitoresRodando;
	}
	
}
