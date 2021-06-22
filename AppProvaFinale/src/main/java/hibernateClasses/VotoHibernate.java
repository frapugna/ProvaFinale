package hibernateClasses;

import javax.persistence.*;

@Entity
public class VotoHibernate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	long id;
	int valutazione;
	
	public VotoHibernate() {
		super();
	}
	
	public VotoHibernate(int valutazione) {
		super();
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
