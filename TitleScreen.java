import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class TitleScreen {

	private JFrame landingFrame;

	public static void main(String[] args) {
		
		textFile.createTxt(); // creates the txt
		
		EventQueue.invokeLater(new Runnable() {	//loads the title screen
			public void run() {
				try {
					TitleScreen window = new TitleScreen();
					window.landingFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TitleScreen() {
		initialize();
	}

	private void initialize() {
		landingFrame = new JFrame();
		landingFrame.setBounds(100, 100, 800, 600);
		landingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		landingFrame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Connect 4");
		titleLabel.setBackground(Color.BLUE);
		titleLabel.setBounds(232, 0, 313, 66);
		titleLabel.setFont(new Font("Arial Black", Font.BOLD, 46));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		landingFrame.getContentPane().add(titleLabel);
		
		JButton playButton = new JButton("Play");
		playButton.setBackground(new Color(255, 51, 102));
		playButton.setBounds(260, 176, 260, 190);
		playButton.setFont(new Font("Arial", Font.BOLD, 36));
		landingFrame.getContentPane().add(playButton);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Connect4.loadBoard();	//starts game upon clicking play.
				landingFrame.setVisible(false);	//hides landing page while in play.
			}
		});
		
		JTextField txtrLastWinner = new JTextField("Last Winner:");
		txtrLastWinner.setEditable(false);
		txtrLastWinner.setHorizontalAlignment(SwingConstants.LEFT);
		txtrLastWinner.setFont(new Font("Arial", Font.BOLD, 16));
		txtrLastWinner.setBackground(Color.LIGHT_GRAY);
		txtrLastWinner.setText(textFile.readTxt());	// calls lastest winner method and returns the lastest line of the list.
		txtrLastWinner.setBounds(10, 515, 230, 35);
		landingFrame.getContentPane().add(txtrLastWinner);
		
		JButton textFileButton = new JButton("Open Winner History");
		textFileButton.setBackground(Color.LIGHT_GRAY);
		textFileButton.setFont(new Font("Arial", Font.BOLD, 16));
		textFileButton.setBounds(544, 515, 230, 35);
		landingFrame.getContentPane().add(textFileButton);
		textFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					textFile.openTxt();
				}
				
				catch(Exception error) {
					System.out.println("Error in attempt to open file");
					error.printStackTrace();
				}
			}
		});
		
		JButton exitButton = new JButton("Exit");
		exitButton.setBackground(new Color(0, 102, 204));
		exitButton.setFont(new Font("Arial", Font.BOLD, 16));
		exitButton.setBounds(260, 377, 260, 35);
		landingFrame.getContentPane().add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
	}
	
}
