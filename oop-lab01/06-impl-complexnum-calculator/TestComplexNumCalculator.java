class TestComplexNumCalculator {
  public static void main(String[] args) {
      /*
       * 1) Testare la classe ComplexNumCalculator con le seguenti operazioni
       *    tra numeri complessi:
       *
       * - add(1+2i, 2+3i) = 3+5i
       *
       * - sub(4+5i, 6+7i) = -2-2i
       *
       * - mul(8+2i, 3-i) = 26 - 2i
       *
       * - ... altre a piacere
       *
       * 2) Verificare il corretto valore dei campi nOpDone, lastRes
       *
       * 3) Fare altre prove con operazioni a piacere
       */
	   
		ComplexNumCalculator testCalculator = new ComplexNumCalculator();
		
		ComplexNum a = new ComplexNum();
		ComplexNum b = new ComplexNum();
		ComplexNum c = new ComplexNum();
		
		
		a.build(1,2);
		b.build(2,3);
		c = testCalculator.add(a,b);
		System.out.println(c.toStringRep());
		
		System.out.println("\noperation done " + testCalculator.nOpDone);
	    System.out.println("last result " + testCalculator.lastRes.toStringRep()+"\n");
		
		a.build(4,5);
		b.build(6,7);
		c = testCalculator.sub(a,b);
		System.out.println(c.toStringRep());
		System.out.println("\noperation done " + testCalculator.nOpDone);
	    System.out.println("last result " + testCalculator.lastRes.toStringRep()+"\n");
		
		a.build(8,2);
		b.build(3,1);
		c = testCalculator.mul(a,b);
		System.out.println(c.toStringRep());
		System.out.println("\noperation done " + testCalculator.nOpDone);
	    System.out.println("last result " + testCalculator.lastRes.toStringRep()+"\n");
		
		c = testCalculator.div(a,b);
		System.out.println(c.toStringRep());
		
		System.out.println("\noperation done " + testCalculator.nOpDone);
	    System.out.println("last result " + testCalculator.lastRes.toStringRep()+"\n");
  }
}
