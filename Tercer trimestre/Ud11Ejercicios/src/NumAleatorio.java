import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JButton;

public class NumAleatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumAleatorio frame = new NumAleatorio();
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
	public NumAleatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSlider slider = new JSlider(1, 100);
		slider.setBounds(107, 11, 200, 26);
		contentPane.add(slider);
		
		JButton btnNewButton = new JButton("Generar");
		btnNewButton.setBounds(167, 48, 89, 23);
		btnNewButton.addActionListener(e -> {
			int max = slider.getValue();
			int num = (int)(Math.random() * (max + 1));
			JOptionPane.showMessageDialog(null, "El numero es " + num);
		});
		contentPane.add(btnNewButton);
	}
}
