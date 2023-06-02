import java.awt.*;

public class Jogador1 {
	public static final int Raquete_Largura = 10;
	public static final int Raquete_Altura = 65;
	public static final int Raquete_Velocidade = 10;

    private int y;

    public Jogador1(int initialY) {
        this.y = initialY;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        y -= Raquete_Velocidade;
        if (y < 0) {
            y = 0;
        }
    }

    public void moveDown() {
        y += Raquete_Velocidade;
        if (y > Jogo.Altura - Raquete_Altura) {
            y = Jogo.Altura - Raquete_Altura;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(Raquete_Largura, y, Raquete_Largura, Raquete_Altura);
    }
}
