
// import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

  // ArrayList<Integer> numeros = new ArrayList<Integer>();
  // numeros.add(5);
  // numeros.add(4);
  // numeros.add(3);
  // numeros.add(2);
  // numeros.add(1);

  // Collections.shuffle(numeros); // desordena el ArrayList
  // System.out.println(numeros);
  // Collections.sort(numeros); // ordena el ArrayList
  // System.out.println(numeros);

  // Random r = new Random();
  // System.out.println(r.nextInt());// da un numero aleatorio sin limite
  // System.out.println(r.nextInt(5)); //da un numero aleatorio entre 0 y 5

  public ArrayList<Integer> suma(ArrayList<Integer> array) {
    int sum = 0;
    ArrayList<Integer> nuevoArray = new ArrayList<Integer>();

    for (int elemento : array) {
      sum += elemento;
      if (elemento > 10) {
        nuevoArray.add(elemento);
      }
    }

    System.out.println("La suma total del arreglo es " + sum);
    return nuevoArray;
  }

  public ArrayList<String> mostrarNombres(ArrayList<String> nombres) {
    Collections.shuffle(nombres); // desordena los elementos del array
    // System.out.println(nombres);

    ArrayList<String> nuevaLista = new ArrayList<String>();
    for (String nombre : nombres) {
      System.out.println(nombre);
      int largoString = nombre.length();

      if (largoString > 5) {
        nuevaLista.add(nombre);
      }
    }

    return nuevaLista;
  }

  public void alfabeto() {
    ArrayList<Character> albafeto = new ArrayList<Character>();

    for (char letra = 'a'; letra <= 'z'; letra++) {
      albafeto.add(letra);
    }

    Collections.shuffle(albafeto);
    char ultimaLetra = albafeto.get(albafeto.size() - 1);
    char primeraLetra = albafeto.get(0);

    System.out.println(ultimaLetra);
    System.out.println(primeraLetra);

    if (primeraLetra == 'a' || primeraLetra == 'e' || primeraLetra == 'i' || primeraLetra == 'o'
        || primeraLetra == 'u') {
      System.out.println(primeraLetra + " es la primera letra y es una vocal");
    }

  }

  public ArrayList<Integer> arregloAleatorio() {
    Random r = new Random();
    ArrayList<Integer> listaAleatoria = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      listaAleatoria.add(r.nextInt((100 - 55 + 1)) + 55);
    }
    return listaAleatoria;
  }

  public ArrayList<Integer> arregloAleatorio2() {
    Random r = new Random();
    ArrayList<Integer> listaAleatoria = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      int numeroAleatorio = r.nextInt((100 - 55 + 1)) + 55;
      if (!listaAleatoria.contains(numeroAleatorio)) { // si no existe el elemento en la lista se agrega
        listaAleatoria.add(numeroAleatorio);
        System.out.println("Numero agregado a la lista " + numeroAleatorio);
      }
    }

    Collections.sort(listaAleatoria);
    System.out.println("el numero menor es:" + Collections.min(listaAleatoria));
    System.out.println("el numero mayor es:" + Collections.max(listaAleatoria));
    return listaAleatoria;
  }

  public String generadorCadenas() {
    Random random = new Random(); // se crea una instancia de la clase Random
    StringBuilder cadena = new StringBuilder(); // se crea un StringBuilder para construir la cadena aleatoria
    for (int i = 0; i < 5; i++) { // se utiliza un bucle para generar 5 caracteres aleatorios
      int letra = random.nextInt(26) + 97; // se genera un número aleatorio entre 97 y 122, que corresponde a las letras minúsculas en el código ASCII
      cadena.append((char) letra); // se convierte el número aleatorio en su correspondiente letra en ASCII y se agrega al StringBuilder
    }
    String cadenaString = cadena.toString();
   // System.out.println("Cadena generada: " + cadenaString); // se imprime la cadena completa como un mensaje en la consola
    return cadenaString;
  }
 
  public ArrayList<String>generar10Cadenas(){
    ArrayList<String> listaCadenas = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      String cadena = generadorCadenas();
      listaCadenas.add(cadena);
    }
    return listaCadenas;
  }
}