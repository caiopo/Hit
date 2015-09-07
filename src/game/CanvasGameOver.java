package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CanvasGameOver extends myCanvas {

	private int p1s, p2s;

	public CanvasGameOver(int p1Score, int p2Score) {
		p1s = p1Score;
		p2s = p2Score;
	}

	@Override
	public void SimulaSe(long diftime) {

	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {

		dbg.setColor(Color.darkGray);

		dbg.fillRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);

		if (GamePanel.numPlayers == 2) {

			dbg.setColor(Color.white);

			dbg.setFont(new Font("Raavi", Font.PLAIN, 40));

			dbg.drawString("You lost!", GamePanel.PWIDTH / 2 - 50, 100);

			dbg.drawString("Pontuação:", GamePanel.PWIDTH / 2 - 120, 200);

			dbg.drawString(Integer.toString(p1s), GamePanel.PWIDTH / 2 - 50,
					300);

			dbg.setFont(new Font("Raavi", Font.PLAIN, 25));

			dbg.drawString("Aperte espaço para jogar novamente", 120, 400);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_ESCAPE) {
			GamePanel.instance.stopGame();
		}

		if (keyCode == KeyEvent.VK_SPACE) {
			GamePanel.canvasAtivo = new CanvasGame(CanvasGame.dificuldade);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

}
