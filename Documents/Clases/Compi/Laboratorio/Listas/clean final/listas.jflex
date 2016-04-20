%%

%class scanner
%unicode
%line
%column
%byaccj

%{

	private Parser yyparser;
	/*  */
	java.util.ArrayList devl;
	
	public scanner (java.io.Reader r,Parser yyparser,java.util.ArrayList arrl){
		this (r);
		this.yyparser = yyparser;
		this.devl = arrl;
	}
	/*	*/

	/*
	public scanner (java.io.Reader r, Parser yyparser) {
		this (r);
		this.yyparser = yyparser;
	}
	*/

	/*
      return the current line number.
   */
	public int getLine() {
		return yyline;
	}

%}

%%

E     		{return Parser.ELEM;}
[ \t]	   	{;}
\r|\n|\r\n	{return Parser.EOLN;}
.		      {return (int) yycharat(0);}
