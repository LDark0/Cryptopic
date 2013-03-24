package crypto;

//Short class for testing cryptography without running full code

public class TestCrypto {

	
	public static void main(String[] args) {
		SimpleCrypto sim = new SimpleCrypto();
		String message = "Hello World";
		String mess = sim.encrypt(message);
		System.out.println(mess);
		message = sim.decrypt(mess);
		System.out.println(message);
	}

}
