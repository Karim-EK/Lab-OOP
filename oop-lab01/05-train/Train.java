class Train{
	
	int nTotSeats;
	int nFirstClassSeats;
	int nFirstClassReservedSeats;
	int nSecondClassReservedSeats;
	
	void build(int nTotSeats, int nFirstClassSeats){
		this.nTotSeats = nTotSeats;
		this.nFirstClassSeats = nFirstClassSeats;
	}
	
	void reserveFirstClassSeats(int seatsToReserve){
		if( nFirstClassReservedSeats < nFirstClassSeats){
			this.nFirstClassReservedSeats += seatsToReserve;
		}
	}
	
	void reserveSecondClassSeats(int seatsToReserve){
		if (nSecondClassReservedSeats < nTotSeats){
			this.nSecondClassReservedSeats += seatsToReserve;
		}
	}
	
	double getTotOccupancyRatio(){
		return (nFirstClassReservedSeats + nSecondClassReservedSeats) * 100d / nTotSeats;
	}
	
	double getFirstClassOccupancyRatio(){
		return (double) nFirstClassReservedSeats / nFirstClassSeats * 100;
	}
	
	double getSecondClassOccupancyRatio(){
		return (double) nSecondClassReservedSeats / (nTotSeats - nFirstClassSeats) * 100;
	}
	
	void deleteAllReservations(){
		this.nFirstClassReservedSeats = 0;
		this.nSecondClassReservedSeats = 0;
	}
	
}