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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class DigitalAnalogClock extends Thread {
  private JFrame frame;
  
  Thread t;
  
  Thread t2;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {
              DigitalAnalogClock window = new DigitalAnalogClock();
              window.frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          }
        });
  }
  
  public DigitalAnalogClock() {
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
    this.frame.setVisible(true);
    this.frame.setBounds(0, 0, 1300, 800);
    this.frame.setDefaultCloseOperation(0);
    this.frame.getContentPane().setLayout(new BorderLayout(0, 0));
    JPanel panel = new JPanel();
    panel.setBackground(Color.BLACK);
    this.frame.getContentPane().add(panel, "North");
    panel.setLayout(new FlowLayout(1, 5, 5));
    JLabel lblDigitalAnalogClock = new JLabel("DIGITAL ANALOG CLOCK");
    lblDigitalAnalogClock.setFont(new Font("SansSerif", 3, 20));
    lblDigitalAnalogClock.setForeground(Color.CYAN);
    panel.add(lblDigitalAnalogClock);
    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.DARK_GRAY);
    this.frame.getContentPane().add(panel1, "South");
    panel1.setLayout(new FlowLayout(1, 5, 5));
    JButton btnClose = new JButton("CLOSE");
    btnClose.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            DigitalAnalogClock.this.frame.dispose();
          }
        });
    btnClose.setFont(new Font("Berlin Sans FB Demi", 0, 13));
    btnClose.setForeground(Color.RED);
    panel1.add(btnClose);
    JPanel panel_1 = new JPanel();
    this.frame.getContentPane().add(panel_1, "Center");
    panel_1.setLayout(new GridLayout(0, 2, 0, 0));
    JPanel panel_2 = new JPanel();
    panel_1.add(panel_2);
    panel_2.setLayout(new BorderLayout(0, 0));
    JPanel panel_3 = new JPanel();
    panel_3.setForeground(Color.WHITE);
    panel_3.setBackground(Color.DARK_GRAY);
    panel_2.add(panel_3, "North");
    panel_3.setLayout(new FlowLayout(1, 50, 10));
    JLabel lblCurrentTimeIs = new JLabel("CURRENT TIME AND DATE IS SHOWING ---");
    lblCurrentTimeIs.setForeground(Color.WHITE);
    panel_3.add(lblCurrentTimeIs);
    clockdesign container = new clockdesign();
    container.setBackground(Color.BLACK);
    panel_2.add(container, "Center");
    JPanel panel_4 = new JPanel();
    panel_1.add(panel_4);
    panel_4.setLayout(new BorderLayout(0, 0));
    JPanel panel_5 = new JPanel();
    panel_5.setBackground(Color.DARK_GRAY);
    panel_4.add(panel_5, "North");
    JPanel panel_6 = new JPanel();
    panel_4.add(panel_6, "Center");
    panel_6.setLayout(new BorderLayout(0, 0));
    JPanel panel_7 = new JPanel();
    panel_7.setForeground(Color.WHITE);
    panel_7.setBackground(Color.DARK_GRAY);
    panel_6.add(panel_7, "North");
    panel_7.setLayout(new FlowLayout(1, 5, 5));
    JLabel lblNewLabel = new JLabel("TO SEE THE OTHER CITY TIME SELECT THE CITY AND PRESS THE ENTER BUTTON : ");
    lblNewLabel.setForeground(Color.WHITE);
    panel_7.add(lblNewLabel, "North");
    final JPanel panel_81 = new JPanel();
    panel_6.add(panel_81, "Center");
    panel_81.setLayout(new BorderLayout(0, 0));
    JPanel panel_82 = new JPanel();
    panel_81.add(panel_82, "North");
    panel_82.setLayout(new FlowLayout(1, 5, 5));
    String[] aray = { 
        "Asia/Dhaka", "Africa/Algiers", "Africa/Asmara", "Africa/Bujumbura", "Africa/Brazzaville", "Africa/Cairo", "Africa/Casablanca", "Africa/Ceuta", "Africa/Conakry", "Africa/Dakar", 
        "Africa/Dar_es_Salaam", "Africa/Freetown", "Africa/Harare", "Africa/Johannesburg", "Africa/Juba", "Africa/Kampala", "Africa/Khartoum", "Africa/Kigali", "Africa/Kinshasa", "Africa/Lagos", 
        "Africa/Libreville", "Africa/Luanda", "Africa/Maputo", "Africa/Mogadishu", "Africa/Monrovia", "Africa/Nairobi", "Africa/Niamey", "Africa/Nouakchott", "Africa/Timbuktu", "Africa/Tripoli", 
        "Africa/Tunis", "Africa/Windhoek", "America/Antigua", "America/Argentina/Buenos_Aires", "America/Argentina/Cordoba", "America/Asuncion", "America/Barbados", "America/Belize", "America/Bogota", "America/Buenos_Aires", 
        "America/Caracas", "America/Chicago", "America/Costa_Rica", "America/Denver", "America/Detroit", "America/Dominica", "America/El_Salvador", "America/Grenada", "America/Guatemala", "America/Guyana", 
        "America/Havana", "America/Jamaica", "America/Lima", "America/Los_Angeles", "America/Mexico_City", "America/Montreal", "America/New_York", "America/Panama", "America/Sao_Paulo", "America/St_Kitts", 
        "America/Toronto", "America/Vancouver", "Antarctica/South_Pole", "Arctic/Longyearbyen", "Asia/Aden", "Asia/Amman", "Asia/Ashgabat", "Asia/Ashkhabad", "Asia/Baghdad", "Asia/Bahrain", 
        "Asia/Baku", "Asia/Bangkok", "Asia/Beirut", "Asia/Bishkek", "Asia/Brunei", "Asia/Calcutta", "Asia/Colombo", "Asia/Dacca", "Asia/Damascus", "Asia/Dili", 
        "Asia/Dubai", "Asia/Dushanbe", "Asia/Gaza", "Asia/Hebron", "Asia/Hong_Kong", "Asia/Irkutsk", "Asia/Istanbul", "Asia/Jakarta", "Asia/Jayapura", "Asia/Jerusalem", 
        "Asia/Kabul", "Asia/Karachi", "Asia/Kathmandu", "Asia/Kolkata", "Asia/Kuala_Lumpur", "Asia/Macao", "Asia/Manila", "Asia/Qatar", "Asia/Rangoon", "Asia/Riyadh", 
        "Asia/Shanghai", "Asia/Singapore", "Asia/Tehran", "Asia/Tel_Aviv", "Asia/Thimbu", "Asia/Tokyo", "Atlantic/Bermuda", "Atlantic/St_Helena", "Australia/Canberra", "Australia/Hobart", 
        "Australia/Melbourne", "Australia/Perth", "Australia/Queensland", "Australia/Sydney", "Australia/Tasmania", "Brazil/Acre", "Canada/Central", "Canada/Newfoundland", "Canada/Pacific", "Chile/Continental", 
        "Cuba", "Egypt", "Europe/Amsterdam", "Europe/Andorra", "Europe/Athens", "Europe/Belfast", "Europe/Belgrade", "Europe/Berlin", "Europe/Bratislava", "Europe/Brussels", 
        "Europe/Bucharest", "Europe/Budapest", "Europe/Copenhagen", "Europe/Dublin", "Europe/Helsinki", "Europe/Istanbul", "Europe/Jersey", "Europe/Lisbon", "Europe/London", "Europe/Luxembourg", 
        "Europe/Madrid", "Europe/Moscow", "Europe/Oslo", "Europe/Paris", "Europe/Rome", "Europe/Skopje", "Europe/Sofia", "Europe/Stockholm", "Europe/Vatican", "Europe/Vienna", 
        "Europe/Volgograd", "Europe/Zagreb", "Europe/Zurich", "GMT", "Greenwich", "Iceland", "Iran", "Israel", "Jamaica", "Japan", 
        "Libya", "Pacific/Auckland", "Pacific/Fiji", "Pacific/Nauru", "Poland", "Portugal", "Singapore", "Turkey", "US/Alaska", "US/Arizona", 
        "US/Hawaii", "US/Michigan" };
    final JComboBox<String> comboBox = new JComboBox<>(aray);
    comboBox.setFont(new Font("Berlin Sans FB Demi", 0, 16));
    panel_82.add(comboBox);
    JButton btnEnter = new JButton("ENTER");
    btnEnter.setFont(new Font("Berlin Sans FB Demi", 0, 15));
    btnEnter.setBackground(Color.BLACK);
    btnEnter.setForeground(Color.RED);
    panel_82.add(btnEnter);
    final JLabel lblNew = new JLabel("New label");
    panel_81.add(lblNew, "West");
    btnEnter.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            String selection = (String)comboBox.getSelectedItem();
            lblNew.setText(selection);
            clockdesign2 container2 = new clockdesign2(selection);
            DigitalAnalogClock.this.t = new Thread(container2);
            DigitalAnalogClock.this.t.start();
            panel_81.add(container2, "Center");
          }
        });
    JButton btnBack = new JButton("STOP");
    btnBack.setForeground(Color.RED);
    btnBack.setFont(new Font("Berlin Sans FB Demi", 0, 15));
    btnBack.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            DigitalAnalogClock.this.t.stop();
          }
        });
    panel_82.add(btnBack);
    JButton btnNext = new JButton("NEXT");
    btnNext.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            weatherinput input = new weatherinput();
          }
        });
    btnNext.setForeground(Color.RED);
    btnNext.setFont(new Font("Berlin Sans FB Demi", 0, 15));
    panel_82.add(btnNext);
  }
}
