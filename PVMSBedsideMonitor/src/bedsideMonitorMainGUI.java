import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import commonFiles.Patient;
import commonFiles.Vital;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class bedsideMonitorMainGUI extends JFrame{

	
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnCallButton = new JButton("Call Button");
	private Timer callTimer = new Timer(500, new Blinker());
	private Timer alarmTimer = new Timer(400, new Alarmer());
	private Timer dataUpdate = new Timer(1000, new Update());
	private bedsideMonitorMainGUI frame = null;
	public Boolean sensors[] = { true, true, true, true, true };
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	protected Patient p = null;
	public HashMap <String, Integer> ranges;
	public BedsideSystemImpl bedside;
	XYSeriesCollection dataset = new XYSeriesCollection();
	
	XYSeries heartRate = new XYSeries("Heart Rate");
	XYSeries bodytemp = new XYSeries("Body Temparture");
	XYSeries resprate = new XYSeries("Respiratory Rate");
	XYSeries bloodpressure = new XYSeries("Blood Pressure");
	XYSeries weight = new XYSeries("Weight");
	int count = 0;
	
	//Timer refresher = new Timer(500, new guiUpdater());
//	private BedsideSystemImpl bedside;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bedsideMonitorMainGUI frame = new bedsideMonitorMainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	

	/**
	 * Create the frame.
	 */
	public bedsideMonitorMainGUI( final BedsideSystemImpl bedside ){
		this.bedside = bedside;
		Font f = new Font("Dialog", Font.PLAIN, 18);
		this.p = bedside.getPatient();
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);  
	   
		JButton btnLog = new JButton("Log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logGUI logGui = null;
				try {
					logGui = new logGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logGui.setAlwaysOnTop(true);
				logGui.setVisible(true);			}
		});
		btnLog.setBounds(370, 9, 135, 57);
		contentPane.add(btnLog);
		
		JButton btnSettings = new JButton("Configuration");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				configurationDialog cfD = new configurationDialog(p, frame);
				cfD.setAlwaysOnTop(true);
				cfD.setVisible(true);
			}
		});
		btnSettings.setBounds(370, 77, 135, 57);
		contentPane.add(btnSettings);
		
		JButton btnCallReset = new JButton("Call Reset ");
		btnCallReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callTimer.stop();
				btnCallButton.setBackground(null);
				btnCallButton.setForeground(Color.BLACK);
			}
		});
		btnCallReset.setBounds(205, 77, 135, 57);
		contentPane.add(btnCallReset);
		
		JButton btnAlarmReset = new JButton("Alarm Reset");
		btnAlarmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				reset();
				getContentPane().setBackground(null);
			}
		});
		btnAlarmReset.setBounds(205, 9, 135, 57);
		contentPane.add(btnAlarmReset);
		
		
		btnCallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {; 
				callTimer.start();
				try {
					bedside.callNurse();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCallButton.setBounds(10, 40, 174, 94);
		contentPane.add(btnCallButton);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(66, 12, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);	
		textField.setText(p.getName());
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setBounds(10, 15, 46, 14);
		contentPane.add(lblPatient);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 190, 34, 4);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(10, 173, 91, 57);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHeartRate = new JLabel("Heart Rate:");
		lblHeartRate.setBounds(10, 145, 104, 20);
		lblHeartRate.setFont(f);
		contentPane.add(lblHeartRate);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 263, 91, 57);
		contentPane.add(textField_2);
		
		JLabel lblBodyTemp = new JLabel("Body Temp");
		lblBodyTemp.setBounds(10, 235, 110, 24);
		lblBodyTemp.setFont(f);
		contentPane.add(lblBodyTemp);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 358, 91, 57);
		contentPane.add(textField_3);
		
		JLabel lblB = new JLabel("Resp. Rate");
		lblB.setBounds(11, 330, 110, 24);
		contentPane.add(lblB);
		lblB.setFont(f);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 448, 91, 57);
		contentPane.add(textField_4);
		
		JLabel lblBloodPress = new JLabel("Blood Press.");
		lblBloodPress.setBounds(10, 426, 110, 18);
		lblBloodPress.setFont(f);
		contentPane.add(lblBloodPress);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 539, 91, 57);
		contentPane.add(textField_5);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(10, 514, 91, 24);
		lblWeight.setFont(f);
		contentPane.add(lblWeight);
			
		final XYDataset dataset = createDataSet();
	    final JFreeChart chart = createChart(dataset);
	    final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(124, 145, 381, 451);
		contentPane.add(chartPanel);
		dataUpdate.start();
		
	}
	
	public void alarm(){
		alarmTimer.start();
	}
	
	public void calling(){
		callTimer.start();
	}
	public void reset(){
		alarmTimer.stop();
		//callTimer.stop();
		frame.getContentPane().setBackground(null);
	}
	public void setSensors( Boolean[] sensors ){
		this.sensors = sensors;
		//System.out.println( sensors[0] + " " + sensors[1] + sensors[2] + " " + sensors[3] + " " + sensors[4]);
		
		if( !sensors[0] ){
			textField_1.setText("N/A");
			textField_1.setHorizontalAlignment(JTextField.CENTER);
		}
		else{
			Vital x = (Vital) (p.getVitals().get("Heart Rate"));
			textField_1.setText( "" + x.getCurrentValue() );
			textField_1.setHorizontalAlignment(JTextField.CENTER);
		}
		if( !sensors[1] ){
			textField_2.setText("N/A");
			textField_2.setHorizontalAlignment(JTextField.CENTER);
		}
		else{
			Vital x = (Vital) (p.getVitals().get("Body Temperature"));
			textField_2.setText( "" + x.getCurrentValue() );
			textField_2.setHorizontalAlignment(JTextField.CENTER);
		}
		if( !sensors[2] ){
			textField_3.setText("N/A");
			textField_3.setHorizontalAlignment(JTextField.CENTER);
		}
		else{
			Vital x = (Vital) (p.getVitals().get("Respiratory Rate"));
			textField_3.setText( "" + x.getCurrentValue() );
			textField_3.setHorizontalAlignment(JTextField.CENTER);
		}
		if( !sensors[3] ){
			textField_4.setText("N/A");
			textField_4.setHorizontalAlignment(JTextField.CENTER);
		}
		else{
			Vital x = (Vital) (p.getVitals().get("Heart Rate"));
			textField_4.setText( "" + x.getCurrentValue() );
			textField_4.setHorizontalAlignment(JTextField.CENTER);
		}
		if( !sensors[4] ){
			textField_5.setText("N/A");
			textField_5.setHorizontalAlignment(JTextField.CENTER);
		}
		else{
			Vital x = (Vital) (p.getVitals().get("Weight"));
			textField_5.setText( "" + x.getCurrentValue() );
			textField_5.setHorizontalAlignment(JTextField.CENTER);
		}
		repaint();
	}
	
	public void setSensorRanges( HashMap <String, Integer> ranges  ){
		this.ranges = ranges;
		/*Iterator<Integer> it = ranges.values().iterator();
		while( it.hasNext()){
			System.out.println(it.next());
		}*/
	}
	
	class Blinker implements ActionListener{
        boolean on=false;
 
        public void actionPerformed(ActionEvent e) {
            // blink the label background on and off
        	btnCallButton.setBackground( on ? Color.BLUE : null);
        	btnCallButton.setForeground( on ? Color.WHITE : Color.BLACK);
            on = !on;
        }
    }
	
	class Alarmer implements ActionListener{
        boolean on=false;
 
        public void actionPerformed(ActionEvent e) {       
        	frame.getContentPane().setBackground( on ? Color.RED : null);
            on = !on;
        }
    }
	class Update implements ActionListener{
        public void actionPerformed(ActionEvent e) {
             updateDisplay();   	
        }
    }
		
	public void updateDisplay(){
		p = bedside.getPatient();
		//ArrayList<Double> value = new ArrayList<Double>();
		Double temp [] = new Double[8];
		
		Vital x = (Vital) (p.getVitals().get("Heart Rate"));	
		textField_1.setText("" + x.getCurrentValue());
		//heartRate.add( (-1*(count%8)), x.getCurrentValue());
		
		if( heartRate.getItemCount() == 8 ){
			for( int size = 0; size < heartRate.getItemCount(); size++ ){
				temp[size] = (Double) heartRate.getY(size);
				System.err.println( temp[size].toString());
			}
			
			for( int pos = 8; pos > 0; pos-- ){
				if( pos != 1 ){
				temp[pos-1] = temp[pos-2];
				}
				else{
					temp[0]=(double) x.getCurrentValue();
				}
			}
			heartRate.clear();
			int counter = 0; 
			for( int y = 0; y < temp.length; y++ ){
				heartRate.add((-1*(counter%8)), temp[y]);
				counter++;
			}
			
		}
		else{
			heartRate.add((-1*(count%8)), x.getCurrentValue());
		}
		
		x = (Vital) (p.getVitals().get("Body Temperature"));
		textField_2.setText("" + x.getCurrentValue() );
		if( bodytemp.getItemCount() == 8 ){
			for( int size = 0; size < bodytemp.getItemCount(); size++ ){
				temp[size] = (Double) bodytemp.getY(size);
				System.err.println( temp[size].toString());
			}
			
			for( int pos = 8; pos > 0; pos-- ){
				if( pos != 1 ){
				temp[pos-1] = temp[pos-2];
				}
				else{
					temp[0]=(double) x.getCurrentValue();
				}
			}
			bodytemp.clear();
			int counter = 0; 
			for( int y = 0; y < temp.length; y++ ){
				bodytemp.add((-1*(counter%8)), temp[y]);
				counter++;
			}
			
		}
		else{
			bodytemp.add((-1*(count%8)), x.getCurrentValue());
		}
		
		x = (Vital) (p.getVitals().get("Respiratory Rate"));
		textField_3.setText("" + x.getCurrentValue());
		if( resprate.getItemCount() == 8 ){
			for( int size = 0; size < resprate.getItemCount(); size++ ){
				temp[size] = (Double) resprate.getY(size);
				System.err.println( temp[size].toString());
			}
			
			for( int pos = 8; pos > 0; pos-- ){
				if( pos != 1 ){
				temp[pos-1] = temp[pos-2];
				}
				else{
					temp[0]=(double) x.getCurrentValue();
				}
			}
			resprate.clear();
			int counter = 0; 
			for( int y = 0; y < temp.length; y++ ){
				resprate.add((-1*(counter%8)), temp[y]);
				counter++;
			}
			
		}
		else{
			resprate.add((-1*(count%8)), x.getCurrentValue());
		}

		
		x = (Vital) (p.getVitals().get("Blood Pressure"));
		textField_4.setText("" + x.getCurrentValue());
		
		if( bloodpressure.getItemCount() == 8 ){
			for( int size = 0; size < bloodpressure.getItemCount(); size++ ){
				temp[size] = (Double) bloodpressure.getY(size);
				System.err.println( temp[size].toString());
			}
			
			for( int pos = 8; pos > 0; pos-- ){
				if( pos != 1 ){
				temp[pos-1] = temp[pos-2];
				}
				else{
					temp[0]=(double) x.getCurrentValue();
				}
			}
			bloodpressure.clear();
			int counter = 0; 
			for( int y = 0; y < temp.length; y++ ){
				bloodpressure.add((-1*(counter%8)), temp[y]);
				counter++;
			}
			
		}
		else{
			bloodpressure.add((-1*(count%8)), x.getCurrentValue());
		}
		
		
		x = (Vital) (p.getVitals().get("Weight"));
		textField_5.setText("" + x.getCurrentValue());
		
		if( weight.getItemCount() == 8 ){
			for( int size = 0; size < weight.getItemCount(); size++ ){
				temp[size] = (Double) weight.getY(size);
				System.err.println( temp[size].toString());
			}
			
			for( int pos = 8; pos > 0; pos-- ){
				if( pos != 1 ){
				temp[pos-1] = temp[pos-2];
				}
				else{
					temp[0]=(double) x.getCurrentValue();
				}
			}
			weight.clear();
			int counter = 0; 
			for( int y = 0; y < temp.length; y++ ){
				weight.add((-1*(counter%8)), temp[y]);
				counter++;
			}
			
		}
		else{
			weight.add((-1*(count%8)), x.getCurrentValue());
		}
		
		
		x = (Vital) (p.getVitals().get("Weight"));
		textField_5.setText("" + x.getCurrentValue());
		
		count++;
		//turn on alarm blinker
		if( bedside.getCurrentStatus().equals("ALARMED")){
	    	alarm();
	    }
	    /*else if( bedside.getCurrentStatus().equals("CALLING")){
	    	calling();	    		
	    }*/
	    else if(  bedside.getCurrentStatus().equals("IDLE")){
	    	reset();	    		
	    }	
		repaint();	
	}
	
	private XYDataset createDataSet(){
		
		heartRate.setMaximumItemCount(9);
		bodytemp.setMaximumItemCount(8);
		resprate.setMaximumItemCount(8);
		bloodpressure.setMaximumItemCount(8);
		weight.setMaximumItemCount(8);
		
       dataset.addSeries(heartRate);
       dataset.addSeries(bodytemp);
       dataset.addSeries(resprate);
       dataset.addSeries(bloodpressure);
       dataset.addSeries(weight);
                
       return dataset;
	}
	
	private JFreeChart createChart(XYDataset dataset) {
		 final JFreeChart chart = ChartFactory.createXYLineChart(
				 	"",
		            "Second",                 // x axis label
		            "Numeric Value",          // y axis label
		            dataset,                  // data
		            PlotOrientation.VERTICAL,
		            true,            
		            true,                    
		            false                    
		 );
		 
		 chart.setBackgroundPaint(Color.white);
		 final XYPlot plot = chart.getXYPlot();
	     plot.setBackgroundPaint(Color.lightGray);
	    
	     plot.setDomainGridlinePaint(Color.white);
	     plot.setRangeGridlinePaint(Color.white);
	        
	     final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	     plot.setRenderer(renderer);

	     // change the auto tick unit selection to integer units only...
	     final NumberAxis domain = (NumberAxis) plot.getDomainAxis();
	     domain.setRange(-8, 0);
	     domain.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	                
	     return chart;
		 
	}
}