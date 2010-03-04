import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;


public class DrawSound {
	
	
	 public void play(int pitch){
		    MidiChannel channel = null;
		    Synthesizer synthesizer = null;
		    try {
		    	if( synthesizer == null){
		    	      synthesizer = MidiSystem.getSynthesizer();
		    	      synthesizer.open();

		    	      Soundbank soundbank = synthesizer.getDefaultSoundbank();

		    	      Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();
		    	      synthesizer.loadInstrument(instruments[0]);
		    	}

		    	      channel = synthesizer.getChannels()[0];

		    //	      System.out.println("Play pitch:48 velocity:127");
		    	      channel.noteOn( pitch, 1000);
		    	      Thread.currentThread().sleep(30);
		    	      channel.noteOff(1);
		    	      System.out.println(pitch);

//		    	      synthesizer.close();
		    	    } catch(Exception e){
		    	      if(channel != null)  channel.allNotesOff();
		    	    }
//		    	    System.exit(0);
		    	  }

	 }

