package clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import javax.swing.JPanel;

class clockdesign2 extends JPanel implements Runnable {
  private static final int spacing = 100;
  
  private int size;
  
  private int centerX;
  
  private int centerY;
  
  private double pi = Math.PI;
  
  Thread t = null;
  
  SimpleDateFormat sf;
  
  Calendar cal;
  
  int hour;
  
  int minute;
  
  int second;
  
  int day;
  
  int month;
  
  int year;
  
  Color colorSecond;
  
  Color colorMHour;
  
  Color colorNumber;
  
  double rhours;
  
  double rsecond;
  
  double rminute;
  
  Timer timer;
  
  TimeZone timeZone;
  
  int theta;
  
  double sectheta;
  
  double mintheta;
  
  double hrtheta;
  
  protected String set;
  
  Thread t1;
  
  public clockdesign2(String s) {
    start(s);
  }
  
  public synchronized void start(String s) {
    this.set = s;
  }
  
  public void run() {
    try {
      while (true) {
        String[] tz = TimeZone.getAvailableIDs();
        int l = tz.length;
        for (int i = 0; i < l; i++) {
          TimeZone y = TimeZone.getTimeZone(tz[i]);
          if (y.getID().equals(this.set))
            this.cal = Calendar.getInstance(y); 
        } 
        repaint();
        Thread.sleep(1000L);
      } 
    } catch (InterruptedException e) {
      e.printStackTrace();
      return;
    } 
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.BLACK);
    g.fillOval(250, 100, 350, 350);
    g.setColor(Color.WHITE);
    g.fillOval(260, 110, 330, 330);
    this.size = 300;
    this.centerX = 425;
    this.centerY = 275;
    this.hour = this.cal.get(10);
    this.minute = this.cal.get(12);
    this.second = this.cal.get(13);
    this.day = this.cal.get(5);
    this.month = this.cal.get(2) + 1;
    this.year = this.cal.get(1);
    g.setColor(Color.LIGHT_GRAY);
    g.fillRect(this.centerX - 30, this.centerY - 10, 87, 20);
    g.setColor(Color.BLACK);
    g.drawRect(this.centerX - 30, this.centerY - 10, 87, 20);
    this.sf = new SimpleDateFormat("hh a");
    g.setColor(Color.BLACK);
    g.setFont(new Font("Tahoma", 1, 15));
    if (this.hour == 0)
      this.hour += 12; 
    if (this.hour < 10) {
      if (this.second < 10 && this.minute >= 10) {
        g.drawString("0" + this.hour + ":" + this.minute + ":" + "0" + this.second, this.centerX - 45 + 20, this.centerY + 5);
      } else if (this.minute < 10 && this.second >= 10) {
        g.drawString("0" + this.hour + ":" + "0" + this.minute + ":" + this.second, this.centerX - 45 + 20, this.centerY + 5);
      } else if (this.second < 10 && this.minute < 10) {
        g.drawString("0" + this.hour + ":" + "0" + this.minute + ":" + "0" + this.second, this.centerX - 45 + 20, this.centerY + 5);
      } else {
        g.drawString("0" + this.hour + ":" + this.minute + ":" + this.second, this.centerX - 45 + 20, this.centerY + 5);
      } 
    } else if (this.second < 10 && this.minute >= 10) {
      g.drawString(String.valueOf(this.hour) + ":" + this.minute + ":" + "0" + this.second, this.centerX - 45 + 20, this.centerY + 5);
    } else if (this.minute < 10 && this.second >= 10) {
      g.drawString(String.valueOf(this.hour) + ":" + "0" + this.minute + ":" + this.second, this.centerX - 45 + 20, this.centerY + 5);
    } else if (this.second < 10 && this.minute < 10) {
      g.drawString(String.valueOf(this.hour) + ":" + "0" + this.minute + ":" + "0" + this.second, this.centerX - 45 + 20, this.centerY + 5);
    } else {
      g.drawString(String.valueOf(this.hour) + ":" + this.minute + ":" + this.second, this.centerX - 45 + 20, this.centerY + 5);
    } 
    String monthname = new String();
    if (this.month == 1) {
      monthname = "JANUARY ";
    } else if (this.month == 2) {
      monthname = "FEBRAURY ";
    } else if (this.month == 3) {
      monthname = "MARCH ";
    } else if (this.month == 4) {
      monthname = "APRIL ";
    } else if (this.month == 5) {
      monthname = "MAY ";
    } else if (this.month == 6) {
      monthname = "JUNE ";
    } else if (this.month == 7) {
      monthname = "JULY ";
    } else if (this.month == 8) {
      monthname = "AUGUST ";
    } else if (this.month == 9) {
      monthname = "SEPTEMBER ";
    } else if (this.month == 10) {
      monthname = "OCTOBER ";
    } else if (this.month == 11) {
      monthname = "NOVEMBER ";
    } else if (this.month == 12) {
      monthname = "DECEMBER ";
    } 
    g.setColor(Color.BLACK);
    g.drawRect(150, 520, 170, 35);
    g.drawString("DATE: " + this.day + " " + monthname, 170, 540);
    g.setColor(Color.BLACK);
    g.drawRect(460, 520, 120, 30);
    g.drawString("YEAR: " + this.year, 475, 540);
    g.setColor(Color.BLACK);
    this.theta = 0;
    while (this.theta <= 360) {
      double r = Math.toRadians(this.theta);
      int x1 = (int)(175.0D * Math.cos(r));
      int y1 = (int)(175.0D * Math.sin(r));
      int x2 = (int)(140.0D * Math.cos(r));
      int y2 = (int)(140.0D * Math.sin(r));
      g.drawLine(x1 + this.centerX, y1 + this.centerY, x2 + this.centerX, y2 + this.centerY);
      this.theta += 30;
    } 
    g.setColor(Color.BLUE);
    this.theta = 0;
    while (this.theta <= 360) {
      double r = Math.toRadians(this.theta);
      int x11 = (int)(175.0D * Math.cos(r));
      int y11 = (int)(175.0D * Math.sin(r));
      int x22 = (int)(165.0D * Math.cos(r));
      int y22 = (int)(165.0D * Math.sin(r));
      g.drawLine(x11 + this.centerX, y11 + this.centerY, x22 + this.centerX, y22 + this.centerY);
      this.theta += 6;
    } 
    this.rsecond = this.second * 6.0D * Math.PI / 180.0D;
    this.rminute = (this.minute + this.second / 60.0D) * 6.0D * Math.PI / 180.0D;
    this.rhours = (this.hour + this.minute / 60.0D) * 30.0D * Math.PI / 180.0D;
    g.setColor(Color.RED);
    g.drawLine(this.centerX, this.centerY, this.centerX + (int)(176.0D * Math.cos(this.rsecond - this.pi / 2.0D)), this.centerY + (int)(176.0D * Math.sin(this.rsecond - this.pi / 2.0D)));
    g.setColor(Color.BLUE);
    g.drawLine(this.centerX, this.centerY, this.centerX + (int)(140.0D * Math.cos(this.rminute - this.pi / 2.0D)), this.centerY + (int)(140.0D * Math.sin(this.rminute - this.pi / 2.0D)));
    g.setColor(Color.BLACK);
    g.drawLine(this.centerX, this.centerY, this.centerX + (int)(95.0D * Math.cos(this.rhours - this.pi / 2.0D)), this.centerY + (int)(95.0D * Math.sin(this.rhours - this.pi / 2.0D)));
  }
}
