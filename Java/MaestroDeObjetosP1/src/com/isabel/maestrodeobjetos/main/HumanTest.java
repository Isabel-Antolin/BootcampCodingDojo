package com.isabel.maestrodeobjetos.main;

import com.isabel.maestrodeobjetos.objetos.Human;

public class HumanTest {
	public static void main(String[] args) {
			Human agresor = new Human();
			Human objetivo = new Human();
			
			System.out.println("----Agresor----");
			agresor.display();
			
			System.out.println("----Objetivo----");
			objetivo.display();
			
			objetivo.attack(agresor);
			
			System.out.println("----Agresor----");
			agresor.display();
			System.out.println("----Objetivo----");
			objetivo.display();
	}
}
