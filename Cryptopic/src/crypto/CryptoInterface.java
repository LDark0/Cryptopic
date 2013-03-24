package crypto;

//Interface to makes sure all crypto classes have the two necessary methods for encode and decode to work

public interface CryptoInterface {

	public String encrypt(String message);
	
	public String decrypt(String mess);
	
}
