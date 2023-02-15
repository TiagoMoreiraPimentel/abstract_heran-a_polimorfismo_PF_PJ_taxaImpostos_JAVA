package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Pessoa;
import Entities.PessoaFisica;
import Entities.PessoaJuridica;

public class Main {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Insira o número de contribuintes: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			Double renda = sc.nextDouble();
			
			if(ch == 'f') {
				System.out.print("Gastos com saúde: ");
				Double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, renda, gastoSaude));
			}
			else if(ch == 'j') {
				System.out.print("Numero de Funcionarios: ");
				int numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, renda, numeroFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("IMPOSTOS PAGOS: ");
		Double soma = 0.0;
		
		for(Pessoa pessoa : list) {
			
			Double imposto = pessoa.CalculoImposto();
			System.out.printf(pessoa.getNome() + ": $ " + String.format("%.2f%n", imposto));
			soma += imposto;
		}
		
		System.out.println();
		System.out.println("TOTAL DE IMPOSTOS: ");
		System.out.printf("TOTAL: $ " + String.format("%.2f", soma));
		
		sc.close();
		
	}
}
