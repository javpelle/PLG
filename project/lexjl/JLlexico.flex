/* JL language lexer specification */
package lexjl;

import java_cup.runtime.*;
import java.io.Reader;

%%

%class AnalizadorLexico
%unicode
%cup
%line
%column

%{
	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline, yycolumn, value);
	}
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
InputCharacter = [^\r\n]
Comment = "//" {InputCharacter}* {LineTerminator}?

/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

%%

<YYINITIAL> {

  /* keywords */
  "bool"                     	 { return symbol(sym.BOOL); }
  "const"                        { return symbol(sym.CONST); }
  "else"                         { return symbol(sym.ELSE); }
  "int"                          { return symbol(sym.INT); }
  "if"                           { return symbol(sym.IF); }
  "return"                       { return symbol(sym.RETURN); }
  "void"                         { return symbol(sym.VOID); }
  "while"                        { return symbol(sym.WHILE); }
  "function"                     { return symbol(sym.FUNCTION); }
  "start"                        { return symbol(sym.START); }
  "decVar:"                       { return symbol(sym.DECVAR); }
 
  /* boolean literals */
  "true"                         { return symbol(sym.BOOLEAN_LITERAL, true); }
  "false"                        { return symbol(sym.BOOLEAN_LITERAL, false); }
  
  /* separators */
  "("                            { return symbol(sym.LPAREN); }
  ")"                            { return symbol(sym.RPAREN); }
  "{"                            { return symbol(sym.LBRACE); }
  "}"                            { return symbol(sym.RBRACE); }
  "["                            { return symbol(sym.LBRACK); }
  "]"                            { return symbol(sym.RBRACK); }
  ";"                            { return symbol(sym.SEMICOLON); }
  ","                            { return symbol(sym.COMMA); }
  "."                            { return symbol(sym.DOT); }
  
  /* operators */
  "="                            { return symbol(sym.EQ); }
  "<"                            { return symbol(sym.LT); }
  "!"                            { return symbol(sym.NOT); }
  "=="                           { return symbol(sym.EQEQ); }
  "<="                           { return symbol(sym.LTEQ); }
  "!="                           { return symbol(sym.NOTEQ); }
  "&&"                           { return symbol(sym.ANDAND); }
  "||"                           { return symbol(sym.OROR); }
  "+"                            { return symbol(sym.PLUS); }
  "-"                            { return symbol(sym.MINUS); }
  "*"                            { return symbol(sym.MULT); }
  "/"                            { return symbol(sym.DIV); }
  

  /* numeric literals */
  
  {DecIntegerLiteral}            { return symbol(sym.INTEGER_LITERAL, new Integer(yytext())); }
    
  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifiers */ 
  {Identifier}                   { return symbol(sym.IDENTIFIER, yytext()); }  
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return symbol(EOF); }