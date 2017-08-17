import java.util.*;

public class Aluno {
	private List<Prova> provas;

	/**
	 * Construtor para a classe
	 * @param prova Objeto prova à ser inserida
	 */
	public Aluno(Prova prova) {
		provas = new ArrayList<Prova>();
		provas.add(prova);
	}

	/**
	 * Adiciona uma prova à este objeto
	 * @param prova Prova à ser inserida
	 */
	public void addProva(Prova prova) {
		provas.add(prova);
	}

	/**
	 * Remove uma prova deste objeto
	 * @param indice Posição zero-based da prova à remover
	 */
	public void delProva(int indice) {
		provas.remove(indice);
	}
	
	/**
	 * Calcula a média das notas de todas as provas do aluno
	 * @return Média das notas de todas as provas do aluno
	 */
	public double calcularMedia() {
		double media = 0;
		for(int i = 0; i < provas.size(); i++)
			media += provas.get(i).calcularNotaTotal();
		media /= provas.size();
		return media;
	}
}
