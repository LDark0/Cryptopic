package decoder;
//Main class for extracting messages from images

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import steg.BinaMatte;

import crypto.CryptoBase;
import crypto.CryptoInterface;

import java.util.ArrayList;

public class Decode {

	
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
		
		BinaMatte code = new BinaMatte();
		
		ArrayList<Integer> keyInput = new ArrayList<Integer>();
		
		for(int i = 1; i<args.length; i++){
		keyInput.add(Integer.parseInt(args[i]));
		
		}
		
		int[] key = new int[keyInput.size()];
		
		for(int j=0; j<keyInput.size(); j++){
			key[j] = keyInput.get(j);
		}
		
		String message= code.decode(changer, key);
		
		message = crypto.decrypt(message);
		
		System.out.println(message);
		
	}

}
