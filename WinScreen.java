import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WinScreen {

	private JFrame frame;
	private JTextField txtEnterWinnersName;

	public static void loadWinScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinScreen window = new WinScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WinScreen() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Arial", Font.BOLD, 16));
		exitButton.setBounds(90, 90, 200, 40);
		frame.getContentPane().add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		txtEnterWinnersName = new JTextField();
		txtEnterWinnersName.setText("Enter Winner's Name");
		txtEnterWinnersName.setBounds(90, 59, 200, 20);
		frame.getContentPane().add(txtEnterWinnersName);
		txtEnterWinnersName.setColumns(10);
		txtEnterWinnersName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textFile.writeTxt(txtEnterWinnersName.getText());
			}
		});
		
		JLabel winnerLabel = new JLabel();
		winnerLabel.setFont(new Font("Arial", Font.BOLD, 18));
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winnerLabel.setText("Winner is " + Connect4.player.altPlayer().toString() +"!");
		winnerLabel.setBounds(90, 11, 200, 37);
		frame.getContentPane().add(winnerLabel);
		
	}
}
