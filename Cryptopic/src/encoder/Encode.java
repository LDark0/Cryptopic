package encoder;
// Main class for inserting messages into images
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

import steg.BinaMatte;

import crypto.CryptoBase;
import crypto.CryptoInterface;





public class Encode {

	
	public static void main(String[] args) {

		File source = null;
		BufferedImage changer = null;
		try {
			source = new File(args[0]);
			changer = ImageIO.read(source);
		} catch (IOException e) {
			System.out.println("FAIL");
		}
		
		CryptoInterface crypto = new CryptoBase();
		
		String message = crypto.encrypt(args[1]);
		
		BinaMatte code = new BinaMatte();
		
		changer = code.encode(changer, message);
		
		String keySet = "";
		for(int c=0; c<code.coords.length; c++){
			keySet = keySet + (int)code.coords[c] + " ";
		}
		
		try {
			FileWriter key = new FileWriter("key.txt");
			BufferedWriter writer = new BufferedWriter(key);
			writer.write(keySet);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			
		}
		
		Writer write = new Writer(new File(args[2]), changer);
		write.save();
	}

}
