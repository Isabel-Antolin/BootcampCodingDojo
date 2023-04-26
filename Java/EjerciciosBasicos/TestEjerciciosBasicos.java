import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TestEjerciciosBasicos {
  public static void main(String[] args) {
    EjerciciosBasicos ejerciciosBasicos = new EjerciciosBasicos();
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    ArrayList<Integer> prueba = new ArrayList<Integer>();

    numeros.addAll(Arrays.asList(1,-3,3,5,7,50,9,13));
    prueba.addAll(Arrays.asList(1,5,10,-2));
    

    ejerciciosBasicos.imprimirNumeros();
    ejerciciosBasicos.imprimirNumerosImpares();
    ejerciciosBasicos.imprimirSuma();
    ejerciciosBasicos.recorrerArreglo(numeros);
    ejerciciosBasicos.encontrarMayor(numeros);
    ejerciciosBasicos.promedio(numeros);
    System.out.println(ejerciciosBasicos.listaNumerosImpares());
    ejerciciosBasicos.mayorQueY(numeros);
    System.out.println(ejerciciosBasicos.listaNumerosAlCuadrado(numeros));
    System.out.println(ejerciciosBasicos.reemplazarNegativos(numeros));
    System.out.println(ejerciciosBasicos.obtenerMinMaxAvg(numeros));
    System.out.println(ejerciciosBasicos.cambiarElemento(numeros));
  }
}
