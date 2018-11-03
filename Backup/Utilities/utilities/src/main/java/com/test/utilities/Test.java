package com.test.utilities;

public class Test {
	
	Test(){
		EncryptorUtils encryp = new EncryptorUtils();
		String s1 = encryp.encrypt("abcde");
		System.out.println("***** encrypted = " + s1);
		String s2 = encryp.decrypt(s1);
		System.out.println("***** decrypted = " + s2);
	}

	public static void main(String[] args){
		new Test();
	}
}
