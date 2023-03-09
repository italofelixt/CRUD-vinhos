package aplicacao;

import java.util.Scanner;

import vinhos.Rotulo;
import vinhos.ListaDeRotulos;

public class Aplicacao {

	static public Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ListaDeRotulos vetor = new ListaDeRotulos(5);
		Rotulo rt = new Rotulo();

		int opcao = -1;

		try {
			while (opcao != 0) {
				System.out.println("\nDigite uma opção: ");
				mostraMenu();
				opcao = sc.nextInt();

				switch (opcao) {
				case 1:
					System.out.println("***** Adicionando novo Rótulo *****");

					System.out.print("Nome: ");
					sc.nextLine(); // Para limpar o inputStream
					String nome = sc.nextLine();

					System.out.print("Produtor: ");
					String produtor = sc.nextLine();

					System.out.print("Tipo: ");
					String tipo = sc.nextLine();

					System.out.print("Região: ");
					String regiao = sc.nextLine();

					System.out.print("Ano de Produção: ");
					int anoProducao = sc.nextInt();
					System.out.println("\n");

					vetor.adiciona(rt.criaRotulo(nome, produtor, tipo, regiao, anoProducao)); // cria e add um novo
																								// rótulo
					break;

				case 2:
					System.out.println("Lista de Rótulos cadastrados: \n");
					System.out.println(vetor.toString());
					break;

				case 3:
					System.out.println("Histórico de rótulos já cadastrados até hoje: ");
					System.out.println(Rotulo.getQuantidadeDeRotulos());// usa Rotulo invés de rt pois é um atributo
																		// estático, então é independente de instância
					break;

				case 4:
					System.out.println("Quantidade de rótulos cadastrados atualmente: ");
					System.out.println(vetor.getTamanho());
					break;

				case 5:
					System.out.println("Indique pela posição, qual o rótulo deseja remover");
					int posicao = sc.nextInt();
					menuRemove(vetor, posicao);
				}

			}

			System.out.println("Saindo...");
			System.out.println("Fim.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mostraMenu() {
		System.out.println("*************** MENU ****************");
		System.out.println("0 - Sair");
		System.out.println("1 - Adiciona Rótulo");
		System.out.println("2 - Lista de Rótulos");
		System.out.println("3 - Quantidade de Rótulos (Histórico)");
		System.out.println("4 - Quantidade de Rótulos (Atual)");
		System.out.println("5 - Apaga Rótulo");
		System.out.println("*************************************");
	}

	public static void menuRemove(ListaDeRotulos vetor, int posicao) throws Exception {

		System.out.println("O rótulo indicado é: ");
		System.out.println(vetor.buscaElementoNaPosicao(posicao - 1));

		String opcao = "";
		System.out.println("Tem certeza que deseja excluir esse rótulo? (S/N)");
		// System.out.println("Ou aperte Q para sair.");

		opcao = sc.next();
		if (opcao.equalsIgnoreCase("s"))
			vetor.remove(posicao - 1);
		
		if(opcao.equalsIgnoreCase("n"))
			return;
			
	}

}
