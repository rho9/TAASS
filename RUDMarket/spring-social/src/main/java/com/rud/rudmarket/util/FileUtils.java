package com.rud.rudmarket.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
	public static File moveAndStoreFile(MultipartFile file) {
		File convertedFile = new File(file.getOriginalFilename());
		try {
			convertedFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convertedFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertedFile;
	}

	public static byte[] getImageBytes(File file) {
		if(file.exists()){
			try {
				BufferedImage bufferedImage = ImageIO.read(file);
				ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "png", byteOutStream);
				return byteOutStream.toByteArray();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static byte[] getImageByteImgNotAvaible() {
		File file = new File("img_non_disp.jpg");
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", byteOutStream);
			return byteOutStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
