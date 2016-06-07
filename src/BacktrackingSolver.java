import java.util.ArrayList;
import java.util.List;

/**
 * Created by @aniltallam on 5/21/2016.
 */
public class BacktrackingSolver {

    static final int SUDOKU_MAX = 9;
    static final int SUB_VAL = SUDOKU_MAX/3;
    static int counter = 0;
    private static List<Integer> getPValues(List<List<Integer>> grid, int i, int j) {
        List<Integer> plist = new ArrayList<>();
        for (int k = 1; k <= SUDOKU_MAX ; k++) {
            plist.add(k);
        }
        for (int a = 0; a < SUDOKU_MAX; a++) {
            int val = grid.get(i).get(a);
            if (val > 0 && val <= SUDOKU_MAX && plist.contains(val)) {
                plist.remove(plist.indexOf(val));
                if (plist.isEmpty()) return plist;
            }
        }

        for (int b = 0; b < SUDOKU_MAX; b++) {
            int val = grid.get(b).get(j);
            if (val > 0 && val <= SUDOKU_MAX && plist.contains(val)) {
                plist.remove(plist.indexOf(val));
                if (plist.isEmpty()) return plist;
            }
        }

        int start_i = Math.floorDiv(i,SUB_VAL)*SUB_VAL;
        int end_i = (int)Math.ceil((i+1)/(double)SUB_VAL)*SUB_VAL;
        int start_j = Math.floorDiv(j,SUB_VAL)*SUB_VAL;
        int end_j = (int)Math.ceil((j+1)/(double)SUB_VAL)*SUB_VAL;
        for (int b = start_i; b < end_i; b++) {
            for (int a = start_j; a < end_j; a++) {
                int val = grid.get(b).get(a);
                if (val > 0 && val <= SUDOKU_MAX && plist.contains(val)) {
                    plist.remove(plist.indexOf(val));
                    if (plist.isEmpty()) return plist;
                }
            }
        }
        return plist;
    }

    private static boolean solve(List<List<Integer>> grid, int i, int j) {
        counter++;
        if (i >= grid.size()) {
            return true;
        }
        if (grid.get(i).get(j) > 0 && grid.get(i).get(j) <= SUDOKU_MAX) { // Value filled by user
            // goto next element
            j++; if(j >= SUDOKU_MAX){ j=0; i++; }
            return solve(grid, i, j);
        }

        List<Integer> plist = getPValues(grid, i, j);
        //System.out.println("plist  for ("+i+","+j+") = " + plist);
        for (int pval: plist) {
            int temp = grid.get(i).get(j);
            grid.get(i).set(j, pval);
            // goto next element
            int a = i; int b = j + 1; if(b >= SUDOKU_MAX){ b=0; a++; }
            if (solve(grid, a, b))
                return true;
            else
                grid.get(i).set(j, temp);
        }
        return false;
    }

    public static void solve(List<List<Integer>> grid) throws Exception {
        if (grid == null || grid.size() != SUDOKU_MAX || grid.get(0).size() != SUDOKU_MAX) {
            throw new Exception("Invalid input!");
        }

        if(!solve(grid, 0, 0))
            throw new Exception("Invalid sudoku problem!");
        System.out.println("counter = " + counter);
    }
}
