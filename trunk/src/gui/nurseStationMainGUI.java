package gui;

import gui.bedsideMonitorMainGUI.Blinker;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class nurseStationMainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JButton button_14 = new JButton("60");
	JButton btnPatient_1 = new JButton("Patient3");
	Timer alarmTimer = new Timer(500, new Blinker());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nurseStationMainGUI frame = new nurseStationMainGUI();
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
	public nurseStationMainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmit = new JButton("ADMIT");
		btnAdmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admittanceDialog admit = new admittanceDialog();
				admit.setAlwaysOnTop(true);
				admit.setVisible(true);
			}
		});
		btnAdmit.setBounds(367, 11, 130, 61);
		contentPane.add(btnAdmit);
		
		JButton btnDischarge = new JButton("DISCHARGE");
		btnDischarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dischargeDialog dD = new dischargeDialog();
				dD.setAlwaysOnTop(true);
				dD.setVisible(true);
			}
		});
		btnDischarge.setBounds(503, 11, 130, 61);
		contentPane.add(btnDischarge);
		
		JButton btnConfiguration = new JButton("CONFIGURATION");
		btnConfiguration.setBounds(10, 11, 130, 61);
		contentPane.add(btnConfiguration);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(437, 83, -415, 315);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Patient1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 119, 130, 90);
		contentPane.add(btnNewButton);
		
		JButton btnPatient = new JButton("Patient2");
		btnPatient.setBounds(10, 220, 130, 90);
		contentPane.add(btnPatient);
		
		//JButton btnPatient_1 = new JButton("Patient3");
		btnPatient_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alarmTimer.start();
			}
		});
		//btnPatient_1.setBackground(Color.RED);
		btnPatient_1.setBounds(10, 321, 130, 90);
		contentPane.add(btnPatient_1);
		
		JButton btnNewButton_1 = new JButton("24");
		btnNewButton_1.setBounds(168, 119, 89, 90);
		contentPane.add(btnNewButton_1);
		
		JButton button_2 = new JButton("80");
		button_2.setBounds(257, 119, 89, 90);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("95");
		button_3.setBounds(346, 119, 89, 90);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("98.2");
		button_4.setBounds(435, 119, 89, 90);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("82");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_5.setBounds(524, 119, 89, 90);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("150");
		button_6.setBounds(524, 220, 89, 90);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("16");
		button_7.setBounds(168, 220, 89, 90);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("95");
		button_8.setBounds(257, 220, 89, 90);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("115");
		button_9.setBounds(346, 220, 89, 90);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("99");
		button_10.setBounds(435, 220, 89, 90);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("210");
		button_11.setBounds(524, 321, 89, 90);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("19");
		button_12.setBounds(168, 321, 89, 90);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("95");
		button_13.setBounds(257, 321, 89, 90);
		contentPane.add(button_13);
		
		//JButton button_14 = new JButton("60");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//button_14.setBackground(Color.RED);
		//button_14.setForeground(Color.BLACK);
		button_14.setBounds(346, 321, 89, 90);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("98.6");
		button_15.setBounds(435, 321, 89, 90);
		contentPane.add(button_15);
		
		Font f = new Font("Dialog", Font.PLAIN, 18);
		
		textField = new JTextField();
		textField.setText("3");
		textField.setFont(f);
		textField.setBounds(247, 11, 110, 61);
		textField.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPatients = new JLabel("Patients:");
		lblPatients.setBounds(168, 34, 89, 14);
		contentPane.add(lblPatients);
		lblPatients.setFont(f);
		
		
	}
	
	class Blinker implements ActionListener{
        boolean on=false;
 
        public void actionPerformed(ActionEvent e) {
            // blink the label background on and off
        	button_14.setBackground( on ? Color.RED : null);
        	btnPatient_1.setBackground( on ? Color.RED : null);
            on = !on;
        }
    }
}
