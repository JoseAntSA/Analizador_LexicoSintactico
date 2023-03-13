package Codigo;
import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

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
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}

%%

/*Tabulaciones y saltos de linea*/
(\ \ \ \ )* {return new Symbol(sym.Tabulacion, yychar, yyline, yytext());}
{E}* {/*NO SE HACE NADA*/}


/*Comentarios y espacios*/
((\#)(.)*) {/*NO SE HACE NADA*/}
{S}* {/*NO SE HACE NADA*/}


/*Operadores Aritmeticos*/
( "+" | "-" | "*" | "/" | "//" | "**" | "%" | "@" | "~" ) {return new Symbol(sym.Oper_Arit, yychar, yyline, yytext());}


/*Operadores Logicos*/
( "&" | "^" | "|" | "or" | "and") {return new Symbol(sym.Oper_Log, yychar, yyline, yytext());}


/*Operadores Relacionales*/
( ">" | "<" | ">>" | "<<" | ">=" | "<=" | "==" | "!=" ) {return new Symbol(sym.Oper_Rel, yychar, yyline, yytext());}


/*Operadores Booleanos*/
( "True" | "False" ) {return new Symbol(sym.Oper_Bol, yychar, yyline, yytext());}


/*Operadores de Asignacion*/
( "=" ) {return new Symbol(sym.Oper_Asig, yychar, yyline, yytext());}

/*Operadores de Asignacion Aritmetico*/
( "+=" | "-=" | "*=" | "/=" | "%=" | "//=" | "**=" | "@=" | "&=" | "|=" | "^=" | ">>=" | "<<=" ) {return new Symbol(sym.Oper_AsigArit, yychar, yyline, yytext());}


/*Parentesis Izquierdo*/
"(" {return new Symbol(sym.Par_Izq, yychar, yyline, yytext());}

/*Parentesis Derecho*/
( ")" ) {return new Symbol(sym.Par_Der, yychar, yyline, yytext());}

/*Corchete Izquierdo*/
( "[" ) {return new Symbol(sym.Cor_Izq, yychar, yyline, yytext());}

/*Corchete Derecho*/
( "]" ) {return new Symbol(sym.Cor_Der, yychar, yyline, yytext());}

/*Punto y Coma*/
( ";" ) {return new Symbol(sym.Punt_Coma, yychar, yyline, yytext());}

/*Dos Puntos*/
( ":" ) {return new Symbol(sym.Dos_Punt, yychar, yyline, yytext());}

/*Coma*/
( "," ) {return new Symbol(sym.Coma, yychar, yyline, yytext());}

/*Punto*/
( "." ) {return new Symbol(sym.Punto, yychar, yyline, yytext());}

/*Comillas*/
( "\"" | "\'" ) {return new Symbol(sym.Comilla, yychar, yyline, yytext());}

/*Palabra Reservada await*/
( await ) {return new Symbol(sym.Pal_await, yychar, yyline, yytext());}

/*Palabra Reservada else*/
( else ) {return new Symbol(sym.Pal_else, yychar, yyline, yytext());}

/*Palabra Reservada import*/
( import ) {return new Symbol(sym.Pal_import, yychar, yyline, yytext());}

/*Palabra Reservada pass*/
( pass ) {return new Symbol(sym.Pal_pass, yychar, yyline, yytext());}

/*Palabra Reservada None*/
( None ) {return new Symbol(sym.Pal_None, yychar, yyline, yytext());}

/*Palabra Reservada break*/
( break ) {return new Symbol(sym.Pal_break, yychar, yyline, yytext());}

/*Palabra Reservada except*/
( except ) {return new Symbol(sym.Pal_except, yychar, yyline, yytext());}

/*Palabra Reservada in*/
( in ) {return new Symbol(sym.Pal_in, yychar, yyline, yytext());}

/*Palabra Reservada raise*/
( raise ) {return new Symbol(sym.Pal_raise, yychar, yyline, yytext());}

/*Palabra Reservada class*/
( class ) {return new Symbol(sym.Pal_class, yychar, yyline, yytext());}

/*Palabra Reservada finally*/
( finally ) {return new Symbol(sym.Pal_finally, yychar, yyline, yytext());}

/*Palabra Reservada is*/
( is ) {return new Symbol(sym.Pal_is, yychar, yyline, yytext());}

/*Palabra Reservada return*/
( return ) {return new Symbol(sym.Pal_return, yychar, yyline, yytext());}

/*Palabra Reservada continue*/
( continue ) {return new Symbol(sym.Pal_continue, yychar, yyline, yytext());}

/*Palabra Reservada for*/
( for ) {return new Symbol(sym.Pal_for, yychar, yyline, yytext());}

/*Palabra Reservada lambda*/
( lambda ) {return new Symbol(sym.Pal_lambda, yychar, yyline, yytext());}

/*Palabra Reservada try*/
( try ) {return new Symbol(sym.Pal_try, yychar, yyline, yytext());}

/*Palabra Reservada as*/
( as ) {return new Symbol(sym.Pal_as, yychar, yyline, yytext());}

/*Palabra Reservada def*/
( def ) {return new Symbol(sym.Pal_def, yychar, yyline, yytext());}

/*Palabra Reservada from*/
( from ) {return new Symbol(sym.Pal_from, yychar, yyline, yytext());}

/*Palabra Reservada nonlocal*/
( nonlocal ) {return new Symbol(sym.Pal_nonlocal, yychar, yyline, yytext());}

/*Palabra Reservada while*/
( while ) {return new Symbol(sym.Pal_while, yychar, yyline, yytext());}

/*Palabra Reservada assert*/
( assert ) {return new Symbol(sym.Pal_assert, yychar, yyline, yytext());}

/*Palabra Reservada del*/
( del ) {return new Symbol(sym.Pal_del, yychar, yyline, yytext());}

/*Palabra Reservada global*/
( global ) {return new Symbol(sym.Pal_global, yychar, yyline, yytext());}

/*Palabra Reservada not*/
( not ) {return new Symbol(sym.Pal_not, yychar, yyline, yytext());}

/*Palabra Reservada with*/
( with ) {return new Symbol(sym.Pal_with, yychar, yyline, yytext());}

/*Palabra Reservada async*/
( async ) {return new Symbol(sym.Pal_async, yychar, yyline, yytext());}

/*Palabra Reservada elif*/
( elif ) {return new Symbol(sym.Pal_elif, yychar, yyline, yytext());}

/*Palabra Reservada if*/
( if ) {return new Symbol(sym.Pal_if, yychar, yyline, yytext());}

/*Palabra Reservada yield*/
( yield ) {return new Symbol(sym.Pal_yield, yychar, yyline, yytext());}

/*Palabra Reservada print*/
( print ) {return new Symbol(sym.Pal_print, yychar, yyline, yytext());}


/*Variables*/
( int | float | chr | str | bool ) {return new Symbol(sym.Variable, yychar, yyline, yytext());}


/*Identificadores*/
{L}({L}|{D})* {return new Symbol(sym.Ident, yychar, yyline, yytext());}


/*Numeros Enteros*/
( {DECINT} | {BININT} | {OCTINT} | {HEXINT} ) {return new Symbol(sym.Num_Int, yychar, yyline, yytext());}

/*Numeros Float*/
({FN} | {PF} | {EF} | {DP} | {FR} | {EX}) {return new Symbol(sym.Num_Float, yychar, yyline, yytext());}

/*Numeros Imaginarios*/
({FN} | {PF} | {EF} | {DP} | {FR} | {EX})("j" | "J") {return new Symbol(sym.Num_Imag, yychar, yyline, yytext());}


/*Cadenas - Strings*/
(\")({A})*(\") {return new Symbol(sym.String, yychar, yyline, yytext());}
(\"\"\")({A}|{E})*(\"\"\") {return new Symbol(sym.String, yychar, yyline, yytext());}
(\')({A})*(\') {return new Symbol(sym.String, yychar, yyline, yytext());}
(\'\'\')({A}|{E})*(\'\'\') {return new Symbol(sym.String, yychar, yyline, yytext());}

/*Errores de sintaxis*/
. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}