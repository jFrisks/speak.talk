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
ID = [a-zA-Z][a-zA-Z0-9]*
NUMERAL = (0 | [1-9][0-9]*)
COMMENT = \/\/.*
POSITIVE = (the negative of the negative of)+
NEGATIVE = (the negative of)+
ARTICLE = (A|an)
DO = (do|runs|Run|run)
DOFOLLOWING = (((do|runs|Run) )the following)
IT = (it|It)
%%

// discard whitespace information
{WhiteSpace}  { }
{POSITIVE}    { }

// token definitions
{NEGATIVE}                     { return sym(Terminals.NEG);} //TODO: Test if problems with seperating new stmt and expression. Maybe adding newline re for stmt?
{IT}                           { return sym(Terminals.IT); }
"that is called"               { return sym(Terminals.CALLED); }
"the variable"                 { return sym(Terminals.VARIABLE); }
"the expression"               { return sym(Terminals.EXPRESSION); }
"integer"                      { return sym(Terminals.INT); }
"if"                           { return sym(Terminals.IF); }
{DOFOLLOWING}                  { return sym(Terminals.DOFOLLOWING); } //TODO: May need to seperate these
{DO}                           { return sym(Terminals.DO); } //TODO: May need to seperate these
"the following"                { return sym(Terminals.FOLLOWING); } //TODO: May need to seperate these
"else, do"                     { return sym(Terminals.ELSE); }
"loop while"                   { return sym(Terminals.WHILE); }
"each time"                    { return sym(Terminals.EACHTIME); }
"finally return"               { return sym(Terminals.RETURN); }
"and"                          { return sym(Terminals.AND); }
"returns"                      { return sym(Terminals.RETURNS); }
"("                            { return sym(Terminals.LPARAN);}
")"                            { return sym(Terminals.RPARAN);}
":"                            { return sym(Terminals.LBRACKET);} //TODO: Rename
"."                            { return sym(Terminals.ENDING);}
"multiplied with"              { return sym(Terminals.MULTIPLIER);}
"added to"                     { return sym(Terminals.PLUS);}
"subtracted by"                { return sym(Terminals.SUB);}
"divided by"                   { return sym(Terminals.DIVIDER);}
"modulo"                       { return sym(Terminals.MODULAR);}
"is less or equal to"          { return sym(Terminals.LEQ);}
"is greater or equal to"       { return sym(Terminals.GEQ);}
"is less than"                 { return sym(Terminals.LESS);}
"is greater than"              { return sym(Terminals.GREATER);}
"is not equal to"              { return sym(Terminals.NOTEQ);}
"is equal to"                  { return sym(Terminals.EQ);}
"has the value of"             { return sym(Terminals.ASSIGN); }
","                            { return sym(Terminals.COMMA); }
"-"                            { return sym(Terminals.DASH);}
"the function"                 { return sym(Terminals.OFFUNC); }
"function"                     { return sym(Terminals.FUNCTION); }
"uses the arguments of"        { return sym(Terminals.USESARGS); }
"by using the arguments of"    { return sym(Terminals.USINGSARGS); }
{COMMENT}                      { }
{NUMERAL}                      { return sym(Terminals.NUMERAL); }
{ARTICLE}                      { return sym(Terminals.ARTICLE); }
{ID}                           { return sym(Terminals.ID); }
<<EOF>>                        { return sym(Terminals.EOF); }

/* error fallback */
[^]                            { throw new SyntaxError("Illegal character <"+yytext()+">"); }
