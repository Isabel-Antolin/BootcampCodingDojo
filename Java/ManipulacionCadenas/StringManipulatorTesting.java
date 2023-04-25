public class StringManipulatorTesting {
  public static void main(String[] args) {
    StringManipulator manipulator = new StringManipulator();

    String str = manipulator.trimAndConcat("    Hola     ", "     Mundo    ");
    System.out.println(str); // HolaMundo

    char letter = 'n';
    int a = manipulator.getIndexOrNull("Coding", letter);
    int b = manipulator.getIndexOrNull("Hola Mundo", letter);
    int c = manipulator.getIndexOrNull("Saludar", letter);

    System.out.println(a);
    System.out.println(b);
    System.out.println(c);

    String word = "Hola";
    String subString = "la";
    String notSubString = "mundo";

    int d = manipulator.getIndexOrNull(word, subString);
    int e = manipulator.getIndexOrNull(word, notSubString);

    System.out.println(d);
    System.out.println(e);

  
    String word2 = manipulator.concatSubstring("Hola", 1, 3, "mundo");
    System.out.println(word2); // olmundo

  }
}
