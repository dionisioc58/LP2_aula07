import java.util.*;

public class Turma {
	private List<Aluno> alunos;

	/**
	 * Construtor para a classe
	 * @param aluno Objeto aluno à ser inserido na turma
	 */
	public Turma(Aluno aluno) {
		alunos = new ArrayList<Aluno>();
		alunos.add(aluno);
	}

	/**
	 * Lista de todos alunos da turma
	 * @return Lista de todos os alunos da turma
	 */
	public List<Aluno> getAlunos() {
		return alunos;
	}

	/**
	 * Adiciona um aluno à este objeto
	 * @param aluno Aluno à ser inserido
	 */
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	/**
	 * Remove um aluno deste objeto
	 * @param indice Posição zero-based do aluno à remover
	 */
	public void delAluno(int indice) {
		alunos.remove(indice);
	}

	/**
	 * Calcula a média das notas de todas as provas de um aluno
	 * @param indice Posição zero-based do aluno na lista
	 * @return Média das notas de todas as provas de um aluno
	 */
	public double getMediaAluno(int indice) {
		return alunos.get(indice).calcularMedia();
	}

	/**
	 * Calcula a média das notas de todos os alunos
	 * @return Média das notas de todos os alunos
	 */
	public double calcularMedia() {
		double media = 0;
		for(int i = 0; i < alunos.size(); i++)
			media += alunos.get(i).calcularMedia();
		media /= alunos.size();
		return media;
	}
}
