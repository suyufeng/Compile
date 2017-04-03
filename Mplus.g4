grammar Mplus;

program: (classpart | functionpart | difinition)+;

classpart: 'class' Name '{' (functionpart | difinition | selfpart )* '}' ;

selfpart:  type '('')' blockpart;

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
;
expr_statement: expr? ';';

blockpart: '{' statement* '}';

if_statement: 'if' '(' expr ')' scope_statement ('else' scope_statement)?;

while_statement: 'while' '(' expr ')' scope_statement;

scope_statement: statement;

for_statement: 'for' '(' expr? ';' expr? ';' expr? ')' scope_statement;

skip_statement: 'continue' ';'                      #continue
			  | 'break' ';'                         #break
		      | 'return' (expr | This)? ';'         #return
;

expr : constant                                           #constant_expr
	 | Name                                               #name_expr
	 | '(' expr ')'                                       #bracket_expr
	 | expr op = ('++'|'--')                              #suffix_expr
	 | expr '(' ((expr | This) (',' (expr | This))*)? ')' #function_expr
	 | expr '[' expr ']'                                  #aref_expr
	 | expr '.' Name                                      #member_expr
     | This '.' Name                                      #member_expr
     | op = ('+'|'-'|'!'|'~'|'++'|'--') expr              #unary_expr
	 | 'new' type ('[' expr? ']')*                        #new_expr
	 | expr op = ('*'|'/'|'%') expr                       #binary_expr
	 | expr op = ('+'|'-') expr                           #binary_expr
	 | expr op = ('<<'|'>>') expr                         #binary_expr
	 | expr op = '&' expr                                 #binary_expr
	 | expr op = '^' expr                                 #binary_expr
	 | expr op = '|' expr                                 #binary_expr
	 | expr op = ('<'|'>'|'<='|'>='|'=='|'!=') expr       #binary_expr
	 | expr op = '&&' expr                                #binary_expr
	 | expr op = '||' expr                                #binary_expr
	 | expr op = '=' expr                                 #assign_expr
	 | This op = '=' expr                                 #assign_expr
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
	| Name                                          #my_type
	| type '['']'                                   #array_type
;

Comment : '//' ~[\r\n]* -> skip;

This: 'this';

Blockcomment: '/*' (. | [\r\n])*? '*/'	->	skip;

Name: [a-zA-Z_][a-zA-Z_0-9]*;

Integer: [0-9]+;

String: '\"' Char* '\"';

fragment
Char	:	~["\\\r\n]
		|	'\\' ["nt\\]
;

Space: [ \t\r\n]+ -> skip;
