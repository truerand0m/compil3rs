public interface Visitor{
   public void visit(Node n);
   public void visit(StringLeaf s);
   public void visit(IntLeaf n);
   public void visit(PowerNode p);
   public void visit(FactorNode p);
   public void visit(TermNode n);
   public void visit(TermNodeX n);
   public void visit(ArithNode n);
}

class PrintVisitor implements Visitor{
   public void visit(Node n){
      System.out.println("Soy clase genérica Nodo");
   }

   public void visit(StringLeaf s){
      System.out.println("Soy nodo hoja con valor: "+ s.getValue().sval);
   }

   public void visit(IntLeaf n){
      System.out.println("Soy nodo entero con valor: "+ n.getValue().ival);
   }

   public void visit(PowerNode n){
      System.out.println("Soy nodo potencia ");
      Node l = n.getLeftChild();
      Node r = n.getRightChild();
      l.accept(this);
      r.accept(this);
   }

   public void visit(FactorNode n){
      System.out.println("Soy nodo factor ");
      Node f = n.getLeftChild();
      f.accept(this);
   }

   public void visit(TermNode n){
      System.out.println("Soy nodo term:[");
      Node l = n.getLeftChild();
      Node r = n.getRightChild();
      l.accept(this);
      System.out.println(n.op);
      r.accept(this);
      System.out.println("]");
   }

   public void visit(TermNodeX n){
      System.out.println("Soy nodo term:[");
      
   }

   public void visit(ArithNode n){
      System.out.println("Soy nodo Arith:[");
      Node l = n.getLeftChild();
      Node r = n.getRightChild();
      l.accept(this);
      System.out.println(n.op);
      r.accept(this);
      System.out.println("]");
   }
}
