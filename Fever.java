class Fever extends Thread {
  // 1. Circular Evaluation
  public static String disco() {
    return Saturday.disco();
  }

  // 2. Race Condition
  public void run() {
    Disco.add("fever");
  }
}
