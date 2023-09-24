package test;

public class Common2 extends Common3 {// extend other class to call all other methods in this class. Because this
										// parent class has own constructor, need to the constructor in this class as
										// the only one (super constructor) for all methods in parent class

	int x;// class variable

	public Common2(int x) {
		// TODO Auto-generated constructor stub
		super(x);// invoke the constructor of parent class - inheritance scenario
		this.x = x;// assign the class variable to the constructor
	}

	// public Common2(int x)
//		{
//			this.x=x;
//		}
	public int increase() {
		x = x + 1;// take the class variable
		return x;
	}

}
