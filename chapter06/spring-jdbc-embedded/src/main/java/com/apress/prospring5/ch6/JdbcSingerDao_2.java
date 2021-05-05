package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.entities.Singer;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcSingerDao_2 implements SingerDao, InitializingBean {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject("select first_name || ' ' || " +
                "last_name from musicdb_schema.singer where id = ?", new Object[]{id}, String.class);
    }



    //@Override
    public void insert(Singer singer) {
        throw new NotImplementedException("insert");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null){
            throw new BeanCreationException("Must set jdbcTemplate on SingerDao");
        }
    }
}
