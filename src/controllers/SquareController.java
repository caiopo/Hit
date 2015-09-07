package controllers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

//import java.util.Random;

public class SquareController implements Runnable {

	private Random rng = new Random();

	private int x, y;

	// private int sizeX, sizeY;

	private static final int sizeSquare = 200;

	private static final int numSquareX = 3, numSquareY = 3;

	int[][] squares = new int[numSquareX][numSquareY];

	ColorController[][] colorGen = new ColorController[numSquareX][numSquareY];

	Thread[][] tColors = new Thread[numSquareX][numSquareY];

	public SquareController(int x, int y) {

		this.x = x;
		this.y = y;

		// sizeX = sizeSquare * numSquareX;
		// sizeY = sizeSquare * numSquareY;

	}

	public void SimulaSe(long diftime) {

	}

	public void DesenhaSe(Graphics2D dbg) {
		// dbg.drawImage(img, x, y, null);

		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {

				if (squares[i][j] == 0) {
					try {
						dbg.setColor(colorGen[i][j].getColor());
					} catch (Exception e) {
						dbg.setColor(new Color(rng.nextInt(256), rng
								.nextInt(256), rng.nextInt(256)));
					}

				} else if (squares[i][j] == 1) {
					dbg.setColor(Color.RED);
				}

				// else if (squares[i][j] == 2) {
				// // dbg.setColor(cor3);
				// }

				dbg.fillRect(x + sizeSquare * i, y + sizeSquare * j,
						sizeSquare, sizeSquare);
			}
		}

		// dbg.setColor(Color.black);
		//
		// dbg.drawRect(0, 0, sizeX - 1, sizeY);
		//
		// dbg.drawLine(sizeSquare, 0, sizeSquare, GamePanel.PHEIGHT);
		//
		// dbg.drawLine(sizeSquare * 2, 0, sizeSquare * 2, GamePanel.PHEIGHT);
		//
		// dbg.drawLine(0, sizeSquare, GamePanel.PHEIGHT, sizeSquare);
		//
		// dbg.drawLine(0, sizeSquare * 2, GamePanel.PHEIGHT, sizeSquare * 2);

		// dbg.setColor(Color.BLACK);
		// dbg.setFont(FONT);
		// dbg.drawString(Integer.toString(x), x, y);
		// dbg.drawString(Integer.toString(x + sizeX), x + sizeX, y);

	}

	public void updateSquares(int x, int y) {

		// int x = hc.getX();
		// int y = hc.getY();

		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {

				if (i == x && j == y) {
					squares[i][j] = 1;
				} else {
					squares[i][j] = 0;
				}

			}
		}

	}

	@Override
	public void run() {

		// System.out.println("Creating Square Controller");

		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				squares[i][j] = 0;
			}
		}

		for (int i = 0; i < colorGen.length; i++) {
			for (int j = 0; j < colorGen[i].length; j++) {
				colorGen[i][j] = new ColorController();
			}
		}

		for (int i = 0; i < tColors.length; i++) {
			for (int j = 0; j < tColors[i].length; j++) {
				tColors[i][j] = new Thread(colorGen[i][j]);
				tColors[i][j].start();
			}
		}

		// System.out.println("Square Controller created!");

	}

}
