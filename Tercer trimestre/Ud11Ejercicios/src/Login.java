import java.awt.EventQueue;
import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ArrayList<Usuario> usuarios = new ArrayList();
	private File fichero = new File("Usuarios.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class Usuario{
		String Nom;
		String Contra;
		
		public Usuario(String nom, String contra) {
			this.Nom = nom;
			this.Contra = contra;
		}
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		Scanner sc = null;
		try {
			sc = new Scanner(fichero);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(sc.hasNext()) {
			usuarios.add(new Usuario(sc.next(), sc.next()));
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(174, 42, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(174, 73, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(102, 128, 89, 23);
		btnNewButton.addActionListener(e ->{
			String nom = textField.getText();
			String contra = textField_1.getText();
			
			for(Usuario u : usuarios) {
				if(u.Nom.equals(nom) && u.Contra.equals(contra)) {
					JOptionPane.showMessageDialog(null, "Logeo correcto");
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Nao Nao manin");
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(239, 128, 89, 23);
		btnNewButton_1.addActionListener(e ->{
			String nom = textField.getText();
			String contra = textField_1.getText();
			final FileWriter fw;
			try {
				fw = new FileWriter(fichero, true);
			} catch (IOException e1) {
				e1.printStackTrace();
				throw new RuntimeException("Failed to initialize FileWriter", e1); // Ensure fw is properly handled
			}
			
			usuarios.add(new Usuario(nom, contra));
			try {
				fw.write("\n" + nom + " " + contra);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Registro correcto");
		});
		contentPane.add(btnNewButton_1);
	}

}
