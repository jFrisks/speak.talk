
package lang;
import lang.ast.LangParser;
import lang.ast.LangScanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static lang.ast.LangParser.Terminals.*;

/**
 * Abstract base class for recursive decent parsers.
 * You should implement the parseProgram() method to parse a MiniS program. */
public class RecursiveDescentCompiler {
    private static LangScanner scanner;
    private static RecursiveDescentParser parser;
    private beaver.Symbol currentToken;

    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("You must specify a source file on the command line!");
            System.exit(1);
        }
        try {
            scanner = new LangScanner(new FileReader(args[0]));
            parser = new RecursiveDescentParser();
            parser.parse(scanner);
            System.out.println("Valid syntax! You da man <3 or woman, or non-binary files (sorry machine...)");
//        } catch (RuntimeException e) {
//            System.err.println("Syntax error: " + e.getMessage());
//            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


}