package dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTest {

    @Test
    public void testPlayCreation() {
        String playName = "Hamlet";
        String playType = "Tragedy";
        Play play = new Play(playName, playType);

        assertEquals(playName, play.name);
        assertEquals(playType, play.type);
    }

    @Test
    public void testDifferentPlayType() {
        String playName = "Romeo and Juliet";
        String playType = "Romantic Tragedy";
        Play play = new Play(playName, playType);

        assertEquals(playType, play.type);
    }
}
