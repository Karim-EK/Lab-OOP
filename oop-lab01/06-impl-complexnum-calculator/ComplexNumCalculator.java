class ComplexNumCalculator{
	
	int nOpDone;
    ComplexNum lastRes;
	
	void build(int nOpDone, ComplexNum lastRes){
		this.nOpDone = nOpDone;
		this.lastRes = lastRes;
	}
	
	ComplexNum add(ComplexNum a, ComplexNum b){
		ComplexNum result = new ComplexNum();
		result.re = a.re + b.re;
		result.im = a.im + b.im;
		this.nOpDone ++;
		this.lastRes = result;
		return result;
	}
	
	ComplexNum sub(ComplexNum a, ComplexNum b){
		ComplexNum result = new ComplexNum();
		result.re = a.re - b.re;
		result.im = a.im - b.im;
		this.nOpDone ++;
		this.lastRes = result;
		return result;
	}
	
	ComplexNum mul(ComplexNum a, ComplexNum b){
		ComplexNum result = new ComplexNum();
		result.re = a.re * b.re - a.im * b.im;
		result.im = a.re * b.im + a.im * b.re;
		this.nOpDone ++;
		this.lastRes = result;
		return result;
	}
	
	ComplexNum div(ComplexNum a, ComplexNum b){
		ComplexNum result = new ComplexNum();
		result.re = (a.re * b.re + a.im * b.im) / (b.re*b.re + b.im*b.im);
		result.im = (a.re * b.im - a.im * b.re) / (b.re*b.re + b.im*b.im);
		this.nOpDone ++;
		this.lastRes = result;
		return result;
	}
}