package com.apress.prospring5.ch4.config;

import com.apress.prospring5.ch4.FoodProviderService;
import org.springframework.beans.factory.annotation.Autowired;

@ActiveProfiles("kindergarten")
public class ProfilesJavaConfigTest {
    @Autowired
    FoodProviderService foodProviderService;

    @Test
    public void testProvider(){
        assertTrue(foodProviderService.provideLunchSet() != null);
        assertFalse(foodProviderService.provideLunchSet().isEmpty());
        assertEquals(2, foodProviderService.provideLunchSet().size());
    }
}
