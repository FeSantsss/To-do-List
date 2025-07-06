package model.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import model.entities.Tarefa;

public class TarefaService {
	private List<Tarefa> listaTarefas = new ArrayList<>();
	private Integer nextID = 1;
	
	public void adicionarTarefa(String nomeDaTarefa, String descricao) {
		Tarefa tarefa = new Tarefa(nextID++, nomeDaTarefa, descricao, LocalDate.now(), false);
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
		List<Tarefa> filtrarLista = listaTarefas.stream().filter(t -> t.isStatus() == status).collect(Collectors.toList());
		if (filtrarLista.isEmpty()) {
			System.out.println("Nenhuma tarefa encontrada com o status " + (status ? "concluída" : "pendente") + ".");
		} else {
			for (Tarefa t : filtrarLista) {
				System.out.println(t);
			}
		}
	}
	
	public void excluirTarefa(int id) {
		Tarefa tarefaPraExcluir = listaTarefas.stream().filter(t -> t.getID() == id).findFirst().orElse(null);
		if (tarefaPraExcluir != null) {
			listaTarefas.remove(tarefaPraExcluir);
			System.out.println("Tarefa " + id + " excluída com sucesso.");
		} else {
			System.out.println("Tarefa não encontrada.");
		}
	}
}
