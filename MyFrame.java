import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    
  Random rand = new Random();
  int score = 0;
  boolean isClicked = false;
  int lives = 3;

  JButton button = new JButton("Start");
  JButton shoot = new JButton("Shoot");
  
  JLabel label = new JLabel("Test Your Luck");
  JLabel scoreLabel = new JLabel();
  JLabel timeLabel = new JLabel();
  JLabel LivesLabel = new JLabel();

  JPanel jp = new JPanel();
  
  MyFrame(){
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400,500);
    this.setVisible(true);
    this.setTitle("RUSSION ROULETTE");
    this.setLayout(null);
    

    this.add(button);
    this.add(label);
    this.add(shoot);
    this.add(scoreLabel);
    this.add(timeLabel);
    this.add(LivesLabel);
    this.add(jp);
    
    button.setBounds(150,200,100,50);
    button.setFocusable(false);
    button.setFont(new Font("Comic Sans", Font.BOLD,15));
    button.addActionListener(this);
    button.setVisible(true);

    shoot.setFocusable(false);
    shoot.setFont(new Font("Comic Sans", Font.BOLD,15));
    shoot.addActionListener(this);
    shoot.setVisible(false);
    
    label.setBounds(150, 100, 150, 150);
    label.setVisible(true);

    scoreLabel.setBounds(150,50,200,200);
    scoreLabel.setVisible(false);
    scoreLabel.setFont(new Font("Comic Snas",Font.BOLD , 15));

    LivesLabel.setBounds(0, 0, 100, 50);
    LivesLabel.setFont(new Font("Comic Sans", Font.BOLD, 15));
    LivesLabel.setVisible(true);

    jp.setBackground(Color.cyan);
    jp.setBounds(0, 0, 400, 500);
    
  }
  @Override
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == button){
      button.setVisible(false);
      label.setVisible(false);

      int x = rand.nextInt(300);
      int y = rand.nextInt(400);
      
      shoot.setBounds(x, y, 100, 50);
      shoot.setVisible(true);

      scoreLabel.setVisible(true);
      scoreLabel.setText("Score: " + score);
      isClicked = true;
    }
    if(e.getSource() == shoot && isClicked == true){
      isClicked = true;
      score++;
      scoreLabel.setText("Score: " + score);

      int x = rand.nextInt(300);
      int y = rand.nextInt(400);
      
      int fire = rand.nextInt(12);
      
      shoot.setBounds(x, y, 100, 50);
      shoot.setVisible(true);
      
      System.out.println(fire);
      LivesLabel.setText("Lives: " + lives);
      jp.setBackground(Color.cyan);
      
      if(fire == 1){
        lives--;
        LivesLabel.setText("Lives: " + lives);
      }
      if(lives == 0){
        shoot.setVisible(false);
        label.setText("GAME OVER");
        label.setBounds(150, 50, 100, 50);
        button.setText("Restart");
        button.setBounds(150, 200, 100, 50);
        button.setVisible(true);
        lives = 3;
        score = 0;
        isClicked = false;
        jp.setBackground(Color.red);
        scoreLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));;
      }
    }
  }
}