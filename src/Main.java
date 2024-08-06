import com.sun.corba.se.impl.orb.ParserTable;

class Main {
    public static void main(String[] args) {
        String DIFF = TextDiffUtility.highlightDifferences("chlouma", "matchalem");

        System.out.printf(DIFF);

    }
}