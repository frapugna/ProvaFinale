package jdbcClasses;

public class VotoJDBC {
	long id;
	int valutazione;
	public VotoJDBC(long id, int valutazione) {
		super();
		this.id = id;
		this.valutazione = valutazione;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getValutazione() {
		return valutazione;
	}
	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}
	
}
