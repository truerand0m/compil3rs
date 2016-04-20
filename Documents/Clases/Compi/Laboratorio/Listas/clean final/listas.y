%{
   import java.io.*;
   import java.util.*;
%}

%token EOLN
%token ELEM

%%

inicio:  start          {
                           System.out.println("Good String m8\n");
                           for(int i=0; i< this.lexer.devl.size();i++)
                              System.out.println(this.lexer.devl.get(i));
                        }
         ;

start:  linea           { this.lexer.devl.add(0,"s -> ln"); }
      | start linea     { this.lexer.devl.add(0,"s -> s ln"); }
      ;

linea: lista fin        { this.lexer.devl.add(0,"ln -> ls fin "); }

lista:  lista ELEM      { this.lexer.devl.add(0,"ls -> ls e"); }
      | ELEM            { this.lexer.devl.add(0,"ls -> e"); }
      ;

fin:  EOLN              { this.lexer.devl.add(0,"fin -> eoln "); }
      ;

%%

   /*
   Byacc/J expects a member method int yylex(). We need to provide one
   through this mechanism. See the jflex manual for more information.
   */

	/* reference to the lexer object */
	private scanner lexer;

	/* interface to the lexer */
	private int yylex() {
		int retVal = -1;
		try {
			retVal = lexer.yylex();
		} catch (IOException e) {
			System.err.println("IO Error:" + e);
		}
		return retVal;
	}

	/* error reporting */
	public void yyerror (String error) {
		System.err.println("Error : " + error );
      System.err.println("Errores text: " +lexer.yytext());
      System.err.println("Errores line : " +lexer.getLine());
		System.err.println("String rejected");
      System.exit(0);
	}

	/* constructor taking in File Input */
	public Parser (Reader r) {
		/* lexer = new scanner (r, this); */
      lexer = new scanner (r, this, new ArrayList());
	}

	public static void main (String [] args) throws IOException {
		Parser yyparser = new Parser(new FileReader(args[0]));
		yyparser.yyparse();
	}
