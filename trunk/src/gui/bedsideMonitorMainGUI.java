package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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

	
	private JPanel contentPane, vitalPanel;
	private JTextField textField;
	private JButton btnCallButton = new JButton("Call Button");
	private Timer callTimer = new Timer(500, new Blinker());
	private Timer alarmTimer = new Timer(400, new Alarmer());
	private bedsideMonitorMainGUI frame = null;
	public Boolean sensors[] = { true, true, true, true, true };
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
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
	public bedsideMonitorMainGUI( final Patient p ){
		//this.bedside = bedside;
		//bedside = null;
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		final XYDataset dataset = createDataSet();
	    final JFreeChart chart = createChart(dataset);
	    final ChartPanel chartPanel = new ChartPanel(chart);
	    //chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	    
	   
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
				alarmTimer.stop();
				getContentPane().setBackground(null);
			}
		});
		btnAlarmReset.setBounds(205, 9, 135, 57);
		contentPane.add(btnAlarmReset);
		
		
		btnCallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {; 
				callTimer.start();
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
		//refresher.start();
		vitalPanel = new JPanel();
		vitalPanel.setBackground(Color.white);
		vitalPanel.setBounds(10,237,495,365);
		contentPane.add(vitalPanel);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(20, 148, 86, 78);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(116, 148, 86, 78);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(212, 148, 86, 78);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(308, 148, 86, 78);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(404, 148, 86, 78);
		contentPane.add(textField_5);
		chartPanel.setPreferredSize( new java.awt.Dimension(510,365));
		//vitalPanel.add(chartPanel);
		
				
	}
	
	public void alarm(){
		alarmTimer.start();
	}
	
	public void setSensors( Boolean[] sensors ){
		this.sensors = sensors;
		//System.out.println( sensors[0] + " " + sensors[1] + sensors[2] + " " + sensors[3] + " " + sensors[4]);
		
		if( !sensors[0] ){
			textField_1.setText("N/A");
		}
		if( !sensors[1] ){
			textField_2.setText("N/A");
		}
		if( !sensors[2] ){
			textField_3.setText("N/A");
		}
		if( !sensors[3] ){
			textField_4.setText("N/A");
		}
		if( !sensors[4] ){
			textField_5.setText("N/A");
		}
		repaint();
	}
	private JFreeChart createChart(XYDataset dataset) {
		 final JFreeChart chart = ChartFactory.createXYLineChart(
		            "Line Chart Demo 6",      // chart title
		            "X",                      // x axis label
		            "Y",                      // y axis label
		            dataset,                  // data
		            PlotOrientation.VERTICAL,
		            true,                     // include legend
		            true,                     // tooltips
		            false                     // urls
		        );
		 chart.setBackgroundPaint(Color.white);
		 final XYPlot plot = chart.getXYPlot();
	        plot.setBackgroundPaint(Color.lightGray);
	    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
	        plot.setDomainGridlinePaint(Color.white);
	        plot.setRangeGridlinePaint(Color.white);
	        
	        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesLinesVisible(0, false);
	        renderer.setSeriesShapesVisible(1, false);
	        plot.setRenderer(renderer);

	        // change the auto tick unit selection to integer units only...
	        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	        // OPTIONAL CUSTOMISATION COMPLETED.
	                
	        return chart;
		 
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
            // blink the label background on and off
        	//btnCallButton.setBackground(null);
			//btnCallButton.setForeground(Color.BLACK);
        	getContentPane().setBackground( on ? Color.RED : null);
            on = !on;
        }
    }
	
	
	private XYDataset createDataSet(){
		final XYSeries series1 = new XYSeries("First");
        series1.add(1.0, 1.0);
        series1.add(2.0, 4.0);
        series1.add(3.0, 3.0);
        series1.add(4.0, 5.0);
        series1.add(5.0, 5.0);
        series1.add(6.0, 7.0);
        series1.add(7.0, 7.0);
        series1.add(8.0, 8.0);

        final XYSeries series2 = new XYSeries("Second");
        series2.add(1.0, 5.0);
        series2.add(2.0, 7.0);
        series2.add(3.0, 6.0);
        series2.add(4.0, 8.0);
        series2.add(5.0, 4.0);
        series2.add(6.0, 4.0);
        series2.add(7.0, 2.0);
        series2.add(8.0, 1.0);

        final XYSeries series3 = new XYSeries("Third");
        series3.add(3.0, 4.0);
        series3.add(4.0, 3.0);
        series3.add(5.0, 2.0);
        series3.add(6.0, 3.0);
        series3.add(7.0, 6.0);
        series3.add(8.0, 3.0);
        series3.add(9.0, 4.0);
        series3.add(10.0, 3.0);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
                
        return dataset;
		
	}
}