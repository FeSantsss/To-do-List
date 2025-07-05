package application;

import java.util.Scanner;

public class MenuTarefa {

	public static void main(String[] args) {
		boolean continua = true;
		try (Scanner sc = new Scanner(System.in)) {
			while (continua) {
				System.out.println(
						"\n--- MENU DE TAREFAS ---\n" 
						+ "1 - Adicionar Tarefa\n" 
						+ "2 - Listar Tarefas\n"
						+ "3 - Filtrar Tarefas\n" 
						+ "4 - Excluir Tarefa\n" 
						+ "5 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = sc.nextInt();
				
				//posteriormente: switch

				if (continua) {
					System.out.print("Deseja continuar? (s/n): ");
					char resposta = sc.next().toLowerCase().charAt(0);
					if (resposta == 'n') {
						continua = false;
						System.out.println("Programa finalizado.");
					} else if (resposta != 's') {
						System.out.println("Opção inválida. Encerrando o programa.");
						continua = false;
					}
				}
			}
		}
	}
}
