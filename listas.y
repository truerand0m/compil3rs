%{
   import java.io.*;
%}

%token EOLN
%token ELEM

%%

start:  linea
      | start linea
      ;

linea: lista fin

lista:  lista ELEM
      | ELEM
      ;

fin:  EOLN
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
		lexer = new scanner (r, this);
	}

	public static void main (String [] args) throws IOException {
		Parser yyparser = new Parser(new FileReader(args[0]));
		yyparser.yyparse();
		System.out.println("String accepted");
	}
