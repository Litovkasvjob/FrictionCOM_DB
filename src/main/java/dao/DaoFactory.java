package dao;

import holder.PropertyHolder;
import model.Loads;


/**
 * Created by SergLion on 11.03.2017.
 */
public class DaoFactory {

    private static DaoFactory daoFactory = null;

    private Dao<Integer, Loads> loadsDao;

    private DaoFactory() {
        loadDAOs();
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    private void loadDAOs() {
        if (PropertyHolder.getInstanse().isInMemoryDB()) {

        } else {
            loadsDao = LoadsDAOImp.getInstanse();

        }
    }

    public Dao<Integer, Loads> getLoadsDao() {
        return loadsDao;
    }

    public void setLoadsDao(Dao<Integer, Loads> loadsDao) {
        this.loadsDao = loadsDao;
    }
}
