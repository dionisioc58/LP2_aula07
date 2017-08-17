/**
 * 
 * Representa o "Retorno" que o "FornecedorDaSenha" gera assim que compara a
 * verdadeira senha e a tentativa do "Adivinho"
 */
public class Retorno {
	/**
	 * Quantidade de pinos já inseridos
	 */
	private int pinosInseridos;

	/**
	 * Representação do retorno para o Adivinho indicando se ele acertou a
	 * posição -ou- posição e cor de um pino na tentativa
	 * 
	 * As strings do arranjo são as cores dos pinos(preto - acertou posição e
	 * cor do pino, ou branco - acertou apenas cor)
	 */
	private String retorno[];

	public Retorno() {

		// setando "retorno" arranjo de 4 strings

		retorno = new String[4];
		for (int i = 0; i < 4; i++) {
			retorno[i] = "nenhum";
		}

		// setando "pinosInseridos"
		pinosInseridos = 0;
	}

	/**
	 * se já houver 4 pinos, o novo pino não será adicionado
	 * 
	 * @param corPino
	 *            "preto" ou "branco" senão exception é lançada
	 * @throws CorInvalidaException
	 */
	public void adicionarPino(String corPino) throws CorInvalidaException {
		if (corPino != "branco" && corPino != "preto") {
			throw new CorInvalidaException();
		} else if (pinosInseridos != 4) {
			retorno[pinosInseridos] = corPino;
			pinosInseridos++;
		}
	}

	/**
	 * 
	 * @param posicao
	 *            de 0 a 3 (válida) senão exception é lançada
	 * @return cor do pino que está naquela posição
	 * @throws PosicaoInvalidaException
	 */
	public String getPino(int posicao) throws PosicaoInvalidaException {
		if (posicao >= 0 && posicao <= 3) {
			return retorno[posicao];
		} else {
			throw new PosicaoInvalidaException();
		}
	}

	/**
	 * 
	 * @return quantidade de pinos inseridos
	 */
	public int getPinosInseridos() {
		return pinosInseridos;
	}

	/**
	 * Função que retorna uma string com os resultados da jogada
	 * @return String com o resultado da jogada
	 */
	public String imprime() throws PosicaoInvalidaException {
		String retorno = "";
		for(int i = 0; i < pinosInseridos; i++)
			retorno += getPino(i) + " ";
		return retorno;
	}
}
