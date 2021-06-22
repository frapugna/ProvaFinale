package jdbcClasses;

public class IdGenerator {
	long id;

	public IdGenerator() {
		super();
		this.id = 1;
	}
	
	public long getId() {
		long out = id;
		++id;
		return out;
	}
}
