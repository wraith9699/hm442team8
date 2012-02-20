package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dischargeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dischargeDialog dialog = new dischargeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dischargeDialog() {
		setBounds(100, 100, 454, 532);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setBounds(10, 422, 130, 61);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			okButton.setBounds(294, 422, 130, 61);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 400);
		//panel.set
		contentPanel.add(panel);
		panel.setLayout(null);
	//	panel.setLayout(new GridLayout(0, 1, 0, 0));
		//JScrollPane scrollPane = new JScrollPane(panel);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 11, 414, 400 );
		scrollPane.setVisible(true);
		for( int x = 0; x < 3; x++ ){
			JButton newJB = new JButton();
			
			newJB.setText( "Patient" + x );
			//newJB.setSize(414, 75);
			//panel.add(newJB);
			//System.out.println(x+"");
			newJB.setBounds( 0, ((x*75)+1), 414, 75);
		/*	newJB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					dispose();
				}
			);*/
			 panel.add(newJB);
			
		}
		panel.revalidate();
		//scrollPane.revalidate();
		
		
		//panel.setLayout(null);
		
		//contentPanel.add(panel);
		contentPanel.add(scrollPane);
		//textArea.add(scrollPane, BorderLayout.CENTER);
		//ntentPane.add(scrollPane, BorderLayout.CENTER);
		//panel.a
		
		//JScrollPane scrollPane = new JScrollPane(panel);
		//scrollPane.setBounds(10, 11, 407, 248 );
		//textArea.add(scrollPane, BorderLayout.CENTER);
		//contentPane.add(scrollPane, BorderLayout.CENTER);
	}
}
