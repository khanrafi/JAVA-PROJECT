package clock;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class firstpage {
  private JFrame frame;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {
              firstpage window = new firstpage();
              window.frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          }
        });
  }
  
  public firstpage() {
    initialize();
  }
  
  void setSystemLook() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    } 
  }
  
  private void initialize() {
    setSystemLook();
    this.frame = new JFrame();
    this.frame.getContentPane().setBackground(Color.WHITE);
    this.frame.getContentPane().setLayout((LayoutManager)null);
    this.frame.setResizable(false);
    JLabel lblHellowEveryone = new JLabel("HELLOW EVERYONE");
    lblHellowEveryone.setFont(new Font("Tahoma", 1, 15));
    lblHellowEveryone.setBounds(191, 26, 201, 53);
    this.frame.getContentPane().add(lblHellowEveryone);
    JLabel lblWelcomeToOur = new JLabel("WELCOME TO OUR PROJECT");
    lblWelcomeToOur.setFont(new Font("Tahoma", 3, 17));
    lblWelcomeToOur.setBounds(143, 97, 249, 43);
    this.frame.getContentPane().add(lblWelcomeToOur);
    JLabel lblClickStartButton = new JLabel("CLICK START BUTTON TO START");
    lblClickStartButton.setForeground(Color.DARK_GRAY);
    lblClickStartButton.setFont(new Font("Tahoma", 0, 14));
    lblClickStartButton.setBounds(86, 173, 238, 30);
    this.frame.getContentPane().add(lblClickStartButton);
    JButton btnStart = new JButton("START");
    btnStart.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            DigitalAnalogClock clock = new DigitalAnalogClock();
          }
        });
    btnStart.setFont(new Font("Berlin Sans FB Demi", 0, 14));
    btnStart.setForeground(Color.BLACK);
    btnStart.setBounds(130, 238, 144, 43);
    this.frame.getContentPane().add(btnStart);
    JButton btnNewButton = new JButton("CLOSE");
    btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            firstpage.this.frame.dispose();
          }
        });
    btnNewButton.setFont(new Font("Berlin Sans FB Demi", 0, 14));
    btnNewButton.setForeground(Color.BLACK);
    btnNewButton.setBounds(368, 238, 144, 43);
    this.frame.getContentPane().add(btnNewButton);
    this.frame.setBounds(100, 100, 650, 388);
    this.frame.setDefaultCloseOperation(3);
  }
}
