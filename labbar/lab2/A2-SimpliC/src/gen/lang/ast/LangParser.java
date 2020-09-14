package lang.ast;
import beaver.*;
import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.zip.DeflaterOutputStream;

// This is a parser generated by NeoBeaver.
public class LangParser extends beaver.Parser {
  
	static public class SyntaxError extends RuntimeException { public SyntaxError(String msg) {super(msg);}}
	// Disable syntax error recovery
	protected void recoverFromError(Symbol token, TokenStream in) {
		throw new SyntaxError("Cannot recover from the syntax error");
	}

  public static class Terminals {
    public static final short EOF = 0;
    public static final short INT = 1;
    public static final short ID = 2;
    public static final short SEMICOLON = 3;
    public static final short PLUS = 4;
    public static final short MULTIPLIER = 5;
    public static final short RBRACKET = 6;
    public static final short NUMERAL = 7;
    public static final short ASSIGN = 8;
    public static final short LPARAN = 9;
    public static final short LBRACKET = 10;
    public static final short RPARAN = 11;

    public static final String[] NAMES = {
        "EOF",
        "INT",
        "ID",
        "SEMICOLON",
        "PLUS",
        "MULTIPLIER",
        "RBRACKET",
        "NUMERAL",
        "ASSIGN",
        "LPARAN",
        "LBRACKET",
        "RPARAN",
    };
  }

  private final Action[] actions = {
    new Action() { // [0] functionCallStmtList =  functionCallStmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final FunctionCallStmt stmt = (FunctionCallStmt) _symbols[offset + 1].value;
        return new List().add(stmt);
      }
    },
    new Action() { // [1] program =  functionCallStmtList
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List a = (List) _symbols[offset + 1].value;
        return new Program(a);
      }
    },
    new Action() { // [2] GOAL =  program EOF
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Program program = (Program) _symbols[offset + 1].value;
        final Symbol sym2 = _symbols[offset + 2];
        return program;
      }
    },
    new Action() { // [3] functionCallStmtList =  functionCallStmtList functionCallStmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List list = (List) _symbols[offset + 1].value;
        final FunctionCallStmt b = (FunctionCallStmt) _symbols[offset + 2].value;
        return list.add(b);
      }
    },
    new Action() { // [4] functionCallStmt =  INT ID LPARAN RPARAN block
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol INT = _symbols[offset + 1];
        final Symbol ID = _symbols[offset + 2];
        final Symbol LPARAN = _symbols[offset + 3];
        final Symbol RPARAN = _symbols[offset + 4];
        final Block b = (Block) _symbols[offset + 5].value;
        return new FunctionCallStmt(b);
      }
    },
    new Action() { // [5] idUse =  ID
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol id = _symbols[offset + 1];
        return new IdUse(id);
      }
    },
    Action.RETURN, // [6] stmt =  assignment (default action: return symbol 1)
    new Action() { // [7] stmtList =  stmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Stmt a = (Stmt) _symbols[offset + 1].value;
        return new List().add(a);
      }
    },
    new Action() { // [8] block =  LBRACKET RBRACKET
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol LBRACKET = _symbols[offset + 1];
        final Symbol RBRACKET = _symbols[offset + 2];
        return new Block();
      }
    },
    new Action() { // [9] stmtList =  stmtList stmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List a = (List) _symbols[offset + 1].value;
        final Stmt b = (Stmt) _symbols[offset + 2].value;
        return a.add(b);
      }
    },
    new Action() { // [10] block =  LBRACKET stmtList RBRACKET
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol LBRACKET = _symbols[offset + 1];
        final List list = (List) _symbols[offset + 2].value;
        final Symbol RBRACKET = _symbols[offset + 3];
        return new Block(list);
      }
    },
    new Action() { // [11] idDecl =  INT ID SEMICOLON
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol INT = _symbols[offset + 1];
        final Symbol id = _symbols[offset + 2];
        final Symbol SEMICOLON = _symbols[offset + 3];
        return new IdDecl(id);
      }
    },
    Action.RETURN, // [12] factor =  idUse (default action: return symbol 1)
    Action.RETURN, // [13] term =  mul (default action: return symbol 1)
    Action.RETURN, // [14] expr =  add (default action: return symbol 1)
    new Action() { // [15] numeral =  NUMERAL
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol a = _symbols[offset + 1];
        return new Numeral(a);
      }
    },
    new Action() { // [16] assignment =  idUse ASSIGN expr SEMICOLON
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final IdUse a = (IdUse) _symbols[offset + 1].value;
        final Symbol ASSIGN = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        final Symbol SEMICOLON = _symbols[offset + 4];
        return new Assignment(a,b);
      }
    },
    new Action() { // [17] add =  expr PLUS term
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol PLUS = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Add(a, b);
      }
    },
    new Action() { // [18] mul =  term MULTIPLIER factor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol MULTIPLIER = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Mul(a, b);
      }
    },
  };

  static final ParsingTables PARSING_TABLES = new ParsingTables(
    "U9ojbRrk4q4GnsVlx3WVTc9o9YHs8E4peaD2F00T3HqKj4Wy01KLWeAAWWg97ecIYeeg3y0" +
    "3y09qa8HyVyBmMz#UupEpo2YUrMzt$B#vsVNUxPo8MvL4AZ8kTV4sBQbKzOUSaqp6f1aqRx" +
    "De5nYRKfEsBCdbRdz3bj4MVO1Y31svABdbKQA$cU5w4TLd4sAQ$ehe9tfYNfYqusKgeZTa9" +
    "dYjKlvZFJRZpqVopDco7lcMUoNzK0yBRnYzRvtpfVW3FIYyahwl##Q25knrzhABN2hbsTEz" +
    "mYlfkxfhfT4TtIcyahxjct73LRbYvjdopT0tTTEC$#cReKVcxUQvDloyqVtPq8t26of#NTV" +
    "DUTTy4yTzCpBVFJrrthKvJbcJivP8bclTVi5hZ1atrdapfaC$YzOA9y$HjwMZ6d9nFTTFeq" +
    "vD9jIq$1nRkizlw5EH#Cc8xYG9tjXG#PD8dl68dbBDgdz7HESTbHvRVnfPP#z$IUrC#MFnl" +
    "NqON8zKx7MEBdua#l$kJop#d$EogoilfVVjybyINslzQRq5j#4UF827y1YUmIju0s$X0to2" +
    "LVW2N#4Rh07rtzM0xunRWfjm1#x2VNW4J#0fF8VNy0xUmqVu7DQszOAk0Dlk$nsqxt0qg1U" +
    "GfZBmkn6BZTo$7CPcdxPYLCspMKRzSrH1HnLCy1DgOvLQvgY8ZYheU3u9OyAOKXDJQY3r3T" +
    "hGW8pdsa5lmU8VwfgZP0==");

  public LangParser() {
    super(PARSING_TABLES);
  }

  protected Symbol invokeReduceAction(int rule_num, int offset) {
    return actions[rule_num].reduce(_symbols, offset);
  }
}
