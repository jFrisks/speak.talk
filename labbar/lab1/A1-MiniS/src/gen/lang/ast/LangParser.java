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
    public static final short OD = 1;
    public static final short FI = 2;
    public static final short ID = 3;
    public static final short THEN = 4;
    public static final short UNTIL = 5;
    public static final short DO = 6;
    public static final short NOT = 7;
    public static final short NUMERAL = 8;
    public static final short FOR = 9;
    public static final short ASSIGN = 10;
    public static final short IF = 11;

    public static final String[] NAMES = {
        "EOF",
        "OD",
        "FI",
        "ID",
        "THEN",
        "UNTIL",
        "DO",
        "NOT",
        "NUMERAL",
        "FOR",
        "ASSIGN",
        "IF",
    };
  }

  private final Action[] actions = {
    Action.RETURN, // [0] id =  ID (default action: return symbol 1)
    Action.RETURN, // [1] stmt =  assignment (default action: return symbol 1)
    Action.RETURN, // [2] program =  stmt (default action: return symbol 1)
    new Action() { // [3] GOAL =  program EOF
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol program = _symbols[offset + 1];
        final Symbol sym2 = _symbols[offset + 2];
        return program;
      }
    },
    Action.RETURN, // [4] expr =  id (default action: return symbol 1)
    Action.RETURN, // [5] numeral =  NUMERAL (default action: return symbol 1)
    RETURN3, // [6] assignment =  id ASSIGN expr (default action: return symbol 3)
    RETURN2, // [7] expr =  NOT expr (default action: return symbol 2)
    RETURN5, // [8] ifStmt =  IF expr THEN stmt FI (default action: return symbol 5)
    RETURN9, // [9] forStmt =  FOR id ASSIGN expr UNTIL expr DO stmt OD (default action: return symbol 9)
  };

      static final Action RETURN2 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 2];
        }
      };
      static final Action RETURN3 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 3];
        }
      };
      static final Action RETURN5 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 5];
        }
      };
      static final Action RETURN9 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 9];
        }
      };
  static final ParsingTables PARSING_TABLES = new ParsingTables(
    "U9oTbJjImp0GXbTn7iHntYGyGuQUWg6ceQEZeOJX0Xo0Bj1m2Wv0oH5ekG4j1w1CUCTyKkp" +
    "4s9QJ8CqdhTV$hDRHIX5H5rAGgjIa8NKHoKCP7AX8KKgo8gxa$26Ajb68UDXTx9gicN6BKU" +
    "iBwDUDtZ6welJqas#QI3ZhPfx7kakY#Jz9d$5RzAmxQIrfBgBtlzFZs#B8gYMVBzrdypo$T" +
    "2nnFdMVpVFoyJzqNoB$GiGEzrV7UTTzDa$RHdgUicdns$9yqpr5lpqdJYnFsKcN#oFTgJMF" +
    "JWLJKsMeW6Vgh4vDDycgpGu62lpknFuxudUcUi$emYSHHVtxP4Hz1pNiclZ67szXdIVz5hq" +
    "Jp9oqXVIs#BOuRdO#qU$AzEUNZBFiTzdqJiGEzZTptO8bpvGr$vLdCUdBp5DPz2O#O$zQp9" +
    "xgMy#36kp2FXp2CPp2ELp25Tp0BTp1FJp08pp1Cxp0At3JAUvYHHMh7kp10Hp12Pm5Quy73" +
    "8D9OiFGZlX6eOsy57yV#Al1t81kx5qxOlSYTjzo4opUz6bMhAauvOfpdkCyAtv3PVwJgZot" +
    "g8ycTqdd5qdcfuO=");

  public LangParser() {
    super(PARSING_TABLES);
  }

  protected Symbol invokeReduceAction(int rule_num, int offset) {
    return actions[rule_num].reduce(_symbols, offset);
  }
}
