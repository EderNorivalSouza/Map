package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		Map<String, Integer> votos = new LinkedHashMap<>();
		
		System.out.println("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line!=null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				int numero = Integer.parseInt(fields[1]);
				if(votos.containsKey(nome)) {
					int votoamais = votos.get(nome);
					votos.put(nome, numero + votoamais);
				}
				else {
					votos.put(nome, numero);
				}
							
				
				line = br.readLine();
			}
			
			for(String Key : votos.keySet()) {
				System.out.println(Key + ": "+votos.get(Key));
			}
			
		}catch(IOException e) {
		System.out.println(e.getMessage());
		}
	}

}
