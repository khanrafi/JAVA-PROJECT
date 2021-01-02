package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class analogclock2 {
  private JFrame frame;
  
  public void countrytime(final String selection) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {
              analogclock2 window = new analogclock2(selection);
              window.frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          }
        });
  }
  
  public analogclock2(String s) {
    initialize(s);
  }
  
  void setSystemLook() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    } 
  }
  
  void initialize(String s) {
    setSystemLook();
    this.frame = new JFrame();
    this.frame.setBounds(100, 100, 1260, 900);
    this.frame.setDefaultCloseOperation(3);
    this.frame.getContentPane().setLayout(new BorderLayout(0, 0));
    JPanel panel = new JPanel();
    panel.setBackground(Color.GRAY);
    this.frame.getContentPane().add(panel, "South");
    panel.setLayout(new FlowLayout(1, 5, 5));
    JButton btnClose2 = new JButton("CLOSE");
    btnClose2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            analogclock2.this.frame.dispose();
          }
        });
    btnClose2.setFont(new Font("Berlin Sans FB Demi", 0, 13));
    panel.add(btnClose2);
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.DARK_GRAY);
    this.frame.getContentPane().add(panel_1, "North");
    panel_1.setLayout(new FlowLayout(1, 5, 5));
    JLabel lblTimeOfSearched = new JLabel("TIME AND DATE OF SEARCHED COUNTRY");
    lblTimeOfSearched.setForeground(Color.WHITE);
    panel_1.add(lblTimeOfSearched);
    JPanel panel_2 = new JPanel();
    this.frame.getContentPane().add(panel_2, "Center");
    panel_2.setLayout(new GridLayout(0, 2, 0, 0));
    JPanel panel_3 = new JPanel();
    panel_2.add(panel_3);
    panel_3.setLayout(new BorderLayout(0, 0));
    JPanel panel_4 = new JPanel();
    panel_4.setForeground(Color.BLACK);
    panel_4.setBackground(Color.ORANGE);
    panel_3.add(panel_4, "North");
    JLabel country = new JLabel("THE COCK IS SHOWING THE TIME OF " + s + " IS --- ");
    country.setForeground(Color.BLACK);
    panel_4.add(country);
    clockdesign2 container2 = new clockdesign2(s);
    panel_3.add(container2, "Center");
    container2.setBackground(Color.GRAY);
    JPanel panel_5 = new JPanel();
    panel_2.add(panel_5);
    panel_5.setLayout(new BorderLayout(0, 0));
    JPanel panel_6 = new JPanel();
    panel_6.setBackground(Color.ORANGE);
    panel_5.add(panel_6, "North");
    panel_6.setLayout(new FlowLayout(1, 5, 5));
    JLabel lblWeatherPress = new JLabel("PRESS WEATHER BUTTON TO GET THE CURRENT WEATHER INFORMATION ");
    lblWeatherPress.setForeground(Color.BLACK);
    panel_6.add(lblWeatherPress);
    JPanel panel_7 = new JPanel();
    panel_7.setBackground(Color.GRAY);
    panel_5.add(panel_7, "Center");
    panel_7.setLayout(new FlowLayout(1, 5, 5));
    JButton btnWeather = new JButton("WEATHER");
    btnWeather.setFont(new Font("Berlin Sans FB Demi", 0, 14));
    btnWeather.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {}
        });
    panel_7.add(btnWeather);
  }
}
