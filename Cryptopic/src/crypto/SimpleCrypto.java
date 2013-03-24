package crypto;

// Simple cryptography class to reverse all the binary bits in a string. Non-functional. Requires updating.

import java.io.UnsupportedEncodingException;

public class SimpleCrypto implements CryptoInterface{

	public String encrypt(String message) {
		byte[] binMessage = null;
		String bitByBit = "";
		try {
			binMessage = message.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		char[][] revCrypt = new char[binMessage.length][8];

		for(int c = 0; c<binMessage.length; c++){
			bitByBit = Integer.toBinaryString(binMessage[c]);
			while(bitByBit.length()<8){
				bitByBit = "0" + bitByBit;
			}
			
		}
		String mess = "";
		for(int d=0; d< revCrypt.length; d++){
			mess = mess + (char)Integer.parseInt(new String(revCrypt[d]), 2);
		}
		return mess;
	}


	public String decrypt(String mess) {
		byte[] binMessage = null;
		try {
			binMessage = mess.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		char[][] revCrypt = new char[binMessage.length/8][8];
		int p = 0;
		int q = 0;
		for(int c = 0; c<binMessage.length; c++){
			if(p >= 8){
			   p=0;
			   q++;
			}
			if(binMessage[c] == 1){
				revCrypt[q][p] ='0';
			}
			else{
				revCrypt[q][p] ='1';
			}
			p++;
		}
		String message = "";
		for(int d=0; d< revCrypt.length; d++){
			message = message + (char)Integer.parseInt(new String(revCrypt[d]), 2);
		}
		return message;
	}

}
