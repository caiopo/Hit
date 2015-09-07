/*
 * v1.1 
 */

package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	public static boolean playingMusic = false;
	
	public static int numPlayers = 2;

	public static final int PWIDTH = 600 * numPlayers;
	public static final int PHEIGHT = 600;

	private static Dimension screenSize = Toolkit.getDefaultToolkit()
			.getScreenSize();
	private final static double SWIDTH = screenSize.getWidth();
	private final static double SHEIGHT = screenSize.getHeight();

	private static String title = "Hit!";
	public static int diftime = 0;

	public static GamePanel instance;

	private Thread animator;
	private boolean running = false;

	private BufferedImage dbImage;
	private Graphics2D dbg;

	// public static int objVel = 1;

	public static int FPS, SFPS;
	public static int fpscount;

	public static myCanvas canvasAtivo = null;

	public GamePanel() {

		instance = this;

		setBackground(Color.white);
		setPreferredSize(new Dimension(PWIDTH, PHEIGHT));

		// create game components
		setFocusable(true);

		requestFocus(); // JPanel now receives key events

		if (dbImage == null) {
			dbImage = new BufferedImage(PWIDTH, PHEIGHT,
					BufferedImage.TYPE_INT_ARGB);
			if (dbImage == null) {
				System.out.println("dbImage is null");
				return;
			} else {
				dbg = (Graphics2D) dbImage.getGraphics();
			}
		}

		// Adiciona um Key Listner
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (canvasAtivo != null) {
					canvasAtivo.keyPressed(e);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (canvasAtivo != null) {
					canvasAtivo.keyReleased(e);
				}
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				if (canvasAtivo != null) {
					canvasAtivo.mouseMoved(e);
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (canvasAtivo != null) {
					canvasAtivo.mouseDragged(e);
				}
			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (canvasAtivo != null) {
					canvasAtivo.mouseReleased(e);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (canvasAtivo != null) {
					canvasAtivo.mousePressed(e);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		canvasAtivo = new CanvasMenu();

	} // end of GamePanel()

	public void addNotify() {
		super.addNotify(); // creates the peer
		startGame(); // start the thread
	}

	private void startGame()
	// initialize and start the thread
	{

		if (animator == null || !running) {
			animator = new Thread(this);
			animator.start();
		}

	} // end of startGame()

	public void stopGame()
	// called by the user to stop execution
	{
		running = false;
	}

	public void run()
	/* Repeatedly update, render, sleep */
	{

		running = true;

		long DifTime, TempoAnterior;

		int segundo = 0;
		DifTime = 0;
		TempoAnterior = System.currentTimeMillis();

		while (running) {

			gameUpdate(DifTime); // game state is updated
			gameRender(); // render to a buffer
			paintImmediately(0, 0, PWIDTH, PHEIGHT); // paint with the buffer

			try {
				Thread.sleep(0); // sleep a bit
			} catch (InterruptedException ex) {
			}

			DifTime = System.currentTimeMillis() - TempoAnterior;
			TempoAnterior = System.currentTimeMillis();

			if (segundo != ((int) (TempoAnterior / 1000))) {
				FPS = SFPS;
				SFPS = 1;
				segundo = ((int) (TempoAnterior / 1000));
			} else {
				SFPS++;
			}

			diftime = (int) DifTime;
		}

		System.exit(0); // so enclosing JFrame/JApplet exits

	} // end of run()

	int timerfps = 0;

	private void gameUpdate(long DiffTime) {
		if (canvasAtivo != null) {
			canvasAtivo.SimulaSe(DiffTime);
		}
	}

	private void gameRender()
	// draw the current frame to an image buffer
	{
		if (canvasAtivo != null) {
			canvasAtivo.DesenhaSe(dbg);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (dbImage != null)
			g.drawImage(dbImage, 0, 0, null);
	}

	public static void main(String args[]) {

		System.out.println(SWIDTH + " " + SHEIGHT);

		GamePanel ttPanel = new GamePanel();

		// create a JFrame to hold the timer test JPanel
		JFrame app = new JFrame(title);
		app.getContentPane().add(ttPanel, BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		app.pack();
		app.setResizable(false);
		app.setLocation((int) (SWIDTH - PWIDTH) / 2,
				(int) (SHEIGHT - PHEIGHT) / 2);
		app.setVisible(true);
	} // end of main()

	public static int getDiftime() {
		return diftime;
	}

} // end of GamePanel class
