package clock;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class weathermap {
   public String location;
   String apikey;
   String urlstring;
   URL url;
   URLConnection con;
   StringBuilder result;
   BufferedReader fr;
   String line;
   Map<String, Object> respmap;

   public Map<String, Object> jsonToMap(String str) {
      Map<String, Object> map = (Map)(new Gson()).fromJson(str, (new TypeToken<HashMap<String, Object>>() {
      }).getType());
      return map;
   }

   public weathermap(String loc) {
      this.location = loc;
      this.apikey = "b34fcb369b0ace824e03feca497edcd6";
      this.urlstring = "http://api.openweathermap.org/data/2.5/weather?q=" + this.location + "&appid=" + this.apikey + "&units=Metric";

      try {
         this.url = new URL(this.urlstring);
         this.con = this.url.openConnection();
         this.result = new StringBuilder();
         this.fr = new BufferedReader(new InputStreamReader(this.con.getInputStream()));

         while((this.line = this.fr.readLine()) != null) {
            this.result.append(this.line);
         }

         this.fr.close();
         this.respmap = this.jsonToMap(this.result.toString());
         Object var2 = null;
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public String getname() {
      Iterator var2 = this.respmap.entrySet().iterator();

      while(var2.hasNext()) {
         Entry<String, Object> i = (Entry)var2.next();
         if (((String)i.getKey()).equals("name")) {
            return (String)i.getValue();
         }
      }

      return null;
   }

   public Map<String, Object> getmain() {
      Map<String, Object> mainmap = this.jsonToMap(this.respmap.get("main").toString());
      return mainmap;
   }

   public Map<String, Object> getwind() {
      Map<String, Object> windmap = this.jsonToMap(this.respmap.get("wind").toString());
      return windmap;
   }

   public Map<String, Object> getcloud() {
      Map<String, Object> cloudmap = this.jsonToMap(this.respmap.get("clouds").toString());
      return cloudmap;
   }

   public Map<String, Object> getsys() {
      Map<String, Object> sysmap = this.jsonToMap(this.respmap.get("sys").toString());
      return sysmap;
   }
}