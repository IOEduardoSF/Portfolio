public class Launcher {
    public static void main(String[] args) {

        new Interface_Pantera();

        /*try {
            // Step 1: Create an input stream for Pantera code from a text file
            CharStream input = CharStreams.fromFileName("src/fibonacci.pantera");

            // Step 2: Create a lexer for Pantera grammar and attach it to the input stream
            PanteraLexer lexer = new PanteraLexer(input);

            // Step 3: Create a parser for Pantera grammar and attach it to the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PanteraParser parser = new PanteraParser(tokens);

            // Step 4: Obtain the root parsing rule (e.g., program)
            ParseTree tree = parser.program();

            // Step 5: Create a custom visitor
            MyVisitor visitor = new MyVisitor();

            // Step 6: Invoke the visitor
            visitor.visit(tree);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
