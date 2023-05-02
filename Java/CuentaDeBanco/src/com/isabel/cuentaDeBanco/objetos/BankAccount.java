package com.isabel.cuentaDeBanco.objetos;

import java.util.Random;

public class BankAccount {
	private String numeroCuenta;
	private double saldoCuentaCorriente, saldoCuentaAhorro;
	private static int cantCuentasCreadas;
	private static double cantDineroAlmacenado;

	public BankAccount() {
		this.numeroCuenta = generarNumeroCuenta();
		cantCuentasCreadas++;	
	}

//-------------Get | Set-----
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public double getSaldoCuentaCorriente() {
		return saldoCuentaCorriente;
	}

	public double getSaldoCuentaAhorro() {
		return saldoCuentaAhorro;
	}


//	-----------Metodos----------
	private String generarNumeroCuenta() {
		Random r = new Random();
		StringBuilder numeroCuenta = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			numeroCuenta.append(r.nextInt(10));
		}
		return numeroCuenta.toString();
	}

    public static int obtenerCantidadCuentas() {
        return cantCuentasCreadas;
    }

    public static double obtenerTotalDinero() {
        return cantDineroAlmacenado;
    }

	public void display() {
		System.out.println(
				String.format("Numero de cuenta: %s, Saldo Cuenta Corriente: %.0f, Saldo cuenta de ahorro: %.0f",
						numeroCuenta, saldoCuentaCorriente, saldoCuentaAhorro));

	}

	public void depositarDinero(double cantidad, String tipoCuenta) {
		if (tipoCuenta.equals("corriente")  || tipoCuenta.equals("Corriente")) {
			this.saldoCuentaCorriente += cantidad;
			cantDineroAlmacenado+=cantidad;
		} else if (tipoCuenta.equals("ahorro")  || tipoCuenta.equals("Ahorro")) {
			this.saldoCuentaAhorro += cantidad;
			cantDineroAlmacenado+=cantidad;
		} else {
			System.out.println("Seleccione tipo de cuenta de ahorro o corriente");
		}
	}
	
	public void retirarDinero(double cantidad, String tipoCuenta) {
		if (tipoCuenta == "corriente" || tipoCuenta == "Corriente") {
			if(cantidad <= this.saldoCuentaCorriente) {
				this.saldoCuentaCorriente -= cantidad;
				cantDineroAlmacenado-=cantidad;
			}else {
				System.out.println("Saldo insuficiente");
			}
		} else if (tipoCuenta == "ahorro" || tipoCuenta == "Ahorro") {
			if(cantidad <=this.saldoCuentaAhorro ) {
				this.saldoCuentaAhorro -= cantidad;
				cantDineroAlmacenado-=cantidad;
			}else {
				System.out.println("Saldo insuficiente");
			}
		} else {
			System.out.println("Seleccione tipo de cuenta de ahorro o corriente");
		}
	}

}
