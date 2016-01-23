package services;

import com.sun.media.sound.MidiOutDeviceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.midi.*;
import java.util.Vector;

public class SendMidi {
    private static final Logger LOG = LogManager.getLogger(SendMidi.class.getName());
    private static final int MIDDLE_C = 60;


    public void sendToBlofeld(){

        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        ShortMessage myMsg = new ShortMessage();
        long timeStamp = 2;


        for (int i = 0; i < infos.length; i++) {
            try {
                MidiDevice device = MidiSystem.getMidiDevice(infos[i]);
                myMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 127);

                if (device.getMaxReceivers() != 0 && device.getDeviceInfo().getName().equalsIgnoreCase("blofeld")){
                    device.open();
                    device.getReceiver().send(myMsg, timeStamp);

                    Thread.sleep(5000);
                    myMsg.setMessage(ShortMessage.NOTE_OFF, 0, 60, 127);
                    device.getReceiver().send(myMsg, timeStamp);
                    //device.close();
                }
            }catch (MidiUnavailableException | InvalidMidiDataException | InterruptedException ex){}

        }

    }

}
