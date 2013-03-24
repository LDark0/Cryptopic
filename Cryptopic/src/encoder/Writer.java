package encoder;

//Used to save the cover image after image insertion

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Writer {

	public File source;
	public BufferedImage altered;
	
	
	public Writer(File image, BufferedImage newImage){
		source = image;
		altered = newImage;
	}
	
	public void save(){
		try{
			ImageIO.write(altered, "bmp", source);
			System.out.println("Saved to: " + source.getPath());
		}
		catch(IOException e){
			System.out.println("Well, that didn't work");
		}
	}
}
