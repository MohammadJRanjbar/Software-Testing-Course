package dramaplays;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {

    @Test
    public void testPerformanceConstructor() {
        String playID = "Hamlet";
        int audience = 100;
        Performance performance = new Performance(playID, audience);

        assertEquals(playID, performance.playID);
        assertEquals(audience, performance.audience);
        System.out.println("Performance Constructor Test Passed");
    }

    @Test
    public void testAudienceIncrease() {
        String playID = "Romeo and Juliet";
        int initialAudience = 500;
        Performance performance = new Performance(playID, initialAudience);
        // Simulate an increase in audience
        int additionalAudience = 200;
        performance.audience += additionalAudience;
        assertEquals(initialAudience + additionalAudience, performance.audience);
        System.out.println("Performance Audience Increase Test Passed");
    }


    @Test
    public void testNoNegativeAudience() {
        // Create a Performance object with a negative audience
        Performance performance = new Performance("playID", -100);
        // Check if the audience is not negative
        assertTrue(performance.audience >= 0, "Audience cannot be negative");
    }

    @Test
    public void testZeroAudionce() {
        String playID = "Hamlet";
        int initialAudience = 0;
        Performance performance = new Performance(playID, initialAudience);
        assertTrue(performance.audience >= 0);
    }
}
