import java.awt.EventQueue;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Monitor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Monitor frame = new Monitor();
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
	public Monitor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Memoria RAM total:" + osBean.getTotalPhysicalMemorySize() / 1024 / 1024 + " MB");
		lblNewLabel.setBounds(149, 11, 200, 14);
		contentPane.add(lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue((int) ((osBean.getTotalPhysicalMemorySize() - osBean.getFreePhysicalMemorySize()) * 100 / osBean.getTotalPhysicalMemorySize()));
		progressBar.setBounds(149, 36, 146, 14);
		contentPane.add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(149, 61, 146, 14);
		progressBar_1.setValue((int) (osBean.getSystemCpuLoad() * 100));
		contentPane.add(progressBar_1);
	}
}
