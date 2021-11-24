import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	private List<String> bd = new ArrayList<String>();

	public BancoDeDados(String f) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {

			String line = br.readLine();
			while (line != null) {
				this.bd.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo bd.txt");
		}
		
	}

	public List<String> getBd() {
		return bd;
	}
	
}
