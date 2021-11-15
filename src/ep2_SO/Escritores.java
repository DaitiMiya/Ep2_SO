package ep2_SO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Escritores extends ThreadsObj {

	public Escritores(List<String> bd) {
		super(bd);
	}

	@Override
	public void run() {
		try(BufferedWriter br = new BufferedWriter(new FileWriter(".//src//log.txt", true))){
			Random r = new Random();
			System.out.println(super.getName());
			for (int i = 0; i < super.getBd().size(); i++) {
				int posicao = r.nextInt(super.getBd().size());
				String modificado = super.getBd().get(posicao);
				modificado ="MODIFICADO";
				System.out.println(modificado);
			}
			System.out.println("-----------------------------------------------------------------------------------------------");
			Thread.sleep(1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
