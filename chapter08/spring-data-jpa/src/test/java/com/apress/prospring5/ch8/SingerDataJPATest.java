package com.apress.prospring5.ch8;

import com.apress.prospring5.ch8.config.DataJpaConfig;
import com.apress.prospring5.ch8.entities.Singer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class SingerDataJPATest {

    private static Logger logger = LoggerFactory.getLogger(SingerDataJPATest.class);

    private GenericApplicationContext context;
    private SingerService singerService;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        singerService = context.getBean(SingerService.class);
        assertNotNull(singerService);
    }


    @Test
    public void testFindAll() {
        List<Singer> singers = singerService.findAll();
        assertTrue(singers.size() > 0);
        listSingers(singers);
    }

    @Test
    public void testFindAllByFirstName() {
        List<Singer> singers = singerService.findByFirstName("John");
        assertTrue(singers.size() > 0);
        assertEquals(2, singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindAllFirstNameAndLastName() {
        List<Singer> singers = singerService.finsByFirstNameAndLastName("John", "Mayer");
        assertTrue(singers.size() > 0);
        assertEquals(1, singers.size());
        listSingers(singers);
    }

    public static void listSingers(List<Singer> singers) {
        logger.info("---- Listing singers:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
        }
    }

    @After
    public void tearDown() {
        context.close();
    }


}
