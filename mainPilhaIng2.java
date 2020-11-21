package Pilhas2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class mainPilhaIng2 extends PilhaIngenua2 {

	public static void main(String[] args) {
		long milisInicial = System.currentTimeMillis();
		Integer[] executados = new Integer[1000000];
		Integer[] tarefas = ler();
		PilhaIngenua2 pilha = new PilhaIngenua2();

		int s = 0;
		for(int i = 0; tarefas[i] != null; i++) {
			if(tarefas[i] != -1) {
				pilha.add(tarefas[i]);
			}else {
				executados[s] = pilha.remove();
				//System.out.println(tarefas[s]);
				s++;		
			}
		}

		File saida = new File("saida.txt");
		try {
			saida.createNewFile();
		} catch (IOException ex) {
			
		}
		try {
		FileWriter out = new FileWriter(saida);
		BufferedWriter buffwrite = new BufferedWriter(out);

		for(int i = 0; i < executados.length && executados[i] != null; i++) {
			String impresso = String.valueOf(executados[i]);
			buffwrite.write(impresso);
			buffwrite.newLine();
			buffwrite.flush();
		}
		buffwrite.close();
		out.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	long milisFinal = System.currentTimeMillis();
	System.out.println(milisFinal - milisInicial);
	}

	private static Integer[] ler(){
		Integer[] pegaValores = new Integer[1000000];
		try {
			FileReader arquivo = new FileReader("C:\\Users\\Daniel\\eclipse-workspace\\AEDI - EP2\\src\\entradas\\tarefas1000.txt");
			BufferedReader buffread = new BufferedReader(arquivo);
		 
			String linha;
			int j = 0;
			while ((linha = buffread.readLine()) != null) {
				if(linha.trim().length() != 0) {
					int num = Integer.parseInt(linha);
					pegaValores[j] = num;
					j++;
				}else {
					pegaValores[j] = -1;
					j++;
				}
			}
			buffread.close();
			arquivo.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return pegaValores;
	}
}