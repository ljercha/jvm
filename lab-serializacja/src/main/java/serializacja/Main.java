package serializacja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ClassNotFoundException, JAXBException {
		// TODO Auto-generated method stub

		long[] singleLoginMeasureTime = new long[4];
		long[] tenLoginMeasureTime = new long[4];
		long[] tenThousandLoginMeasureTime = new long[4];
		long[] startTime = new long[4];
		long[] stopTime = new long[4];
		long[] elapsedTime = new long[4];
		ArrayList<Login> singleLogin = new ArrayList<Login>();
		singleLogin.add(new Login());
		
		Login2 singleLogin2 = new Login2();

		ArrayList<Login> tenLogins = new ArrayList<Login>();
		ArrayList<Login> tenThousandLogins = new ArrayList<Login>();
		ArrayList<Login2> tenLogins2 = new ArrayList<Login2>();
		ArrayList<Login2> tenThousandLogins2 = new ArrayList<Login2>();
		
		
		for(int i = 0; i < 10000; i++)
		{
			if (i < 10) {
				tenLogins.add(new Login());
				tenLogins2.add(new Login2());
			}
			tenThousandLogins.add(new Login());
			tenThousandLogins2.add(new Login2());
		}
		
		test("Single object",singleLogin, 99, 1100);
		test("10 object",tenLogins, 99, 1100);
		
		test("1000 object",tenThousandLogins, 99, 210);
		
		
	}
	
	public static void test(String title, ArrayList<Login> logins, int burnTime, int runTime) throws FileNotFoundException, IOException, JAXBException, ClassNotFoundException {
		Jackson jackson = new Jackson();
		JavaSerializer javaSerialize = new JavaSerializer();
		GsonSerializer gson = new GsonSerializer();
		XStreamXML jaxb = new XStreamXML();
		
		
		double jacksonTime = 0;
		double javaSerializeTime = 0;
		double gsonTime = 0;
		double xstreamTime = 0;
		
		for(int i = 0; i < runTime; i++)
		{
			if (i >= burnTime) {
			jacksonTime += jackson.testSerialization(logins);
			jacksonTime += jackson.testDeserialization(logins);

			javaSerializeTime += javaSerialize.testSerialization(logins);
			javaSerializeTime += javaSerialize.testDeserialization(logins);
			
			gsonTime += gson.testSerialization(logins);
			gsonTime += gson.testDeserialization(logins);
			
			xstreamTime += jaxb.testSerialization(logins);
			xstreamTime += jaxb.testDeserialization(logins);
			
			}
			
		}
		
		System.out.println(title);
		System.out.println("Jackson: " + jacksonTime / (runTime - 1));
		System.out.println("Java serialize: " + javaSerializeTime / (runTime - 1));
		System.out.println("Gson serialize: " + gsonTime / (runTime - 1));
		System.out.println("Xstream serialize: " + xstreamTime / (runTime - 1));
	}
}
