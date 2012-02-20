package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.io.*;

import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class logGUI extends JFrame {

	private JPanel contentPane;
	static JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logGUI frame = new logGUI();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public logGUI() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 363);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		parse();
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				dispose();
			}
		});
		btnOk.setBounds(282, 270, 135, 61);
		contentPane.add(btnOk);
		
		//JScrollBar scrollBar = new JScrollBar();
		//scrollBar.setBounds(415, 11, 17, 248);
		//contentPane.add(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		scrollPane.setBounds(10, 11, 407, 248 );
		//textArea.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setBounds(10, 270, 135, 61);
		contentPane.add(btnPrint);
	}
	
	public static void parse() throws IOException{
		String filePath = "C:\\Users\\tmc7617\\Desktop\\Log.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String strLine; 
		while((strLine = reader.readLine())!= null ){
			if( strLine.contains("Patient1") ){
				textArea.append(strLine + "\n");
			}
		}
		reader.close();
	}
}
