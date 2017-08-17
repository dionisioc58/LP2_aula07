/**
 * interface em comum ao Adivinho e ao FornecedorDaSenha que são os dois
 * jogadores necessários para se jogar o jogo Senha.
 *
 */
public interface Jogador {
	/**
	 * seta uma Jogada ao jogador. É chamada pelo jogo para setar uma nova Jogada
	 * tanto no Adivinho quanto no FornecedordaSenha em cada novo turno do
	 * jogo(o jogo tem no máximo 10 turnos).
	 * 
	 * @param jog
	 *            É a nova jogada passada para o Jogador(Adivinho e
	 *            FornecedorDaSenha).
	 */
	public void setJogada(Jogada jog);

	public void jogar();

}
