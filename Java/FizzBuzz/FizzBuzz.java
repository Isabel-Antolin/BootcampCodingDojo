public class FizzBuzz {
  public String fizzBuzz(int number) {
    String resultado;
    if (number % 3 == 0 && number % 5 == 0) {
      resultado = "FizzBuzz";
    } else if (number % 5 == 0) {
      resultado = "Buzz";
    } else if (number % 3 == 0) {
      resultado = "Fizz";
    } else {

      resultado = Integer.toString(number);
    }
    return resultado;
  }
}
