import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJavaTest {
  public static void main(String[] args) {
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    ArrayList<String> listaNombres = new ArrayList<String>();

    numeros.addAll(Arrays.asList(3, 5, 1, 2, 7, 9, 8, 13, 25, 32)); // Agrego varios elementos en un ArrayList
    listaNombres.addAll(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));

    PuzzleJava puzzleJava = new PuzzleJava();

    // ArrayList<Integer> arrayMayora10 = puzzleJava.suma(numeros);
    // ArrayList<String> nombresConMasDeCincoCarateres =
    // puzzleJava.mostrarNombres(listaNombres);

    System.out.println(puzzleJava.suma(numeros));
    System.out.println(puzzleJava.mostrarNombres(listaNombres));
    puzzleJava.alfabeto();
    System.out.println(puzzleJava.arregloAleatorio());
    System.out.println(puzzleJava.arregloAleatorio2());
    System.out.println("Cadena generada: " + puzzleJava.generadorCadenas());
    System.out.println(puzzleJava.generar10Cadenas());
  }

}
