package com.apress.prospring5.ch8;

import com.apress.prospring5.ch8.config.JpaConfig;
import com.apress.prospring5.ch8.entities.Album;
import com.apress.prospring5.ch8.entities.Instrument;
import com.apress.prospring5.ch8.entities.Singer;
import com.apress.prospring5.ch8.service.SingerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SingerJPATest {

    private static Logger logger = LoggerFactory.getLogger(SingerJPATest.class);

    private GenericApplicationContext context;
    private SingerService singerService;


    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(JpaConfig.class);
        singerService = context.getBean(SingerService.class);
        assertNotNull(singerService);
    }


    @Test
    public void testFindById(){
        Singer singer = singerService.findById(1L);
        assertNotNull(singer);
        logger.info(singer.toString());
    }



    @Test
    public void testFindAllWithAlbum() {
        List<Singer> singers = singerService.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info("---- Listing singers with instruments:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    logger.info("\t" + album.toString());
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument : singer.getInstruments()) {
                    logger.info("\tInstrument: " + instrument.getInstrumentId());
                }
            }
        }
    }


    @Test
    public void testFindAll() {
        List<Singer> singers = singerService.findAll();
        assertEquals(3, singers.size());
        listSingers(singers);
    }

    private static void listSingers(List<Singer> singers) {
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
