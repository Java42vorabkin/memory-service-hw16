package telran.util.memory;

public class Singleton {
	private String str = "XXX";
	private Integer num = 55;
	
	private static Singleton instance = null;
	private Singleton() {
		
	}

	static public Singleton instance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public void setString(String s) {
		str = s;
	}
	public void setInteger(Integer n) {
		num = n;
	}
	public String getString() {
		return str;
	}
	public Integer getInteger() {
		return num;
	}
}
