package steg;

//Class responsible for breaking code down to binary and hiding data in pixels as well as undoing this process.

import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.Random;


public class BinaMatte implements StegInterface{

	public char[] coords;
	
		public BufferedImage encode(BufferedImage cover, String message){
			
			Random ranGenX = new Random();
			Random ranGenY = new Random();
			
			byte[] byteForm = null;
			int binaryForm = 0;
			String bitByBit = null;
			try {
				byteForm = message.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			int[] steg = new int[byteForm.length*8];
			int stegPointer = 0;
			for(int i = 0; i<byteForm.length; i++){
				binaryForm = byteForm[i];
				bitByBit = Integer.toBinaryString(binaryForm);
				while(bitByBit.length() < 8 ){
					bitByBit = "0" + bitByBit;
				}
				for(int c = 0; c<bitByBit.length(); c++){
					if(bitByBit.charAt(c) == '0'){
						steg[stegPointer] = 0;
					}
					else{
						steg[stegPointer] = 1;
					}
					stegPointer++;
				}
			}
			
			coords = new char[steg.length*2];
			
			for(int e = 0; e<coords.length;e = e+2){
				coords[e] = (char)ranGenX.nextInt(cover.getWidth());
			}
			for(int o = 1; o<coords.length; o = o+2){
				coords[o] = (char)ranGenY.nextInt(cover.getHeight());
			}
			
			String newVal = "";
			for(int i = 0; i<steg.length; i++){
				newVal = Integer.toBinaryString(cover.getRGB(i, 0));
				newVal = newVal.substring(0, newVal.length()-2) + steg[i];
			cover.setRGB(coords[i*2], coords[(i*2)+1], Integer.parseInt(newVal, 2));
			}
			return cover;
		}
		
		public String decode(BufferedImage cover, char[] key){
			char[][] mess = new char[key.length/16][8];
			int q = 0;
			int p = 0;
			for(int j = 0; j<key.length/2; j++){
				if(p >= 8){
					p = 0;
					q++;
				}
			mess[q][p] = Integer.toBinaryString(cover.getRGB(key[j*2], key[j*2+1])).charAt(Integer.toBinaryString(cover.getRGB(key[j*2], key[j*2+1])).length()-1);
				p++;
			}
			
			String message = "";
			for(int c=0; c< mess.length; c++){
				message = message + (char)Integer.parseInt(new String(mess[c]), 2);
			}
			
			return message;
		}
	}
