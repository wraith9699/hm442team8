


import javax.swing.*;

import commonFiles.Patient;
import commonFiles.Vital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class configurationDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Boolean sensor[] = { true, true, true, true, true } ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			configurationDialog dialog = new configurationDialog(p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public configurationDialog( final Patient p, final bedsideMonitorMainGUI monitor ) {
		sensor = monitor.sensors;
		System.out.println(p.getName());
		setBounds(100, 100, 449, 509);
		setResizable(false);
		getContentPane().setLayout(null);
		{
			final JButton btnHeartRate = new JButton("ENABLED");
			btnHeartRate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if( btnHeartRate.getText() == "ENABLED" ){
						btnHeartRate.setBackground(Color.RED);
						btnHeartRate.setText("DISABLED");
						sensor[0] = false;
					}
					else if( btnHeartRate.getText() == "DISABLED"){
						btnHeartRate.setBackground(Color.GREEN);
						btnHeartRate.setText("ENABLED");
						sensor[0] = true;
					}
				}
			});
			btnHeartRate.setBackground(Color.GREEN);
			if( !monitor.sensors[0] ){
				btnHeartRate.setBackground(Color.RED);
				btnHeartRate.setText("DISABLED");
			}
			btnHeartRate.setBounds(175, 47, 130, 61);
			getContentPane().add(btnHeartRate);
			
		}
		
		Font f = new Font("Dialog", Font.PLAIN, 18);
		
		JLabel lblHeartRate = new JLabel("Heart Rate:");
		lblHeartRate.setBounds(14, 47, 121, 61);
		lblHeartRate.setFont(f);
		getContentPane().add(lblHeartRate);
		
		JLabel lblBodyTemperature = new JLabel("Body Temperature:");
		lblBodyTemperature.setBounds(14, 113, 165, 59);
		lblBodyTemperature.setFont(f);
		getContentPane().add(lblBodyTemperature);
		
		JLabel lblRespiratoryRate = new JLabel("Respiratory Rate:");
		lblRespiratoryRate.setBounds(14, 183, 165, 63);
		lblRespiratoryRate.setFont(f);
		getContentPane().add(lblRespiratoryRate);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		lblBloodPressure.setBounds(14, 257, 149, 61);
		lblBloodPressure.setFont(f);
		getContentPane().add(lblBloodPressure);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(14, 329, 121, 61);
		lblWeight.setFont(f);
		getContentPane().add(lblWeight);
		
		final JButton btnNewButton = new JButton("ENABLED");
		btnNewButton.setBackground(Color.GREEN);
		if( !monitor.sensors[1] ){
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setText("DISABLED");
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( btnNewButton.getText() == "ENABLED" ){
					btnNewButton.setBackground(Color.RED);
					btnNewButton.setText("DISABLED");
					sensor[1] = false;
					
				}
				else if( btnNewButton.getText() == "DISABLED"){
					btnNewButton.setBackground(Color.GREEN);
					btnNewButton.setText("ENABLED");
					sensor[1] = true;
				}
			}
		});
		btnNewButton.setBounds(175, 113, 130, 61);
		
		getContentPane().add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("ENABLED");
		btnNewButton_1.setBackground(Color.GREEN);
		if( !monitor.sensors[2] ){
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setText("DISABLED");
		}
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( btnNewButton_1.getText() == "ENABLED" ){
					btnNewButton_1.setBackground(Color.RED);
					btnNewButton_1.setText("DISABLED");
					sensor[2] = false;
				}
				else if( btnNewButton_1.getText() == "DISABLED"){
					btnNewButton_1.setBackground(Color.GREEN);
					btnNewButton_1.setText("ENABLED");
					sensor[2] = true;
				}
			}
		});
		btnNewButton_1.setBounds(175, 185, 130, 61);
		getContentPane().add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("ENABLED");
		btnNewButton_2.setBackground(Color.GREEN);
		if( !monitor.sensors[3] ){
			btnNewButton_2.setBackground(Color.RED);
			btnNewButton_2.setText("DISABLED");
		}
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( btnNewButton_2.getText() == "ENABLED" ){
					btnNewButton_2.setBackground(Color.RED);
					btnNewButton_2.setText("DISABLED");
					sensor[3] = false;
				}
				else if( btnNewButton_2.getText() == "DISABLED"){
					btnNewButton_2.setBackground(Color.GREEN);
					btnNewButton_2.setText("ENABLED");
					sensor[3] = true;
				}
			}
		});
		btnNewButton_2.setBounds(175, 257, 130, 61);
		getContentPane().add(btnNewButton_2);
		
		final JButton btnNewButton_3 = new JButton("ENABLED");
		btnNewButton_3.setBackground(Color.GREEN);
		if( !monitor.sensors[4] ){
			btnNewButton_3.setBackground(Color.RED);
			btnNewButton_3.setText("DISABLED");
		}
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( btnNewButton_3.getText() == "ENABLED" ){
					btnNewButton_3.setBackground(Color.RED);
					btnNewButton_3.setText("DISABLED");
					sensor[4] = false;
				}
				else if( btnNewButton_3.getText() == "DISABLED"){
					btnNewButton_3.setBackground(Color.GREEN);
					btnNewButton_3.setText("ENABLED");
					sensor[4] = true;
				}
				
			}
		});
		btnNewButton_3.setBounds(175, 329, 130, 61);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblSensorStatus = new JLabel("Sensor Status");
		lblSensorStatus.setFont(f);
		lblSensorStatus.setBounds(175, 11, 130, 25);
		getContentPane().add(lblSensorStatus);
		
		JLabel lblCurrentValue = new JLabel("Current Value");
		lblCurrentValue.setBounds(315, 11, 119, 25);
		lblCurrentValue.setFont(f);
		getContentPane().add(lblCurrentValue);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(315, 47, 119, 61);
		getContentPane().add(textField);
		textField.setColumns(10);
		Vital x = (Vital) (p.getVitals().get("Blood Pressure"));
		textField.setText( "" + x.getCurrentValue() );
		textField.setHorizontalAlignment(JTextField.CENTER);
				
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(315, 187, 119, 61);
		x = (Vital) (p.getVitals().get("Body Temperature"));
		textField_1.setText( "" + x.getCurrentValue());
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(315, 115, 119, 61);
		x = (Vital) (p.getVitals().get("Heart Rate"));
		textField_2.setText( "" + x.getCurrentValue());
		textField_2.setHorizontalAlignment(JTextField.CENTER);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(315, 257, 119, 61);
		x = (Vital) (p.getVitals().get("Respiratory Rate"));
		textField_3.setText( "" + x.getCurrentValue());
		textField_3.setHorizontalAlignment(JTextField.CENTER);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(315, 329, 119, 61);
		x = (Vital) (p.getVitals().get("Weight"));
		textField_4.setText( "" + x.getCurrentValue());
		textField_4.setHorizontalAlignment(JTextField.CENTER);
		getContentPane().add(textField_4);
		
		{
			JButton okButton = new JButton("SET");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					monitor.setSensors(sensor);
					dispose();
				}
			});
			okButton.setBounds(304, 413, 130, 61);
			getContentPane().add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("CANCEL");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelButton.setBounds(5, 413, 130, 61);
			getContentPane().add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		JButton btnCalibrate = new JButton("CALIBRATE");
		btnCalibrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calibrationDialog calD = new calibrationDialog(p, monitor);
				calD.setAlwaysOnTop(true);
				calD.setVisible(true);
			}
		});
		btnCalibrate.setActionCommand("OK");
		btnCalibrate.setBounds(156, 413, 130, 61);
		getContentPane().add(btnCalibrate);
	}
}