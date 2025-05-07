import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ejemplo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanelGeneral;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
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
	public Ejemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 401);
		jPanelGeneral = new JPanel();

		setContentPane(jPanelGeneral);
		jPanelGeneral.setLayout(null);
		
		JLabel jLabelEtiqueta = new JLabel("Sexoooooooo");
		jLabelEtiqueta.setBounds(368, 10, 66, 14);
		jPanelGeneral.add(jLabelEtiqueta);
		
		textField = new JTextField();
		textField.setBounds(348, 35, 86, 20);
		jPanelGeneral.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Btn");

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(Ejemplo.this, textField.getText());
			}
		});
		btnNewButton.setBounds(348, 66, 89, 23);
		jPanelGeneral.add(btnNewButton);
		
		
	}
}
