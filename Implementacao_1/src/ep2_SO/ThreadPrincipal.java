package ep2_SO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;

//palavra com duas aspas
//palavra modificado pode ser acessado
//como fazer o outro caso sem threads

public class ThreadPrincipal extends Thread {
	
	
	public static void main(String[] args) {
		String fileCsv = ".\\src\\logCSV.csv";
		try (BufferedWriter br = new BufferedWriter(new FileWriter(fileCsv, true))) {
			int aux = 0;
			int contador = 1;
			br.append("Leitores;");
			br.append("Escritores;");
			br.append("Media;\n");
			
			while (aux <= 100) {
				String f = ".\\src\\bd.txt";
				HashSet<ControlaThread> threads = new HashSet<ControlaThread>(100);
				BancoDeDados bd = new BancoDeDados(f);
				List<String> dados = bd.getBd();

				for (int i = 0; i < aux; i++) {
					Leitores l = new Leitores(dados, 0, false);
					threads.add(l);
				}
				for (int j = 0; j < 100 - aux; j++) {
					Escritores e = new Escritores(dados,0,false);
					threads.add(e);
				}
				int count = 0;
				
				System.out.println("PROPORCAO: " + aux + " Leitores/Escritores " + (100 - aux) + " - COMBINACAO " + contador);
				long media = 0;
				
				while (count < 50) {
					long start = System.currentTimeMillis()/1000;
					for(ControlaThread t: threads) {
						t.run();
						t.join();
					}
					count++;
					long fim = (System.currentTimeMillis()/1000) - start;
					media += fim;
				}
				br.append(aux + ";");
				br.append((100 - aux)+";");
				br.append((media/50.0)+";\n");
				System.out.println(media/50.0);
				
				contador++;
				aux++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}
}
