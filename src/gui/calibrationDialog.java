package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calibrationDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			calibrationDialog dialog = new calibrationDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public calibrationDialog() {
		setBounds(100, 100, 1124, 536);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		Font f = new Font("Dialog", Font.PLAIN, 18);
		JLabel lblNewLabel = new JLabel("Maximum Allowable");
		lblNewLabel.setBounds(54, 11, 195, 33);
		lblNewLabel.setFont(f);
		getContentPane().add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setHorizontalAlignment(JTextField.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(84, 55, 103, 61);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setHorizontalAlignment(JTextField.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(84, 121, 103, 61);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("0");
		textField_7.setHorizontalAlignment(JTextField.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(84, 195, 103, 61);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("0");
		textField_8.setHorizontalAlignment(JTextField.CENTER);
		textField_8.setColumns(10);
		textField_8.setBounds(84, 264, 103, 61);
		getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("0");
		textField_9.setHorizontalAlignment(JTextField.CENTER);
		textField_9.setColumns(10);
		textField_9.setBounds(84, 340, 103, 61);
		getContentPane().add(textField_9);
		
		JButton button_4 = new JButton("+");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_5.setText( Integer.parseInt((textField_5.getText())) + 1 + "");
			}
		});
		button_4.setBounds(197, 54, 64, 61);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("+");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_6.setText( Integer.parseInt((textField_6.getText())) + 1 + "");
			}
		});
		button_5.setBounds(197, 121, 64, 61);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("+");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_7.setText( Integer.parseInt((textField_7.getText())) + 1 + "");
			}
		});
		button_6.setBounds(197, 193, 64, 61);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("+");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_8.setText( Integer.parseInt((textField_8.getText())) + 1 + "");
			}
		});
		button_7.setBounds(197, 265, 64, 61);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton("+");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_9.setText( Integer.parseInt((textField_9.getText())) + 1 + "");
			}
		});
		button_8.setBounds(197, 340, 64, 61);
		getContentPane().add(button_8);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_5.setText((Integer.parseInt(textField_5.getText())-1) + "" );
			}
		});
		button.setBounds(10, 55, 64, 61);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_6.setText((Integer.parseInt(textField_6.getText())-1) + "" );
			}
		});
		button_1.setBounds(10, 121, 64, 61);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_7.setText((Integer.parseInt(textField_7.getText())-1) + "" );
			}
		});
		button_2.setBounds(10, 195, 64, 61);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_8.setText((Integer.parseInt(textField_8.getText())-1) + "" );
			}
		});
		button_3.setBounds(10, 264, 64, 61);
		getContentPane().add(button_3);
		
		JButton button_9 = new JButton("-");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_9.setText((Integer.parseInt(textField_9.getText())-1) + "" );
			}
		});
		button_9.setBounds(10, 340, 64, 61);
		getContentPane().add(button_9);
		
		JButton button_10 = new JButton("-");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_14.setText((Integer.parseInt(textField_14.getText())-1) + "" );
			}
		});
		button_10.setBounds(290, 340, 64, 61);
		getContentPane().add(button_10);
		
		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setHorizontalAlignment(JTextField.CENTER);
		textField_10.setColumns(10);
		textField_10.setBounds(364, 55, 103, 61);
		getContentPane().add(textField_10);
		
		JButton button_11 = new JButton("+");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_14.setText(Integer.parseInt((textField_14.getText())) + 1 + "");
			}
		});
		button_11.setBounds(477, 340, 64, 61);
		getContentPane().add(button_11);
		
		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_13.setText(Integer.parseInt((textField_13.getText())) + 1 + "");
			}
		});
		button_12.setBounds(477, 268, 64, 61);
		getContentPane().add(button_12);
		
		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setHorizontalAlignment(JTextField.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(364, 127, 103, 61);
		getContentPane().add(textField_11);
		
		JButton button_13 = new JButton("-");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_13.setText((Integer.parseInt(textField_13.getText())-1) + "" );
			}
		});
		button_13.setBounds(290, 268, 64, 61);
		getContentPane().add(button_13);
		
		JButton button_14 = new JButton("-");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_12.setText((Integer.parseInt(textField_12.getText())-1) + "" );
			}
		});
		button_14.setBounds(290, 199, 64, 61);
		getContentPane().add(button_14);
		
		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setColumns(10);
		textField_12.setHorizontalAlignment(JTextField.CENTER);
		textField_12.setBounds(364, 199, 103, 61);
		getContentPane().add(textField_12);
		
		JButton button_15 = new JButton("+");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_12.setText(Integer.parseInt((textField_12.getText())) + 1 + "" );
			}
		});
		button_15.setBounds(477, 199, 64, 61);
		getContentPane().add(button_15);
		
		JButton button_16 = new JButton("+");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_11.setText(Integer.parseInt((textField_11.getText())) + 1 + "");
			}
		});
		button_16.setBounds(477, 127, 64, 61);
		getContentPane().add(button_16);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setHorizontalAlignment(JTextField.CENTER);
		textField_13.setColumns(10);
		textField_13.setBounds(364, 268, 103, 61);
		getContentPane().add(textField_13);
		
		JButton button_17 = new JButton("-");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_11.setText((Integer.parseInt(textField_11.getText())-1) + "" );
			}
		});
		button_17.setBounds(290, 127, 64, 61);
		getContentPane().add(button_17);
		
		JButton button_18 = new JButton("-");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_10.setText((Integer.parseInt(textField_10.getText())-1) + "" );
			}
		});
		button_18.setBounds(290, 55, 64, 61);
		getContentPane().add(button_18);
		
		textField_14 = new JTextField();
		textField_14.setText("0");
		textField_14.setHorizontalAlignment(JTextField.CENTER);
		textField_14.setColumns(10);
		textField_14.setBounds(364, 340, 103, 61);
		getContentPane().add(textField_14);
		
		JButton button_19 = new JButton("+");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_10.setText(Integer.parseInt((textField_10.getText())) + 1 + "" );
			}
		});
		button_19.setBounds(477, 55, 64, 61);
		getContentPane().add(button_19);
		
		JLabel lblMinimumAllowable = new JLabel("Minimum Allowable");
		lblMinimumAllowable.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMinimumAllowable.setBounds(322, 11, 195, 33);
		getContentPane().add(lblMinimumAllowable);
		
		JLabel lblCautionaryMaximum = new JLabel("Cautionary Maximum");
		lblCautionaryMaximum.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblCautionaryMaximum.setBounds(607, 15, 195, 33);
		getContentPane().add(lblCautionaryMaximum);
		
		JButton button_20 = new JButton("+");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(Integer.parseInt((textField.getText())) + 1 + "");
			}
		});
		button_20.setBounds(1030, 340, 64, 61);
		getContentPane().add(button_20);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(917, 340, 103, 61);
		getContentPane().add(textField);
		
		JButton button_21 = new JButton("-");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText((Integer.parseInt(textField.getText())-1) + "" );
			}
		});
		button_21.setBounds(843, 340, 64, 61);
		getContentPane().add(button_21);
		
		JButton button_22 = new JButton("-");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText((Integer.parseInt(textField_1.getText())-1) + "" );
			}
		});
		button_22.setBounds(843, 268, 64, 61);
		getContentPane().add(button_22);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(917, 268, 103, 61);
		getContentPane().add(textField_1);
		
		JButton button_23 = new JButton("+");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText(Integer.parseInt((textField_1.getText())) + 1 + "");
			}
		});
		button_23.setBounds(1030, 268, 64, 61);
		getContentPane().add(button_23);
		
		JButton button_24 = new JButton("+");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_2.setText(Integer.parseInt((textField_2.getText())) + 1 + "");
			}
		});
		button_24.setBounds(1030, 199, 64, 61);
		getContentPane().add(button_24);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(917, 199, 103, 61);
		getContentPane().add(textField_2);
		
		JButton button_25 = new JButton("-");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_2.setText((Integer.parseInt(textField_2.getText())-1) + "" );
			}
		});
		button_25.setBounds(843, 196, 64, 61);
		getContentPane().add(button_25);
		
		JButton button_26 = new JButton("-");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_3.setText((Integer.parseInt(textField_3.getText())-1) + "" );
			}
		});
		button_26.setBounds(843, 121, 64, 61);
		getContentPane().add(button_26);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(917, 123, 103, 61);
		getContentPane().add(textField_3);
		
		JButton button_27 = new JButton("+");
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_3.setText(Integer.parseInt((textField_3.getText())) + 1 + "");
			}
		});
		button_27.setBounds(1030, 121, 64, 61);
		getContentPane().add(button_27);
		
		JButton button_28 = new JButton("+");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_4.setText(Integer.parseInt((textField_4.getText())) + 1 + "");
			}
		});
		button_28.setBounds(1030, 55, 64, 61);
		getContentPane().add(button_28);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(917, 55, 103, 61);
		getContentPane().add(textField_4);
		
		JButton button_29 = new JButton("-");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_4.setText((Integer.parseInt(textField_4.getText())-1) + "" );
			}
		});
		button_29.setBounds(843, 55, 64, 61);
		getContentPane().add(button_29);
		
		JButton button_30 = new JButton("+");
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_15.setText(Integer.parseInt((textField_15.getText())) + 1 + "");
			}
		});
		button_30.setBounds(750, 340, 64, 61);
		getContentPane().add(button_30);
		
		textField_15 = new JTextField();
		textField_15.setText("0");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		textField_15.setBounds(637, 340, 103, 61);
		getContentPane().add(textField_15);
		
		JButton button_31 = new JButton("-");
		button_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_15.setText((Integer.parseInt(textField_15.getText())-1) + "" );
			}
		});
		button_31.setBounds(563, 340, 64, 61);
		getContentPane().add(button_31);
		
		JButton button_32 = new JButton("-");
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_16.setText((Integer.parseInt(textField_16.getText())-1) + "" );
			}
		});
		button_32.setBounds(563, 268, 64, 61);
		getContentPane().add(button_32);
		
		textField_16 = new JTextField();
		textField_16.setText("0");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);
		textField_16.setBounds(637, 268, 103, 61);
		getContentPane().add(textField_16);
		
		JButton button_33 = new JButton("+");
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_16.setText(Integer.parseInt((textField_16.getText())) + 1 + "");
			}
		});
		button_33.setBounds(750, 265, 64, 61);
		getContentPane().add(button_33);
		
		JButton button_34 = new JButton("+");
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_17.setText(Integer.parseInt((textField_17.getText())) + 1 + "");
			}
		});
		button_34.setBounds(750, 199, 64, 61);
		getContentPane().add(button_34);
		
		textField_17 = new JTextField();
		textField_17.setText("0");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setColumns(10);
		textField_17.setBounds(637, 199, 103, 61);
		getContentPane().add(textField_17);
		
		JButton button_35 = new JButton("-");
		button_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_17.setText((Integer.parseInt(textField_17.getText())-1) + "" );
			}
		});
		button_35.setBounds(563, 199, 64, 61);
		getContentPane().add(button_35);
		
		JButton button_36 = new JButton("-");
		button_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_18.setText((Integer.parseInt(textField_18.getText())-1) + "" );
			}
		});
		button_36.setBounds(563, 121, 64, 61);
		getContentPane().add(button_36);
		
		textField_18 = new JTextField();
		textField_18.setText("0");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);
		textField_18.setBounds(637, 123, 103, 61);
		getContentPane().add(textField_18);
		
		JButton button_37 = new JButton("+");
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_18.setText(Integer.parseInt((textField_18.getText())) + 1 + "");
			}
		});
		button_37.setBounds(750, 123, 64, 61);
		getContentPane().add(button_37);
		
		JButton button_38 = new JButton("+");
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_19.setText(Integer.parseInt((textField_19.getText())) + 1 + "");
			}
		});
		button_38.setBounds(750, 55, 64, 61);
		getContentPane().add(button_38);
		
		textField_19 = new JTextField();
		textField_19.setText("0");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);
		textField_19.setBounds(637, 55, 103, 61);
		getContentPane().add(textField_19);
		
		JButton button_39 = new JButton("-");
		button_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				textField_19.setText((Integer.parseInt(textField_19.getText())-1) + "" );
			}
		});
		button_39.setBounds(563, 55, 64, 61);
		getContentPane().add(button_39);
		
		JLabel lblCautionaryMinimum = new JLabel("Cautionary Minimum");
		lblCautionaryMinimum.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblCautionaryMinimum.setBounds(875, 15, 195, 33);
		getContentPane().add(lblCautionaryMinimum);
		
		JButton btnNewButton = new JButton("SET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(964, 432, 130, 61);
		getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(10, 432, 130, 61);
		getContentPane().add(btnCancel);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnReset.setBounds(150, 432, 130, 61);
		getContentPane().add(btnReset);
	}

}