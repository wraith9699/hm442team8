package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admittanceDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			admittanceDialog dialog = new admittanceDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public admittanceDialog() {
		setBounds(100, 100, 323, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		Font f = new Font("Dialog", Font.PLAIN, 18);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			okButton.setBounds(167, 108, 130, 61);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setBounds(10, 11, 130, 23);
		lblPatientName.setFont(f);
		contentPanel.add(lblPatientName);
		
		textField = new JTextField();
		textField.setBounds(132, 7, 165, 31);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(132, 49, 164, 31);
		contentPanel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Patient ID:");
		lblNewLabel.setBounds(10, 62, 112, 14);
		lblNewLabel.setFont(f);
		contentPanel.add(lblNewLabel);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnDelete.setActionCommand("Cancel");
		btnDelete.setBounds(10, 108, 130, 61);
		contentPanel.add(btnDelete);
	}
}
