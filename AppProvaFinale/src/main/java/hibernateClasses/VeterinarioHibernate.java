package hibernateClasses;

import javax.persistence.*;

@Entity
public class VeterinarioHibernate {
	
	@Id
	EmbeddedIdVeterinario id;
	
	String CF;
	
	public VeterinarioHibernate() {
		super();
	}
	
	public VeterinarioHibernate(String cF, String nome, String cognome) {
		super();
		CF = cF;
		this.id=new EmbeddedIdVeterinario(nome, cognome);
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}
	
	public EmbeddedIdVeterinario getId() {
		return id;
	}

	public void setId(EmbeddedIdVeterinario id) {
		this.id = id;
	}
	
}
