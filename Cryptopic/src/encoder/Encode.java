package encoder;

import java.awt.image.BufferedImage;
import java.io.File;
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
			ImageIO.write(changer, ".jpg", new File("test2.jpg"));
		} catch (IOException e) {
			System.out.println("FAIL");
		}
		
		CryptoInterface crypto = new CryptoBase();
		
		String message = crypto.encrypt(args[1]);
		
		System.out.println(message);
		
		BinaMatte code = new BinaMatte();
		
		changer = code.encode(changer, message);
		
		System.out.println("[");
		for(int c=0; c<code.coords.length; c++){
			System.out.print((int)code.coords[c]+ ", ");
		}
		System.out.println("]");
		Writer write = new Writer(new File("cover.jpg"), changer);
		write.save();
	}

}
