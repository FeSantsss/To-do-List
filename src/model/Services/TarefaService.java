package model.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.Tarefa;

public class TarefaService {
	private List<Tarefa> listaTarefas = new ArrayList<>();
	
	public void adicionarTarefa(Tarefa tarefa) {
		listaTarefas.add(tarefa);
	}
	
	public void listarTarefas() {
	    if (listaTarefas.isEmpty()) {
	        System.out.println("Nenhuma tarefa encontrada.");
	    } else {
	        for (Tarefa t : listaTarefas) {
	            System.out.println(t); 
	        }
	    }
	}
	
	public void marcarTarefaConcluida(int id) {
		for (Tarefa t : listaTarefas) {
			if (t.getID() == id) {
				t.setStatus(true);
				System.out.println("Tarefa " + id + " marcada como concluída.");
				return;
			}
		}
		System.out.println("Tarefa não encontrada.");
	}
	
	public void marcarTarefaNaoConcluida(int id) {
		for (Tarefa t : listaTarefas) {
			if (t.getID() == id) {
				t.setStatus(false);
				System.out.println("Tarefa " + id + " marcada como pendente.");
				return;
			}
		}
		System.out.println("Tarefa não encontrada.");
	}
	
	public void filtrarTarefas(boolean status) {
		List<Tarefa> filtarLista = listaTarefas.stream().filter(t -> t.isStatus() == status).collect(Collectors.toList());
		if (filtarLista.isEmpty()) {
			System.out.println("Nenhuma tarefa encontrada com o status " + (status ? "concluída" : "pendente") + ".");
		} else {
			for (Tarefa t : filtarLista) {
				System.out.println(t);
			}
		}
	}
	
	public void excluirTarefa(int id) {
		Tarefa tarefaPraExcluir = listaTarefas.of(listaTarefas.stream().filter(t -> t.getID() == id).findFirst().orElse(null));
	}

}
