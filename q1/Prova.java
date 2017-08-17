import java.util.*;

public class Prova {
	private List<Double> notas;

	/**
	 * Construtor para a classe
	 * @param nota Valor de uma nota à ser inserida
	 */
	public Prova(double nota) {
		notas = new ArrayList<Double>();
		notas.add(nota);
	}

	/**
	 * Adiciona uma nota à este objeto
	 * @param nota Valor à ser inserido
	 */
	public void addNota(double nota) {
		notas.add(nota);
	}

	/**
	 * Remove uma nota deste objeto
	 * @param indice Posição zero-based da nota à remover
	 */
	public void delNota(int indice) {
		notas.remove(indice);
	}

	/**
	 * Calcula a nota total (soma de todas as notas)
	 * @return Soma de todas as notas
	 */
	public double calcularNotaTotal() {
		double total = 0;

		for(int i = 0; i < notas.size(); i++)
			total += notas.get(i);

		if(total > 10)
			total = 10;
		return total;
	}
}
