package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entities.Products;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String file = "C:\\ProjetosTesteJavaVSCode\\TesteProdutos.txt";
		
		List<Products> list = new ArrayList<>();
		
		char resp2;
		
		do {
			System.out.println("O que deseja fazer no programa?\\nAdicionar produto ao estoque - (A)\\nRetirar produto do estoque - (R)\\nPedir a lista de produtos que tem em estoque - (L)");
			char resp = sc.next().charAt(0);
		
			//LENDO PRODUTOS DA LISTA
			if(resp == 'L') {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String line = br.readLine();

					while (line != null) {
						String[] fields = line.split(", ");
						list.add(new Products(fields[0], Double.parseDouble(fields[1])));

						line = br.readLine();
					}

					Comparator<Products> comp = new Comparator<Products>() {

						@Override
						public int compare(Products p1, Products p2) {
							return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
						}

					};

					list.sort(comp);

					for (Products p : list) {
						System.out.println(p);
					}
					
					line = br.readLine();

				} catch (IOException e) {
					System.out.println("erro: " + e.getMessage());
				}
			}
			
			//ADICIONANDO PRODUTOS À LISTA
			if(resp == 'A') {
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
					
					
					
				}
				catch(IOException e) {
					System.out.println("Error addig product: ");
				}
				
			}
			
			//REMOVENDO PRODUTOS DA LISTA
			if(resp == 'R') {
				System.out.println("RETIRAR");
			}

			System.out.println("Deseja realizar mais alguma ação no programa? (s/n)");
			resp2 = sc.next().charAt(0);
			
		}while(resp2 == 's');
		
		System.out.println("FIM DO PROGRAMA!");
		sc.close();
	}

}
