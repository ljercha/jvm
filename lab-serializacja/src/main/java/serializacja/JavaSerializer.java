package serializacja;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class JavaSerializer extends BaseSerializer {

	@Override
	protected void serialize(List<Login> logins) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logins.ser")
			);
			out.writeObject(logins);
			out.close();
		
	}

	@Override
	protected void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
	    ObjectInputStream in = new ObjectInputStream(new FileInputStream("logins.ser")
		);
	    Object result = in.readObject();
	    in.close();
	}
	
}

