import java.awt.event.*;

import javax.sound.midi.*;
import javax.swing.*;

public class TestMidi {

	public static void main(String[] args) {  
		Synthesizer synth;
		try {
			synth = MidiSystem.getSynthesizer();
			synth.open();
			final MidiChannel[] mc = synth.getChannels();
			Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
			synth.loadInstrument(instr[90]);
			
			JFrame frame = new JFrame("Sound1");                
			JPanel pane = new JPanel();                         
			JButton button1 = new JButton("jouer");            
			JButton button2 = new JButton("arrêter");            
			frame.getContentPane().add(pane);                   
			pane.add(button1);
			pane.add(button2); 
			frame.pack();                                       
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.show();
			
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					mc[5].noteOn(60, 127);
				}
			});
			
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					mc[5].noteOff(60, 127);
				}
			});
			
			
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
		
	}

}