package desktopDuo.server;

import java.util.ArrayList;

import libDuo.Dao.ICursDAO;
import libDuo.implement.CursImpl;
import libDuo.model.Curs;

public class ServerDesktopDuoImplements implements IServerRMI {

	@Override
	public ArrayList<String> obtindreCursos() {
		// TODO Auto-generated method stub
		ICursDAO icmanagerCurs = new CursImpl();
		System.out.println("Conexio exitosa");
		ArrayList<String> aS = new ArrayList<String>();
		ArrayList<Curs> aC = new ArrayList<Curs>();
		aC = icmanagerCurs.getAllCursos();
		for (Curs curs : aC) {
			aS.add(curs.getIdiomaOrigen().getIdioma()+" - "+curs.getIdiomaDesti().getIdioma());
		}
		return aS;
	}

}
