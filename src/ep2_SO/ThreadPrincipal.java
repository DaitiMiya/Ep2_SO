package ep2_SO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//palavra com duas aspas
//palavra modificado pode ser acessado
//como fazer o outro caso sem threads

public class ThreadPrincipal extends Thread {

	public static void main(String[] args) {
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter(".\\src\\log.txt", true))) {
			int aux = 0;
			int contador = 1;
			while (aux <= 100) {
				String f = ".\\src\\bd.txt";
				HashSet<ThreadsObj> threads = new HashSet<ThreadsObj>(100);
				BancoDeDados bd = new BancoDeDados(f);
				List<String> dados = bd.getBd();

				for (int i = 0; i < aux; i++) {
					Leitores l = new Leitores(dados);
					threads.add(l);
				}
				for (int j = 0; j < 100 - aux; j++) {
					Escritores e = new Escritores(dados);
					threads.add(e);
				}
				int count = 0;
				System.out.println("PROPORCAO: " + aux + " Leitores/Escritores " + (100 - aux) + " - COMBINACAO " + contador);
				long media = 0;
				while (count < 50) {
					long start = System.currentTimeMillis()/1000;
					for (ThreadsObj l : threads.stream()
							.filter(x -> x.getClass().toString().equals("class ep2_SO.Leitores"))
							.collect(Collectors.toList())) {

						//br.append("##########################################");
						//br.append("\n");
						Thread newThreadLeitor = new Thread(l);
						//br.append("PROPORCAO: " + aux + " Leitores/Escritores " + (100 - aux) + " - COMBINACAO " + contador);
						//br.append("\n");
						//br.append(l.getClass().toString());
						//br.append("\n");
						newThreadLeitor.start();
						newThreadLeitor.join();
					}
					for (ThreadsObj t : threads.stream()
							.filter(x -> x.getClass().toString().equals("class ep2_SO.Escritores"))
							.collect(Collectors.toList())) {
						Thread newThreadEscritor = new Thread(t);
						//br.append(t.getClass().toString());
						//br.append("\n");
						//br.append("PROPORCAO: " + aux + " Leitores/Escritores " + (100 - aux) + " - COMBINACAO " + contador);
						//br.append("\n");
						newThreadEscritor.start();
						
						newThreadEscritor.join();
					}

					count++;
					long fim = (System.currentTimeMillis()/1000) - start;
					media += fim;
				}
				
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
