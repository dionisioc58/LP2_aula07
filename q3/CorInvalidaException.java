/**
 * Exceção disparada quando é tentado adicionar uma cor na Tentativa do
 * adivinho, na Senha ou no Retorno que não é válida para nosso jogo.
 * 
 * Para a tentativa do adivinho e a senha do jogo, as cores válidas são:
 * vermelho,rosa,amarelo,roxo,verde,cinza e laranja.
 * 
 * Para o retorno(feedback mostrado ao adivinho para indica se ele acertou algo
 * em sua tentativa de adivinhar a senha), as cores válidas são: preto(indicando
 * que ele acertou uma cor e uma posição de um pino na senha) e branco(indicando
 * que ele acertou a cor de um pino na senha, mas não acertou posição).
 */
public class CorInvalidaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CorInvalidaException() {
		super("cor inválida");
	}

}
