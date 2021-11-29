grammar Mx_lite;

Dot: '.';
LeftParen: '(';
RightParen: ')';
LeftBracket: '[';
RightBracket: ']';
LeftBrace: '{';
RightBrace: '}';

Less: '<';
LessEqual: '<=';
Greater: '>';
GreaterEqual: '>=';
LeftShift: '<<';
RightShift: '>>';

Plus: '+';
SelfPlus: '++';
Minus: '-';
SelfMinus: '--';
Mul: '*';
Div: '/';
Mod: '%';

And: '&';
Or: '|';
AndAnd: '&&';
OrOr: '||';
Caret: '^';
Not: '!';
Tilde: '~';

Question: '?';
Colon: ':';
Semi: ';';
Comma: ',';

Assign: '=';
Equal: '==';
NotEqual: '!=';

LambdaStart: '[&]';

WhiteSpace
	: [ \t\n]+
	  -> skip
	;
NewLine
	: (	'\r' '\n'?
	  |	'\n'
	  )
	  -> skip
	;
LineComment: '//' ~[\r\n]* -> skip;
BlockComment: '/*' .*? '*/' -> skip;

constant: BoolConst | IntConst | StringConst | Null;
BoolConst
	: True
	| False
	;
IntConst
	: [1-9] [0-9]*
	| '0'
	;
StringConst
	: '"' ( '\\n'
		  | '\\\\'
		  | '\\"'
		  | .
		  )*?
	  '"'
	;

basType: Identifier | Int | Bool | String;
varType: basType ('[' ']')*;
returnType: varType | Void;

program: (programBlock)*;
programBlock: varDef | funcDef | classDef;

varDef: varType varDeclaration (',' varDeclaration)* ';';
varDeclaration: Identifier ('=' expression)?;

funcDef: returnType Identifier '(' parameterList? ')' suite;
parameterList: parameter (',' parameter)*;
parameter: varType Identifier;
suite: '{' statement* '}';

classDef: Class Identifier '{' (varDef | funcDef | classStruct)* '}' ';';
classStruct: Identifier '(' ')' suite;

statement
	: suite                                                                                 #suiteStmt
	| varDef                                                                                #varDefStmt
	| If '(' expression ')' trueStmt=statement
		(Else falseStmt=statement)?                                                         #ifStmt
	| While '(' expression ')' statement                                                    #whileStmt
	| For '(' expr1=expression? ';'expr2=expression? ';' expr3=expression? ')' statement    #forStmt
	| Return expression? ';'                                                                #returnStmt
	| Break ';'                                                                             #breakStmt
	| Continue ';'                                                                          #continueStmt
	| expression ';'                                                                        #pureExprStmt
	| ';'                                                                                   #emptyStmt
	;

expression
	: '(' expression ')'                                                                    #subExpr
	| constant                                                                              #constExpr
	| lambda                                                                                #lambdaExpr
	| This                                                                                  #thisExpr
	| Identifier                                                                            #idExpr
	| expression '(' expressionList? ')'                                                    #funcExpr
	| expr1=expression '[' expr2=expression ']'                                             #indexExpr
	| expression '.' Identifier                                                             #classExpr
	| expression op=('++' | '--')                                                           #sufExpr
	| <assoc=right> op=('++' | '--') expression                                             #preExpr
	| <assoc=right> op=('+' | '-') expression                                               #preExpr
	| <assoc=right> op=('!' | '~') expression                                               #preExpr
	| <assoc=right> New creator                                                             #newExpr
	| src1=expression op=('*' | '/' | '%') src2=expression                                  #binaryExpr
	| src1=expression op=('+' | '-') src2=expression                                        #binaryExpr
	| src1=expression op=('<<' | '>>') src2=expression                                      #binaryExpr
	| src1=expression op=('<' | '<=' | '>' | '>=') src2=expression                          #binaryExpr
	| src1=expression op=('!=' | '==') src2=expression                                      #binaryExpr
	| src1=expression op='&' src2=expression                                                #binaryExpr
	| src1=expression op='^' src2=expression                                                #binaryExpr
	| src1=expression op='|' src2=expression                                                #binaryExpr
	| src1=expression op='&&' src2=expression                                               #binaryExpr
	| src1=expression op='||' src2=expression                                               #binaryExpr
	| <assoc=right> src1=expression op='=' src2=expression                                  #binaryExpr
	;
expressionList: expression (',' expression)*;

creator
	: basType ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+                        #errorCrea
	| basType ('[' expression ']')+ ('[' ']')*                                              #arrayCrea
	| basType '(' ')'                                                                       #classCrea
	| basType                                                                               #basicCrea
	;

lambda: '[&]' ('(' parameterList? ')')? '->' suite '(' expressionList? ')';

Int: 'int';
Bool: 'bool';
String: 'string';
Null: 'null';
Void: 'void';
True: 'true';
False: 'false';
If: 'if';
Else: 'else';
For: 'for';
While: 'while';
Break: 'break';
Continue: 'continue';
Return: 'return';
New: 'new';
Class: 'class';
This: 'this';

Identifier: [a-zA-Z][a-zA-Z_0-9]*;