package com.apress.prospring5.ch7;

import com.apress.prospring5.ch7.config.AppConfig;
import com.apress.prospring5.ch7.dao.SingerDao;
import com.apress.prospring5.ch7.entities.Album;
import com.apress.prospring5.ch7.entities.Instrument;
import com.apress.prospring5.ch7.entities.Singer;
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

public class SingerDaoTest {

    private static Logger logger = LoggerFactory.getLogger(SingerDaoTest.class);

    private GenericApplicationContext context;
    private SingerDao singerDao;


    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = context.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }

    @Test
    public void testUpdate(){
        Singer singer = singerDao.findById(1L);

        //убедиться, что такой певец существует
        assertNotNull(singer);

        //убедиться, что получен ожидаемый певец
        assertEquals("Mayer", singer.getLastName());

        //извлечь альбом
        Album album = singer.getAlbums().stream().filter(a -> a.getTitle()
                .equals("Battle Studies"))
                .findFirst()
                .get();

        singer.setFirstName("John Clayton");
        singer.removeAlbum(album);
        singerDao.save(singer);

        //проверить обновление
        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    @Test
    public void testInsert() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date((new GregorianCalendar(1910, 8, 16)).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new Date((new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date((new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.save(singer);
        assertNotNull(singer.getId());

        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(4, singers.size());
        listSingersWithAlbum(singers);
    }


    @Test
    public void findAll() {
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());
        listSingers(singers);
    }

    @Test
    public void findAllWithAlbum(){
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void findById(){
        Singer singer = singerDao.findById(1L);
        assertNotNull(singer);
        logger.info(singer.toString());

    }


    private void listSingers(List<Singer> singers) {
        logger.info("-----------Listing singers:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
        }

    }


    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info("-----------Listing singers with instruments:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    logger.info("\t" + album.toString());
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument : singer.getInstruments()) {
                    logger.info("\t" + instrument.getInstrumentId());
                }
            }

        }
    }

    @After
    public void tearDown(){
        context.close();
    }

}
