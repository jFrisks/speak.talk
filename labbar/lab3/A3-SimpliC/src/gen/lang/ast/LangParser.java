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
    public static final short SUB = 1;
    public static final short RPARAN = 2;
    public static final short SEMICOLON = 3;
    public static final short COMMA = 4;
    public static final short ID = 5;
    public static final short PLUS = 6;
    public static final short GEQ = 7;
    public static final short GREATER = 8;
    public static final short EQ = 9;
    public static final short LESS = 10;
    public static final short INT = 11;
    public static final short NOTEQ = 12;
    public static final short LEQ = 13;
    public static final short LPARAN = 14;
    public static final short DIVIDER = 15;
    public static final short MODULAR = 16;
    public static final short MULTIPLIER = 17;
    public static final short NUMERAL = 18;
    public static final short WHILE = 19;
    public static final short RETURN = 20;
    public static final short IF = 21;
    public static final short RBRACKET = 22;
    public static final short LBRACKET = 23;
    public static final short ASSIGN = 24;
    public static final short ELSE = 25;
    public static final short COMMENT = 26;

    public static final String[] NAMES = {
        "EOF",
        "SUB",
        "RPARAN",
        "SEMICOLON",
        "COMMA",
        "ID",
        "PLUS",
        "GEQ",
        "GREATER",
        "EQ",
        "LESS",
        "INT",
        "NOTEQ",
        "LEQ",
        "LPARAN",
        "DIVIDER",
        "MODULAR",
        "MULTIPLIER",
        "NUMERAL",
        "WHILE",
        "RETURN",
        "IF",
        "RBRACKET",
        "LBRACKET",
        "ASSIGN",
        "ELSE",
        "COMMENT",
    };
  }

  private final Action[] actions = {
    new Action() { // [0] program = 
      public Symbol reduce(Symbol[] _symbols, int offset) {
        return new Program();
      }
    },
    new Action() { // [1] program =  programStmtList
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List a = (List) _symbols[offset + 1].value;
        return new Program(a);
      }
    },
    Action.RETURN, // [2] programStmt =  functionDecl (default action: return symbol 1)
    new Action() { // [3] programStmtList =  programStmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final ProgramStmt stmt = (ProgramStmt) _symbols[offset + 1].value;
        return new List().add(stmt);
      }
    },
    new Action() { // [4] programStmtList =  programStmtList programStmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List list = (List) _symbols[offset + 1].value;
        final ProgramStmt b = (ProgramStmt) _symbols[offset + 2].value;
        return list.add(b);
      }
    },
    new Action() { // [5] GOAL =  program EOF
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Program program = (Program) _symbols[offset + 1].value;
        final Symbol sym2 = _symbols[offset + 2];
        return program;
      }
    },
    new Action() { // [6] paramDeclareList =  idDecl
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final IdDecl a = (IdDecl) _symbols[offset + 1].value;
        return new List().add(a);
      }
    },
    new Action() { // [7] idDecl =  INT ID
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol INT = _symbols[offset + 1];
        final Symbol id = _symbols[offset + 2];
        return new IdDecl(id);
      }
    },
    new Action() { // [8] functionDecl =  INT ID LPARAN RPARAN block
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol INT = _symbols[offset + 1];
        final Symbol id = _symbols[offset + 2];
        final Symbol LPARAN = _symbols[offset + 3];
        final Symbol RPARAN = _symbols[offset + 4];
        final Block b = (Block) _symbols[offset + 5].value;
        return new FunctionDecl(id, new List(), b);
      }
    },
    new Action() { // [9] stmt =  ifElse
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final IfElse a = (IfElse) _symbols[offset + 1].value;
        return a;
      }
    },
    new Action() { // [10] stmt =  while
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final While a = (While) _symbols[offset + 1].value;
        return a;
      }
    },
    new Action() { // [11] functionCallStmt =  functionCall
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        return new FunctionCallStmt(a);
      }
    },
    new Action() { // [12] stmtList =  stmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Stmt a = (Stmt) _symbols[offset + 1].value;
        return new List().add(a);
      }
    },
    new Action() { // [13] block =  LBRACKET RBRACKET
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol LBRACKET = _symbols[offset + 1];
        final Symbol RBRACKET = _symbols[offset + 2];
        return new Block();
      }
    },
    new Action() { // [14] idUse =  ID
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol id = _symbols[offset + 1];
        return new IdUse(id);
      }
    },
    new Action() { // [15] paramDeclareList =  paramDeclareList COMMA idDecl
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List a = (List) _symbols[offset + 1].value;
        final Symbol COMMA = _symbols[offset + 2];
        final IdDecl b = (IdDecl) _symbols[offset + 3].value;
        return a.add(b);
      }
    },
    new Action() { // [16] functionDecl =  INT ID LPARAN paramDeclareList RPARAN block
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol INT = _symbols[offset + 1];
        final Symbol id = _symbols[offset + 2];
        final Symbol LPARAN = _symbols[offset + 3];
        final List a = (List) _symbols[offset + 4].value;
        final Symbol RPARAN = _symbols[offset + 5];
        final Block b = (Block) _symbols[offset + 6].value;
        return new FunctionDecl(id, a, b);
      }
    },
    new Action() { // [17] stmt =  returnStmt SEMICOLON
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final ReturnStmt a = (ReturnStmt) _symbols[offset + 1].value;
        final Symbol SEMICOLON = _symbols[offset + 2];
        return a;
      }
    },
    new Action() { // [18] stmt =  idDecl SEMICOLON
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final IdDecl a = (IdDecl) _symbols[offset + 1].value;
        final Symbol SEMICOLON = _symbols[offset + 2];
        return a;
      }
    },
    new Action() { // [19] stmtList =  stmtList stmt
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List a = (List) _symbols[offset + 1].value;
        final Stmt b = (Stmt) _symbols[offset + 2].value;
        return a.add(b);
      }
    },
    new Action() { // [20] block =  LBRACKET stmtList RBRACKET
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol LBRACKET = _symbols[offset + 1];
        final List list = (List) _symbols[offset + 2].value;
        final Symbol RBRACKET = _symbols[offset + 3];
        return new Block(list);
      }
    },
    new Action() { // [21] stmt =  functionCallStmt SEMICOLON
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final FunctionCallStmt a = (FunctionCallStmt) _symbols[offset + 1].value;
        final Symbol SEMICOLON = _symbols[offset + 2];
        return a;
      }
    },
    new Action() { // [22] stmt =  assignment SEMICOLON
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Assignment a = (Assignment) _symbols[offset + 1].value;
        final Symbol SEMICOLON = _symbols[offset + 2];
        return a;
      }
    },
    Action.RETURN, // [23] term =  factor (default action: return symbol 1)
    Action.RETURN, // [24] expr =  greaterEqual (default action: return symbol 1)
    Action.RETURN, // [25] comparator =  add (default action: return symbol 1)
    Action.RETURN, // [26] posFactor =  idUse (default action: return symbol 1)
    Action.RETURN, // [27] factor =  posFactor (default action: return symbol 1)
    new Action() { // [28] numeral =  NUMERAL
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol a = _symbols[offset + 1];
        return new Numeral(a);
      }
    },
    new Action() { // [29] returnStmt =  RETURN expr
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol RETURN = _symbols[offset + 1];
        final Expr a = (Expr) _symbols[offset + 2].value;
        return new ReturnStmt(a);
      }
    },
    new Action() { // [30] while =  WHILE paren block
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol WHILE = _symbols[offset + 1];
        final Expr a = (Expr) _symbols[offset + 2].value;
        final Block b = (Block) _symbols[offset + 3].value;
        return new While(a,b);
      }
    },
    new Action() { // [31] assignment =  idUse ASSIGN expr
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final IdUse a = (IdUse) _symbols[offset + 1].value;
        final Symbol ASSIGN = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Assignment(a,b);
      }
    },
    new Action() { // [32] ifElse =  IF paren block
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol IF = _symbols[offset + 1];
        final Expr a = (Expr) _symbols[offset + 2].value;
        final Block b = (Block) _symbols[offset + 3].value;
        return new IfElse(a,b, new Opt());
      }
    },
    new Action() { // [33] functionCall =  ID LPARAN RPARAN
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol a = _symbols[offset + 1];
        final Symbol LPARAN = _symbols[offset + 2];
        final Symbol RPARAN = _symbols[offset + 3];
        return new FunctionCall(a, new List());
      }
    },
    new Action() { // [34] paramList =  expr
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        return new List().add(a);
      }
    },
    new Action() { // [35] factor =  SUB posFactor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol SUB = _symbols[offset + 1];
        final Expr a = (Expr) _symbols[offset + 2].value;
        return new Neg(a);
      }
    },
    new Action() { // [36] paren =  LPARAN expr RPARAN
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol LPARAN = _symbols[offset + 1];
        final Expr a = (Expr) _symbols[offset + 2].value;
        final Symbol RPARAN = _symbols[offset + 3];
        return a;
      }
    },
    new Action() { // [37] assignment =  INT idUse ASSIGN expr
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol INT = _symbols[offset + 1];
        final IdUse a = (IdUse) _symbols[offset + 2].value;
        final Symbol ASSIGN = _symbols[offset + 3];
        final Expr b = (Expr) _symbols[offset + 4].value;
        return new Assignment(a,b);
      }
    },
    new Action() { // [38] functionCall =  ID LPARAN paramList RPARAN
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol a = _symbols[offset + 1];
        final Symbol LPARAN = _symbols[offset + 2];
        final List b = (List) _symbols[offset + 3].value;
        final Symbol RPARAN = _symbols[offset + 4];
        return new FunctionCall(a, b);
      }
    },
    new Action() { // [39] lessEqual =  comparator LEQ comparator
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol LEQ = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new LessEq(a, b);
      }
    },
    new Action() { // [40] greaterEqual =  comparator GEQ comparator
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol GEQ = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new GreaterEq(a, b);
      }
    },
    new Action() { // [41] greater =  comparator GREATER comparator
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol GREATER = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Greater(a, b);
      }
    },
    new Action() { // [42] add =  comparator PLUS term
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol PLUS = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Add(a, b);
      }
    },
    new Action() { // [43] less =  comparator LESS comparator
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol LESS = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Less(a, b);
      }
    },
    new Action() { // [44] equal =  comparator EQ comparator
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol EQ = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Eq(a, b);
      }
    },
    new Action() { // [45] notEqual =  comparator NOTEQ comparator
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol NOTEQ = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new NotEq(a, b);
      }
    },
    new Action() { // [46] sub =  comparator SUB term
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol SUB = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Sub(a, b);
      }
    },
    new Action() { // [47] div =  term DIVIDER factor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol DIVIDER = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Div(a, b);
      }
    },
    new Action() { // [48] mod =  term MODULAR factor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol MODULAR = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Mod(a, b);
      }
    },
    new Action() { // [49] mul =  term MULTIPLIER factor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol MULTIPLIER = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Mul(a, b);
      }
    },
    new Action() { // [50] ifElse =  IF paren block ELSE block
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol IF = _symbols[offset + 1];
        final Expr a = (Expr) _symbols[offset + 2].value;
        final Block b = (Block) _symbols[offset + 3].value;
        final Symbol ELSE = _symbols[offset + 4];
        final Block c = (Block) _symbols[offset + 5].value;
        return new IfElse(a,b,new Opt(c));
      }
    },
    new Action() { // [51] paramList =  paramList COMMA expr
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List a = (List) _symbols[offset + 1].value;
        final Symbol COMMA = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return a.add(b);
      }
    },
  };

  static final ParsingTables PARSING_TABLES = new ParsingTables(
    "U9pjcbbm55KKXlz9CcGPzXt9mXP2Ga92GaW82L6KHL5G4CK5GLn15XyjBKfBot9xyK4j7wp" +
    "I1vStb$B91xTd491L5b5H5i6DNKLj$#xRTxfxvcHw#cP8nEAU#kXpp#t$djEtUxgRp0299o" +
    "qBVT0VHHY4IiIjJOYZ01EGXtmCGndweGfJq83hS0FMEH7L2j62gp0Nj#4QzaRY2epcTZWgC" +
    "1OZaf5HZ4ns8spMFwwgbQecpC1zk1BJc2iOlTg9ha8xfZkoOd5yfZC#7ytem1pCmsoq#VPR" +
    "O$sTebfjgzAYQgvxT2xhBz$uG#wn1gEUwjvaXIMX5LwRLk5QwmA4ngWqr$t92lyCpRN0pUL" +
    "lVTCI9SHv7aWUazq6XEQwKSWrCEaj2jNVbTGF8OF5$HyCr1HShJySmhAi3rPf$Qw8sCRv$D" +
    "AKiQ4OZtAC4IeyBzOjHdqj4QMmP1iOlelG9Xgf9fc8h7Eoh$hA15crIIxK6Ad2ptAjeAepI" +
    "MMTbNtLLoR8werodJ5HcLqRrcdPLtrbWkfKkXVqLLzPScogKOKdbNcUzj6eU$wzNQVJtOv3" +
    "QjFhD4l8zPiYOeM$PX$rDQCA3UyRPglnY#ohlZ91zRFigxuoGVMJxAk#Ca5r8jqB#gglJ8z" +
    "PntrZnrFsFQuiFHUk5sAXBVjdL#0wDZhBre#oh$hA15ad5ZhRQDV6CMMUftqT4IiqKnsrJH" +
    "h9rAmZoZnF#nbLXvLvdlPrH5JzeCppjAyZlRqQM9RKtOp5M89Ri9J#hRWfayXm3StEr$VAF" +
    "4$xEYBAejqzTIwpbJUxDd9$zTwEEt1d3Yiy5BMwRkGoMmspQtvvP8MTwplPLtrbWkfRaro6" +
    "p#LlP5$rbJcT5O6HWyeyJ$iw8bPuDrcPnP44g$XQ4R6PlH5TLlMIoZgWpFEqhoD2falXkFO" +
    "hyppjwuX$twItJyWVtdhoVNwlCi$Jlew8kPPPNza6#yqX#xRCscDRPDLkswAfh5tAF4$xoF" +
    "2iPAwTjaMkS8TjaLNRROkcihvKvddQHwPtW6tAF4$xEYAgjYhpFEthYAZQeippjAyZekeBs" +
    "LTzPO9gim9DQ23rj5RC83FPJ$1w7urITA2Csp9djDwEM4v3t1ajGpags6l0L3HoEmtDc8uM" +
    "7K6x5t5Ky5GOWx7yj8t71EQIefNyv5LbK3dZc8Hgr60oQb67AO7zSf3BSbkeghzPXPRGShS" +
    "QWLdpekP9FSiHSer8UctPw#qAKH1UKyfHXAZaAfLAdh7hXhX$zLB6Xc0eXc6ueEhYB8Va2X" +
    "dlGZKYV1z1rTz8DT98PRQ6#KQvp5GzMQ5PhdXwB8jSPXMQNHlT$AHagySeu#EAET$o5ZZV0" +
    "1UY2CKeeTyN$NWl7y1to461lKTgLNfzRiHT9mmMSfdTRSpk6sOLcjqtp79r#vg$w2gpwz0i" +
    "bzbTDEjhtZ#$uLasEwwOUkE8U6rq#QdalscVocwgN4sqbYcNcIhdntL9hqO6LSuhpB0QaQx" +
    "QRkRwZvold5UOu#VoHLWDGrLKXQFgoRVAY$fSjfzr$bncvyleZSXCPROQbrMzfZAxH$LaXM" +
    "Qgx8$BznSKipj0JxxFT$kP4gN2tb5TFgvBG6NsX5L$FmGsFE7zONmuiNzpQ$#IOorvXhn4F" +
    "YRsjpOdWLWn6Knca#Na4V8YUPzyHhQIqq0Uvyvh98l86l8KUODyH7OIpfKV8vLa3k5S#O#I" +
    "bybxP3CvGau01QMaYImagybpv7No3jb33WBn1AaXd2k#ad2k#2la0yAvuaU1FipNfuoqaiL" +
    "aFNcQl4a#9Nl9MQ1m8AacSmddAdoCSAx2TyacSepmVyj5vOHp5IqX6yZpv2t2TIZQJyu1nO" +
    "D8BPb7Lf6Dv5No8M5TnJk04gvLIGLf8ql9m#G5yZRvd1mWvu44rprHH#QJ5MIZVUvuChSyh" +
    "axgDdihmRRTtUvAYPzoj$l8Rd9Qq5xm#UVSxTdK$LXAYyz$bXlxjqgVT5MJEyzXT$ypcVQJ" +
    "e2OMNHCRAinJ1VKB3rxBpgz$UPvnYFlQl$bTxEwpWAmZh$bgv$KPcnUr1b$U3T9tMl#hPly" +
    "Y7oI69ZBB8GypI0Vz1cvR4KSpVPkff9tKCpwQsmxU3LjvBsnctwQTr3Ec##EupsHIISh965" +
    "91MZZMoFscascabBGvutaeS#85Z1MWbdurgI5LP1Af8rF8H3AMJ23ZdNdYd2CVdVy2JRkXk" +
    "0==");

  public LangParser() {
    super(PARSING_TABLES);
  }

  protected Symbol invokeReduceAction(int rule_num, int offset) {
    return actions[rule_num].reduce(_symbols, offset);
  }
}
