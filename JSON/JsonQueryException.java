package ex3;
public class JsonQueryException{//exception class that throws exceptions
	String Message=new String("Query Error");
	public void error() {
		throw new IllegalArgumentException(Message);
	}
}
