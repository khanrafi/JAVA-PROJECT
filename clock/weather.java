package clock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

class weather {
  public String location;
  
  public weather(String loc) {
    this.location = loc;
  }
  
  public static Map<String, Object> jsonToMap(String str) {
    Map<String, Object> map = (Map<String, Object>)(new Gson()).fromJson(str, (new TypeToken<HashMap<String, Object>>() {
        
        }).getType());
    return map;
  }
  
  public static void main(String[] args) {
    String apikey = "b34fcb369b0ace824e03feca497edcd6";
    weather ob1 = new weather("Dhaka,BD");
    String urlstring = "http://api.openweathermap.org/data/2.5/weather?q=" + ob1.location + "&appid=" + apikey + "&units=Metric";
    try {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlstring);
      URLConnection con = url.openConnection();
      BufferedReader fr = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String line;
      while ((line = fr.readLine()) != null)
        result.append(line); 
      fr.close();
      Map<String, Object> respmap = jsonToMap(result.toString());
      Map<String, Object> rainmap = null;
      for (Map.Entry<String, Object> i : respmap.entrySet()) {
        if (((String)i.getKey()).equals("name"))
          System.out.println(i.getValue()); 
        if (((String)i.getKey()).equals("rain"))
          rainmap = jsonToMap(respmap.get("rain").toString()); 
      } 
      Map<String, Object> mainmap = jsonToMap(respmap.get("main").toString());
      Map<String, Object> windmap = jsonToMap(respmap.get("wind").toString());
      Map<String, Object> cloudmap = jsonToMap(respmap.get("clouds").toString());
      Map<String, Object> sysmap = jsonToMap(respmap.get("sys").toString());
      System.out.println("CURRENT TEMPARETURE : " + mainmap.get("temp") + " * CELCIUS");
      System.out.println("MAXIMUM TEMPERATURE : " + mainmap.get("temp_max") + " * CELCIUS");
      System.out.println("MINIMUM TEMPERATURE : " + mainmap.get("temp_min") + " * CELCIUS");
      System.out.println("CLOUDINESS : " + cloudmap.get("all") + " %");
      System.out.println("HUMIDITY : " + mainmap.get("humidity") + " %");
      System.out.println("PRESSURE : " + mainmap.get("pressure") + " hPa");
      System.out.println("WIND SPEED : " + windmap.get("speed") + " METER/SECOND");
      System.out.println("WIND DIRECTION : " + windmap.get("deg") + " DEGREE");
      if (rainmap != null)
        System.out.println("rain : " + rainmap.get("3h") + " CUBIC METER"); 
      System.out.println("SUNRISE : " + sysmap.get("sunrise") + " UNIX");
      System.out.println("SUNSET : " + sysmap.get("sunset") + "UNIX");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } 
  }
}
