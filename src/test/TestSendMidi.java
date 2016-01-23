import org.junit.*;
import services.SendMidi;

public class TestSendMidi {
    private static final int MIDDLE_C = 60;

    @Test
    public void test(){
        SendMidi sendMidi = new SendMidi();
        sendMidi.sendToBlofeld();
    }
}
