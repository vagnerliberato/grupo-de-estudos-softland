package baseConhecimento.dao;

import globalproject.interfaces.InterfaceData;

public class AnalistaDAO implements InterfaceData {

    private static AnalistaDAO analistaDao;

    public AnalistaDAO() {
    }

    public static AnalistaDAO getSingleton() {
        if (AnalistaDAO.analistaDao == null) {
            AnalistaDAO.analistaDao = new AnalistaDAO();
        }

        return AnalistaDAO.analistaDao;
    }

    @Override
    public String insert() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }
}
