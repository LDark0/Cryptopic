package steg;

//Interface to ensure any further steg classes have the required methods

import java.awt.image.BufferedImage;

public interface StegInterface {

	
	public BufferedImage encode(BufferedImage cover, String mess);
	
	public String decode(BufferedImage cover, char[] key);
}
