import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SAT {

    private final int n;
    private final int k;

    private final ArrayList<ArrayList<Integer>> instance;

    private boolean isGenerate;

    public SAT(int n, int k) {
        this.n = n;
        this.k = k;
        this.instance = new ArrayList<>();
        this.isGenerate = false;
    }

    public int getN() {
        return n;
    }

    public int getK() {
        return k;
    }

    public ArrayList<ArrayList<Integer>> generate(){
        // Si l'instance est déjà générer, ne pas la recalculer
        if (isGenerate) {
            return instance;
        }

        // Ajout des clauses pour avoir exactement une boule pour chaque v
        for (int v = 1; v <= n; v++){
            ArrayList<Integer> clause1 = new ArrayList<>();
            for (int b1 = 0; b1 < k; b1++){
                clause1.add(b1*n+v);
                ArrayList<Integer> clause2 = new ArrayList<>();
                for (int b2 = b1+1; b2 < k; b2++){
                    clause2.add(-(b1*n+v));
                    clause2.add(-(b2*n+v));
                    instance.add(clause2);
                    clause2 = new ArrayList<>();
                }
            }
            instance.add(clause1);
            clause1 = new ArrayList<>();
        }

        // Ajout des clauses pour que x, y et z ne soient pas dans la même boite avec x+y=z
        for (int x = 1; x <= n; x++){
            for (int y = x + 1; x + y <= n; y++){
                ArrayList<Integer> clause = new ArrayList<>();
                for (int b = 0; b < k; b++){
                    clause.add(-(b*n+x));
                    clause.add(-(b*n+y));
                    int z = x+y;
                    clause.add(-(b*n+z));
                    instance.add(clause);
                    clause = new ArrayList<>();
                }
            }
        }

        isGenerate = true;
        return instance;
    }

    public boolean write(String fileName){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileName,false);
        } catch (IOException e) {
            return false;
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("p cnf " + (n*k) + " " + instance.size());
        for (ArrayList<Integer> clause : instance) {
            for (Integer integer : clause) {
                printWriter.print(integer + " ");
            }
            printWriter.println("0");
        }
        printWriter.close();
        return true;
    }

}
