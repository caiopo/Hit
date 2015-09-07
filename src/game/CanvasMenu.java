package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CanvasMenu extends myCanvas {

	public CanvasMenu() {

		if (!GamePanel.playingMusic) {

//			try {
//				Sound.musica();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

			GamePanel.playingMusic = true;
		}
	}

	@Override
	public void SimulaSe(long diftime) {

	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {

		dbg.setColor(new Color(230, 230, 230));
		dbg.fillRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);

		dbg.setColor(new Color(50, 50, 50));

		dbg.setFont(new Font("Raavi", Font.BOLD, 50));

		dbg.drawString("HIT!", GamePanel.PWIDTH / 2 - 50, 100);

		dbg.setFont(new Font("Raavi", Font.BOLD, 16));
		dbg.drawString(
				"Aperte a tecla correspondente ao quadrado vermelho no numpad ou teclado",
				20, 200);

		String[] numpad = { "7|Q", "4|A", "1|Z", "8|W", "5|S", "2|X", "9|E",
				"6|D", "3|C" };

		Color[][] colorMenu = { { Color.GREEN, Color.cyan, Color.pink },
				{ Color.GRAY, Color.RED, Color.YELLOW },
				{ Color.magenta, Color.ORANGE, Color.LIGHT_GRAY } };

		int n = 0;

		int sizeX = 100, sizeY = 100, x = (GamePanel.PWIDTH - 3 * sizeX) / 2, y = (GamePanel.PHEIGHT - 3 * sizeY) / 2 + 100;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				dbg.setColor(colorMenu[j][i]);
				dbg.fillRect(x + sizeX * i, y + sizeY * j, sizeX, sizeY);
				dbg.setColor(new Color(50, 50, 50));
				dbg.drawString(numpad[n], x + 40 + sizeX * i, y + 40 + sizeY
						* j);
				n++;
			}
		}

		dbg.drawString("Aperte espaço para começar", 220, 580);

		dbg.setFont(new Font("Raavi", Font.PLAIN, 10));
		dbg.drawString("(v1.1) caiopoliveira@gmail.com", 460, 595);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE
				|| e.getKeyCode() == KeyEvent.VK_5) {

			GamePanel.canvasAtivo = new CanvasDif();

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
