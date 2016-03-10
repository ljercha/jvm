
public class Foo {

	public int silniaRekurencja(int i) 
	{
	    if (i == 0) 
	      return 1;
	    else 
	      return i * silniaRekurencja(i - 1);
	}
	
	public int silniaIteracyjne(int i)
	{
		int silnia = 1;
		while(i > 0)
		{
			silnia = silnia * i;
			i--;
		}
		
		return silnia;
	}
}
