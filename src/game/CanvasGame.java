package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CanvasGame extends myCanvas {

	public static int dificuldade = 2;

	public static boolean keys[][] = new boolean[3][3];

	// public static CanvasGame instance = null;

	public static int pontuacao = 0, vidas = 5;

	public static ArrayList<SquareController> listaObj = new ArrayList<>();

	private SquareController sqrctl = null;

	private HitController hitCtl;

	// private SquareController sqrctl2;

	public CanvasGame(int dificuldade) {

		CanvasGame.dificuldade = dificuldade;

		pontuacao = 0;
		vidas = 5;

		hitCtl = new HitController();

		sqrctl = new SquareController(0, 0);

		new Thread(sqrctl).start();

		new Thread(hitCtl).start();

		if (GamePanel.numPlayers == 2) {
			// sqrctl2 = new SquareController(600, 0);
		}
	}

	@Override
	public void SimulaSe(long diftime) {

		sqrctl.updateSquares(hitCtl.getX(), hitCtl.getY());

		sqrctl.SimulaSe(diftime);

		if (GamePanel.numPlayers == 2) {
			// sqrctl2.SimulaSe(diftime);
		}

		if (vidas <= 0) {
			gameOver();
		}
	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {

		sqrctl.DesenhaSe(dbg);

		if (GamePanel.numPlayers == 2) {
			// sqrctl2.DesenhaSe(dbg);

			dbg.setColor(Color.black);

			dbg.drawLine(GamePanel.PWIDTH / 2, 0, GamePanel.PWIDTH / 2,
					GamePanel.PHEIGHT);

			dbg.drawRect(0, 0, GamePanel.PWIDTH - 1, GamePanel.PHEIGHT - 1);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_NUMPAD7 || keyCode == KeyEvent.VK_Q) {
			keys[0][0] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD8 || keyCode == KeyEvent.VK_W) {
			keys[0][1] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD9 || keyCode == KeyEvent.VK_E) {
			keys[0][2] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD4 || keyCode == KeyEvent.VK_A) {
			keys[1][0] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD5 || keyCode == KeyEvent.VK_S) {
			keys[1][1] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD6 || keyCode == KeyEvent.VK_D) {
			keys[1][2] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD1 || keyCode == KeyEvent.VK_Z) {
			keys[2][0] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD2 || keyCode == KeyEvent.VK_X) {
			keys[2][1] = true;
		}

		if (keyCode == KeyEvent.VK_NUMPAD3 || keyCode == KeyEvent.VK_C) {
			keys[2][2] = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_NUMPAD7 || keyCode == KeyEvent.VK_Q) {
			keys[0][0] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD8 || keyCode == KeyEvent.VK_W) {
			keys[0][1] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD9 || keyCode == KeyEvent.VK_E) {
			keys[0][2] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD4 || keyCode == KeyEvent.VK_A) {
			keys[1][0] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD5 || keyCode == KeyEvent.VK_S) {
			keys[1][1] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD6 || keyCode == KeyEvent.VK_D) {
			keys[1][2] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD1 || keyCode == KeyEvent.VK_Z) {
			keys[2][0] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD2 || keyCode == KeyEvent.VK_X) {
			keys[2][1] = false;
		}

		if (keyCode == KeyEvent.VK_NUMPAD3 || keyCode == KeyEvent.VK_C) {
			keys[2][2] = false;
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

	public void gameOver() {

		sqrctl = null;
		hitCtl.stop();
		hitCtl = null;

		GamePanel.canvasAtivo = new CanvasGameOver();

	}
}
