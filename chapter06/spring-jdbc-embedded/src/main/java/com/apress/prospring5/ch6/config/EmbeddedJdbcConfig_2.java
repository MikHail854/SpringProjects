package com.apress.prospring5.ch6.config;

import com.apress.prospring5.ch6.JdbcSingerDao_2;
import com.apress.prospring5.ch6.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class EmbeddedJdbcConfig_2 {

    private static Logger logger = LoggerFactory.getLogger(EmbeddedJdbcConfig_2.class);

    @Bean
    public DataSource dataSource(){
        try{
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            //EmbeddedJdbcConfig dbBuilder = new EmbeddedJdbcConfig();
            return dbBuilder.setType(EmbeddedDatabaseType.H2).addScripts("classpath:db/h2/schema.sql",
                    "classpath:db/h2/test-data.sql").build();
        } catch (Exception e){
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public SingerDao singerDao(){
        JdbcSingerDao_2 dao = new JdbcSingerDao_2();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
