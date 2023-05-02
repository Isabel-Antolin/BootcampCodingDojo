package com.isabel.cuentaDeBanco.main;
import com.isabel.cuentaDeBanco.objetos.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount ct1 = new BankAccount();
		BankAccount ct2 = new BankAccount();
//		BankAccount cb2 = new BankAccount();
//		BankAccount cb3 = new BankAccount();
		
//		-----------cuenta 1-----------
		System.out.println("-----cuenta 1---");
		ct1.display();
		ct1.depositarDinero(2500, "Corriente");
		ct1.depositarDinero(1500, "Ahorro");
		ct1.display();

		
//		-----------cuenta 2 -----------
		System.out.println("-----cuenta 2---");
		ct2.display();
		ct2.depositarDinero(50000, "Corriente");
		ct2.depositarDinero(60000, "Ahorro");
		ct2.retirarDinero(40000, "Ahorro");
		ct2.display();

		
		System.out.println(String.format("Dinero total de las cuentas es de $%.0f ",BankAccount.obtenerTotalDinero()));
	}
	
}
