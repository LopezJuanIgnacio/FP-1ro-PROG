import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Par extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Par frame = new Par();
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
	public Par() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(160, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Par o Impar");
		btnNewButton.setBounds(157, 42, 89, 23);
		btnNewButton.addActionListener(e -> {
			try {
				int num = Integer.parseInt(textField.getText());
				if (num % 2 == 0)
					JOptionPane.showMessageDialog(null, "El numero es par");
				else
					JOptionPane.showMessageDialog(null, "El numero es impar");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Introduce un numero valido");
			}
		});
		contentPane.add(btnNewButton);
	}

}
