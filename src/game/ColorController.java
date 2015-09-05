package game;

import java.awt.Color;

public class ColorController implements Runnable {

	private ColorCount[] c = { new ColorCount(), new ColorCount(), new ColorCount() };
	private Thread[] t = new Thread[c.length];

	@Override
	public void run() {

		for (int i = 0; i < c.length; i++) {
			// c[i] = new ColorCount();
			t[i] = new Thread(c[i]);
			t[i].start();
		}

		// while (true) {
		//
		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		//
		// scrambleColor();
		// System.out.println("scrambled!");
		//
		// }

	}

	public Color getColor() {

		return new Color(c[0].getValue(), c[1].getValue(), c[2].getValue());

	}
}
