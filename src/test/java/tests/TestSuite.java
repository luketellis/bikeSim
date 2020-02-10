package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ForwardOutOfBoundaryTests.class,
        ForwardTests.class,
        PlaceOutOfBoundsTests.class,
        PlaceInGridTests.class,
        TurnLeftTests.class,
        TurnRightTests.class
})

public class TestSuite {
    //Empty class used as holder for above annotations
}
