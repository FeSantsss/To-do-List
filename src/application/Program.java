package application;

import model.Services.TarefaService;
import model.entities.Tarefa;

public class Program {
		public static void main(String[] args) {
		MenuTarefa menu = new MenuTarefa();
		
		System.out.println("Bem-vindo ao Gerenciador de Tarefas!");
		System.out.println("Escolha uma opção:");
		
		menu.executar();
	
	}
}
