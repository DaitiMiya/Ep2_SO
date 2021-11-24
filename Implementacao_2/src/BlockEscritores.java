
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockEscritores extends ControlaThread {
	
	private List<String> banco = new ArrayList<String>();

	public BlockEscritores(List<String> bd,int bloqueados, boolean statusBloqueado) {
		super(bd,bloqueados,statusBloqueado);
	}

	@Override
	public void run() {
		try {
			super.bloqueia();
			//System.out.println(super.getName());
			Random r = new Random();
			for (int i = 0; i < 100; i++) {
				int posicao = r.nextInt(super.bd.size());
				//String modificado = super.bd.get(posicao);
				super.bd.set(posicao, "MODIFICADO");
				//System.out.println(modificado);
			}
			//System.out.println(
				//	"-----------------------------------------------------------------------------------------------");
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
