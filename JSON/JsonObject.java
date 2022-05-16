package ex3;
import java.util.LinkedHashMap;
import java.util.Map;
public class JsonObject implements JsonValue{
	Map<String,JsonValue>o;
	
	public JsonObject(CharScanner sc) {
		o=new LinkedHashMap<String,JsonValue>();
		JsonSyntaxException error=new JsonSyntaxException();
		char index;
		//if it is { that means it is good else error
		if(sc.peek()=='{') {
			sc.next();
			index=sc.peek();
			//json object keys is from string so it check if it is string or not else error
			if(index!='\"') {
				error.error();
			}
			else {//making the string 
				String s=new String("");
				while(true) {
					if(index=='\"') {
						s+=sc.next();
						while(true) {
							index=sc.next();
							if(index!='\"') {
								s+=index;
							}
							else {
								s+='\"';
								break;
							}
						}//skip the : and making jsonvalue by if its string number .... and ofc else error
						if(sc.peek()==':') {
							sc.next();
							if(Character.isDigit(sc.peek())) {
								JsonValue p=new JsonNumber(sc);
								o.put(s,p);
								s="";
							}
							if(sc.peek()=='[') {
								JsonValue p=new JsonArray(sc);
								o.put(s,p);
								s="";
							}
							if(sc.peek()=='\"') {
								JsonValue p=new JsonString(sc);
								o.put(s,p);
								s="";
							}
							if(sc.peek()=='{') {
								JsonValue p=new JsonObject(sc);
								o.put(s, p);
								s="";
							}
							if(sc.peek()=='}') {
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
						else {
							error.error();
						}
					}
					else {
						error.error();
					}
				}
			}
		}
		else {
			error.error();
		}
	}
	
	
	
	@Override
	public JsonValue get(int i) {//there is no get int i in maps(JsonObjects)
		JsonQueryException s=new JsonQueryException();
		s.error();
		return null;
	}

	@Override
	public String toString() {
		return ""+o;
	}



	@Override
	public JsonValue get(String s) {//getting the string from the jsonobject
		String w="\"";
		w+=s;
		w+="\"";
		return o.get(w);
	}

}
