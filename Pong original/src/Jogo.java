import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jogo extends JPanel implements KeyListener, Runnable {
   public static final int Largura = 640;
   public static final int Altura = 400;

    private Jogador1 jogador1;
    private Jogador2 jogador2;
    private Bola bola;
    private Contador contador;

    private boolean[] keys = new boolean[256];

    public Jogo() {
        setPreferredSize(new Dimension(Largura, Altura));
        setFocusable(true);
        addKeyListener(this);

        jogador1 = new Jogador1(HEIGHT / 2 - Jogador1.Raquete_Altura / 2);
        jogador2 = new Jogador2(HEIGHT / 2 - Jogador2.Raquete_Altura / 2);
        bola = new Bola(Largura / 2 - Bola.Bola_Tamanho / 2, Altura / 2 - Bola.Bola_Tamanho / 2);
        contador = new Contador();
    }

    public void startGame() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Largura, Altura);

        jogador1.draw(g);
        jogador2.draw(g);
        bola.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("" + contador.getJogador1Pontos(), 350, 30);
        g.drawString("" + contador.getJogador2Pontos(), Largura - 350, 30);
    }
    

    @Override
    public void run() {
        while (true) {
            update();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        bola.update();
        bola.checarColisao(jogador1, jogador2);

        if (isKeyPressed(KeyEvent.VK_W)) {
            jogador1.moveUp();
        }
        if (isKeyPressed(KeyEvent.VK_S)) {
            jogador1.moveDown();
        }
        if (isKeyPressed(KeyEvent.VK_UP)) {
            jogador2.moveUp();
        }
        if (isKeyPressed(KeyEvent.VK_DOWN)) {
            jogador2.moveDown();
        }
        // Pontuação do Jogo
        if (bola.getX() < 0) {
            contador.incrementarPontosJogador2();
            bola.reset();
        } else if (bola.getX() > Largura) {
            contador.incrementarPontosJogador1();
            bola.reset();
        }

    }
    
   

    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keys[keyCode] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keys[keyCode] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
