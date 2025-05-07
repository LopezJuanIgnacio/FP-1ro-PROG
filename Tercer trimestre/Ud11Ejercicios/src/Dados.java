import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Dados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dados frame = new Dados();
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
	public Dados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);

		JButton btnD6 = new JButton("D6", new ImageIcon("img/d6.ico"));
		btnD6.setBounds(50, 50, 80, 30);
		btnD6.addActionListener(e -> JOptionPane.showMessageDialog(this, "Resultado: " + (1 + (int)(Math.random() * 6))));
		contentPane.add(btnD6);

		JButton btnD8 = new JButton("D8", new ImageIcon("img/d8.ico"));
		btnD8.setBounds(150, 50, 80, 30);
		btnD8.addActionListener(e -> JOptionPane.showMessageDialog(this, "Resultado: " + (1 + (int)(Math.random() * 8))));
		contentPane.add(btnD8);

		JButton btnD12 = new JButton("D12", new ImageIcon("img/d12.ico"));
		btnD12.setBounds(50, 100, 80, 30);
		btnD12.addActionListener(e -> JOptionPane.showMessageDialog(this, "Resultado: " + (1 + (int)(Math.random() * 12))));
		contentPane.add(btnD12);

		JButton btnD20 = new JButton("D20", new ImageIcon("img/d20.ico"));
		btnD20.setBounds(150, 100, 80, 30);
		btnD20.addActionListener(e -> JOptionPane.showMessageDialog(this, "Resultado: " + (1 + (int)(Math.random() * 20))));
		contentPane.add(btnD20);
		setContentPane(contentPane);
	}

}
