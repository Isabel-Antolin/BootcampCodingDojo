import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EjerciciosBasicos {
  // Imprimir 1 - 255 :Escriba un método que imprima todos los número del 1 al
  // 255.
  public void imprimirNumeros() {
    for (int i = 1; i <= 255; i++) {
      System.out.println(i);
    }
  }

  // Imprimir los Números Impares Entre 1 - 255 : Escriba un método que imprima
  // todos los número impares entre el 1 al 255.
  public void imprimirNumerosImpares() {
    for (int i = 1; i <= 255; i++) {
      if (i % 2 != 0) {
        System.out.println(i);
      }
    }
  }

  // Imprimir la Suma : Escriba un método que imprima los números desde el 0 hasta
  // el 255, pero esta vez muestre también las suma de los números que ha
  // mostradoen pantalla hasta ahora.
  public void imprimirSuma() {
    int suma = 0;
    for (int i = 0; i <= 255; i++) {
      suma += i;
      System.out.println(i);
      System.out.println(suma);
    }
  }

  // Recorrer un Arreglo: Dado un arreglo X, digamos [1,3,5,7,9,13], escriba un
  // método que recorra cada uno de los elementos del arreglo e imprima cada
  // valor. Ser capaz de recorrer cada elemento de un arreglo es extremadamente
  // importante.
  public void recorrerArreglo(ArrayList<Integer> listaNumeros) {
    for (int i = 0; i < listaNumeros.size(); i++) {
      System.out.println(listaNumeros.get(i));
    }
  }

  // Encontrar el Máximo: Escribir un método que tome un arreglo e imprima el
  // valor máximo en el arreglo. Su método debería funcionar también con todos los
  // números en negativo (ejemplo [-3,-5,-7]), o incluso una mezcla de números
  // positivos, números negativos y cero.
  public void encontrarMayor(ArrayList<Integer> listaNumeros) {
    int mayor = listaNumeros.get(0);
    for (int i = 1; i < listaNumeros.size(); i++) {
      int elemento = listaNumeros.get(i);
      if (elemento > mayor) {
        mayor = elemento;
      }
    }
    System.out.println(mayor);
  }

  // Obtener el Promedio: Escribir un método que tome un arreglo e imprima el
  // promedio de los valores en el arreglo. Por ejemplo en un arreglo hay
  // [2,10,3], su método debería Imprimir “Promedio de 5”. Nuevamente, asegúrese
  // de crear un caso simple y escriba las instrucciones para resolver ese caso
  // primero, luego pruebe sus instrucciones con casos más complicados.
  public void promedio(ArrayList<Integer> listaNumeros) {
    int suma = 0;
    for (int numero : listaNumeros) {
      suma += numero;
    }
    double promedio = (double) suma / listaNumeros.size();
    System.out.println("Promedio de " + suma + " es " + promedio);
  }

  // Arreglo con Números Impares: Escribir un método que cree un arreglo ‘y’ que
  // contenga todos los números impares entre 1 - 255. Cuando el método haya
  // terminado, ‘y’ debe tener los valores de [1,3,5,7…255].
  public ArrayList<Integer> listaNumerosImpares() {
    ArrayList<Integer> y = new ArrayList<Integer>();
    for (int i = 1; i <= 255; i++) {
      if (i % 2 != 0) {
        y.add(i);
      }
    }
    return y;
  }

  // Mayor que Y :Escribir un método que tome un arreglo y devuelva el número de
  // valores mayores a un valor Y dado. Por ejemplo, si el arreglo es [1,3,5,7] y
  // Y = 3, después de terminar el proceso el método debe Imprimir el número 2 (ya
  // que hay 2 valores en el arreglo que son mayores que 3).
  public void mayorQueY(ArrayList<Integer> listaNumeros) {
    int y = 3;
    int contador = 0;
    for (int numero : listaNumeros) {
      if (numero > y) {
        contador++;
      }
    }
    System.out.println(contador);
  }

  // Valores al Cuadrado Dado cualquier arreglo x, digamos [1,5,10,-2], escribir
  // un método que multiplique cada valor en el arreglo por sí mismo. Cuando el
  // método haya terminado, el arreglo x debe contener valores que han sido
  // elevados al cuadrado, digamos [1,25,100,4].
  public ArrayList<Integer> listaNumerosAlCuadrado(ArrayList<Integer> listaNumeros) {
    for (int i = 0; i < listaNumeros.size(); i++) {
      int numeroCuadrado = (int) Math.pow(listaNumeros.get(i), 2);
      listaNumeros.set(i, numeroCuadrado);
    }
    return listaNumeros;
  }

  // Eliminar Números Negativos : Dado un arreglo x, digamos [1,5,10,-2], escribir
  // un método que reemplace cualquier número negativo por 0. Cuando el método
  // haya terminado, x no debe tener valores negativos, digamos como [1,5,10,0].
  public ArrayList<Integer> reemplazarNegativos(ArrayList<Integer> listaNumeros) {
    for (int numero : listaNumeros) {
      if (numero < 0) {
        listaNumeros.set(listaNumeros.indexOf(numero), 0);
      }
    }
    return listaNumeros;
  }

  // Mínimo, Máximo y Promedio : Dado un arreglo x, digamos [1,5,10,-2], escribir
  // un método que devuelva un arreglo con el número máximo, el número mínimo y el
  // valor promedio que hay en el arreglo x. El arreglo devuelto debe contener
  // solo 3 valores [Max, Min, Prom].
  public ArrayList<Integer> obtenerMinMaxAvg(ArrayList<Integer> listaNumeros) {
    // stream() es una función de Java 8 que convierte la lista en un flujo de datos
    // que se puede manipular de manera eficiente.
    // mapToInt(a -> a) es una función que convierte cada elemento del ArrayList en
    // un número entero (int).
    // average() es una función que calcula el promedio de los elementos del flujo.
    // orElse(0) es una función que devuelve 0 si la lista está vacía y no se puede
    // calcular el promedio.
    ArrayList<Integer> nuevaList = new ArrayList<Integer>();
    int numMayor = Collections.max(listaNumeros);
    int numMenor = Collections.min(listaNumeros);
    int avg = (int) listaNumeros.stream().mapToDouble(a -> a).average().orElse(0);
    nuevaList.addAll(Arrays.asList(numMenor, numMayor, avg));
    return nuevaList;
  }

  // Cambiando los Valores del Arreglo: Dado un arreglo x, digamos [1,5,10,7,-2],
  // escribir un método que cambie cada valor por el valor que sigue. Por ejemplo,
  // cuando el método haya terminado, un arreglo x [1,5,10,7,-2] se convertirá en
  // [5,10,7,-2,0]. Observe que el último número es 0. El método no necesita
  // ajustarse para los valores que están fuera de los límites.
  public ArrayList<Integer> cambiarElemento(ArrayList<Integer> lista) {
    for (int i = 0; i < lista.size() - 1; i++) {
      lista.set(i, lista.get(i + 1));
    }
    lista.set(lista.size() - 1, 0);
    return lista;
  }
}
