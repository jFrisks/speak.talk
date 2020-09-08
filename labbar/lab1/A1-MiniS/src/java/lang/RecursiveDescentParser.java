package lang;

import lang.ast.LangParser;
import lang.ast.LangScanner;

import static lang.ast.LangParser.Terminals.*;

public class RecursiveDescentParser {
    private LangScanner scanner;
    private beaver.Symbol currentToken;

    /** Initialize the parser and start parsing via the parseProgram() method. */
    public void parse(LangScanner scanner) {
        this.scanner = scanner;
        accept();
        parseProgram();
        accept(EOF); // Ensure all input is processed.
    }

    /** Run the program */
    protected void parseProgram() {
        stmt();
    }

    protected void stmt() {
        switch(currentToken.getId()) {
            case FOR:
                forStmt(); break;
            case IF: ifStmt(); break;
            case ID: assignment(); break;
            default: error("Expecting statement, found: " + currentToken);
        }
    }

    protected void forStmt() {
        accept(FOR);
        accept(ID);
        accept(ASSIGN);
        this.expr();
        accept(UNTIL);
        expr();
        accept(DO);
        stmt();
        accept(OD);
    }

    protected void ifStmt() {
        accept(IF);
        expr();
        accept(THEN);
        stmt();
        accept(FI);
    }

    protected void assignment() {
        accept(ID);
        accept(ASSIGN);
        expr();
    }

    protected void expr() {
        switch (currentToken.getId()) {
            case ID: accept(ID); break;
            case NUMERAL: accept(NUMERAL); break;
            case NOT:
                accept(NOT);
                expr();
                break;
            default: error("Expecting expr, found: " + currentToken);
        }
    }

    /** Returns the current token without proceeding to the next. */
    protected int peek() {
        if (currentToken == null) accept();
        return currentToken.getId();
    }

    /** Read the next token from the scanner. */
    protected void accept() {
        try {
            currentToken = scanner.nextToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Ensure the current token is of a certain type; then read the next. */
    protected void accept(int expectedToken) {
        if (peek() != expectedToken) {
            error("expected token " +
                    LangParser.Terminals.NAMES[expectedToken] +
                    " got token " + LangParser.Terminals.NAMES[currentToken.getId()]);
        }
        accept();
    }

    protected static void error(String message) {
        throw new RuntimeException(message);
    }
}
