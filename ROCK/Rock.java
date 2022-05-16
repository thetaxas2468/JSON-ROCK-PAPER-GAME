package ex4;

import java.awt.Color;
//import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
public class Rock extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	//private fields that i used to make the program that has labels and how many human wins and computer wins and drwas
	private static int Humanwins=0;
	   private static int Computerwins=0;
	   private static int Draws1=0;
	   private JLabel humanswins=new JLabel("");
	   private JLabel alldraws=new JLabel("");
	   private JLabel computerswins=new JLabel("");
	   private JPanel panel;
	   private JPanel panel1;
	   private JPanel panel2;
//	   private JLabel first;
//	   private JLabel second;
	   private JButton[] array=new JButton[3];
	   private JLabel icon1 = new JLabel(new ImageIcon("Blank.jpg"));
	   private JLabel icon2 = new JLabel(new ImageIcon("Blank.jpg"));
	   private JButton  button1;
	   private JButton  button2;
	   private JButton  button3;
	   private ImageIcon a=new ImageIcon("Rock.jpg");
	   private ImageIcon b=new ImageIcon("Paper.jpg");
	   private ImageIcon c=new ImageIcon("Scissors.jpg");
	   private JButton  buttona=new JButton(new ImageIcon ("Rock.jpg"));
	   private JButton  buttonb=new JButton(new ImageIcon ("Paper.jpg"));
	   private JButton  buttonc=new JButton(new ImageIcon ("Scissors.jpg"));
	   //private JButton  buttonacopy=new JButton(new ImageIcon ("Rock.jpg"));
	   //private JButton  buttonbcopy=new JButton(new ImageIcon ("Paper.jpg"));
	   //private JButton  buttonccopy=new JButton(new ImageIcon ("Scissors.jpg"));
	   private JLabel playerlabelpic;
	   private JLabel Computerpic;
	   private JLabel maybe=new JLabel("");
	public Rock() {
		//array that has rock pieper scissors that computer will use randomaly
		array[0]=buttona;
		array[1]=buttonb;
		array[2]=buttonc;
		String p;
		//making labels and panels that needed to be added to the main frame
		Font font = new Font( "Times new Roman", Font.BOLD, 25 );
		maybe.setFont(font);
		//instead of setborder preffered size this.accessibleContext you can make jpanel
		Border outer = BorderFactory.createEmptyBorder( 0, 20, 0, 20 );
		Border inner = BorderFactory.createLineBorder( Color.blue, 3 );
		JFrame frame=new JFrame("Lets do it!");
		frame. setPreferredSize( new Dimension( 800, 600 ) );
		Container cp = frame.getContentPane();
		cp.setLayout( new BoxLayout( cp, BoxLayout.Y_AXIS ));
		((JComponent) frame.getContentPane()).setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.blue));
		//panel1=new JPanel();
		this.setPreferredSize(new Dimension(80,50));
		setBorder( new CompoundBorder( outer, inner ) );
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		playerlabelpic =new JLabel(new ImageIcon("Player.png"));
		Computerpic = new JLabel(new ImageIcon("Computer.png"));
		add(playerlabelpic);
		add(Box.createHorizontalStrut(120));
		add(Computerpic);
		//making the panels that i need and put strusts if needed
		panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
		panel1.setPreferredSize(new Dimension(20,100));
		panel2=new JPanel();
		panel2.setBorder( new CompoundBorder( outer, inner ) );
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
		JLabel Human=new JLabel("Human: ");
		JLabel Draws = new JLabel("Draws :");
		JLabel Computer =new JLabel("Computer :");
		//making fonts to letters for labels
		Human.setFont( font );
		humanswins.setFont(font);
		Draws.setFont(font);
		alldraws.setFont(font);
		Computer.setFont(font);
		computerswins.setFont(font);
		panel2.add(Human);
		p=String.valueOf(Humanwins);
		panel2.add(humanswins);
		humanswins.setText(p);
		panel2.add(Box.createHorizontalStrut(120));
		p=String.valueOf(Draws1);
		panel2.add(Draws);
		panel2.add(alldraws);
		alldraws.setText(p);
		panel2.add(Box.createHorizontalStrut(120));
		p=String.valueOf(Computerwins);
		panel2.add(Computer);
		panel2.add(computerswins);
		computerswins.setText(p);
		panel2.add(Box.createVerticalStrut(50));
		panel2.add(maybe);
		panel = new JPanel();
	    panel.setPreferredSize( new Dimension( 120, 100 ) );
	    panel.setBorder( new CompoundBorder( outer, inner ) );
	    panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS) );
	    //making buttons to get the picutrs with listener that are loking for clicks
		button1=new JButton(new ImageIcon ("Rock.jpg"));
		button2=new JButton(new ImageIcon ("Paper.jpg"));
		button3=new JButton(new ImageIcon ("Scissors.jpg"));
		panel.add(button1);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(button2);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		//adding all the program to the panel with few struts
		frame.add(Box.createVerticalStrut(20));
		frame.add(this);
		frame.add(Box.createVerticalStrut(50));
		frame.add(panel1);
		frame.add(Box.createVerticalStrut(20));
		frame.add(panel2);
		frame.add(Box.createVerticalStrut(10));
		frame.add(panel);
		frame.add(Box.createVerticalStrut(50));
		frame.setResizable(false);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random r=new Random();
		String 	s;
//		panel1.add(first);
//		panel1.add(second);
//		panel1.revalidate();
//		panel1.repaint();
		//adding icons to the panel for the player and computer choose and every time change it
		panel1.add(icon1);
		panel1.add(icon2);
		//checking what button is clicked and check if you win or lose and add for you if you win 
		//if you lose computer ++,you won ,player ++,draw drwas++
		if(e.getSource()==button1) {
			//all the 3 buttons check you and computer choice and set icon for the correct
			int random=r.nextInt(3);
			if(array[random]==buttona) {
				icon1.setIcon(a);
				icon2.setIcon(a);
//				panel1.add(buttona);
//				panel1.add(buttonacopy);
				maybe.setText("Tie");
				Draws1++;
				s=String.valueOf(Draws1);
				alldraws.setText(s);
			}
			else if(array[random]==buttonb) {
//				panel1.add(buttona);
//				panel1.add(buttonbcopy);
				icon1.setIcon(a);
				icon2.setIcon(b);
				maybe.setText("You Lost");
				Computerwins++;
				s=String.valueOf(Computerwins);
				computerswins.setText(s);
			}
			else {
//				panel1.add(buttona);
//				panel1.add(buttonccopy);
				icon1.setIcon(a);
				icon2.setIcon(c);
				maybe.setText("You Won");
				Humanwins++;
				s=String.valueOf(Humanwins);
				humanswins.setText(s);
			}
		

		}
		if(e.getSource()==button2) {
			int random=r.nextInt(3);
			if(array[random]==buttonb) {
//				panel1.add(buttonb);
//				panel1.add(buttonbcopy);
				icon1.setIcon(b);
				icon2.setIcon(b);
				maybe.setText("Tie");
				Draws1++;
				s=String.valueOf(Draws1);
				alldraws.setText(s);
			}
			else if(array[random]==buttonc) {
//				panel1.add(buttonb);
//				panel1.add(buttonccopy);
				icon1.setIcon(b);
				icon2.setIcon(c);
				maybe.setText("You Lost");
				Computerwins++;
				s=String.valueOf(Computerwins);
				computerswins.setText(s);
			}
			else {
//				panel1.add(buttonb);
//				panel1.add(buttonacopy);
				icon1.setIcon(b);
				icon2.setIcon(a);
				maybe.setText("You Won");
				Humanwins++;
				s=String.valueOf(Humanwins);
				humanswins.setText(s);
			}
		
		}
		if(e.getSource()==button3) {
			int random=r.nextInt(3);
			if(array[random]==buttonc) {
//				panel1.add(buttonc);
//				panel1.add(buttonccopy);
				icon1.setIcon(c);
				icon2.setIcon(c);
				maybe.setText("Tie");
				Draws1++;
				s=String.valueOf(Draws1);
				alldraws.setText(s);
			}
			else if(array[random]==buttona) {
//				panel1.add(buttonc);
//				panel1.add(buttonacopy);
				icon1.setIcon(c);
				icon2.setIcon(a);
				maybe.setText("You Lost");
				Computerwins++;
				s=String.valueOf(Computerwins);
				computerswins.setText(s);
			}
			else {
//				panel1.add(buttonc);
//				panel1.add(buttonbcopy);
				icon1.setIcon(c);
				icon2.setIcon(b);
				maybe.setText("You Won");
				Humanwins++;
				s=String.valueOf(Humanwins);
				humanswins.setText(s);
			}
		
		}	
		panel1.repaint();
	}
	public static void main(String[] args) {
		//Component o=new Container();
		new Rock();
	}

}
