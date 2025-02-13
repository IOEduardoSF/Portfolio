grammar Pantera;

Break : 'break';
Do : 'do';
Continuar : 'continuar';
Else : 'else';
Func : 'func';
For : 'for';
If : 'if';
Then : 'then';
Len : 'len';
NoneObj : 'none';
Print : 'print';
Return : 'return';
While : 'while';
TrueLiteral : 'true';
FalseLiteral : 'false';

// Reglas para el Lexer 
LINEA_COMENTARIO
    : '//' ~[\r\n]* -> skip;
NUMERO: [0-9]+;
ESPACIO: [ \t\n]+ -> skip;
VARIABLE: [a-zA-Z_][a-zA-Z0-9_]*;
NEWLINE: [\t\r\n] -> skip;


// Reglas para Parser 
program: functionDecl* EOF;

block: '{' stmt* '}';

identifier: var=VARIABLE;

functionDecl: Func (name=VARIABLE) '(' (identifier (',' identifier)* )? ')' block;

stmt: block # BlockStmt
    | Print expr ';'# PrintStmt
    | Continuar ';' # ContinueStmt //Falta en el while
    | Break ';' # BreakStmt
    | Return expr? ';' # ReturnStmt //Falta
    | If expr Then stmt # IfStmt
    | If expr Then stmt Else stmt # IfElseStmt
    | For var=VARIABLE 'in' (lbound=expr) '..' (ubound=expr) Do stmt # ForStmt
    | While expr Do stmt # WhileStmt
    | (var=VARIABLE) '=' (rhs=expr) ';'# AssignStmt // VAR = 45; | c = a + b; | arr = [45, 6, 3];
    | expr '[' expr ']' '=' expr ';' # AssignIdxStmt  // a[45] = 4; | a[45] = a[4]
    | expr ';' # SingleStmt
    | ';' # NullStmt
    ;

expr:  (name=VARIABLE) '(' (expr (',' expr)*)? ')' # FuncCall
    | '(' expr ')' # ParenExpr
    | expr '[' expr ']' # IndexExpr // a[4]
    | op=('+' | '-' | '!' | Len ) expr # UnaryExpr
    | expr op=('*' | '/' | '%' ) expr # BinExpr
    | expr op=('+' | '-') expr # BinExpr
    | expr op=('<' | '<=' | '>' | '>=' | '==' | '!=') expr #BinExpr
    | num=NUMERO op=('<' | '<=' | '>' | '>=' | '==' | '!=') num=NUMERO #BinExpr
    | expr op=('&' | '|') expr #BinExpr
    | '[' (expr (',' expr)*)? ']' #ListExpr // [45, (*)?] -> define los elementos
    | TrueLiteral #TrueLiteral
    | FalseLiteral #FalseLiteral
    | num=NUMERO # NumExpr
    | var=VARIABLE # VarExpr
    | NoneObj # NoneExpr
    ;
