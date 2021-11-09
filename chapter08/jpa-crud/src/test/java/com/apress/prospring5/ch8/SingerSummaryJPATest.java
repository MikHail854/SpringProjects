package com.apress.prospring5.ch8;

import com.apress.prospring5.ch8.config.JpaConfig;
import com.apress.prospring5.ch8.service.SingerSummaryService;
import com.apress.prospring5.ch8.service.SingerSummaryUntypeImpl;
import com.apress.prospring5.ch8.view.SingerSummary;
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


public class SingerSummaryJPATest {

    private static Logger logger = LoggerFactory.getLogger(SingerSummaryJPATest.class);
    private GenericApplicationContext context;
    private SingerSummaryUntypeImpl singerSummaryUntype;
    private SingerSummaryService singerSummaryService;


    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(JpaConfig.class);
        singerSummaryUntype = context.getBean(SingerSummaryUntypeImpl.class);
        singerSummaryService = context.getBean(SingerSummaryService.class);
        assertNotNull(singerSummaryUntype);
        assertNotNull(singerSummaryService);
    }

    @Test
    public void testFindAll() {
        List<SingerSummary> singers = singerSummaryService.findAll();
        listSingerSummary(singers);
        assertEquals(2, singers.size());
    }

    private static void listSingerSummary(List<SingerSummary> singers) {
        logger.info("---- Listing singers summary:");
        for (SingerSummary singer : singers) {
            logger.info(singer.toString());
        }
    }


    @Test
    public void testFindAllUntype() {
        singerSummaryUntype.displayAllSingerSummary();
    }


    @After
    public void tearDown() {
        context.close();
    }

}
