class ComplexNum {
    /*
     * Inserire qui la dichiarazione dei campi della classe
     */
	double re;
	double im;
	
    void build(double re, double im) {
        this.re = re;
		this.im = im;
    }

    boolean equal(ComplexNum num) {
		if(num.re == this.re && num.im == this.im){
			return true;
		}
		else {
			return false;
		}
    }

    void add(ComplexNum num) {
        this.re += num.re;
		this.im += num.im;
    }

    String toStringRep() {
		if (this.im < 0) {
			return this.re +""+ this.im + "i";
		} else {
			return this.re +"+"+ this.im + "i";
		}
    }
}
