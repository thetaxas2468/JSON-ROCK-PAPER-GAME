package ex3;
public class JsonString implements JsonValue{
	private String s;
//constructor that make json string
	public JsonString(CharScanner sc) {//maybe return string
		JsonSyntaxException error=new JsonSyntaxException();
		s=new String();
		char index;
		index=sc.next();
		//every else throws an error because it is not fine
		
		//if it starts with " so it is usually string so we continue
		if(index=='\"') {
		s+=index;
		while(true) {
			index=sc.next();
			//end of string with out errors
			if(index=='\"') {
				s+=index;
				break;
			}
			//any unicode will be added to string
			if(index!='\\'&&index!='\"') {
				s+=index;
			}
			//if it is / then it usually should be " or / else error and so on
			if(index=='\\') {
				index=sc.next();
				if(index=='\\') {
					s+=index;
				}
				else if(index=='\"') {
					s+=index;
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
	public JsonValue get(int i) {//there is no get int i in string
		JsonQueryException s=new JsonQueryException();
		 s.error();
		 return null;
	
		}
	@Override
	public JsonValue get(String s) {//there is no get string in string
		JsonQueryException w=new JsonQueryException();
		w.error();
		return null;
	}
	public String toString() {
		return s.substring(1,s.length()-1);
	}
}


