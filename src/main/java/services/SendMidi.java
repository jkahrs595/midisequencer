package services;

import com.sun.media.sound.MidiOutDeviceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.midi.*;

public class SendMidi {
    private static final Logger LOG = LogManager.getLogger(SendMidi.class.getName());
    private static final int MIDDLE_C = 60;

    public void sendNotes(int channel, int note, int velocity){
        Receiver receiver = null;
        ShortMessage message = new ShortMessage();
        long timeStamp = -1;
        try {
            receiver = MidiSystem.getReceiver();
            message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
            receiver.send(message,timeStamp);
            Thread.sleep(5000);
        }catch (InvalidMidiDataException | MidiUnavailableException | InterruptedException ex){
            LOG.error(ex);
        }
        finally {
            receiver.close();
        }





    }

}
