package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HomePageTest {

    @Mock
    private Model model;

    @InjectMocks
    private HomePage homePage;

    @Test
    void testGetHomePage() {
        String viewName = homePage.getHomePage(model);
        assertEquals("HomePage", viewName);
    }
}