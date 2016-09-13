public class Date{

	private int day;
	private int month;
	private int year;

	public Date(){
		year = 1000;
		month = 1;
		day = 1;
	}

	public Date(int y, int m, int d){
		setDate(y,m,d);
	}

	public int getYear(){
		return year;
	}

	public int getMonth(){
		return month;
	}

	public int getDay(){
		return day;
	}

	public void setYear(int y){
		if(y > 9999 || y < 1000){
			throw new IllegalArgumentException("Year not allowed");
		}
		year = y;
	}
	
	public void setMonth(int m){
		if(m > 12 || m < 1){
			throw new IllegalArgumentException("Month not allowed");
		}
		month = m;
	}
	
	public void setDay(int d){
		int x = 0, y = 0;
		y = getYear();
		x = getMonth();
		if(x==1 || x==3 || x==5|| x==7|| x==8|| x==10|| x==12){
			if(d>31){
				throw new IllegalArgumentException("Day is out of bound");
			}
		}
		else
		if(x==2){
			if((y%40==0) || (y%4==0) && (y%100!=0)){
				if(d>29){
					throw new IllegalArgumentException("Day is out of bound");	
				}
			}
		}
		else{
			if(d>30){
				throw new IllegalArgumentException("Day is out of bound");
			}
		}
		day=d;
	}

	public String toString(){
		return String.format("%02d/%02d/%d",day,month,year);
	}

	public void setDate(int y, int m, int d){
		setDay(d);
		setMonth(m);
		setYear(y);
	}
}