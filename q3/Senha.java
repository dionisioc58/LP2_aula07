/**
 * Classe que representa a senha do jogo. Vai armazenar pinos de cores
 * diferentes e o adivinho(usuário que usa o sistema) vai tentar adivinhar a
 * senha para ganhar o jogo.
 */
public class Senha {
	/**
	 * o atributo senha é um arranjo que só vai ter 4 posições representando os
	 * pinos da senha. É um arranjo de Strings onde cada elemento do arranjo é a
	 * cor de um pino. Por exemplo, se senha=["azul", "verde", "rosa" e "cinza"]
	 * então a senha é: pino1="azul" pino2="verde" pino3="rosa" pino4="cinza"
	 */
	private String senha[];

	/**
	 * o atributo pinosInseridos representa o total de pinos já inseridos na
	 * senha. Essa senha só pode ter 4 pinos.
	 */
	private int pinosInseridos;

	public Senha() {
		senha = new String[4];
		for (int i = 0; i < 4; i++) {
			senha[i] = "nenhum";// por enquanto, nenhum pino foi inserido na
								// senha.
		}
		pinosInseridos = 0;
	}

	/**
	 * método para adicionar um pino na senha.
	 * 
	 * @param corPino
	 *            É uma String representando a cor do pino a ser adicionado.
	 *            Pode ser "vermelho","rosa","amarelo","roxo","verde","cinza" ou
	 *            "laranja".
	 * @throws CorInvalidaException
	 *             caso a cor fornecida como parâmetro do método não seja válida
	 *             no nosso jogo.
	 */
	public void adicionarPino(String corPino) throws CorInvalidaException {
		if (this.CorEhValida(corPino) != true) {
			throw new CorInvalidaException();
		} else if (pinosInseridos != 4) {
			senha[pinosInseridos] = corPino;
			pinosInseridos++;
		}

	}

	public int getPinosInseridos() {
		return pinosInseridos;
	}

	/**
	 * método para checar se uma String representando uma cor é válida para ser
	 * adicionada na senha(consequentemente, checa se o pino é válido para a
	 * senha). As cores válidas são:
	 * "vermelho","rosa","amarelo","roxo","verde","cinza" ou "laranja".
	 * 
	 * @param c1
	 *            String que representa a cor a ser checada.
	 * @return um booleano indicando se a cor é válida para ser inserida na
	 *         senha
	 */
	public boolean CorEhValida(String c1) {
		if (c1 == null) {
			return false;
		} else if ((c1.compareTo("vermelho") == 0) || (c1.compareTo("azul") == 0) || (c1.compareTo("rosa") == 0)
				|| (c1.compareTo("amarelo") == 0) || (c1.compareTo("roxo") == 0) || (c1.compareTo("verde") == 0)
				|| (c1.compareTo("cinza") == 0) || (c1.compareTo("laranja") == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * esse método pega um pino(String com cor do pino) no atributo
	 * "String [] senha" da classe.
	 * 
	 * @param posicao
	 *            indica o índice onde o pino está inserido na senha.
	 * @return String representando a cor do pino contido na senha.
	 * @throws PosicaoInvalidaException
	 *             essa exceção é lançada quando o parâmetro do método é um
	 *             índice inválido para a senha.
	 */
	public String getPino(int posicao) throws PosicaoInvalidaException {
		if (posicao < 0 || posicao > 3) {
			throw new PosicaoInvalidaException();
		}

		return this.senha[posicao];

	}

	/**
	 * checa se uma senha é válida para ser usada no jogo. Uma senha válida
	 * contém 4(QUATRO) pinos de CORES DIFERENTES.
	 * 
	 * @return um booleano representando se a senha é válida para ser usada no
	 *         jogo.
	 */
	public boolean ehSenhaValida() {
		// como não podemos inserir senha de cor inválida, basta
		// checar se não há cores repetidas
		boolean ehValida = true;
		String corComparada;
		int i, j;
		for (i = 0; i < 4; i++) {
			corComparada = senha[i];
			if (corComparada == "nenhum") {
				ehValida = false;
			}

			// temos de ver se há pinos de cores iguais
			for (j = i + 1; j < 4; j++) {
				if (senha[j] == corComparada) {
					ehValida = false;
				}
			}
		}
		return ehValida;
	}

}
