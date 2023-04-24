import java.text.DecimalFormat;

// package TeoremaPitagoras;

public class Pitagoras {
  public double calcularHipotenusa(double catetoA, double catetoB) {
    catetoA = Math.abs(catetoA);
    catetoB = Math.abs(catetoB);
    double resultado = Math.sqrt(((Math.pow(Math.abs(catetoA), 2)) + (Math.pow(Math.abs(catetoB), 2))));

    DecimalFormat df = new DecimalFormat("#.##");
    String res = df.format(resultado);
  

    System.out.println("La hipotenusa es: " + res );
    return resultado;
  }
}
