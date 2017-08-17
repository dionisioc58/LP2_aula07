import java.util.Scanner;

/**
 * classe que representa o próprio usuário do nosso jogo. O adivinho adivinha a
 * senha do jogo em cada uma de suas jogadas. Ele tem 10 jogadas para tentar
 * descobrir a senha(que é o objetivo do jogo).
 * 
 * Essa classe Implementa a Interface Jogador que também implementada por
 * FornecedorDaSenha: quem elabora a senha para ser adivinhada.
 *
 */
public class Adivinho implements Jogador {
	/**
	 * O atributo jogadaTurno é a jogada atual do jogo. O jogo tem 10 jogadas no
	 * máximo, sendo que cada jogada consiste em uma adivinhação da senha(feita
	 * pelo adivinho) e um retorno(um feedback fornecido pelo fornecedor da
	 * senha) com base na adivinhação feita pelo adivinho
	 */
	Jogada jogadaTurno;

	public Adivinho() {
		jogadaTurno = new Jogada();
	}

	/**
	 * A classe Jogo chama esse método para passar ao adivinho e ao fornecedor
	 * da senha a jogada atual do jogo(o jogo tem 10 jogadas, como já
	 * explicado).
	 */
	public void setJogada(Jogada jog) {
		jogadaTurno = jog;

	}
	
	public Jogada getJogada() {
		return jogadaTurno;
	}

	/**
	 * método chamado quando o Adivinho termina de jogar. Após ele escolher as
	 * cores dos pinos que ele acha que é a senha correta, ele realiza uma
	 * tentativa para a jogada atual. Dependendo da tentativa, ele pode até
	 * ganhar o jogo se tiver acertado a senha correta.
	 * 
	 * @param tentativaJogador
	 *            É a tentativa completa(com 4 pinos) que o jogador fez para
	 *            tentar acertar a senha.
	 */
	public void realizarTentativa(Tentativa tentativaJogador) {
		jogadaTurno.setTentativa(tentativaJogador);
	}

	/**
	 * cada vez que o adivinho for jogar, ele vai fazer uma tentativa para
	 * descobrir a senha correta. Essa tentativa tem de ter 4 pinos para ser
	 * completa. Após o jogador selecionar os 4 pinos da tentativa, ele vai
	 * realizar a tentativa de acertar a senha.
	 */
	public void jogar() {
		Tentativa tentativaJogador = new Tentativa();
		while (tentativaJogador.ehTentativaIncompleta() == true) {
			this.adicionarNovoPinoATentativa(tentativaJogador);
		}
		this.realizarTentativa(tentativaJogador);

	}

	/**
	 * esse método vai ser chamado enquanto o Adivinho joga. Nele, o jogo pede
	 * para o usuário digitar uma nova cor de pino para a tentativa dele.
	 * Digitando uma cor válida, o pino será inserido na tentativa passada como
	 * parâmetro do método. Esse método é chamado várias vezes dentro de
	 * Adivinho.jogar() até o jogador ter decidido uma tentativa completa(4
	 * pinos) para a senha. Caso o jogador digite uma cor inválida para o jogo,
	 * esse método pega a exceção CorInvalidaException e informa ao usuário que
	 * a cor que ele informou não é válida para o jogo. Ele captura a exceção
	 * PosicaoInvalidaException se tentarmos adicionar um pino em uma tentativa
	 * com 4 pinos(cada tentativa tem, no máximo, 4 pinos). Tecnicamente, Essa
	 * exceção nunca ocorre se o jogo funciona sem bugs.
	 * 
	 * @param tentativa
	 *            É a tentativa(conjunto de pinos) atual do jogador. É a
	 *            tentativa na qual adicionaremos um novo pino após o método.
	 */
	public void adicionarNovoPinoATentativa(Tentativa tentativa) {
		System.out.println("digite um novo pino para sua tentativa. ");
		System.out.println("Ele pode ser vermelho, azul, rosa, amarelo, roxo, verde, cinza ou laranja.");
		Scanner scanIn = new Scanner(System.in);
		String corPino = scanIn.nextLine();
		int posicaoDoNovoPino = tentativa.quantosPinosJaForamAdicionados();
		try {
			tentativa.adicionarPino(posicaoDoNovoPino, corPino);
			System.out.println("pino colocado com sucesso:" + corPino);
		} catch (PosicaoInvalidaException e) {
			System.out.println("posicao para inserir pino na jogada do jogador é inválida");
		} catch (CorInvalidaException e) {
			System.out.println(
					"cor inválida para novo pino a ser inserido na tentativa do jogador." + "Tente novamente.");
		}
	}

}
