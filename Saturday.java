class Saturday extends Thread {
  // 1. Circular Evaluation
  public static String disco = Night.disco;

  // 2. Race Condition
  public void run() {
    Disco.add("saturday");
  }
}
