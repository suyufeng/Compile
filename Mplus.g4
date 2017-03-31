grammar Mplus;

program: (classpart | functionpart | difinition)+;

classpart: 'class' Name '{' (functionpart | difinition)+ '}' ';';

functionpart: type Name '(' parameter ')' blockpart;

parameter: (type Name)? | (type Name (',' type Name)*);

difinition: type Name (op = '=' expr)? ';';

statement: blockpart
		 | expr_statement
		 | if_statement
		 | for_statement
		 | while_statement
		 | skip_statement
		 | difinition
		 | ';'
;
expr_statement: expr ';';

blockpart: '{' statement* '}';

if_statement: 'if' '(' expr ')' statement ('else' statement)?;

while_statement: 'while' '(' expr ')' statement;

for_statement: 'for' '(' expr? ';' expr? ';' expr? ')' statement;

skip_statement: 'continue' ';'                      #continue
			  | 'break' ';'                         #break
		      | 'return' expr? ';'                  #return
;

expr : constant                                          #constant_expr
	 | Name                                              #name_expr
	 | '(' expr ')'                                      #bracket_expr
	 | expr op = ('++'|'--')                             #suffix_expr
	 | expr '(' (expr (',' expr)*)? ')'                  #function_expr
	 | expr '[' expr ']'                                 #aref_expr
	 | expr '.' Name                                     #member_expr
     | This '.' Name                                     #this_expr
     | op = ('+'|'-'|'!'|'~'|'++'|'--') expr             #unary_expr
	 | 'new' type ('[' expr? ']')*                       #new_expr
	 | expr op = ('*'|'/'|'%') expr                      #binary_expr
	 | expr op = ('+'|'-') expr                          #binary_expr
	 | expr op = ('<<'|'>>') expr                        #binary_expr
	 | expr op = '&' expr                                #binary_expr
	 | expr op = '^' expr                                #binary_expr
	 | expr op = '|' expr                                #binary_expr
	 | expr op = ('<'|'>'|'<='|'>='|'=='|'!=') expr      #binary_expr
	 | expr op = '&&' expr                               #binary_expr
	 | expr op = '||' expr                               #binary_expr
	 | expr op = '=' expr                                #assign_expr
;

constant: ('true'|'false')                          #bool
	    | Integer                                   #int
		| String                                    #string
		| 'null'                                    #null
;

type: 'void'                                        #true_type
	| 'int'                                         #true_type
	| 'bool'                                        #true_type
	| 'string'                                      #true_type
	| Name                                          #true_type
	| type '['']'                                   #array_type
;

Comment: '//' .*? ->  skip;

This: 'this';

Blockcomment: '/*' (. | [\r\n])*? '*/'	->	skip;

Name: [a-zA-Z_][a-zA-Z_0-9]*;

Integer: [0-9]+;

String: '\"' Char* '\"';

fragment
Char: ~["\\\r\n]
	| '\\' ["nt]
;

Space: [ \t\r\n]+ -> skip;
