package casino;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Hel extends JFrame {
	private static final long serialVersionUID = 1L;
	static boolean state = true;
	static boolean agai = false;
	static boolean done = false;
	int scor = 0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		LuciPoker.Start();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hel frame = new Hel();
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
	public Hel() {
		setResizable(false);
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icon.png"));
		setTitle("Hell Casino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 690);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton selec = new JButton("Hold");
		selec.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		selec.setBounds(247, 541, 212, 105);
		contentPane.add(selec);
		
		JToggleButton cardOne = new JToggleButton("" + (LuciPoker.player.getCard1()));
		cardOne.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cardOne.setBounds(23, 297, 121, 200);
		contentPane.add(cardOne);
		
		JToggleButton cardTwo = new JToggleButton("" + (LuciPoker.player.getCard2()));
		cardTwo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cardTwo.setBounds(154, 297, 121, 200);
		contentPane.add(cardTwo);
		
		JToggleButton cardThree = new JToggleButton("" + (LuciPoker.player.getCard3()));
		cardThree.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cardThree.setBounds(285, 297, 121, 200);
		contentPane.add(cardThree);
		
		JToggleButton cardFour = new JToggleButton("" + (LuciPoker.player.getCard4()));
		cardFour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cardFour.setBounds(416, 297, 121, 200);
		contentPane.add(cardFour);
		
		JToggleButton cardFive = new JToggleButton("" + (LuciPoker.player.getCard5()));
		cardFive.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cardFive.setBounds(547, 297, 121, 200);
		contentPane.add(cardFive);
		
		JLabel you = new JLabel(" ");
		you.setFont(new Font("Tahoma", Font.PLAIN, 40));
		you.setHorizontalAlignment(SwingConstants.CENTER);
		you.setBounds(154, 222, 385, 59);
		contentPane.add(you);
		
		JLabel score = new JLabel("Score: ");
		score.setFont(new Font("Tahoma", Font.PLAIN, 27));
		score.setBounds(526, 222, 137, 59);
		contentPane.add(score);
		
		JLayeredPane LOne = new JLayeredPane();
		LOne.setBackground(Color.WHITE);
		LOne.setBounds(23, 11, 121, 200);
		contentPane.add(LOne);
		
		JLabel TextOne = new JLabel("");
		TextOne.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextOne.setHorizontalAlignment(SwingConstants.CENTER);
		TextOne.setBounds(0, 0, 121, 200);
		LOne.add(TextOne);
		
		JLabel TextOne_1 = new JLabel("");
		TextOne_1.setIcon(new ImageIcon("BackCard.png"));
		TextOne_1.setHorizontalAlignment(SwingConstants.CENTER);
		TextOne_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextOne_1.setBounds(0, 0, 121, 200);
		LOne.add(TextOne_1);
		
		JLabel lblNewLabel = new JLabel("Your Cards");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(247, 508, 212, 35);
		contentPane.add(lblNewLabel);
		
		JLayeredPane LTwo = new JLayeredPane();
		LTwo.setBackground(Color.WHITE);
		LTwo.setBounds(154, 11, 121, 200);
		contentPane.add(LTwo);
		
		JLabel TextTwo = new JLabel("");
		TextTwo.setHorizontalAlignment(SwingConstants.CENTER);
		TextTwo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextTwo.setBounds(0, 0, 121, 200);
		LTwo.add(TextTwo);
		
		JLabel TextOne_1_1 = new JLabel("");
		TextOne_1_1.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
		TextOne_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		TextOne_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextOne_1_1.setBounds(0, 0, 121, 200);
		LTwo.add(TextOne_1_1);
		
		JLayeredPane LThree = new JLayeredPane();
		LThree.setBackground(Color.WHITE);
		LThree.setBounds(285, 11, 121, 200);
		contentPane.add(LThree);
		
		JLabel TextThree = new JLabel("");
		TextThree.setHorizontalAlignment(SwingConstants.CENTER);
		TextThree.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextThree.setBounds(0, 0, 121, 200);
		LThree.add(TextThree);
		
		JLabel TextOne_1_2 = new JLabel("");
		TextOne_1_2.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
		TextOne_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		TextOne_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextOne_1_2.setBounds(0, 0, 121, 200);
		LThree.add(TextOne_1_2);
		
		JLayeredPane LFour = new JLayeredPane();
		LFour.setBackground(Color.WHITE);
		LFour.setBounds(416, 11, 121, 200);
		contentPane.add(LFour);
		
		JLabel TextFour = new JLabel("");
		TextFour.setHorizontalAlignment(SwingConstants.CENTER);
		TextFour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextFour.setBounds(0, 0, 121, 200);
		LFour.add(TextFour);
		
		JLabel TextOne_1_3 = new JLabel("");
		TextOne_1_3.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
		TextOne_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		TextOne_1_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextOne_1_3.setBounds(0, 0, 121, 200);
		LFour.add(TextOne_1_3);
		
		JLayeredPane LFive = new JLayeredPane();
		LFive.setBackground(Color.WHITE);
		LFive.setBounds(547, 11, 121, 200);
		contentPane.add(LFive);
		
		JLabel TextFive = new JLabel("");
		TextFive.setHorizontalAlignment(SwingConstants.CENTER);
		TextFive.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextFive.setBounds(0, 0, 121, 200);
		LFive.add(TextFive);
		
		JLabel TextOne_1_4 = new JLabel("");
		TextOne_1_4.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
		TextOne_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		TextOne_1_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextOne_1_4.setBounds(0, 0, 121, 200);
		LFive.add(TextOne_1_4);
		
		JButton again = new JButton("Refresh");
		again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LuciPoker.Start();
				TextOne_1.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
				TextOne_1_1.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
				TextOne_1_2.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
				TextOne_1_3.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
				TextOne_1_4.setIcon(new ImageIcon(getClass().getResource("BackCard.png")));
				TextOne.setText("");
				TextTwo.setText("");
				TextThree.setText("");
				TextFour.setText("");
				TextFive.setText("");
				cardOne.setText("" + (LuciPoker.player.getCard1()));
				cardTwo.setText("" + (LuciPoker.player.getCard2()));
				cardThree.setText("" + (LuciPoker.player.getCard3()));
				cardFour.setText("" + (LuciPoker.player.getCard4()));
				cardFive.setText("" + (LuciPoker.player.getCard5()));
			}
		});
		again.setBounds(23, 247, 89, 23);
		contentPane.add(again);
		
		cardOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selec.setText("Draw");
				state = false;
			}
		});
		cardTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selec.setText("Draw");
				state = false;
			}
		});
		cardThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selec.setText("Draw");
				state = false;
			}
		});
		cardFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selec.setText("Draw");
				state = false;
			}
		});
		cardFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selec.setText("Draw");
				state = false;
			}
		});
		selec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (state == false) {
					if(cardOne.isSelected()) {
						int o = LuciPoker.DrawCard();
						LuciPoker.player.change1(o);
						cardOne.setText("" + o);
						cardOne.setSelected(false);
					}
					if(cardTwo.isSelected()) {
						int o = LuciPoker.DrawCard();
						LuciPoker.player.change2(o);
						cardTwo.setText("" + o);
						cardTwo.setSelected(false);
					}
					if(cardThree.isSelected()) {
						int o = LuciPoker.DrawCard();
						LuciPoker.player.change3(o);
						cardThree.setText("" + o);
						cardThree.setSelected(false);
					}
					if(cardFour.isSelected()) {
						int o = LuciPoker.DrawCard();
						LuciPoker.player.change4(o);
						cardFour.setText("" + o);
						cardFour.setSelected(false);
					}
					if(cardFive.isSelected()) {
						int o = LuciPoker.DrawCard();
						LuciPoker.player.change5(o);
						cardFive.setText("" + o);
						cardFive.setSelected(false);
					}
					selec.setText("Hold");
				}
				LuciPoker.CompareHand(LuciPoker.player, LuciPoker.lucifer);
				state = true;
				TextOne.setText("" + LuciPoker.lucifer.getCard1());
				TextOne_1.setIcon(new ImageIcon(getClass().getResource("Card.png")));
				TextTwo.setText("" + LuciPoker.lucifer.getCard2());
				TextOne_1_1.setIcon(new ImageIcon(getClass().getResource("Card.png")));
				TextThree.setText("" + LuciPoker.lucifer.getCard3());
				TextOne_1_2.setIcon(new ImageIcon(getClass().getResource("Card.png")));
				TextFour.setText("" + LuciPoker.lucifer.getCard4());
				TextOne_1_3.setIcon(new ImageIcon(getClass().getResource("Card.png")));
				TextFive.setText("" + LuciPoker.lucifer.getCard5());
				TextOne_1_4.setIcon(new ImageIcon(getClass().getResource("Card.png")));
				you.setText(LuciPoker.res);
				if(LuciPoker.res.contains("W")) {
					scor = scor + 1;
					score.setText("Score: " + scor);
					agai = true;
				}
				else if(LuciPoker.res.contains("L")) {
					scor = scor - 1;
					score.setText("Score: " + scor);
					agai = true;
				}
			}
		});
	}
}
