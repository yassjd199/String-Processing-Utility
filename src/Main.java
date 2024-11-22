import com.sun.corba.se.impl.orb.ParserTable;

class Main {
    public static void main(String[] args) {
        String DIFF = TextDiffUtility.highlightDifferences("Im yassine jedai" , "Im yacine jedai");

       System.out.println(DIFF);
        System.out.println("");
        String match = PatternMatchUtility.find("hello my name is yassine jedai , im yassine jedai , yass","yass");
        System.out.printf(match);

    }
}