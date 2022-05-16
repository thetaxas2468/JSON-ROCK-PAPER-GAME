package ex3;
public class JsonBuilder implements JsonValue {
		CharScanner sc;
		JsonValue s;
		//constructor calls to parseValue to make the json OBJECT that we need
		public JsonBuilder(CharScanner sc) {
			this.sc=sc;
			s=parseValue();
		}
		
	public JsonValue parseValue() {
		char index;
		index=sc.peek();
		//it checks if it is an array number .... and it calls the right method that is in the class to do the word else error
		if(index=='\"') {
			parseString();
		}
		else if(index=='[') {
			parseArray();
		}
		else if(Character.isDigit(index)) {
			parseNumber();
		}
		else if(index=='{') {
			parseObject();
		}
		else {
			JsonSyntaxException w=new JsonSyntaxException();
			w.error();
		}
		return s;
	}

	public JsonArray parseArray() {//making array from json array
		s=new JsonArray(sc);
		return (JsonArray) s;
	}
	public JsonString parseString() {//making string from json string
		s=new JsonString(sc);
		return (JsonString) s;
	}
	public JsonNumber parseNumber() {//making number from json number
		s=new JsonNumber(sc);
		return (JsonNumber) s;
	}
	public JsonObject parseObject() {//making object from json object
		s=new JsonObject(sc);
		return (JsonObject) s;
	}
	@Override
	public JsonValue get(int i) {//get int i it gets from the right json object and if cant throws exception
		return this.s.get(i);
}
	

	@Override
	public JsonValue get(String s) {//same as int if cant get string it throws error else it gives us the answer
		return this.s.get(s);
	}
	@Override
	public String toString() {
		return ""+s ;
	}
	

}
