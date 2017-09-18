
import dao.DaoFactory;
import dao.LoadsDAOImp;
import model.Loads;

/**
 * Created by SergLion on 12.03.2017.
 */
public class Main {
    public static void main(String[] args) {

        LoadsDAOImp loadsDAOImp = (LoadsDAOImp) DaoFactory.getInstance().getLoadsDao();

       /* for (int i = 0; i < 10; i++) {
            Loads loads = new Loads();
            loads.setTime(i + 1);
            String l = String.valueOf((10 + (5 * i)));
            loads.setLoad(l);
            loadsDAOImp.save(loads);
        }*/


        System.out.println(DaoFactory.getInstance().getLoadsDao().getAll());
        System.out.println("--------------------------");

        System.out.println(loadsDAOImp.getById(1));
    }
}
