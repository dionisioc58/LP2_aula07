public class Jogo {

	FornecedorDaSenha desafiante;
	Adivinho desafiado;
	
	public Jogo() {
		desafiante = new FornecedorDaSenha();
		desafiado = new Adivinho();
	}

	/** Função que verifica se o Adivinho já ganhou o jogo, 
	 *  sabendo que o mesmo ocorre apenas quando o FornecedorDaSenha 
	 *  retorna todos os pinos pretos.
	 **/
	public boolean verSeAdivinhoGanhouJogo() {
		Retorno retorno = desafiante.getJogada().getRetorno();
		if(retorno.getPinosInseridos() != desafiante.getJogada().getTentativa().quantosPinosJaForamAdicionados())
			return false;
		try {
			for(int i = 0; i < retorno.getPinosInseridos(); i++)
				if((retorno.getPino(i) != "preto"))
					return false;
		
			return true;
		} catch (PosicaoInvalidaException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/** Método de impressão da jogada
	 *  atual efetuada pelo adivinho(jogador atual).
	 **/
	public void mostrarPinosTentativaDaJogada() {
		Tentativa tentativa = desafiante.getJogada().getTentativa();
		try {
			System.out.print((char)27 + "[42m");
			System.out.print("A tentativa foi: ");
			System.out.print(tentativa.imprime());
			System.out.println((char)27 + "[0m");
		} catch (PosicaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** Método de impressão resultante da jogada do adivinho, 
	 *  apresentando os pinos pretos e brancos indicando se ele
	 *  acertou uma posição e cor ou uma cor de algum pino da senha.
	 **/
	public void mostrarPinosRetornoDaJogada() {
		Retorno retorno = desafiante.getJogada().getRetorno();
		try {
			System.out.print((char)27 + "[43m");
			System.out.print("O retorno da jogada foi: ");
			System.out.print(retorno.imprime());
			System.out.println((char)27 + "[0m");
		} catch (PosicaoInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/** Função que finaliza o jogo, caso o adivinho tenha
	 *  acertado a sequência de cores, ou caso tenham 
	 *  ultrapassado 10 tentativas.
	 **/
	public void terminarJogo() {
		System.out.println("Tchau.");
	}
	
	/**
	 * Função que inicializa o jogo Senha, apresenta um
	 * menu com as opções do jogo e o progresso jogada a jogada.
	 **/
	public void executarJogo() { 
		System.out.println("\tSeja bem-vindo. O jogo vai começar.\n");
		desafiante.criarSenha();
		
		int i = 1;
		while(true) {
			System.out.println();
			System.out.println(i + "ª tentativa.");
			
			//Capturar a tentativa do desafiado
			desafiado.jogar();

			//Expor a tentativa ao desafiante
			desafiante.setJogada(desafiado.getJogada());
			desafiante.jogar();

			//Exibir a tentativa
			mostrarPinosTentativaDaJogada();
			
			//Exibir o retorno
			mostrarPinosRetornoDaJogada();
			
			//Verificar se acertou
			if(verSeAdivinhoGanhouJogo()) {
				System.out.println("Você ganhou!");
				terminarJogo();
			}

			i++;

			if(i >= 10) {
				System.out.println("Você perdeu! Tentativas esgotadas.");
				terminarJogo();
			}
		}
	}
}
