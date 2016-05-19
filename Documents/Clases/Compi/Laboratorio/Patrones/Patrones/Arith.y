%{
  import java.lang.Math;
  import java.io.*;
%}
/* YACC Declarations */
%token CADENA
%token NEWLINE IDENTIFIER ENTERO REAL
%token BOOLEAN DEDENT INDENT
%token AND OR NOT FROM WHILE
%token FOR DEF AS ELIF ELSE IF
%token PRINT RETURN IN
%token MAS MENOS POR POTENCIA DIV  /* + | - | * | ** | / */
%token DIVENTERA MODULO LE GR LEQ /* // | % | < | > | <= */
%token GRQ EQUALS DIFF EQ PA /* >= | == | != | = | ( */
%token XOR ANDB ORB /* ^ | & | "|" */
%token PC DOBLEPUNTO PUNTOCOMA/* ) | : | ; */
/* Grammar follows */
%%
input:

      | arith_expr NEWLINE{
            Visitor v = new PrintVisitor();
            System.out.println("Llegue a input");
            System.out.println("*****************************");
            //$1.accept(v);
            $1.print();
            System.out.println("*****************************");
            /* exp */
            //System.out.println("*****************************");
            Printer p = new Printer($1);
            p.print();
            //System.out.println("*****************************");
            /*
            Aqui asigno los tipos
            new Arbol($1)
            vTipos(new Arol());
            */
      }

      /*
      | term NEWLINE {
            Visitor v = new PrintVisitor();
            System.out.println("Llegue a input");
            System.out.println("*****************************");
            //$1.accept(v);
            $1.print();
            System.out.println("*****************************");
      }
      ;
/*
arith_expr: term { $$ = $1; }
         |  term MAS term     {$$ = new ArithNode($1,EnumOp.MAS,$3);}
         |  term MENOS term   {$$ = new ArithNode($1,EnumOp.MENOS,$3);}
         ;
*/


/* arith_expr: term (('+'|'-') term)* */
arith_expr: term { $$ = $1; }
         |  term MAS arith_expr { $$ = new ArithNode($1,EnumOp.MAS,$3);}
         |  term MENOS arith_expr { $$ = new ArithNode($1,EnumOp.MENOS,$3); }
/*
 term   : factor                         {$$ = $1;}
        | term '*' factor                {$$ = $1 * $3;}
        | term '/' factor                {$$ = $1 / $3;}
        ;
*/

/* term: factor (('*'|'/'|'%'|'//') factor)* */
term: factor               { $$ = $1; }
   |  factor POR term      { $$ = new TermNodeX($1,EnumOp.POR,$3); }
   |  factor DIV term      { $$ = new TermNodeX($1,EnumOp.DIV,$3); }
   |  factor MODULO term      { $$ = new TermNodeX($1,EnumOp.MODULO,$3); }
   |  factor DIVENTERA term      { $$ = new TermNodeX($1,EnumOp.DIVENTERA,$3); }

/*    ('+'|'-') factor | power   */
factor:  MAS factor { $$ = new FactorNode(EnumOp.MAS,$2); }
      |  MENOS factor  { $$ = new FactorNode(EnumOp.MENOS,$2); }
      |  power { $$ = $1; }

/* power: atom ['**' factor] */
/* CAMBIE ESTO */
power:   atom {$$ = $1; }
      |  atom POTENCIA factor  { $$ = new PowerNode($1,$3); }
;

/* atom: IDENTIFIER | INTEGER | STRING | FLOAT */
atom:   CADENA            {$$ = $1;}
      | ENTERO            {$$ = $1;}
      | REAL              {$$ = $1;}
      | IDENTIFIER        {$$ = $1;}
;
%%
/* a reference to the lexer object */
private Flexer lexer;

/* interface to the lexer */
private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
}

/* error reporting */
public void yyerror (String error) {
    System.err.println ("Error: " + error);
}

/* lexer is created in the constructor */
public Parser(Reader r) {
    lexer = new Flexer(r, this);
    yydebug = true;
}

/* that's how you use the parser */
public static void main(String args[]) throws IOException {
    Parser yyparser = new Parser(new FileReader(args[0]));
    yyparser.yyparse();
}
