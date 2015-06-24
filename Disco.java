import java.util.*;

class Disco {
  private static Saturday saturday;
  private static Night night;
  private static Fever fever;

  private static List<String> elements = new ArrayList<String>();

  public static void main(String[] args) throws InterruptedException {
    // We're going to do two experiments here:

    if (args.length == 0) {
      System.out.println("Static at the Disco! Call with 'race' or 'circle'");
      System.exit(1);
    }

    // 1. Circular Evaluation
    if (args[0].equals("circle")) {
      System.out.println(Saturday.disco);
    }

    // 2. Race Condition
    if (args[0].equals("race")) {
      for (int i=0; i < 1000; i++) { race(); }
    }
  }


  // The Race Condition experiment uses the following little helpers:

  // The public static method called from the other classes
  public static void add(String value) {
    // only add to list if nothing in there already :)
    // synchronized (elements) {
      if (elements.size() == 0) {
        elements.add(value);
      }
    // }
  }

  // The race itself
  private static void race() throws InterruptedException {
      // create the threads
      saturday = new Saturday(); night = new Night(); fever = new Fever();

      // run them side by side
      saturday.start(); night.start(); fever.start();

      // wait for them to finish
      saturday.join(); night.join(); fever.join();

      // print the result
      System.out.println(String.join(" ", elements));

      // trash the list
      elements = new ArrayList<String>();
  }
}
