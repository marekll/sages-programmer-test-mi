package com.company;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class DominoTest {
    @Test
    public void testDomino() {
        assertEquals (Domino.getReverseIterationResults ("||////\\\\\\|////|",2), "||//||||\\|//|||");
        assertEquals(Domino.getIterationResult("||//||\\||/\\|",1), "||///\\\\||/\\|");

    }

}
