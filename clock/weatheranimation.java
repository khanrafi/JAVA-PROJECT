package clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class weatheranimation {
  private JFrame frame;
  
  static String location;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {
              weatheranimation window = new weatheranimation(weatheranimation.location);
              window.frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          }
        });
  }
  
  public weatheranimation(String loc) {
    location = loc;
    initialize();
  }
  
  private void initialize() {
    this.frame = new JFrame();
    this.frame.setVisible(true);
    this.frame.setBounds(5, 5, 1200, 950);
    this.frame.setDefaultCloseOperation(0);
    weathermap ob2 = new weathermap(location);
    String name = ob2.getname();
    Map<String, Object> main = ob2.getmain();
    Map<String, Object> wind = ob2.getwind();
    Map<String, Object> cloud = ob2.getcloud();
    Map<String, Object> sys = ob2.getsys();
    JPanel panel = new JPanel();
    panel.setBackground(Color.DARK_GRAY);
    this.frame.getContentPane().add(panel, "Center");
    panel.setLayout(new BorderLayout(0, 0));
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.BLACK);
    panel.add(panel_1, "North");
    panel_1.setLayout(new FlowLayout(1, 10, 10));
    JLabel lblCityname = new JLabel("cityname");
    lblCityname.setFont(new Font("Tahoma", 1, 13));
    lblCityname.setForeground(Color.WHITE);
    lblCityname.setBackground(Color.WHITE);
    panel_1.add(lblCityname);
    lblCityname.setText(name);
    JPanel panel_2 = new JPanel();
    panel_2.setBackground(Color.DARK_GRAY);
    panel.add(panel_2, "Center");
    panel_2.setLayout(new GridLayout(2, 0, 0, 0));
    JPanel panel_4 = new JPanel();
    panel_4.setBackground(Color.DARK_GRAY);
    panel_2.add(panel_4);
    panel_4.setLayout((LayoutManager)null);
    JLabel lblTemp = new JLabel("temp");
    lblTemp.setFont(new Font("Tahoma", 1, 15));
    lblTemp.setForeground(new Color(139, 0, 0));
    lblTemp.setBounds(536, 25, 277, 30);
    panel_4.add(lblTemp);
    lblTemp.setText("TEMPERATURE IS : " + main.get("temp") + " * CELCIUS");
    JLabel lblMaxTemp = new JLabel("max temp");
    lblMaxTemp.setFont(new Font("Tahoma", 1, 14));
    lblMaxTemp.setForeground(new Color(139, 0, 0));
    lblMaxTemp.setBounds(431, 110, 356, 35);
    panel_4.add(lblMaxTemp);
    lblMaxTemp.setText("MAXIMIUM TEMPERATURE IS : " + main.get("temp_max") + " * CELCIUS");
    JLabel lblMinTemp = new JLabel("min temp");
    lblMinTemp.setFont(new Font("Tahoma", 1, 13));
    lblMinTemp.setForeground(new Color(0, 255, 0));
    lblMinTemp.setBounds(881, 113, 293, 30);
    panel_4.add(lblMinTemp);
    lblMinTemp.setText("MINIMUM TEMPERATURE IS : " + main.get("temp_min") + " * CELCIUS");
    JLabel lblCloud = new JLabel("cloud");
    lblCloud.setFont(new Font("Tahoma", 3, 17));
    lblCloud.setForeground(new Color(0, 255, 0));
    lblCloud.setBounds(881, 179, 293, 41);
    panel_4.add(lblCloud);
    lblCloud.setText("TOTAL CLOUDINESS : " + cloud.get("all") + " %");
    JLabel lblSky = new JLabel();
    lblSky.setIcon(new ImageIcon("sun.jpg"));
    lblSky.setBounds(10, 0, 872, 351);
    panel_4.add(lblSky);
    JPanel panel_3 = new JPanel();
    panel_3.setBackground(Color.DARK_GRAY);
    panel_2.add(panel_3);
    panel_3.setLayout((LayoutManager)null);
    JLabel lblHumidity = new JLabel("humidity");
    lblHumidity.setForeground(Color.BLACK);
    lblHumidity.setFont(new Font("Tahoma", 1, 14));
    lblHumidity.setBounds(565, 24, 247, 26);
    panel_3.add(lblHumidity);
    lblHumidity.setText("HUMIDITY IS : " + main.get("humidity") + " %");
    JLabel lblWindSpeed = new JLabel("wind speed");
    lblWindSpeed.setFont(new Font("Tahoma", 1, 14));
    lblWindSpeed.setBounds(565, 73, 309, 26);
    panel_3.add(lblWindSpeed);
    lblWindSpeed.setText("WIND SPEED :" + wind.get("speed") + " METER/SECOND");
    JLabel lblWindAngle = new JLabel("wind angle");
    lblWindAngle.setFont(new Font("Tahoma", 1, 14));
    lblWindAngle.setBounds(565, 123, 309, 33);
    panel_3.add(lblWindAngle);
    lblWindAngle.setText("WIND DIRECTION :" + wind.get("deg") + " DEGREE");
    JLabel lblAtmosphiricpressure = new JLabel("atmosphiricpressure");
    lblAtmosphiricpressure.setFont(new Font("Tahoma", 1, 14));
    lblAtmosphiricpressure.setBounds(565, 188, 309, 26);
    panel_3.add(lblAtmosphiricpressure);
    lblAtmosphiricpressure.setText("ATMOSPHIRIC PRESSURE :" + main.get("pressure") + " hPa");
    JLabel lblCloudsky = new JLabel("cloudsky");
    lblCloudsky.setIcon(new ImageIcon("skycloud.jpg"));
    lblCloudsky.setBounds(10, 0, 853, 351);
    panel_3.add(lblCloudsky);
    JButton btnClose = new JButton("CLOSE");
    btnClose.setForeground(Color.BLUE);
    btnClose.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            weatheranimation.this.frame.dispose();
          }
        });
    btnClose.setFont(new Font("Berlin Sans FB Demi", 0, 14));
    btnClose.setBounds(1030, 232, 109, 23);
    panel_3.add(btnClose);
    JButton btnGoBack = new JButton("GO BACK");
    btnGoBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            weatherinput in = new weatherinput();
          }
        });
    btnGoBack.setForeground(Color.BLUE);
    btnGoBack.setFont(new Font("Berlin Sans FB Demi", 0, 14));
    btnGoBack.setBounds(1030, 150, 109, 23);
    panel_3.add(btnGoBack);
  }
}
