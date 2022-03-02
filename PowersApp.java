package powers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import java.awt.Label;

public class PowersApp extends JFrame {

	private JPanel contentPane;
	private JTextField txtBase;
	private JTextField txtExponent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PowersApp frame = new PowersApp();
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
	public PowersApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("POWER!");
		lblNewLabel.setBounds(182, 11, 66, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.YELLOW);
		contentPane.add(lblNewLabel);

		JLabel lblBase = new JLabel("Base: ");
		lblBase.setBounds(69, 49, 46, 14);
		contentPane.add(lblBase);

		JLabel lblNewLabel_1 = new JLabel("Exponent: ");
		lblNewLabel_1.setBounds(69, 75, 66, 14);
		contentPane.add(lblNewLabel_1);

		txtBase = new JTextField();
		txtBase.setBounds(162, 46, 86, 20);
		contentPane.add(txtBase);
		txtBase.setColumns(10);

		txtExponent = new JTextField();
		txtExponent.setBounds(162, 72, 86, 20);
		txtExponent.setText("");
		contentPane.add(txtExponent);
		txtExponent.setColumns(10);

		Label lblError = new Label("New label");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblError.setBounds(10, 94, 424, 22);
		contentPane.add(lblError);

		JScrollPane ScrollPane = new JScrollPane();
		ScrollPane.setBounds(69, 122, 310, 128);
		contentPane.add(ScrollPane);

		JTextArea txtaOut = new JTextArea();
		ScrollPane.setViewportView(txtaOut);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(287, 45, 89, 23);
		contentPane.add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////////////////////
				String base, exponent;
				double b;
				int e;
				base = txtBase.getText();
				exponent= txtExponent.getText();
				if(inCheckDouble(base)) {
					b = Double.parseDouble(base);
					if(inCheckInt(exponent)) {
						e = Integer.parseInt(exponent);
						if(rangeCheck(e, 1, 10)) {
							for(int i = 1; i<=e; i++) {
								txtaOut.append(b+" to the exponent "+i+" = "+ Math.pow(b, i) +"\n");
							}
						}
						else {
							lblError.setText("Error: Incorrect input. Exponent should be between 1 and 10. Please try again.");
						}
					}
					else {
						lblError.setText("Error: Incorrect input. Exponent should be an integer. Please try again.");
					}
				}
				else {
					lblError.setText("Error: Incorrect input. Base should be a real number. Please try again.");
				}
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(287, 71, 89, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});

	}
	private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
		// TODO add your handling code here:
		System.exit(0); // Exit the application.
	}
	static public boolean inCheckDouble(String in){
		Double temp = .0;
		try {
			temp = Double.parseDouble(in);
			if(temp>=0 && temp <=1000) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e ) {
			return false;
		}
	}
	static public boolean inCheckInt(String in){
		int temp = 0;
		try {
			temp = Integer.parseInt(in);
			return true;
		}
		catch (Exception e ) {
			return false;
		}
	}
	static public boolean rangeCheck(double in, int min, int max) {
		if (in>=min && in<=max) {
			return true;
		}
		else {
			return false;
		}
	}
}
