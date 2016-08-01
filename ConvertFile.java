package entities;

import java.io.File;
import java.io.FileInputStream;

public class ConvertFile {
	public static byte[] getFileConverted(String fileName) {
		File file = new File(fileName);
		byte[] bFile = new byte[(int) file.length()];
		try (FileInputStream fileInputStream = new FileInputStream(file)) {
			fileInputStream.read(bFile);
		} catch (Exception e) {
			bFile = null;
		}
		return bFile;
	}
}
