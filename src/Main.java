/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

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
        sudoku1 s=new sudoku1();
        s.insert(inpuh);
        s.solve();
        s.print();
        //s.rm_pval_row(0, 6);
        ///*
        int y=1,x=1;
        System.out.println(s.cell[y][x].pvalue[0]);
        System.out.println(s.cell[y][x].pvalue[1]);
        System.out.println(s.cell[y][x].pvalue[2]);
        System.out.println(s.cell[y][x].pvalue[3]);
        System.out.println(s.cell[y][x].pvalue[4]);
        System.out.println(s.cell[y][x].pvalue[5]);
        System.out.println(s.cell[y][x].pvalue[6]);
        System.out.println(s.cell[y][x].pvalue[7]);
        System.out.println(s.cell[y][x].pvalue[8]);
        System.out.println(s.cell[y][x].pcount);
        //*/
    }

}
