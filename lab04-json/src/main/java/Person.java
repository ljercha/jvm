import java.util.ArrayList;

public class Person {

	private int age;
	private String name;
	private String surname;
	private Boolean haveChildren;
	private ArrayList<String> childrenNames;

	public String getName() { return this.name; }
    public void setName( String name ) { this.name = name; }

    public Integer getAge() { return this.age; }
    public void setAge( Integer age ) { this.age = age; }

    public String getSurname() { return this.surname; }
    public void setSurname( String surname ) { this.surname = surname; }

    public Boolean getHaveChildren() { return this.haveChildren; }
    public void setHaveChildren( Boolean haveChildren ) { this.haveChildren = haveChildren; }

    public ArrayList<String> getchildrenNames() { return this.childrenNames; }
    public void setChildren( ArrayList<String> children ) { this.childrenNames = children; }

    
    
}
