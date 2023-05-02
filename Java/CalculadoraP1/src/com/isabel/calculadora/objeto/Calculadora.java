package com.isabel.calculadora.objeto;

public class Calculadora {
	private double operandOne, operandTwo, result;
	private String operation;

	

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Calculadora() {

	}

	public void performOperation() {
		if(this.operation.equals("+")) {
			result = operandOne + operandTwo;
		} else if (this.operation.equals("-")) {
            result = operandOne - operandTwo;
        } else {
            System.out.println("Operación no válida");
            return;
        }
		System.out.println(result);
	}

}
