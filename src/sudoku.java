/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Sudoku {
    Box[][] cell=new Box[9][9];
    int fill_count=0;
    Sudoku(int a[][])
    {
        int i,j;
        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
                cell[i][j]=new Box(a[i][j]);
                if(a[i][j]!=0){
                    fill_count++;
                }
            }
        }
        //System.out.println("\n"+fill_count);
    }
    public void solve(){
        int i=0,j=0;
        while(fill_count<= 81){
            if(i<fill_count) i=fill_count;
            if(i>fill_count) break;
            check();
            insertbox();
            check();
            insertcol();
            check();
            insertrow();
            check();
            substitute();
            i++;
            j++;
        }
        //System.out.println(""+j);
    }
    void check(){
        int i,j,val;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if((val=cell[i][j].value) != 0){
                    rm_pval_col(i,j,val);
                    rm_pval_row(i,j,val);
                    rm_pval_box(i,j,val);
                }

            }
        }
    }
    void rm_pval_col(int col,int row,int val){
        int i;
        for(i=0;i<9;i++)
        {
            if(cell[col][i].value == 0){
                cell[col][i].remove(val);
            }
        }
    }
    void rm_pval_row(int col,int row,int val){
        int i;
        for(i=0;i<9;i++)
        {
            if(cell[i][row].value == 0){
                cell[i][row].remove(val);
            }
        }
    }
    void rm_pval_box(int col,int row,int val){
        int i,j;
        int max_col=0,min_col=0,max_row=0,min_row=0;
        if(col<9){ min_col=6; max_col=8;}
        if(col<6){ min_col=3; max_col=5;}
        if(col<3){ min_col=0; max_col=2;}
        if(row<9){ min_row=6; max_row=8;}
        if(row<6){ min_row=3; max_row=5;}
        if(row<3){ min_row=0; max_row=2;}

        for(i=min_col;i<=max_col;i++)
        {
            for(j=min_row;j<=max_row;j++){
                if(cell[i][j].value == 0){
                    cell[i][j].remove(val);
                }
            }
        }
    }
    void substitute(){
        int i,j,pval,k;
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if(cell[i][j].p_count == 1 && cell[i][j].value == 0)
                {
                    cell[i][j].addpvalue();
                    fill_count++;
                }

            }
        }
    }
    void insertbox(){
        int i,j,k,val;
        for(val=1;val<=9;val++){
            for(i=0;i<9;i=i+3){
                for(j=0;j<9;j=j+3){
                    fillbox(i,j,val);
                }
            }
        }
    }
    void fillbox(int min_col,int min_row,int val){
        int i,j,c=0;
        for(i=min_col;i<min_col+3;i++){
            for(j=min_row;j<min_row+3;j++){
                if(cell[i][j].p_value[val-1]==val && cell[i][j].value== 0) c++;
            }
        }
        if(c==1){
            for(i=min_col;i<min_col+3;i++){
                for(j=min_row;j<min_row+3;j++){
                    if(cell[i][j].p_value[val-1]==val && cell[i][j].value== 0){
                        cell[i][j].addvalue(val);
                        fill_count++;
                    }
                }
            }
        }
    }
    void insertcol(){
        int i,val;
        for(val=1;val<=9;val++){
            for(i=0;i<9;i++){
                fillcol(i,val);
            }
        }
    }
    void fillcol(int col,int val){
        int i,c=0;
        for(i=0;i<9;i++){
            if(cell[col][i].p_value[val-1]==val && cell[col][i].value== 0) c++;
        }
        if(c==1){
            for(i=0;i<9;i++){
                if(cell[col][i].p_value[val-1]==val && cell[col][i].value== 0){
                    cell[col][i].addvalue(val);
                    fill_count++;
                }
            }
        }
    }
    void insertrow(){
        int i,val;
        for(val=1;val<=9;val++){
            for(i=0;i<9;i++){
                fillrow(i,val);
            }
        }
    }
    void fillrow(int row,int val){
        int i,c=0;
        for(i=0;i<9;i++){
            if(cell[i][row].p_value[val-1]==val && cell[i][row].value== 0) c++;
        }
        if(c==1){
            for(i=0;i<9;i++){
                if(cell[i][row].p_value[val-1]==val && cell[i][row].value== 0){
                    cell[i][row].addvalue(val);
                    fill_count++;
                }
            }
        }
    }
    void addtocell(int col,int row,int val){

    }
    public void print(){
        int i,j;
        System.out.println("\n____________________________________");
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                System.out.print(" "+cell[i][j].value+" |");

            }
            System.out.println("\n------------------------------------");
        }
        System.out.println("\n"+fill_count);

    }
    void pair(){
        checkbox();
        //pairincol();
        //pairinrow();
    }
    void checkbox(){
        int i,j,val;
        for(val=1;val<=9;val++)
        {
            for(i=0;i<9;i=i+3){
                for(j=0;j<9;j=j+3){
                    funbox(i,j,val);
                }
            }
        }
    }
    void funbox(int col,int row,int val){
        boolean vrow[]={false,false,false};
        boolean vcol[]={false,false,false};
        int crow=0,ccol=0,i,j;
        for(i=col;i<col+3;i++)
        {
            for(j=row;j<col+3;i++){
                if(cell[i][j].p_value[val-1]==val){
                    if(vrow[i]== false){
                        crow++;
                        vrow[i-col]=true;
                    }
                    if(vcol[j]== false){
                        ccol++;
                        vcol[j-row]=true;
                    }
                }

            }
        }
        if(crow==1){
            for(i=0;i<3;i++){
                if(vrow[i]==true){
                    i=i+col;
                    break;
                }
            }
            rm_pval_col(i,crow, val);  //late correction
        }
        if(ccol==1){
            for(i=0;i<3;i++){
                if(vcol[i]==true){
                    i=i+row;
                    break;
                }
            }
            rm_pval_row(ccol, i,val); //latest correction
        }

    }
}
