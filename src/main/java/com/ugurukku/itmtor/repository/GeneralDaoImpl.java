package com.ugurukku.itmtor.repository;

import com.ugurukku.itmtor.model.entity.custom.RawConsumptionStructureData;
import com.ugurukku.itmtor.model.entity.custom.RawFinancialConditionData;
import com.ugurukku.itmtor.model.entity.custom.RawIncomesData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.ugurukku.itmtor.constants.Queries.*;
import static com.ugurukku.itmtor.util.DbUtil.getConnection;

public class GeneralDaoImpl {

    private final Logger logger;

    private static GeneralDaoImpl INSTANCE;

    private GeneralDaoImpl() {
        logger =  Logger.getLogger(this.getClass().getName());
    }

    public static GeneralDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GeneralDaoImpl();
        }
        return INSTANCE;
    }

    public List<RawIncomesData> getAllIncomesData() {
        logger.info("GeneralDaoImpl.getAllIncomesData.Start..");
        List<RawIncomesData> rawIncomesData = new ArrayList<>();

        try (Connection connection = getConnection()) {
            connection.createStatement().execute("SET SQL_MODE = '';");
            ResultSet resultSet = connection.createStatement().executeQuery(TABLE_INCOMES);
            while (resultSet.next()) {
                rawIncomesData
                    .add(
                        RawIncomesData.builder()
                            .ad(resultSet.getString(1))
                            .ksetir(resultSet.getString(5))
                            .d1(resultSet.getBigDecimal(7))
                            .d2(resultSet.getBigDecimal(8))
                            .d3(resultSet.getBigDecimal(9))
                            .d4(resultSet.getBigDecimal(10))
                            .d5(resultSet.getBigDecimal(11))
                            .req(resultSet.getString(3))
                            .id(resultSet.getString(2))
                            .build()
                    );
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }

        logger.info("GeneralDaoImpl.getAllIncomesData.Finish");
        return rawIncomesData;
    }

    public List<RawFinancialConditionData> getAllFinancialConditionData(){
        logger.info("GeneralDaoImpl.getAllFinancialConditionData.Start..");
        List<RawFinancialConditionData> rawFinancialConditionData = new ArrayList<>();

        try (Connection connection = getConnection()) {
            connection.createStatement().execute("SET SQL_MODE = '';");
            ResultSet resultSet = connection.createStatement().executeQuery(TABLE_FINANCIAL_CONDITION);
            while (resultSet.next()) {
                rawFinancialConditionData
                    .add(
                        RawFinancialConditionData.builder()
                            .ad(resultSet.getString(1))
                            .ksetir(resultSet.getString(5))
                            .d1(resultSet.getBigDecimal(7))
                            .d2(resultSet.getBigDecimal(8))
                            .req(resultSet.getString(3))
                            .id(resultSet.getString(2))
                            .build()
                    );
            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }

        logger.info("GeneralDaoImpl.getAllFinancialConditionData.Finish");
        return rawFinancialConditionData;
    }

    public List<RawConsumptionStructureData> getAllRawConsumptionStructureData(){
        logger.info("GeneralDaoImpl.getAllRawConsumptionStructureData.Start..");
        List<RawConsumptionStructureData> rawConsumptionStructureData = new ArrayList<>();

        try (Connection connection = getConnection()) {
            connection.createStatement().execute("SET SQL_MODE = '';");
            ResultSet resultSet = connection.createStatement().executeQuery(TABLE_CONSUMPTION_STRUCTURE);
            while (resultSet.next()) {
                rawConsumptionStructureData
                    .add(
                        RawConsumptionStructureData.builder()
                            .ad(resultSet.getString(1))
                            .ksetir(resultSet.getString(2))
                            .d1(resultSet.getString(3))
                            .d2(resultSet.getString(5))
                            .d3(resultSet.getString(4))
                            .d4(resultSet.getString(6))
                            .build()
                    );
            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }

        logger.info("GeneralDaoImpl.getAllRawConsumptionStructureData.Finish");
        return rawConsumptionStructureData;
    }


}
