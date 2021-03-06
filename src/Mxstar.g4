grammar Mxstar;
program: (varDeclarationStmt|classDeclarationStmt|functionDef)*;
classDeclarationStmt : Class Identifier LeftBrace (constructorDef|varDeclarationStmt|functionDef)* RightBrace ';';
constructorDef : Identifier '(' ')' suite;
functionDef : returnType Identifier '(' functionParameterDef? ')' suite;
singleParameter : varType Identifier;
functionParameterDef : (singleParameter (',' singleParameter)*);
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
    | While '(' expression ')' statement #whilestmt
    | Break ';' #breakstmt
    | Continue ';' #continuestmt
    ;

prefixop : (SelfPlus|SelfMinus);
suffixop : (SelfPlus|SelfMinus);
unaryop : (Minus|Plus|Not|Tilde);
creator : builtinType ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+ #errorcreator
              | builtinType ('[' expression ']')+ ('[' ']')* #arraycreator
              | builtinType '(' ')' #classcreator
              | builtinType #basiccreator
              ;
expression :
    '('expression')' #subexpr
    |literal #literalexpr
    |LambdaStart (LeftParen functionParameterDef? RightParen)? '->' suite LeftParen expressionList? RightParen #lambdaexpr
    |This #thisexpr
    |Identifier #varexpr
    |expression '(' expressionList? ')' #funcexpr
    |in=expression '[' out=expression ']' #arrexpr
    |in=expression Dot Identifier #classexpr
    |expression suffixop #suffixexpr
    |<assoc=right> prefixop expression #prefixexpr
    |<assoc=right> unaryop expression #unaryexpr
    |<assoc=right> New creator #newexpr
    |a=expression op = ('*' | '/' | '%') b=expression #binaryexpr
    |a=expression op = ('+' | '-') b=expression #binaryexpr
    |a=expression op = ('<<' | '>>') b=expression #binaryexpr
    |a=expression op = ('<' | '<=' | '>' | '>=') b=expression #binaryexpr
    |a=expression op = ('==' | '!=') b=expression #binaryexpr
    |a=expression op = '&' b=expression #binaryexpr
    |a=expression op = '^' b=expression #binaryexpr
    |a=expression op = '|' b=expression #binaryexpr
    |a=expression op = '&&' b=expression #binaryexpr
    |a=expression op = '||' b=expression #binaryexpr
    |<assoc=right> a=expression op = '=' b=expression #binaryexpr
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
This : 'this';

LambdaStart : '[&]';

Identifier : [a-zA-Z] [a-zA-Z_0-9]*;

DecimalInteger : [1-9] [0-9]* | '0';

StringConstant :  '"' ( '\\n' | '\\\\' | '\\"' | .)*? '"';


Whitespace : [ \t]+ -> skip ;
Newline : ( '\r' '\n'? | '\n' )-> skip ;
BlockComment : '/*' .*? '*/' -> skip ;
LineComment : '//' ~[\r\n]* -> skip ;