import java.awt.EventQueue;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class FileEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private File fichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileEditor frame = new FileEditor();
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
	public FileEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setBounds(138, 11, 660, 152);
		contentPane.add(fileChooser);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(138, 174, 651, 199);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.setBounds(279, 403, 89, 23);
		btnNewButton.addActionListener(e -> {
			Scanner scanner = null;
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				fichero = fileChooser.getSelectedFile();
				try {
					scanner = new Scanner(fichero);
					StringBuilder sb = new StringBuilder();
					while (scanner.hasNextLine()) {
						sb.append(scanner.nextLine()).append("\n");
					}
					textArea.setText(sb.toString());
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} finally {
					if (scanner != null) {
						scanner.close();
					}
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBounds(579, 403, 89, 23);
		btnNewButton_1.addActionListener(e -> {
			FileWriter writer = null;
			try {
				writer = new FileWriter(fichero);
				writer.write(textArea.getText());
				writer.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		contentPane.add(btnNewButton_1);
	}
}
