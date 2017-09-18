package dao;

import model.Loads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SergLion on 11.03.2017.
 */
public class LoadsDAOImp extends CrudDAO<Loads>{


    private static LoadsDAOImp loadsDAOImp;

    private static final String INSERT_LOADS= "INSERT INTO `libra_test`.`loads` (`time`, `load`) VALUES (?, ?);";
    private static final String UPDATE_LOADS = "UPDATE `libra_test`.`loads` SET `time` = ?, `load` = ? WHERE `id` = ?;";


    private LoadsDAOImp(Class<Loads> type) {
        super(type);
    }

    public static synchronized LoadsDAOImp getInstanse() {
        if (loadsDAOImp == null) {
            loadsDAOImp = new LoadsDAOImp(Loads.class);
        }
        return loadsDAOImp;
    }

    protected List<Loads> readAll(ResultSet resultSet) throws SQLException {

        List<Loads> result = new ArrayList<>();
        Loads loads = null;
        while (resultSet.next()) {
            loads = new Loads();
            loads.setId(resultSet.getInt("id"));
            loads.setTime(resultSet.getInt("time"));
            loads.setLoad(resultSet.getString("load"));
            result.add(loads);

        }
        return result;
    }

    protected PreparedStatement createInsertStatement(Connection connection, Loads entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOADS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getTime());
        preparedStatement.setString(2, entity.getLoad());
        return preparedStatement;
    }

    protected PreparedStatement createUpdateStatement(Connection connection, Loads entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOADS);
        preparedStatement.setInt(1, entity.getTime());
        preparedStatement.setString(2, entity.getLoad());
        preparedStatement.setInt(3, entity.getId());
        return preparedStatement;
    }

}
