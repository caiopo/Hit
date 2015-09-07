package canvas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import main.GamePanel;

public class CanvasGame extends myCanvas {

	public static CanvasGame instance = null;

	public static int dificuldade = 2;

	public static Player p1 = null, p2 = null;

	// public static boolean keys[][] = new boolean[3][3];
	//
	// // public static CanvasGame instance = null;
	//
	// public static int pontuacao = 0, vidas = 5;
	//
	// private SquareController sqrctl = null;
	//
	// private HitController hitCtl;

	// private SquareController sqrctl2;

	public CanvasGame(int dif) {

		dificuldade = dif;
		// GamePanel.dificuldade = dif;

		instance = this;

		if (GamePanel.numPlayers == 2) {

			GamePanel.PWIDTH = 1200;

			GamePanel.instance.resize();

			p2 = new Player(2);

		}

		p1 = new Player(1);

		// CanvasGame.dificuldade = dificuldade;
		//
		// pontuacao = 0;
		// vidas = 5;
		//
		// hitCtl = new HitController();
		//
		// sqrctl = new SquareController(0, 0);
		//
		// new Thread(sqrctl).start();
		//
		// new Thread(hitCtl).start();
		//
		// if (GamePanel.numPlayers == 2) {
		// // sqrctl2 = new SquareController(600, 0);
		// }
	}

	@Override
	public void SimulaSe(long diftime) {

		p1.SimulaSe(diftime);
		if (GamePanel.numPlayers == 2) {

			p2.SimulaSe(diftime);
		}
		// sqrctl.updateSquares(hitCtl.getX(), hitCtl.getY());
		//
		// sqrctl.SimulaSe(diftime);
		//
		// if (GamePanel.numPlayers == 2) {
		// // sqrctl2.SimulaSe(diftime);
		// }
		//
		// if (vidas <= 0) {
		// gameOver();
		// }
	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {

		p1.DesenhaSe(dbg);

		if (GamePanel.numPlayers == 2) {
			p2.DesenhaSe(dbg);
			dbg.setColor(Color.black);

			dbg.drawLine(GamePanel.PWIDTH / 2, 0, GamePanel.PWIDTH / 2,
					GamePanel.PHEIGHT);

			// dbg.drawRect(0, 0, GamePanel.PWIDTH - 1, GamePanel.PHEIGHT - 1);
		}

		// sqrctl.DesenhaSe(dbg);
		//
		// if (GamePanel.numPlayers == 2) {
		// // sqrctl2.DesenhaSe(dbg);
		//
		// dbg.setColor(Color.black);
		//
		// dbg.drawLine(GamePanel.PWIDTH / 2, 0, GamePanel.PWIDTH / 2,
		// GamePanel.PHEIGHT);
		//
		// dbg.drawRect(0, 0, GamePanel.PWIDTH - 1, GamePanel.PHEIGHT - 1);
		// }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		p1.keyPressed(e);
		if (GamePanel.numPlayers == 2) {
			p2.keyPressed(e);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		p1.keyReleased(e);
		if (GamePanel.numPlayers == 2) {
			p2.keyReleased(e);
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

		int p1Score = p1.pontuacao;
		p1.gameOver();

		int p2Score = 0;
		if (GamePanel.numPlayers == 2) {
			p2Score = p2.pontuacao;
			p2.gameOver();
		}

		GamePanel.canvasAtivo = new CanvasGameOver(p1Score, p2Score);

	}
	// public void gameOver() {
	//
	// if (GamePanel.numPlayers == 1) {
	//
	// GamePanel.canvasAtivo = new CanvasGameOver(p1.gameOver(), 0);
	//
	// } else {
	//
	// GamePanel.canvasAtivo = new CanvasGameOver(p1.gameOver(),
	// p2.gameOver());
	//
	// }
	// }
}
