package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new InMemoryDatabase(); // We probably don't want to access our real database...
        
        // It takes a longtime for RecSys recommender to getRecommendation(), 
        // Since we only wanna test GetRecommendation this function, we can just prefigure the recommender output. 
        // We can also create a fake like what we did to Database, but here we wanna try stubs. 
        // We can create a mock of ReSys, and preconfigure its input and output, using when().thenReturn()
        recommender = mock(RecSys.class);
        // Stubbing the recommender's getRecommendation method
        when(recommender.getRecommendation("Scotty")).thenReturn("Animal House");

        // ths PromoService.class is too complicated, 
        // but we are only using this side class to test the sendPromoEmail(String email) in AndrewWebServices.cslass.
        // We either build a fake or mock this class, obviously the mock would perform better here. 
        promoService = mock(PromoService.class);
        // But we don't want this mock of promoservice to send emails or DO ANYTHING.
        // And we don't need to preconfigure some input or output, since PromoService would take any string and return nothing
        // Maybe we can just leave it there. 

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        // We use a fake to test it, which is a InMemory fake database we created.
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        // We use the prefiguration of a mock of RecSys to customize our input and output of recommender.getRecommendation()
        // which we don't really care here, since we are testing andrewWebService.getRecommendation(). 
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?

        // we use verify() to see if sendEmail() was touched.
        andrewWebService.sendPromoEmail("zelinwan@andrew.cmu.edu");
        // no return value
        verify(promoService).mailTo("zelinwan@andrew.cmu.edu");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?

        andrewWebService.logIn("Scotty", 17214);
        // No email has been in certain situations (like right after logging in)
        // Verify that mailTo() was never called on the mock
        verify(promoService, never()).mailTo(anyString());
    }
}
