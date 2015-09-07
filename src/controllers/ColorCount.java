package controllers;

import java.util.Random;

public class ColorCount implements Runnable {

	private Random rng = new Random();

	private int value = (new Random().nextInt(254) + 1);

	private int cont = 0;

	private boolean countAsc = true;

	// private boolean countAsc = rng.nextBoolean();

	@Override
	public void run() {
		int max = 25000;

		while (true) {

			if (cont > max) {

				if (countAsc) {
					value++;
				} else {
					value--;
				}

				if (value > 254 || value < 1) {
					countAsc = !countAsc;
				}

				cont = rng.nextInt(10000) + 15000;

				try {
					Thread.sleep(0, rng.nextInt(5));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			cont++;
		}

	}

	public int getValue() {
		return value;
	}

	public void scrambleValue() {

		value = rng.nextInt(254) + 1;

	}
}
