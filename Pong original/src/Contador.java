public class Contador {
    private int jogador1Pontos;
    private int jogador2Pontos;

    public Contador() {
        jogador1Pontos = 0;
        jogador2Pontos = 0;
    }

    public int getJogador1Pontos() {
        return jogador1Pontos;
    }

    public int getJogador2Pontos() {
        return jogador2Pontos;
    }

    public void incrementarPontosJogador1() {
        jogador1Pontos++;
    }

    public void incrementarPontosJogador2() {
        jogador2Pontos++;
    }

    public void reiniciarPontuacao() {
        jogador1Pontos = 0;
        jogador2Pontos = 0;
    }
}
