import java.awt.*;

public class Bola {
   public static final int Bola_Tamanho = 10;
   public static final int Bola_Velocidade = 4;

    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public Bola(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
        this.xSpeed = Bola_Velocidade;
        this.ySpeed = Bola_Velocidade;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        // Colisão com as paredes
        if (y <= 0 || y >= Jogo.Altura - Bola_Velocidade) {
            ySpeed = -ySpeed;
        }
    }
    
    
    public void reset() {
        x = Jogo.Largura / 2 - Bola_Tamanho / 2;
        y = Jogo.Altura / 2 - Bola_Tamanho / 2;
        xSpeed = Bola_Velocidade;
        ySpeed = Bola_Velocidade;
    }

    public void checarColisao(Jogador1 jogador1, Jogador2 jogador2) {
        if (x <= Jogador1.Raquete_Largura * 2 && y + Bola_Tamanho  >= jogador1.getY() && y <= jogador1.getY() + Jogador1.Raquete_Altura) {
            xSpeed = Bola_Velocidade;
        } else if (x >= Jogo.Largura - 2 * Jogador2.Raquete_Largura - Bola_Tamanho && y + Bola_Tamanho  >= jogador2.getY() && y <= jogador2.getY() + Jogador2.Raquete_Altura) {
            xSpeed = -Bola_Velocidade;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, Bola_Tamanho , Bola_Tamanho);
    }
    public int getX() {
        return x;
    }
}
