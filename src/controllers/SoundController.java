package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.CodeSource;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import main.GamePanel;

public class SoundController {

	static String path = null;

	static Clip audioClip;

	public static void musica() throws Exception {

		path = (getJarContainingFolder(GamePanel.class) + "/song.wav").replace(
				'/', File.separatorChar);

		System.out.println(path);

		musica2();
	}

	public static void musica2() throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {

		File audioFile = new File(path);

		AudioInputStream audioStream = AudioSystem
				.getAudioInputStream(audioFile);

		AudioFormat format = audioStream.getFormat();

		DataLine.Info info = new DataLine.Info(Clip.class, format);
		audioClip = (Clip) AudioSystem.getLine(info);
		audioClip.open(audioStream);
		audioClip.loop(Clip.LOOP_CONTINUOUSLY);

	}

	public static String getJarContainingFolder(Class aclass) throws Exception {
		CodeSource codeSource = aclass.getProtectionDomain().getCodeSource();

		File jarFile;

		if (codeSource.getLocation() != null) {
			jarFile = new File(codeSource.getLocation().toURI());
		} else {
			String path = aclass.getResource(aclass.getSimpleName() + ".class")
					.getPath();
			String jarFilePath = path.substring(path.indexOf(":") + 1,
					path.indexOf("!"));
			jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
			jarFile = new File(jarFilePath);
		}

		return jarFile.getParentFile().getAbsolutePath();
	}
}
