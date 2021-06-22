package core;

public abstract class Test {
	String name;
	Esito esito;
	abstract public void run();
	
	public Esito getEsito() {
		return esito;
	}
	public void setEsito(Esito esito) {
		this.esito = esito;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String showResult() {
		return esito.getMessage();
	}
	
}
