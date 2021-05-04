package com.apress.prospring5.ch6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DbConfigTest {

    private static Logger logger = LoggerFactory.getLogger(DbConfigTest.class);

    public void testOne() throws SQLException{
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/drivermanager-cfg-01.xml");
        ctx.refresh();

        DataSource dataSource =ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
    }

    private void testDataSource(DataSource dataSource) throws SQLException{
        Connection connection = null;

        try{
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int mockVal = resultSet.getInt("1");
                assertTrue(mockVal == 1);
            }
            statement.close();
        } catch (Exception e){
            logger.debug("Something unexpected happened.", e);
        } finally {
            if (connection != null){
                connection.close();
            }
        }
    }


}
