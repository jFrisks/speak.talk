package lang;

import beaver.Parser;
import lang.ast.ActivationRecord;
import lang.ast.LangParser;
import lang.ast.LangScanner;
import lang.ast.Program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Parses an AST and interprets the program, if compiled without errors
 */
public class Interpreter {
    /**
     * Entry point
     * @param args
     */

    public static Object DrAST_root_node; //Enable debugging with DrAST

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.err.println(
                        "You must specify a source file on the command line!");
                printUsage();
                System.exit(1);
                return;
            }

            String filename = args[0];
            LangScanner scanner = new LangScanner(new FileReader(filename));
            LangParser parser = new LangParser();

            //Create AST
            Program program = (Program) parser.parse(scanner);

            //check for errors
            if(!program.errors().isEmpty()){
                System.exit(1);
            }
            //evalute the program
            try {
                program.eval();
            }catch(Exception e){
                System.err.println("Error occured in interpretor: "+ e.getMessage());
                System.exit(1);
            }

            DrAST_root_node = program; //Enable debugging with DrAST
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        } catch (Parser.Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void printUsage() {
        System.err.println("Usage: DumpTree FILE");
        System.err.println("  where FILE is the file to be parsed");
    }
}

