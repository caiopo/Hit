package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player extends myCanvas {

	private int playerNum = 0;

	private int x = 0, y = 0;
	public int vidas = 5, pontuacao = 0;

	public boolean keys[][] = new boolean[3][3];

	private SquareController sqrctl = null;

	private HitController hitCtl;

	private boolean running = true;

	public Player(int playerNum) {
		running = true;
		vidas = 5;
		pontuacao = 0;

		this.playerNum = playerNum;

		if (playerNum == 2) {

			x = 600;

		}

		pontuacao = 0;

		hitCtl = new HitController(this);

		sqrctl = new SquareController(x, 0);

		new Thread(sqrctl).start();

		new Thread(hitCtl).start();
	}

	// private SquareController sqrctl2;

	@Override
	public void SimulaSe(long diftime) {

		if (running) {
			sqrctl.updateSquares(hitCtl.getX(), hitCtl.getY());
			// }

			sqrctl.SimulaSe(diftime);

			if (vidas <= 0) {
				CanvasGame.instance.gameOver();
			}
		}
	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {

		sqrctl.DesenhaSe(dbg);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (GamePanel.numPlayers == 1) {

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

		} else {

			if (playerNum == 1) {

				if (keyCode == KeyEvent.VK_Q) {
					keys[0][0] = true;
				}

				if (keyCode == KeyEvent.VK_W) {
					keys[0][1] = true;
				}

				if (keyCode == KeyEvent.VK_E) {
					keys[0][2] = true;
				}

				if (keyCode == KeyEvent.VK_A) {
					keys[1][0] = true;
				}

				if (keyCode == KeyEvent.VK_S) {
					keys[1][1] = true;
				}

				if (keyCode == KeyEvent.VK_D) {
					keys[1][2] = true;
				}

				if (keyCode == KeyEvent.VK_Z) {
					keys[2][0] = true;
				}

				if (keyCode == KeyEvent.VK_X) {
					keys[2][1] = true;
				}

				if (keyCode == KeyEvent.VK_C) {
					keys[2][2] = true;
				}
			} else {

				if (keyCode == KeyEvent.VK_NUMPAD7) {
					keys[0][0] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD8) {
					keys[0][1] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD9) {
					keys[0][2] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD4) {
					keys[1][0] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD5) {
					keys[1][1] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD6) {
					keys[1][2] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD1) {
					keys[2][0] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD2) {
					keys[2][1] = true;
				}

				if (keyCode == KeyEvent.VK_NUMPAD3) {
					keys[2][2] = true;
				}

			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (GamePanel.numPlayers == 1) {

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

		} else {

			if (playerNum == 1) {

				if (keyCode == KeyEvent.VK_Q) {
					keys[0][0] = false;
				}

				if (keyCode == KeyEvent.VK_W) {
					keys[0][1] = false;
				}

				if (keyCode == KeyEvent.VK_E) {
					keys[0][2] = false;
				}

				if (keyCode == KeyEvent.VK_A) {
					keys[1][0] = false;
				}

				if (keyCode == KeyEvent.VK_S) {
					keys[1][1] = false;
				}

				if (keyCode == KeyEvent.VK_D) {
					keys[1][2] = false;
				}

				if (keyCode == KeyEvent.VK_Z) {
					keys[2][0] = false;
				}

				if (keyCode == KeyEvent.VK_X) {
					keys[2][1] = false;
				}

				if (keyCode == KeyEvent.VK_C) {
					keys[2][2] = false;
				}
			} else {

				if (keyCode == KeyEvent.VK_NUMPAD7) {
					keys[0][0] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD8) {
					keys[0][1] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD9) {
					keys[0][2] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD4) {
					keys[1][0] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD5) {
					keys[1][1] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD6) {
					keys[1][2] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD1) {
					keys[2][0] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD2) {
					keys[2][1] = false;
				}

				if (keyCode == KeyEvent.VK_NUMPAD3) {
					keys[2][2] = false;
				}

			}
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

	public int gameOver() {

		running = false;

		sqrctl = null;
		hitCtl.stop();
		hitCtl = null;

		return pontuacao;
	}
}
