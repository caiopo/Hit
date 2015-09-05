package game;

import java.util.Random;

public class HitController implements Runnable {

	private boolean running = true;

	private Random rng = new Random();

	private int chosenX = rng.nextInt(3), chosenY = rng.nextInt(3);

	@Override
	public void run() {

		boolean descontar = true;

		while (running) {

			descontar = true;

			for (int i = 0; i < 750 / CanvasGame.dificuldade; i++) {

				if (countPressed() > 0) {
					if (hit()) {
						CanvasGame.pontuacao++;
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
				CanvasGame.vidas--;
			}

			chosenX = rng.nextInt(3);
			chosenY = rng.nextInt(3);
			System.out.println(CanvasGame.vidas);
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
		for (int i = 0; i < CanvasGame.keys.length; i++) {
			for (int j = 0; j < CanvasGame.keys.length; j++) {
				if (CanvasGame.keys[i][j]) {
					count++;
				}
			}

		}

		return count;
	}

	public boolean hit() {
		for (int i = 0; i < CanvasGame.keys.length; i++) {
			for (int j = 0; j < CanvasGame.keys.length; j++) {

				if (CanvasGame.keys[i][j] && i == chosenY && j == chosenX
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
