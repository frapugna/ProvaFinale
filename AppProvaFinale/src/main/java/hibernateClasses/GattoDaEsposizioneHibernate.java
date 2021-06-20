package hibernateClasses;

import java.util.List;

public class GattoDaEsposizioneHibernate extends GattoHibernate{
	String razza;
	List<VotoHibernate> valutazioni;
	
	public GattoDaEsposizioneHibernate() {
		super();
	}
}
