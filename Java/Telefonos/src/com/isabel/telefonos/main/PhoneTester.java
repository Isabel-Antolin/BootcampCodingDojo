package com.isabel.telefonos.main;
import com.isabel.telefonos.clases.Galaxy;
import com.isabel.telefonos.clases.Iphone;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s9=new Galaxy("S9", 99, "Verizon", "Ring Ring Ring");
		Iphone iphoneTen =new Iphone("X", 99, "AT&T", "Zing Zing");
		
		s9.displayInfo();
		System.out.println(s9.ring());
		System.out.println(s9.unlock());
		
		iphoneTen.displayInfo();
		System.out.println(iphoneTen.ring());
		System.out.println(iphoneTen.unlock());
	}

}
