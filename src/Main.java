/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anil tallam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int input[][]={ {0,0,0,0,0,0,9,0,0},
                        {0,0,2,0,9,5,0,0,0},
                        {7,0,6,8,0,0,0,5,0},
                        {9,0,0,0,2,0,0,0,3},
                        {6,3,0,0,0,0,0,8,9},
                        {1,0,0,0,4,0,0,0,6},
                        {0,4,0,0,0,9,8,0,7},
                        {0,0,0,2,5,0,6,0,0},
                        {0,0,1,0,0,0,0,0,0}
        };
        int inpus[][]={ {0,0,0,9,2,1,5,0,0},
                        {0,2,0,0,0,4,0,0,9},
                        {0,1,0,8,0,0,0,0,0},
                        {8,0,0,4,0,0,0,3,0},
                        {0,5,0,7,9,8,0,1,0},
                        {0,4,0,0,0,2,0,0,5},
                        {0,0,0,0,0,5,0,9,0},
                        {2,0,0,1,0,0,0,5,0},
                        {0,0,5,2,8,7,0,0,0}
        };
        int inpuf[][]={ {0,0,0,0,0,0,2,0,0},
                        {6,0,7,0,3,2,9,0,0},
                        {0,0,0,1,6,0,0,0,8},
                        {8,0,0,0,0,0,0,9,0},
                        {0,4,5,6,0,9,3,7,0},
                        {0,7,0,0,0,0,0,0,5},
                        {7,0,0,0,5,3,0,0,0},
                        {0,0,2,8,7,0,5,0,4},
                        {0,0,8,0,0,0,0,0,0}
        };
        int inpuh[][]={ {6,0,0,8,0,0,5,4,0},
                        {3,0,0,0,4,0,0,7,0},
                        {5,4,0,0,9,0,0,0,0},
                        {0,0,0,0,0,7,9,0,3},
                        {0,0,0,0,0,0,0,0,0},
                        {2,0,3,4,0,0,0,0,0},
                        {0,0,0,0,1,0,0,9,7},
                        {0,8,0,0,7,0,0,0,2},
                        {0,2,6,0,0,9,0,0,5}
        };
        TestBacktrackingSolver.run();
//        Sudoku s=new Sudoku(inpuh);
//        s.solve();
//        s.print();
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
