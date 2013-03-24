package crypto;
// A basic Caesar cipher for crypto testing

public class CryptoBase implements CryptoInterface{

	private char[] alphabet;
	private char[] alphanot;
	
	public CryptoBase(){
		alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
		alphanot = new char[] {'y', 'z', ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'};
	}
	
	public String encrypt(String message){
		String mess = "";
		int pointer = 0;
		for(int c=0; c<message.length(); c++){
			while(alphabet[pointer] != message.charAt(c)){
		//		System.out.println(message.charAt(c) + " is not equal to " + alphabet[pointer]);
				pointer++;
			}
			mess = mess + alphanot[pointer];
			pointer = 0;
		}
		return mess;
	}
	
	
	public String decrypt(String mess){
		String message = "";
		int pointer = 0;
		for(int c=0; c<mess.length(); c++){
			while(alphanot[pointer] != mess.charAt(c)){
				pointer++;
			}
			message = message + alphabet[pointer];
			pointer = 0;
		}
		return message;
	}
}
