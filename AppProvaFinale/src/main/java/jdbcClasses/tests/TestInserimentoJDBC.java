package jdbcClasses.tests;

import java.sql.SQLException;
import java.util.Random;

import core.Esito;
import core.Test;
import jdbcClasses.GattoJDBC;
import jdbcClasses.JDBCManager;
import jdbcClasses.VeterinarioJDBC;


public class TestInserimentoJDBC extends Test{
	
	private void storeCat(GattoJDBC gatto, VeterinarioJDBC veterinario) {
		try {
			JDBCManager.executeUpdateMysql("INSERT INTO `testdbjdbc`.`gatto` (`id`, `colore`, `nome`) VALUES ('"+gatto.getId()+"', '"+gatto.getColore()+"', '"+gatto.getNome()+"');");
			JDBCManager.executeUpdateMysql("INSERT INTO `testdbjdbc`.`cattovet` (`nome`, `cognome`, `id_gatto`) VALUES ('"+veterinario.getNome()+"', '"+veterinario.getCognome()+"', '"+gatto.getId()+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		Random r = new Random();
		VeterinarioJDBC[] veterinari = {
				new VeterinarioJDBC("Mario", "Rossi","PFKPFKFP1212"),
				new VeterinarioJDBC("Laura", "Bianchi","PFLSKSKFP1212"), 
				new VeterinarioJDBC("Sam", "Bucket","BKBKBKBKFP1212")
		};
		String[] colori = {"Rosso", "Bianco", "Nero"};
		long start = System.nanoTime();

		for(VeterinarioJDBC v:veterinari) {
			try {
				JDBCManager.executeUpdateMysql("INSERT INTO `testdbjdbc`.`veterinario` (`nome`, `cognome`, `CF`) VALUES ('"+ v.getNome()+"', '"+v.getCognome()+"', '"+v.getCF()+"');");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i<1000; ++i) {
				storeCat(new GattoJDBC(i, Integer.toString(i), colori[r.nextInt(3)]),veterinari[r.nextInt(3)]);
		}



		long end = System.nanoTime(); 
		//		System.out.println("Tempo esecuz: " + (end-start)/1000000 + "ms");
		setEsito(new Esito("Test inserimento valori JDBC in mysql:"+(end-start)/1000000 + "ms; Valori inseriti: 1000" ));

	}

}
