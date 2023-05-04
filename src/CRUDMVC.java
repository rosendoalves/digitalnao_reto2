
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Rosendo
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
        // Solicitar una petición 
        // URL https://serpapi.com/search.json
        // URL https://serpapi.com/search.json?engine=google_scholar_profiles&mauthors=Mike
        // engine: google_scholar
        // api_key 5652a6ad89eab8f4794f54be50f06b785cfebdcf5395921fc549f83182ba7d5c
        
        URL url = new URL("https://serpapi.com/search.json?engine=google_scholar&q=biology&api_key=5652a6ad89eab8f4794f54be50f06b785cfebdcf5395921fc549f83182ba7d5c");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        
        // Petición correcta
        int responseCode = conn.getResponseCode();
        if(responseCode != 200) {
            throw new RuntimeException("Ocurrió un error: " + responseCode);
        } else {
        // Abrir un scanner que lea el flujo de datos
            StringBuilder informationString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            
            while(scanner.hasNext()) {
                informationString.append(scanner.nextLine());
            }
            
            scanner.close();
        // Pintar la información obtenida por consola
        
        System.out.println(informationString);
        
        //Linea
        }
        
        } catch(IOException e) {

        }
      
        
    }
    
}
