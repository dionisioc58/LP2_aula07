/**
 * Classe que representa uma tentativa realizada pelo Adivinho para tentar
 * adivinhar uma Senha criada pelo FornecedorDeSenha.
 *
 */
public class Tentativa {
	/**
	 * "tentativa" é um Arranjo de 4 posições que engloba Strings. Cada String
	 * deveria conter uma cor válida utilizada pelo sistema que representa cada
	 * pino que o Adivinho mandou inserir na Tentativa.
	 */
	private String tentativa[];

	/**
	 * Inicialmente todos os pinos da tentativa serão inicializados com a String
	 * "nenhum" que significa "nenhuma cor ainda foi escolhida pelo Adivinho".
	 */
	public Tentativa() {
		tentativa = new String[4];
		for (int i = 0; i < 4; i++) {
			tentativa[i] = "nenhum";
		}
	}

	/**
	 * - Função que representa a adição novo pino é tentativa. Para isso, é
	 * necessário ser informada a posição que o novo pino irá ocupar na
	 * Tentativa e a cor do novo pino. - Caso a posição seja menor que 0 ou
	 * maior que 3, uma exceção "PosicaoInvalidaException" é lançada, pois uma
	 * tentativa só deveria conter 4 pinos no máximo. - Caso a cor do novo pino
	 * não seja uma cor válida, uma exceção "CorInvalidaException" é lançada
	 * 
	 * @param posicao
	 * @param cor
	 * @throws PosicaoInvalidaException
	 * @throws CorInvalidaException
	 */
	public void adicionarPino(int posicao, String cor) throws PosicaoInvalidaException, CorInvalidaException {
		if (posicao < 0 || posicao > 3) {
			throw new PosicaoInvalidaException();
		} else if (CorEhValida(cor) == false) {
			throw new CorInvalidaException();
		} else {
			tentativa[posicao] = cor;
		}
	}

	/**
	 * Função que retorna a cor do pino da posição informada no arranjo
	 * "tentativa". Caso a posição seja menor que 0 ou maior que 3, uma exceção
	 * "PosicaoInvalidaException" é lançada. A função irá retornar "nenhum" se
	 * nenhum pino foi adicionado é aquela posição.
	 * 
	 * @param posicao
	 * @return
	 * @throws PosicaoInvalidaException
	 */
	public String getPino(int posicao) throws PosicaoInvalidaException {
		if (posicao < 0 || posicao > 3) {
			throw new PosicaoInvalidaException();
		} else {
			return tentativa[posicao];
		}
	}

	/**
	 * Caso a Tentativa ainda não possua quatro pinos, essa função retorna true,
	 * senão retorna false.
	 * 
	 * @return
	 */
	public boolean ehTentativaIncompleta() {
		// uma tentativa incompleta é aquela que tem como pino "nenhum".
		for (int i = 0; i < 4; i++) {
			if (this.tentativa[i] == "nenhum") {
				return true;
			}
		}

		return false;
	}

	/**
	 * Função que verifica se uma cor "c1" (passada como parâmetro) é uma das
	 * cores utilizadas pelo sistema. Se c1 for "vermelho", "azul", "rosa",
	 * "amarelo", "roxo", "verde", "cinza" ou "laranja", então c1 é uma cor
	 * válida. Senão, é uma cor inválida.
	 * 
	 * @param c1
	 * @return
	 */
	public boolean CorEhValida(String c1) {
		if ((c1.compareTo("vermelho") == 0) || (c1.compareTo("azul") == 0) || (c1.compareTo("rosa") == 0)
				|| (c1.compareTo("amarelo") == 0) || (c1.compareTo("roxo") == 0) || (c1.compareTo("verde") == 0)
				|| (c1.compareTo("cinza") == 0) || (c1.compareTo("laranja") == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Função que retorna a quantidade de pinos já inseridos na Tentativa. Esse
	 * número é útil quando o Adivinho for adicionar novos pinos na tentativa
	 * para que ele saiba onde adicionar os pinos que faltam para completar essa
	 * Tentativa (uma tenativa deve ter 4 pinos).
	 * 
	 * @return
	 */
	public int quantosPinosJaForamAdicionados() {
		int pinosAdicionados = 0;
		for (int i = 0; i < tentativa.length; i++) {
			if (tentativa[i].compareTo("nenhum") == 0) {
				return pinosAdicionados;
			} else {
				pinosAdicionados = pinosAdicionados + 1;
			}
		}

		return pinosAdicionados;
	}

	/**
	 * Função que retorna uma string com os pinos escolhidos na jogada
	 * @return String com todas os pinos jogados
	 */
	public String imprime() throws PosicaoInvalidaException {
		String retorno = "";
		for(int i = 0; i < tentativa.length; i++)
			retorno += getPino(i) + " ";
		return retorno;
	}
}
