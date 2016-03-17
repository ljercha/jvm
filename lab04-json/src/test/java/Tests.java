import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

import java.awt.List;
import java.util.ArrayList;

import org.json.JSONObject;

public class Tests {

	@Test
	public void compareJsonConverterPerson() throws IllegalArgumentException, IllegalAccessException, JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse

		Person father = new Person();
		father.setAge(44);
		father.setName("Andy");
		father.setSurname("Graham");
		father.setHaveChildren(true);
		
		Person firstChild = new Person();
		firstChild.setAge(4);
		firstChild.setName("Carol");
		firstChild.setSurname("Graham");
		
		Person secondChild = new Person();
		secondChild.setAge(12);
		secondChild.setName("Aaron");
		secondChild.setSurname("Graham");
		
		ArrayList<String> kids = new ArrayList<String>();
		kids.add("Eva");
		kids.add("Adam");
		father.setChildren(kids);
		
        Assert.assertEquals(mapper.writeValueAsString(father) , PojoToJson.toJson(father));

	}
	
	@Test
	public void compareJsonConverterSetsOfNumbers() throws IllegalArgumentException, IllegalAccessException, JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse

		SetOfNumbers tester = new SetOfNumbers();
		tester.setName("Tester");
		ArrayList<Integer> fibonaci = new ArrayList<Integer>();
		fibonaci.add(1);
		fibonaci.add(2);
		fibonaci.add(3);
		fibonaci.add(5);
		fibonaci.add(8);
		fibonaci.add(13);
		;
		tester.setNumbers(fibonaci);
		
		Assert.assertEquals(mapper.writeValueAsString(tester) , PojoToJson.toJson(tester));

	}
}
