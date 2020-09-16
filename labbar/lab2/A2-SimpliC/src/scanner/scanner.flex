package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z0-9]+
NUMERAL = (0 | [1-9][0-9]*)
COMMENT = \/\/.*
%%

// discard whitespace information
{WhiteSpace}  { }

// token definitions
"int"         { return sym(Terminals.INT); }
"if"          { return sym(Terminals.IF); }
"else"        { return sym(Terminals.ELSE); }
"while"       { return sym(Terminals.WHILE); }
"return"      { return sym(Terminals.RETURN); }
"print"       { return sym(Terminals.PRINT); }
"read"        { return sym(Terminals.READ); }
"("           { return sym(Terminals.LPARAN);}
")"           { return sym(Terminals.RPARAN);}
"{"           { return sym(Terminals.LBRACKET);}
"}"           { return sym(Terminals.RBRACKET);}
";"           { return sym(Terminals.SEMICOLON);}
"*"           { return sym(Terminals.MULTIPLIER);}
"+"           { return sym(Terminals.PLUS);}
"-"           { return sym(Terminals.SUB);}
"/"           { return sym(Terminals.DIVIDER);}
"%"           { return sym(Terminals.MODULAR);}
"<="          { return sym(Terminals.LEQ);}
">="          { return sym(Terminals.GEQ);}
"<"           { return sym(Terminals.LESS);}
">"           { return sym(Terminals.GREATER);}
"!="          { return sym(Terminals.NOTEQ);}
"=="          { return sym(Terminals.EQ);}
"="           { return sym(Terminals.ASSIGN); }
","           { return sym(Terminals.COMMA); }
{COMMENT}     { return sym(Terminals.COMMENT); }
{NUMERAL}     { return sym(Terminals.NUMERAL); }
{ID}          { return sym(Terminals.ID); }
<<EOF>>       { return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
