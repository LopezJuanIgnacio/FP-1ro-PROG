import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class Tablas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablas frame = new Tablas();
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
	public Tablas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable(11, 11);
		table.setBounds(172, 62, 552, 176);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(e ->{
			int aux;
			for(int i = 0; i < 11; i++) {
				for(int j = 0; j < 11; j++) {
					aux = (i == 0 ? 1 : i) * (j == 0 ? 1 : j);
					table.setValueAt(aux, i, j);
				}
			}
			table.setValueAt("X", 0, 0);
		});
		btnNewButton.setBounds(406, 279, 89, 23);
		contentPane.add(btnNewButton);
	}
}
