

import java.util.ArrayList;
import java.util.List;

public class ControlaThread extends Thread{
	protected List<String> bd = new ArrayList<String>();
	private int bloqueados;
	private boolean statusBloqueado;
	private Thread threadBloqueada = null;
	
	

	public ControlaThread(List<String> bd, int bloqueados, boolean statusBloqueado) {
		this.bd = bd;
		this.bloqueados = bloqueados;
		this.statusBloqueado = statusBloqueado;
	}

	public synchronized void bloqueia() throws InterruptedException {
		Thread threadAtual = Thread.currentThread();
		while (this.statusBloqueado && threadBloqueada != threadAtual) {
			wait();
		}
		this.statusBloqueado = true;
		this.bloqueados++;
		this.threadBloqueada = threadAtual;
	}
	

	public synchronized void desbloqueia() {
		if (Thread.currentThread() == this.threadBloqueada) {
			this.bloqueados--;

			if (this.bloqueados == 0) {
				this.statusBloqueado = false;
				notify();
			}
		}
	}

	public int getBloqueados() {
		return bloqueados;
	}



	public void setBloqueados(int bloqueados) {
		this.bloqueados = bloqueados;
	}



	public boolean isStatusBloqueado() {
		return statusBloqueado;
	}



	public void setStatusBloqueado(boolean statusBloqueado) {
		this.statusBloqueado = statusBloqueado;
	}



	public Thread getThreadBloquada() {
		return threadBloqueada;
	}



	public void setThreadBloquada(Thread threadBloquada) {
		this.threadBloqueada = threadBloquada;
	}

	
}
