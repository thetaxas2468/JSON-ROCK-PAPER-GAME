package ex3;
//exception class that has a illegal exception throw
public class JsonSyntaxException{
	String Message=new String("Syntax Error");
	public void error() {
		throw new IllegalArgumentException(Message);
	}
}
