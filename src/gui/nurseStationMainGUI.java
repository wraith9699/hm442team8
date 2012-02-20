package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nurseStationMainGUI extends JFrame {

	private JPanel contentPane;

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
		btnDischarge.setBounds(503, 11, 130, 61);
		contentPane.add(btnDischarge);
		
		JButton btnConfiguration = new JButton("CONFIGURATION");
		btnConfiguration.setBounds(10, 11, 130, 61);
		contentPane.add(btnConfiguration);
	}

}
