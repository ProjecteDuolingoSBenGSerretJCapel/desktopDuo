package desktopDuo.server;

import java.util.ArrayList;

import libDuo.Dao.ICursDAO;
import libDuo.implement.CursImpl;
import libDuo.model.Curs;

public class ServerDesktopDuoImplements implements IServerRMI {

	@Override
	public ArrayList<Curs> obtindreCursos() {
		// TODO Auto-generated method stub
		ICursDAO icmanagerCurs = new CursImpl();
		
		return null;
	}

}
