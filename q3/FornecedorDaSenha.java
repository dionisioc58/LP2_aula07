import java.util.LinkedList;
import java.util.Random;

/**
 * Essa classe representa o fornecedor da senha do jogo. Ele quem cria a senha
 * que o Adivinho terá de adivinhar. Ele também é quem verifica a tentativa do
 * adivinho através da Jogada(objeto que o Fornecedor e o Adivinho compartilham)
 * e cria o retorno correspondente ao quanto o adivinho acertou na sua tentativa
 * mais recente.
 *
 */
public class FornecedorDaSenha implements Jogador {
	/**
	 * jogada é o atributo que Adivinho e FornecedorDaSenha compartilham para
	 * que o Fornecedor consiga acessar a tentativa realizada pelo Adivinho.
	 */
	private Jogada jogada;

	/**
	 * senha é um atributo que representa a senha do jogo. Ela é gerada apenas
	 * no começo do jogo e o Adivinho deve tentar adivinhá-la
	 */
	private Senha senha;

	public FornecedorDaSenha() {
		jogada = null;
		senha = new Senha();
	}

	@Override
	public void setJogada(Jogada jog) {
		jogada = jog;

	}

	public Jogada getJogada() {
		return jogada;
	}

	/**
	 * Função que cria a senha que será utilizada no jogo. Essa função só será
	 * executada uma única vez que é quando o jogo começa. Quem manda essa
	 * função ser executada é a mesma classe que cria uma instância de
	 * FornecedorDaSenha: "Jogo". A função segue os seguintes passos: 1 -
	 * armazenar em uma LinkedList várias Strings. Cada String será uma cor
	 * válida usada pelo sistema (vermelho, azul, rosa, amarelo, roxo, verde,
	 * cinza ou laranja). 2 - retirar 4 cores aleatárias da lista, sem
	 * repetição. 3 - ir adicionando na "senha"(atributo do FornecedorDaSenha)
	 * essas 4 cores.
	 */
	public void criarSenha() {
		while (senha.ehSenhaValida() == false) {
			// primeiro temos uma lista de cores
			LinkedList<String> cores = new LinkedList<String>();
			cores.add("vermelho");
			cores.add("azul");
			cores.add("rosa");
			cores.add("amarelo");
			cores.add("roxo");
			cores.add("verde");
			cores.add("cinza");
			cores.add("laranja");

			// agora vamos retirar quatro cores randomicas dessa lista

			for (int i = 0; i < 4; i++) {
				Random geradorNumRandomico = new Random();
				String corDaSenha = cores.remove(geradorNumRandomico.nextInt(cores.size()));
				try {
					senha.adicionarPino(corDaSenha);
				} catch (Exception exc) {
					System.out.println("erro ao setar pinos para senha");
				}
			}
		}

	}

	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha s) {
		senha = s;
	}

	/**
	 * A função "jogar()" do FornecedorDaSenha realiza os seguintes passos: 1 -
	 * Pegar a tentativa do Adivinho. A tentativa pode ser obtida através do
	 * objeto "jogada" que o Fornecedor e o Adivinho compartilham. 2 - Para cada
	 * pino da tentativa, será checado se ele é da mesma cor que um pino da
	 * "senha" e se ele está na mesma posição que a senha. 2.1 - Caso um pino da
	 * tentativa seja da mesma cor e esteja na mesma posição que um pino da
	 * senha, um novo pino preto é adicionado ao "retorno" (resultado da
	 * comparação entre a Senha e a Tentativa) gerado pelo Fornecedor. 2.2 -
	 * Caso um pino da tentativa seja da mesma cor que algum pino da senha mas
	 * os dois não estão na mesma posição, um novo pino branco é adicionado ao
	 * "retorno" 2.3 - Se o pino presente na tentativa do Adivinho não está
	 * presente na senha gerada pelo Fornecedor, nenhum novo pino é adicionado
	 * ao "retorno". 3 - O passo 2 será repetido para cada pino da tentativa e
	 * no final o retorno poderá ser acessado por qualquer um que tenha acesso à
	 * Jogada(objeto compartilhado entre Adivinho e Fornecedor e criado pel
	 * classe "Jogo").
	 */
	public void jogar() {
		Retorno respostaFornecedor = new Retorno();
		Tentativa tentativaAdivinho = null;
		tentativaAdivinho = jogada.getTentativa();
		for (int j = 0; j < 4; j++) {
			try {
				String pinoTentativa = tentativaAdivinho.getPino(j);
				for (int k = 0; k < 4; k++) {
					String pinoSenha = senha.getPino(k);
					if (pinoSenha.compareTo(pinoTentativa) == 0 && k != j) {
						respostaFornecedor.adicionarPino("branco");
					} else if (pinoSenha.compareTo(pinoTentativa) == 0 && k == j) {
						respostaFornecedor.adicionarPino("preto");
					}
				}

			} catch (Exception exc) {
				System.out.println("erro ao setar pinos brancos ou pretos no retorno");
			}

		}

		jogada.setRetorno(respostaFornecedor);
	}
}
