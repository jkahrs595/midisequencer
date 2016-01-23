import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestMakeSound {
    private static final Logger LOG = LogManager.getLogger(MakeSound.class.getName());

    @Test
    public void test(){
        MakeSound ms = new MakeSound();
        ms.testSound();
    }
}
