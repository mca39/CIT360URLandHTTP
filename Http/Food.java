package Http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/*returns the html from www.foodnetwork.com*/
public class Food {

    HttpURLConnection foodNet = null;

    public Food(){
        try{
            URL url = new URL("https://www.foodnetwork.com");
            foodNet = (HttpURLConnection)url.openConnection();
            foodNet.setRequestMethod("GET");
            foodNet.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            foodNet.setRequestProperty("Content-Language", "en-US");
            foodNet.setUseCaches(false);
            foodNet.setDoOutput(true);

            InputStream input = foodNet.getInputStream();
            BufferedReader bufferR = new BufferedReader(new InputStreamReader(input));
            StringBuilder stringBuild = new StringBuilder();
            String line;
            while((line = bufferR.readLine()) != null){
                stringBuild.append(line + "\n");
            }

            bufferR.close();
            System.out.println(stringBuild);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Food food = new Food();
    }
}
