class Night extends Thread {
  // 1. Circular Evaluation
  public static String disco() {
    return Fever.disco();
  }

  // 2. Race Condition
  public void run() {
    Disco.add("night");
  }
}
