import java.util.ArrayList;
public class Prog19_01 {
    int count = 0;

    public Prog19_01(){
        int n = 8;
        printPermutations(n);
    }

    public void printPermutations(int n){
        int[] a = new int[n];
        printPermutations(a, 0);
    }

    public void printPermutations(int[] a, int k){
        if (k == a.length){
            printArray(a);
        }
        else{
            ArrayList<Integer> Sk = constructCandidateSet(a, k);
            for (int s : Sk){
                a[k] = s;
                printPermutations(a, k+1);
            }
        }
    }

    private ArrayList<Integer> constructCandidateSet(int[] a, int k){
        ArrayList<Integer> candidates = new ArrayList<>();
        boolean[] b = new boolean[a.length];

        for (int i = 0; i < k; i++) {
            b[a[i]] = true;
        }

        for (int i = 0; i < a.length; i++) {
            if (!b[i]) candidates.add(i);
        }

        return candidates;
    }

    private void printArray(int[] a){
        System.out.printf("%4d: ", ++count);
        for (int v : a) {
            System.out.print(v + " ");
        }
        System.out.println();
    } 

    
}
