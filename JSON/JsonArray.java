package ex3;
import java.util.ArrayList;
import java.util.List;

public class JsonArray implements JsonValue{

	private List<JsonValue> a;
	public JsonArray(CharScanner sc) {
		a=new ArrayList<JsonValue>();
		//making josn array by checking if it is an array else error 
		JsonSyntaxException error=new JsonSyntaxException();
		if(sc.peek()=='[') {
			sc.next();
			while(true) {
				//checks if it is string number .... and adds it to the existed a array
				if(sc.peek()=='\"') {
					JsonValue p=new JsonString(sc);
					a.add(p);
				}
				if(Character.isDigit(sc.peek())) {
					JsonValue p=new JsonNumber(sc);
					a.add(p);
				}
				if(sc.peek()=='[') {
					JsonValue p=new JsonArray(sc);
					a.add(p);
				}
				if(sc.peek()=='{') {
					JsonValue p=new JsonObject(sc);
					a.add(p);
				}
				if(sc.peek()==']') {
					sc.next();
					break;
				}
				if(sc.peek()==',') {
					sc.next();
				}
				else {
					error.error();
				}
			}

		}
		else {
			error.error();
		}
	}
	
	
	

	
	@Override
	public JsonValue get(int i) {//get the jsonvalue from index i
		return a.get(i);
	}
	@Override
	public JsonValue get(String s) {//cant get string from an array
		JsonQueryException error=new JsonQueryException();
		error.error();
		return null;
	}














	@Override
	public String toString() {
		return ""+ a;
	}

}

	
