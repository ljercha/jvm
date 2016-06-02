package serializacja;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class GsonSerializer extends BaseSerializer {

	@Override
	protected void serialize(List<Login> logins) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logins.ser"));
		out.writeObject(new Gson().toJson(logins));
		out.close();

	}

	@Override
	protected void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		
	    ObjectInputStream in = new ObjectInputStream(new FileInputStream("logins.ser")
		);
	    Object result = new Gson().fromJson((String) in.readObject(),List.class);
	    in.close();


	}

}
