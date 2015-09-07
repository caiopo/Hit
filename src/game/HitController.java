package game;

import java.util.Random;

public class HitController implements Runnable {

	private boolean running = true;

	private Random rng = new Random();

	private int chosenX = rng.nextInt(3), chosenY = rng.nextInt(3);

	private Player player = null;

	public HitController(Player p) {

		player = p;

	}

	@Override
	public void run() {

		boolean descontar = true;

		while (running) {

			descontar = true;

			for (int i = 0; i < 750 / CanvasGame.dificuldade; i++) {

				if (countPressed() > 0) {
					if (hit()) {
						player.pontuacao++;
						descontar = false;
						break;
					}

				}

				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (descontar) {
				player.vidas--;
			}

			chosenX = rng.nextInt(3);
			chosenY = rng.nextInt(3);
//			System.out.println(player.vidas);
			// System.out.println(chosenX + " " + chosenY);

		}
	}

	public int getX() {
		return chosenX;
	}

	public int getY() {
		return chosenY;
	}

	public int countPressed() {
		int count = 0;
		for (int i = 0; i < player.keys.length; i++) {
			for (int j = 0; j < player.keys.length; j++) {
				if (player.keys[i][j]) {
					count++;
				}
			}

		}

		return count;
	}

	public boolean hit() {
		for (int i = 0; i < player.keys.length; i++) {
			for (int j = 0; j < player.keys.length; j++) {

				if (player.keys[i][j] && i == chosenY && j == chosenX
						&& countPressed() == 1) {
					return true;
				}

			}
		}

		return false;
	}

	public void stop() {
		running = false;
	}

}
