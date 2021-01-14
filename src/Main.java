import java.util.ArrayList;

class Main {

  public static void main(String[] args) {
      if (args.length != 2) {
          System.out.println("Usage :");
          System.out.println("java Main k n");
      }
      SAT sat = new SAT(Integer.parseInt(args[1]),Integer.parseInt(args[0]));
      ArrayList instance = sat.generate();System.out.println(instance.size());
      sat.write("../sat.instances/" + args[0] + "-" + args[1] + ".cnf");
  }

}