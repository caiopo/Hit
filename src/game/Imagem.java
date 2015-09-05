package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagem {

	// public static BufferedImage personagem;

	public static void importImages() {

		System.out.println("Importing images");

//		System.out.println(GamePanel.instance.getClass().getResource("/res/fundo.jpg"));

		// personagem = loadImage("/res/electraHeart.png");

		System.out.println("Images imported!");

	}

	public static BufferedImage loadImage(String source) {

		BufferedImage image = null;
		try {
			BufferedImage tmp = ImageIO.read(GamePanel.instance.getClass().getResource(source));
			image = new BufferedImage(tmp.getWidth(), tmp.getHeight(), BufferedImage.TYPE_INT_ARGB);
			image.getGraphics().drawImage(tmp, 0, 0, null);
			tmp = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

}
