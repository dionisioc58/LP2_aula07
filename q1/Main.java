public class Main {
	public static void main(String[] args) {
		Prova prova1  = new Prova(4);
		prova1.addNota(2.5);

		Prova prova2  = new Prova(1);
		prova2.addNota(7);

		Prova prova3  = new Prova(6.5);
		prova3.addNota(3.5);

		Prova prova4  = new Prova(0);
		prova4.addNota(3);

		Prova prova5  = new Prova(5);
		prova5.addNota(4);

		Prova prova6  = new Prova(6);
		prova6.addNota(1.5);

		Aluno aluno1 = new Aluno(prova1);
		aluno1.addProva(prova2);

		Aluno aluno2 = new Aluno(prova3);
		aluno2.addProva(prova4);

		Aluno aluno3 = new Aluno(prova5);
		aluno3.addProva(prova6);

		Turma turma = new Turma(aluno1);
		turma.addAluno(aluno2);
		turma.addAluno(aluno3);

		for(Aluno aluno : turma.getAlunos()) {
			System.out.print("Média do aluno ");
			System.out.print((turma.getAlunos().indexOf(aluno) + 1));
			System.out.println(": " + aluno.calcularMedia());
		}

		System.out.println("Média da turma: " + turma.calcularMedia());
	}
}
