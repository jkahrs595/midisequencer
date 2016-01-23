package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MakeSound {
    private static final Logger LOG = LogManager.getLogger(MakeSound.class.getName());

    public void testSound(){
        Synthesizer synthesizer = null;
        MidiChannel[] channels;
        MidiChannel channel;

        try{
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
        }catch (MidiUnavailableException ex){
            LOG.error(ex);
        }
        channels = synthesizer.getChannels();
        channel = channels[0];
        for (int i = 30; i < 100; i++){
            channel.noteOn(i, 127);
            try {
                Thread.sleep(100);
            }catch (Exception e){}
            channel.noteOff(i);
        }



    }
}
