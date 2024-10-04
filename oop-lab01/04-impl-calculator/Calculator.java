class Calculator{

	int nOpDone;
	double lastRes;
	
	void build(int nOpDone, double lastRes){
		this.nOpDone = nOpDone;
		this.lastRes = lastRes;
	}

	double add(double a, double b){
		this.nOpDone ++;
		this.lastRes = a + b;
		return lastRes;
	}
	
	double sub(double a, double b){
		this.nOpDone ++;
		this.lastRes = a - b;	
		return lastRes;
	}
	
	double mul(double a, double b){
		this.nOpDone ++;
		this.lastRes = a * b;
		return lastRes;		
	}
	
	double div(double a, double b){
		return doOp(a/b);		
	}

	double doOp(double result) {
		this.nOpDone++;
		return result;
	}
}