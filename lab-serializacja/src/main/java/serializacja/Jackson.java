package serializacja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson extends BaseSerializer {

	
	ObjectMapper mapper = new ObjectMapper();
	

	protected void serialize(List<Login> logins) throws FileNotFoundException, IOException {
		 mapper.writeValue(new File("logins2.ser"), logins);		
	}

	@Override
	protected void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		mapper.readValue(new File("logins2.ser"), List.class);
	}
	
}
