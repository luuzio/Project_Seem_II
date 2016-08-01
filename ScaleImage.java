package entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ScaleImage {

	public static Image getImageScaledByPath(String iPath, int iWidth, int iHeight) {
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(iPath));
			int x = iWidth, y = iHeight;
			int ix = bufferedImage.getWidth(), iy = bufferedImage.getHeight();
			int dx = 0, dy = 0;
			if (x / y > ix / iy) {
				dy = y;
				dx = dy * ix / iy;
			} else {
				dx = x;
				dy = dx * iy / ix;
			}
			return new ImageIcon(iPath).getImage().getScaledInstance(dx, dy, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Image getImageScaledByByteFile(byte[] bFile, int iWidth, int iHeight) {
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bFile);
			BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
			int x = iWidth, y = iHeight;
			int ix = bufferedImage.getWidth(), iy = bufferedImage.getHeight();
			int dx = 0, dy = 0;
			if (x / y > ix / iy) {
				dy = y;
				dx = dy * ix / iy;
			} else {
				dx = x;
				dy = dx * iy / ix;
			}
			return new ImageIcon(bFile).getImage().getScaledInstance(dx, dy, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
