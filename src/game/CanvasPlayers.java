package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CanvasPlayers extends myCanvas {

	@Override
	public void SimulaSe(long diftime) {

	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {

		dbg.setColor(Color.cyan);

		dbg.fillRect(0, 0, GamePanel.PWIDTH / 2, GamePanel.PHEIGHT);

		dbg.setColor(Color.magenta);
		dbg.fillRect(GamePanel.PWIDTH / 2, 0, GamePanel.PWIDTH,
				GamePanel.PHEIGHT);

		dbg.setColor(Color.yellow);

		dbg.fillRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT / 3);

		dbg.setColor(new Color(50, 50, 50));

		dbg.setFont(new Font("Raavi", Font.BOLD, 50));

		dbg.drawString("HIT!", GamePanel.PWIDTH / 2 - 50, 100);

		dbg.setFont(new Font("Raavi", Font.BOLD, 16));

		dbg.drawString("Escolha o numero de jogadores", 200, 150);

		dbg.setFont(new Font("Raavi", Font.BOLD, 400));

		dbg.drawString("1", 50, 520);

		dbg.drawString("2", 350, 520);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_1) {

			GamePanel.canvasAtivo = new CanvasMenu();

		} else if (key == KeyEvent.VK_2) {

			GamePanel.numPlayers = 2;

			GamePanel.canvasAtivo = new CanvasMenu();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

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
