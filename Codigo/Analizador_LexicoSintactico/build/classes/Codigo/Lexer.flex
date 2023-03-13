package Codigo;
import static Codigo.Tokens.*;

%%
%class Lexer
%type Tokens
%line
%state COMMENT

L = [a-zA-Z_]+
D = [0-9]+
D2 = [1-9]+
DBIN = [01]+
DOCT = [0-7]+
DHEX = ({L}|{D})+
DECINT = (({D2}+)|{D})+ 
BININT = ("0b" | "0B")( (["_"]{DBIN})+ | {DBIN}+ )
OCTINT = ("0o" | "0O")( (["_"]{DOCT})+ | {DOCT}+ )
HEXINT = ("0x" | "0X")( (["_"]{DHEX})+ | {DHEX}+ )

A = [\x20-\x21\x23-\x7F]+
E = [\r\n]+
S = [\x20]+

FN = ( {PF} | {EF} )
PF =( {DP}{FR} | {DP}(\.))
EF = ( {DP} | {PF} ){EX}
DP = {D}(["_"]{D})*
FR = (\.){DP}
EX = ( "e" | "E" )( "+" | "-" | "" ){DP}

%{
    public String lexeme;
    public int linea;
%}

%%

(\ \ \ \ )+ {linea = yyline+1; lexeme = yytext(); return TABULACION;}
{E}* {linea = yyline+1; lexeme = yytext(); return SALTO_LINEA;}

/*(\#)(( {S} | {A} | \" )*)(.) {/*NO SE HACE NADA*/}*/
((\#)(.*)) {/*NO SE HACE NADA*/}
{S}* {/*NO SE HACE NADA*/}


( "+" | "-" | "*" | "/" | "//" | "**" | "%" | "@" | "~" ) {linea = yyline+1; lexeme = yytext(); return OPER_ARITMETICO;}

( "&" | "^" | "|" | and | or ) {linea = yyline+1; lexeme = yytext(); return OPER_LOGICO;}

( ">" | "<" | ">>" | "<<" | ">=" | "<=" | "==" | "!=" ) {linea = yyline+1; lexeme = yytext(); return OPER_RELACIONAL;}

( "True" | "False" ) {linea = yyline+1; lexeme = yytext(); return OPER_BOOL;}

( "=" | "+=" | "-=" | "*=" | "/=" | "%=" | "//=" | "**=" | "@=" | "&=" | "|=" | "^=" | ">>=" | "<<=" ) {linea = yyline+1; lexeme = yytext(); return OPER_ASIGNACION;}

( "(" | ")" | "{" | "}" | "[" | "]" | ";" | ":" | "," | "." | "\"" | "\'" | "\\" | ":=" ) {linea = yyline+1; lexeme = yytext(); return OPERADOR;}


( await | else | import | pass | None | break | except
  | in | raise | class | finally | is | return
  | continue | for | lambda | try | as | def | from | nonlocal
  | while | assert | del | global | not | with | async | elif
  | if | yield | print ) {linea = yyline+1; lexeme = yytext(); return RESERVADA;}

( "int" | "float" | "chr" | "str" | "bool" ) {linea = yyline+1; lexeme = yytext(); return VARIABLE;}

{L}({L}|{D})* {linea = yyline+1; lexeme=yytext(); return IDENTIFICADOR;}
( {DECINT} | {BININT} | {OCTINT} | {HEXINT} ) {linea = yyline+1; lexeme=yytext(); return NUM_ENTERO;}
({FN} | {PF} | {EF} | {DP} | {FR} | {EX}) {linea = yyline+1; lexeme=yytext(); return NUM_FLOAT;}
({FN} | {PF} | {EF} | {DP} | {FR} | {EX})("j" | "J") {linea = yyline+1; lexeme=yytext(); return NUM_IMAG;}


(\")({A})*(\") {linea = yyline+1; lexeme=yytext(); return STRING;}
(\"\"\")({A}|{E})*(\"\"\") {linea = yyline+1; lexeme=yytext().replace("\n","\\n\\r"); return STRING;}
(\')({A})*(\') {linea = yyline+1; lexeme=yytext(); return STRING;}
(\'\'\')({A}|{E})*(\'\'\') {linea = yyline+1; lexeme=yytext().replace("\n","\\n\\r"); return STRING;}

. {linea = yyline+1; lexeme = yytext(); return ERROR;}