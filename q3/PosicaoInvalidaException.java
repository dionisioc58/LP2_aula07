/**
 * Classe que representa uma exceção que deve ser lançada quando alguma classe
 * tenta acessar alguma posição que é maior que a capacidade do arranjo ou menor
 * que 0 Por exemplo: Se uma classe desejasse acessar a posição 4 de um arranjo
 * de 4 posições, seria lançada uma PosicaoInvalidaException, pois um arranjo de
 * tamanho = 4 deveria somente poder ser acessado através dos índices 0, 1, 2 ou
 * 3 (Lembrem-se que o índice inicial de um arranjo é 0).
 *
 */
public class PosicaoInvalidaException extends Exception {
	public PosicaoInvalidaException() {
		super("posicao invalida para um pino");
	}

}
