package hibernateClasses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class GattoHibernate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	long id;
	String nome;
	String colore;
	
	@JoinTable(name = "catToVet")
	@ManyToMany(cascade = CascadeType.ALL)
	List<VeterinarioHibernate> veterinari;
	
	public GattoHibernate() {
		super();
	}
	
	public GattoHibernate(String nome, String colore) {
		super();
		this.nome = nome;
		this.colore = colore;
		this.veterinari=new ArrayList<VeterinarioHibernate>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public List<VeterinarioHibernate> getVeterinari() {
		return veterinari;
	}

	public void setVeterinari(List<VeterinarioHibernate> veterinari) {
		this.veterinari = veterinari;
	}
	
	public void addVeterinario(VeterinarioHibernate in) {
		this.veterinari.add(in);
	}

	@Override
	public String toString() {
		return "GattoHibernate [id=" + id + ", nome=" + nome + ", colore=" + colore + ", veterinari=" + veterinari
				+ "]";
	}	
}
