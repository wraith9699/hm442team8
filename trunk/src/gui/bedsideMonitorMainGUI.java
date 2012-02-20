package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class bedsideMonitorMainGUI extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnCallButton = new JButton("Call Button");
	Timer callTimer = new Timer(500, new Blinker());
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}
	

	/**
	 * Create the frame.
	 */
	public bedsideMonitorMainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 552);
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
				configurationDialog cfD = new configurationDialog();
				cfD.setAlwaysOnTop(true);
				cfD.setVisible(true);
			}
		});
		btnSettings.setBounds(370, 77, 135, 57);
		contentPane.add(btnSettings);
		
		JButton btnCallReset = new JButton("Call Reset");
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
		
		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setBounds(10, 15, 46, 14);
		contentPane.add(lblPatient);		
		
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

}