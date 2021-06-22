package jdbcClasses;

import java.util.ArrayList;
import java.util.List;

public class GattoJDBC {
	long id;
	String nome;
	String colore;
	List<VeterinarioJDBC> veterinari;
	public GattoJDBC(long id, String nome, String colore) {
		super();
		this.id = id;
		this.nome = nome;
		this.colore = colore;
		this.veterinari=new ArrayList<VeterinarioJDBC>();
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

	public List<VeterinarioJDBC> getVeterinari() {
		return veterinari;
	}

	public void setVeterinari(List<VeterinarioJDBC> veterinari) {
		this.veterinari = veterinari;
	}
	
	public void addVeterinario(VeterinarioJDBC in) {
		this.veterinari.add(in);
	}
	
	
}
