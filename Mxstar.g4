grammar Mxstar;
program: (varDeclarationStmt|classDeclarationStmt|functionDef)*;
classDeclarationStmt : Class Identifier LeftBrace (constructorDef|varDeclarationStmt|functionDef)* RightBrace ';';
constructorDef : Identifier '(' ')' suite;
functionDef : returnType Identifier '(' functionParameterDef ')' suite;
singleParameter : varType Identifier;
functionParameterDef : (singleParameter (',' singleParameter)*)?;
suite : '{' statement* '}';
expressionList : expression (',' expression)*;
statement
    : suite #suitestmt
    | varDeclarationStmt #varstmt
    | If '(' expression ')' trueStmt=statement
        (Else falseStmt=statement)? #ifstmt
    | Return expression? ';' #returnstmt
    | expression? ';' #exprstmt
    | For '(' (x0=varDeclaration|x1=expression)? ';' s1 = expression? ';' s2 = expression? ')' statement #forstmt
    | While '(' expression ')' statement ';' #whilestmt
    | Break ';' #breakstmt
    | Continue ';' #continuestmt
    ;

prefixop : (SelfPlus|SelfMinus);
suffixop : (SelfPlus|SelfMinus);
unaryop : (Minus|Plus|Not|Tilde);
expression :
    '('expression')' #subexpr
    | in=expression '[' out=expression ']' #arrexpr
    | expression '(' expressionList ')' #funcexpr
    | a=expression op = ('*' | '/' | '%') b=expression #binaryexpr
    | a=expression op = ('+' | '-') b=expression #binaryexpr
    | a=expression op = ('<<' | '>>') b=expression #binaryexpr
    | a=expression op = ('<' | '<=' | '>' | '>=') b=expression #binaryexpr
    | a=expression op = ('==' | '!=') b=expression #binaryexpr
    | a=expression op = '&' b=expression #binaryexpr
    | a=expression op = '^' b=expression #binaryexpr
    | a=expression op = '|' b=expression #binaryexpr
    | a=expression op = '&&' b=expression #binaryexpr
    | a=expression op = '||' b=expression #binaryexpr
    | <assoc=right> a=expression '=' b=expression #binaryexpr
    | in=expression Dot out=expression #classexpr
    | expression New builtinType (LeftBracket expression? RightBracket)* (LeftParen RightParen)? #newexpr
    | LambdaStart (LeftParen functionParameterDef? RightParen)? '->' suite LeftParen expressionList? RightParen #lambdaexpr
    | prefixop expression #prefixexpr
    | suffixop expression #suffixexpr
    | unaryop expression #unaryexpr
    | literal #literalexpr
    | Identifier #varexpr
;

varDeclaration:varType singlevarDeclaration (',' singlevarDeclaration)* ;
varDeclarationStmt : varDeclaration ';';
singlevarDeclaration : Identifier ('=' expression)?;
returnType: Void | varType;
varType : builtinType (LeftBracket RightBracket)*;
builtinType : Int | Bool | String | Identifier;



primary:
    '('expression')'
    | Identifier
    | literal
;
literal:
DecimalInteger
| True
| False
| StringConstant
| Null
;

New : 'new';
Class : 'class';
Int : 'int';
Bool : 'bool';
String : 'string';
Null : 'null';
Void : 'void';
True : 'true';
False : 'false';
If : 'if';
Else : 'else';
Return : 'return';
Dot : '.';
LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';
Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';
Plus : '+';
SelfPlus : '++';
Minus : '-';
SelfMinus : '--';
Mul : '*';
Div : '/';
Mod : '%';
And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';
Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';
Assign : '=';
Equal : '==';
NotEqual : '!=';
Quote : '"';
BackSlash : '\\\\';
DbQuotation : '\\"';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';

LambdaStart : '[&]';

Identifier : [a-zA-Z] [a-zA-Z_0-9]*;

DecimalInteger : [1-9] [0-9]* | '0';

StringConstant : Quote ('\\"'| .)* Quote;


Whitespace : [ \t]+ -> skip ;
Newline : ( '\r' '\n'? | '\n' )-> skip ;
BlockComment : '/*' .*? '*/' -> skip ;
LineComment : '//' ~[\r\n]* -> skip ;