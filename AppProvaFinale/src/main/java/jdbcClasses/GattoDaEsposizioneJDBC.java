package jdbcClasses;

public class GattoDaEsposizioneJDBC extends GattoJDBC{
	String razza;
	VotoJDBC valutazione;
	public GattoDaEsposizioneJDBC(long id, String nome, String colore,String razza, VotoJDBC valutazione) {
		super(id,nome,colore);
		this.razza = razza;
		this.valutazione = valutazione;
	}
	public String getRazza() {
		return razza;
	}
	public void setRazza(String razza) {
		this.razza = razza;
	}
	public VotoJDBC getValutazione() {
		return valutazione;
	}
	public void setValutazione(VotoJDBC valutazione) {
		this.valutazione = valutazione;
	}
	
	
}
