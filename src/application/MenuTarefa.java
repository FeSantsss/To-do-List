package application;

import java.util.Scanner;

import model.Services.TarefaService;
import model.entities.Tarefa;

public class MenuTarefa {

	public void executar() {
		boolean continua = true;
		TarefaService tarefa = new TarefaService();
		try (Scanner sc = new Scanner(System.in)) {
			while (continua) {
				System.out.println("\n--- MENU DE TAREFAS ---\n" + "1 - Adicionar Tarefa\n" + "2 - Listar Tarefas\n"
						+ "3 - Marcar Tarefa como Concluída\n" + "4 - Marcar Tarefa como Não Concluída\n"
						+ "5 - Filtrar Tarefas\n" + "6 - Excluir Tarefa\n" + "7 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcao = sc.nextInt();

				switch (opcao) {
				case 1:
					System.out.print("Digite o nome da tarefa: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.print("Digite a descrição da tarefa: ");
					String descricao = sc.nextLine();
					tarefa.adicionarTarefa(nome, descricao);
					System.out.println("Tarefa adicionada com sucesso.");
					break;
				case 2:
					System.out.println("\n--- LISTA DE TAREFAS ---");
					tarefa.listarTarefas();
					break;
				case 3:
					System.out.print("Digite o ID da tarefa a ser marcada como concluída: ");
					int idConcluida = sc.nextInt();
					tarefa.marcarTarefaConcluida(idConcluida);
					break;
				case 4:
					System.out.print("Digite o ID da tarefa a ser marcada como não concluída: ");
					int idPendente = sc.nextInt();
					tarefa.marcarTarefaNaoConcluida(idPendente);
					break;
				case 5:
					System.out.print("Deseja filtrar por tarefas concluídas (1) ou pendentes (2)? ");
					int filtro = sc.nextInt();
					if (filtro == 1) {
						tarefa.filtrarTarefas(true);
					} else if (filtro == 2) {
						tarefa.filtrarTarefas(false);
					} else {
						System.out.println("Opção inválida.");
					}
					break;
				case 6:
					System.out.print("Digite o ID da tarefa a ser excluída: ");
					int idExcluir = sc.nextInt();
					tarefa.excluirTarefa(idExcluir);
					break;
				case 7:
					System.out.println("Saindo do programa...");
					continua = false;
					break;
				default:
					System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
					break;
				}

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
