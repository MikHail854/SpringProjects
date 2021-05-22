package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.entities.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class JdbcSingerDao implements SingerDao, InitializingBean {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Singer> findAll(){
        String sql = "select  musicdb_schema.singer.id, " +
                "musicdb_schema.singer.first_name, musicdb_schema.singer.last_name, " +
                "musicdb_schema.singer.birth_date from musicdb_schema.singer";
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> {
            Singer singer = new Singer();
            singer.setId(rs.getLong("id"));
            singer.setFirstName(rs.getString("first_name"));
            singer.setLastName(rs.getString("last_name"));
            singer.setBirthDate(rs.getDate("birth_date"));
            return singer;
        });
    }

    /*private static final class SingerMapper implements RowMapper<Singer>{

        @Override
        public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Singer singer = new Singer();
            singer.setId(rs.getLong("id"));
            singer.setFirstName(rs.getString("first_name"));
            singer.setLastName(rs.getString("last_name"));
            singer.setBirthDate(rs.getDate("birth_date"));
            return singer;
        }
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        if (namedParameterJdbcTemplate == null){
            throw new BeanCreationException("Null NamedParameterJdbcTemplate on SingerDao");
        }
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

}
