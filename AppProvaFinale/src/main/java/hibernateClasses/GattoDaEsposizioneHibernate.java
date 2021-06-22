package hibernateClasses;

import javax.persistence.*;

@Entity
public class GattoDaEsposizioneHibernate extends GattoHibernate{
	String razza;

	@OneToOne(cascade = CascadeType.ALL)
	VotoHibernate valutazione;
	
	public GattoDaEsposizioneHibernate() {
		super();
	}
	
	public GattoDaEsposizioneHibernate(String nome, String colore, String razza, VotoHibernate valutazione) {
		super(nome,colore);
		this.razza = razza;
		this.valutazione = valutazione;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public VotoHibernate getValutazione() {
		return valutazione;
	}

	public void setValutazione(VotoHibernate valutazione) {
		this.valutazione = valutazione;
	}

}
