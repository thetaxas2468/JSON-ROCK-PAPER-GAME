package ex3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
public class Main {
	public static void main( String[] args ) throws FileNotFoundException
	{
	 InputStream sc=new FileInputStream("abc.txt");
	 CharScanner s=new CharScanner(sc);
	 JsonBuilder avraham ;
	 avraham = new JsonBuilder(s);
//	 avraham.parseValue();
	 System.out.println(avraham);
//	 System.out.println(avraham.get(1));
//	 JsonObject po=new JsonObject(s);
	 System.out.println(avraham.get("issue").get("Ketura").get(0));
	}
}
