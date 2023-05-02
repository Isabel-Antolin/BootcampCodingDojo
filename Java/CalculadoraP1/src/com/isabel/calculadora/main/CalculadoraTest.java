package com.isabel.calculadora.main;

import com.isabel.calculadora.objeto.Calculadora;

public class CalculadoraTest {
 public static void main(String[] args) {
	 Calculadora c1 = new Calculadora();
	 c1.setOperandOne(10.5);
	 c1.setOperation("+");
	 c1.setOperandTwo(5.2) ;
	 c1.performOperation() ;
	 c1.getResult() ;
}
  
 
}
