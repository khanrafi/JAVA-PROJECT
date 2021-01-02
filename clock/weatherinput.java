package clock;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class weatherinput {
  private JFrame frame;
  
  String s;
  
  JComboBox comboBox;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {
              weatherinput window = new weatherinput();
              window.frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          }
        });
  }
  
  public weatherinput() {
    initialize();
  }
  
  private void initialize() {
    this.frame = new JFrame();
    this.frame.getContentPane().setForeground(Color.BLUE);
    this.frame.getContentPane().setFont(new Font("Tahoma", 0, 14));
    this.frame.setVisible(true);
    this.frame.getContentPane().setBackground(Color.WHITE);
    this.frame.setBounds(500, 150, 697, 386);
    this.frame.setDefaultCloseOperation(0);
    this.frame.getContentPane().setLayout((LayoutManager)null);
    this.frame.setResizable(false);
    JLabel lblInputLocationSuch = new JLabel("INPUT CITY NAME AND COUNTRY TO SEE THE WEATHER, SUCH THAT London,UK OR London");
    lblInputLocationSuch.setFont(new Font("Tahoma", 0, 13));
    lblInputLocationSuch.setForeground(Color.BLACK);
    lblInputLocationSuch.setBackground(Color.DARK_GRAY);
    lblInputLocationSuch.setBounds(21, 90, 579, 23);
    this.frame.getContentPane().add(lblInputLocationSuch);
    JButton btnInput = new JButton("INPUT");
    btnInput.setFont(new Font("Berlin Sans FB Demi", 0, 15));
    btnInput.setForeground(Color.BLUE);
    btnInput.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            weatherinput.this.s = (String)weatherinput.this.comboBox.getSelectedItem();
            weatheranimation a = new weatheranimation(weatherinput.this.s);
          }
        });
    btnInput.setBounds(21, 199, 89, 23);
    this.frame.getContentPane().add(btnInput);
    JLabel lblInputLocationFor = new JLabel("INPUT LOCATION FOR WEATHER INFORMATION");
    lblInputLocationFor.setFont(new Font("Tahoma", 2, 14));
    lblInputLocationFor.setBounds(177, 11, 330, 14);
    this.frame.getContentPane().add(lblInputLocationFor);
    JButton btnClose = new JButton("CLOSE");
    btnClose.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            weatherinput.this.frame.dispose();
          }
        });
    btnClose.setFont(new Font("Berlin Sans FB Demi", 0, 14));
    btnClose.setForeground(Color.BLUE);
    btnClose.setBounds(321, 323, 100, 25);
    this.frame.getContentPane().add(btnClose);
    String[] aray2 = { 
        " KABUL,AFGHANISTAN", 
        " TIRANA ,ALBANIA", 
        "ALGIERS,ALGERIA ", 
        "ANDORRA LA VELLA ,ANDORRA", 
        "ANGOLA,LUANDA", 
        "ANTIGUA & BARBUDA,SAINT JOHN'S", 
        "BUENOS AIRES,ARGENTINA", 
        "YEREVAN,ARMENIA", 
        "CANBERRA,AUSTRALIA", 
        "VIENNA,AUSTRIA", 
        "BAKU,AZERBAIJAN", 
        "NASSAU,BAHAMAS", 
        "MANAMA,BAHRAIN", 
        "DHAKA,BANGLADESH", 
        "BRIDGETOWN,BARBADOS", 
        "MINSK,BELARUS", 
        "BRUSSELS,BELGIUM", 
        "BELMOPAN,BELIZE", 
        "THIMPHU,BHUTAN", 
        "SUCRE,BOLIVIA\t", 
        "GABORONE,BOTSWANA", 
        "BRASILIA,BRAZIL", 
        "BANDAR SERI BEGAWAN,BRUNEI", 
        "SOFIA,BULGARIA", 
        "OUAGADOUGOU,BURKINA FASO", 
        "BUJUMBURA,BURUNDI", 
        "PRAIA,CABO VERDE", 
        "PHNOM PENH,CAMBODIA", 
        "YAOUNDE,CAMEROON", 
        "OTTAWA,CANADA", 
        "BANGUI,CENTRAL AFRICAN REPUBLIC", 
        "N'DJAMENA,CHAD", 
        "SANTIAGO,CHILE", 
        "BEIJING,CHINA", 
        "MORONI,COMOROS", 
        "HAVANA,CUBA", 
        "NICOSIA,CYPRUS", 
        "PRAGUE,CZECH REPUBLIC", 
        "COPENHAGEN,DENMARK" };
    this.comboBox = new JComboBox<>(aray2);
    this.comboBox.setBounds(21, 139, 322, 41);
    this.frame.getContentPane().add(this.comboBox);
  }
}
