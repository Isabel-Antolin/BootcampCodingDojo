public class StringManipulator {
  public String trimAndConcat(String cadena1, String cadena2) {
    cadena1 = cadena1.trim();
    cadena2 = cadena2.trim();
    return cadena1 + cadena2;
  }
  public int getIndexOrNull(String cadena, char letra){
    int posicion = cadena.indexOf(letra);
     return posicion;
  }

  public  int getIndexOrNull(String word, String subString) {
    int index = word.indexOf(subString);
    return index;
  }

  public String concatSubstring(String cadena1, int num1, int num2, String cadena2) {
    cadena1 = cadena1.substring(num1, num2);
    String resultado = cadena1 + cadena2;

    return resultado;
  }
}
