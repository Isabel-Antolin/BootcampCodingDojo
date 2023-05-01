package com.isabel.maestrodeobjetos.main;

import com.isabel.maestrodeobjetos.objetos.Ninja;
import com.isabel.maestrodeobjetos.objetos.Samurai;
//import com.isabel.maestrodeobjetos.objetos.Human;
import com.isabel.maestrodeobjetos.objetos.Wizard;

public class HumanTest {
	public static void main(String[] args) {
			Wizard mago = new Wizard();
			System.out.println("__Mago Creado__");
			mago.display();
			
			Ninja ninja = new Ninja();
			System.out.println("Ninja Creado__");
			ninja.display();
			
			Samurai samurai = new Samurai();
			System.out.println("__Samurai Creado__");
			samurai.display();
	System.out.println("________________________________________");		
			ninja.steal(mago);
			mago.display();
			
			mago.heal(mago);
			mago.display();
	}
}
