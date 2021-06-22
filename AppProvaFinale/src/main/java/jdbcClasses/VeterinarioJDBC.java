package jdbcClasses;

public class VeterinarioJDBC {
	String nome;
	String cognome;
	String CF;
	public VeterinarioJDBC(String nome, String cognome, String cF) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		CF = cF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	
	
}
