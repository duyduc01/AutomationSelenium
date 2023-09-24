package test;

public class Common3 {

	int y;// class variable

	public Common3(int y) {
		// TODO Auto-generated constructor stub
		this.y=y;// assign the class variable to the constructor
	}

	// public Common2(int x)
//		{
//			this.x=x;
//		}
	public int multiply() {
		y = y*10;// take the class variable
		return y;
	}

}
