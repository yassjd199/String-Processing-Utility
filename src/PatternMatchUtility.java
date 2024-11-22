import java.util.ArrayList;

public class PatternMatchUtility {
    private static int pi[] = new int[100000];
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";


    private static void buildKmp(String str){

        int k=0;
        for(int i=0;i<str.length();i++) pi[i]=0;
        for(int i=1;i<str.length();i++){
            while(k>0 && str.charAt(k)!=str.charAt(i)){
                k=pi[k-1];
            }
            if(str.charAt(k)==str.charAt(i)){
                pi[i]=++k;
            }
            else pi[i]=k;
        }
    }
    public static  String  find(String text , String pattern){
        int k=0;
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i=0;i<text.length();i++){

            while (k>0 && text.charAt(i)!=pattern.charAt(k)){
                k=pi[k-1];
            }
            if(text.charAt(i)==pattern.charAt(k)){
                k++;
            }
            if(k==pattern.length()){
                pos.add(i-pattern.length()+1);
                k=pi[k-1];
            }
        }
        String res="" ;
        int j=0;
        for(int i=0;i<text.length()&&j<pos.size();){
            if(i==pos.get(j)){
               for(int q =i ;q<i+pattern.length();q++){
                   res+=RED+text.charAt(q);
               }
               i+=pattern.length()-1;
               j++;
            }
            else{
                res+=RESET+text.charAt(i);
                i++;
            }
        }
        return  res ;

    }
}
