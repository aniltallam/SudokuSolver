import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by well on 5/21/2016.
 */
public class TestBacktrackingSolver {
    public static void run(){
        int input1[][]={
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},

                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},

                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0},
                {0,0,0, 0,0,0, 0,0,0}
        };

        int input2[][]={
                {6,0,0,8,0,0,5,4,0},
                {3,0,0,0,4,0,0,7,0},
                {5,4,0,0,9,0,0,0,0},
                {0,0,0,0,0,7,9,0,3},
                {0,0,0,0,0,0,0,0,0},
                {2,0,3,4,0,0,0,0,0},
                {0,0,0,0,1,0,0,9,7},
                {0,8,0,0,7,0,0,0,2},
                {0,2,6,0,0,9,0,0,5}
        };

        int input3[][]={
                {8,0,0, 0,0,0, 0,0,0},
                {0,0,3, 6,0,0, 0,0,0},
                {0,7,0, 0,9,0, 2,0,0},

                {0,5,0, 0,0,7, 0,0,0},
                {0,0,0, 0,4,5, 7,0,0},
                {0,0,0, 1,0,0, 0,3,0},

                {0,0,1, 0,0,0, 0,6,8},
                {0,0,8, 5,0,0, 0,1,0},
                {0,9,0, 0,0,0, 4,0,0}
        };

        List<List<Integer>> grid = convert(input3);
        try {
            long t = System.nanoTime();
            BacktrackingSolver.solve(grid);
            t = (System.nanoTime() - t)/1000000;
            print(grid);
            System.out.format("Time = %d milliseconds", t);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void print(List<List<Integer>> grid) {
        System.out.println("\n------------------------------------");
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                System.out.print(" "+grid.get(i).get(j)+" |");
            }
            System.out.println("\n------------------------------------");
        }
    }

    static List<List<Integer>> convert(int[][] a) {
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                row.add(a[i][j]);
            }
            grid.add(row);
        }
        return grid;
    }
}
