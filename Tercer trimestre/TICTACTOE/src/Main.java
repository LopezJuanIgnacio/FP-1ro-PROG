import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[][] buttons = new JButton[3][3];
	private boolean turno = true; // Variable para controlar el turno del jugador
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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

	public void buttonClicked(String actionCommand) {
		String[] coordinates = actionCommand.split(",");
		int row = Integer.parseInt(coordinates[0]);
		int col = Integer.parseInt(coordinates[1]);
		
		if (buttons[row][col].isEnabled() == false) {
			return; // Si el botón ya está desactivado, no hace nada
		} 
		
		buttons[row][col].setBackground(turno ? java.awt.Color.RED : java.awt.Color.BLUE); // Cambia el color del botón según el turno
		buttons[row][col].setEnabled(false); // Desactiva el botón después de hacer clic
		hayGanador(); // Verifica si hay un ganador después de cada movimiento
		turno = !turno; // Cambia el turno al otro jugador
	}

	public void hayGanador() {
		// Aquí puedes implementar la lógica para verificar si hay un ganador
		// Por ejemplo, puedes verificar filas, columnas y diagonales
		
		// Verifica diagonales
		if (buttons[0][0].getBackground() == buttons[1][1].getBackground() && buttons[0][0].getBackground() == buttons[2][2].getBackground() && buttons[0][0].isEnabled() == false) {
			JOptionPane.showMessageDialog(null, "¡Gano el " + (turno ? "Rojo" : "Azul") + "!"); // Muestra el mensaje de ganador
			reiniciar(); // Reinicia el juego
		}
		if (buttons[0][2].getBackground() == buttons[1][1].getBackground() && buttons[0][2].getBackground() == buttons[2][0].getBackground() && buttons[0][2].isEnabled() == false) {
			JOptionPane.showMessageDialog(null, "¡Gano el " + (turno ? "Rojo" : "Azul") + "!"); // Muestra el mensaje de ganador
			reiniciar(); // Reinicia el juego
		}

		for (int i = 0; i < 3; i++) {
			//Verifica filas
			if (buttons[i][0].getBackground() == buttons[i][1].getBackground() && buttons[i][0].getBackground() == buttons[i][2].getBackground() && buttons[i][0].isEnabled() == false) {
				JOptionPane.showMessageDialog(null, "¡Gano el " + (turno ? "Rojo" : "Azul") + "!"); // Muestra el mensaje de ganador
				reiniciar(); // Reinicia el juego
			}
			//Verifica columnas
			if (buttons[0][i].getBackground() == buttons[1][i].getBackground() && buttons[0][i].getBackground() == buttons[2][i].getBackground() && buttons[0][i].isEnabled() == false) {
				JOptionPane.showMessageDialog(null, "¡Gano el " + (turno ? "Rojo" : "Azul") + "!"); // Muestra el mensaje de ganador
				reiniciar(); // Reinicia el juego
			}
		}
		
		// Verifica si hay un empate
		boolean empate = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (buttons[i][j].isEnabled()) {
					empate = false; // Si hay al menos un botón habilitado, no hay empate
					break;
				}
			}
		}
		if (empate) {
			JOptionPane.showMessageDialog(null, "¡Es un empate!"); // Muestra el mensaje de empate
			reiniciar(); // Reinicia el juego
		}
	}

	public void reiniciar(){
		// Reinicia el juego
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setEnabled(true);
				buttons[i][j].setBackground(null);
			}
		}
		turno = true; // Reinicia el turno al jugador 1 (Rojo)
	}
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));

		// Inicializa los botones y los agrega al panel
		// y asigna la funcion a cada botón
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].setActionCommand(i + "," + j);
				buttons[i][j].addActionListener(e -> buttonClicked(e.getActionCommand()));
				contentPane.add(buttons[i][j]);
			}
		}
	}

}
