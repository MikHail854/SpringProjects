package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.entities.Singer;

import java.util.List;

public interface SingerDao {
    String findNameById(Long id);
    List<Singer> findAll();
}
