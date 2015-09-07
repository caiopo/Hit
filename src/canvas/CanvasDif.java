package canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.GamePanel;

public class CanvasDif extends myCanvas {

	Color[] cores = { Color.GREEN, Color.yellow, Color.RED };
	String[] dificuldade = { "1 - Easy", "2 - Medium", "3 - Hard" };

	@Override
	public void SimulaSe(long diftime) {

	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {

		int largura = GamePanel.PWIDTH / 3 + 1;

		for (int i = 0; i < 3; i++) {
			dbg.setColor(cores[i]);
			dbg.fillRect(largura * i, 0, largura, GamePanel.PHEIGHT);
			dbg.setColor(Color.BLACK);
			dbg.setFont(new Font("Raavi", Font.BOLD, 30));
			dbg.drawString(dificuldade[i], largura * i + 30,
					GamePanel.PHEIGHT / 2 - 30);

		}
		dbg.setFont(new Font("Raavi", Font.BOLD, 12));
		dbg.drawString("Não recomendado para epiléticos", 220, 550);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_1 || key == KeyEvent.VK_NUMPAD1
				|| key == KeyEvent.VK_Z) {
			GamePanel.canvasAtivo = new CanvasGame(1);
		}

		if (key == KeyEvent.VK_2 || key == KeyEvent.VK_NUMPAD2
				|| key == KeyEvent.VK_X) {
			GamePanel.canvasAtivo = new CanvasGame(2);

		}

		if (key == KeyEvent.VK_3 || key == KeyEvent.VK_NUMPAD3
				|| key == KeyEvent.VK_C) {
			GamePanel.canvasAtivo = new CanvasGame(3);
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
