package com.ugurukku.itmtor.repository;

import com.ugurukku.itmtor.model.dto.IncomesDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.ugurukku.itmtor.util.DbUtil.getConnection;

public class IncomesDaoImpl {

    private final Logger logger;

    private static IncomesDaoImpl INSTANCE;

    private IncomesDaoImpl() {
        logger =  Logger.getLogger(this.getClass().getName());
    }

    public static IncomesDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IncomesDaoImpl();
        }
        return INSTANCE;
    }

    public List<IncomesDto> getAllIncomes() {
        logger.info("IncomesDaoImpl.getAllIncomes.Start..");
        List<IncomesDto> incomesDtos = new ArrayList<>();

        try (Connection connection = getConnection()) {
            ResultSet resultSet = connection.createStatement()
                    .executeQuery("select t.ksetir,sum(t.d1) as d1, sum(t.d2) as d2, sum(t.d3) as d3, sum(t.d4) as d4, sum(t.d5) as d5\n" +
                            "from tr_2022 t\n" +
                            "where t.ksetir >= 100 AND t.ksetir <= 125\n" +
                            "group by t.ksetir");
            while (resultSet.next()) {
                incomesDtos.add(
                        IncomesDto.builder()
                                .row(resultSet.getString(1))
                                .column1(resultSet.getBigDecimal(2))
                                .column2(resultSet.getBigDecimal(3))
                                .column3(resultSet.getBigDecimal(4))
                                .column4(resultSet.getBigDecimal(5))
                                .column5(resultSet.getBigDecimal(6))
                                .build()
                );
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }

        logger.info("IncomesDaoImpl.getAllIncomes.Finish");
        return incomesDtos;
    }

}
