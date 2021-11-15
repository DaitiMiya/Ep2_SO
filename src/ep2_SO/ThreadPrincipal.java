package ep2_SO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ThreadPrincipal extends Thread {

	public static void main(String[] args) throws InterruptedException {
		String f = ".\\src\\bd.txt";
		HashSet<ThreadsObj> threads = new HashSet<ThreadsObj>(100);
		BancoDeDados bd = new BancoDeDados(f);
		List<String> dados = bd.getBd();
		for (int i = 0; i < 100; i++) {
			Escritores e = new Escritores(dados);
			threads.add(e);
		}
		List<ThreadsObj> list = new ArrayList<ThreadsObj>();
		list.addAll(threads);
		try (BufferedWriter br = new BufferedWriter(new FileWriter(".//src//log2.txt"))) {
			for (ThreadsObj t : list) {
				br.write(t.getName());
				br.newLine();
				t.start();
				t.join();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
