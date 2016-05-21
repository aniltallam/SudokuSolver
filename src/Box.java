/**
 *
 * @author anil tallam
 */
class Box
{
    int value;
    int[] p_value=new int[9];
    int p_count;
    Box(int value){
        int i;
        if(value==0){
            this.value=value;
            for(i=0;i<9;i++){
                p_value[i]=i+1;
            }
            p_count=9;
        }
        else{
            this.value=value;
            for(i=0;i<9;i++){
                p_value[i]=0;
            }
            p_count=0;
        }
    }
    void remove(int val){
        if(p_value[val-1]!=0)
        {
        p_value[val-1]=0;
        p_count--;
        }
    }
    void addpvalue(){
        int k,pval;
        for(k=0;k<9;k++)
        {
                if((pval=p_value[k]) != 0)
                value=pval;
        }
    }
    void addvalue(int val){
        value=val;
        int k;
        for(k=0;k<9;k++)
        {
                if(k == (val-1))
                p_value[k]=val;
                else
                    p_value[k]=0;
        }
    }
    int count(){
        int i,j=0;
        for(i=0;i<9;i++){
            if(p_value[i]!=0) j++;
        }
        return j;
    }
}
