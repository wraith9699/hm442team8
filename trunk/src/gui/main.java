package gui;

import commonFiles.Patient;
import commonFiles.Vital;


public class main {
	public static void main(String args[] ){
				
		Patient p = new Patient("Tom", "1");
		
		
	
		
		bedsideMonitorMainGUI b = new bedsideMonitorMainGUI(p);
		b.setVisible(true);
		
	}

}
