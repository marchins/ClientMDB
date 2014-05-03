/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestoreGoogleBooks;

import LogicaDominio.Libro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;


/**
 *
 * @author Alessio
 */
public class GestoreGoogleBooks {
    private static final String API_KEY ="AIzaSyC_W66XwLm0yOBP1TOaC53AQ9xCkN1CvHA";
    private static final String URL_RICHIESTA="https://www.googleapis.com/books/v1/volumes?key=%s&q=%s%s";
    private static final String URL_RICHIESTA_ISBN= "isbn:";
    private static final String URL_RICHIESTA_AUTORE= "inauthor:";
    private static final String URL_RICHIESTA_TITOLO= "intitle:";
    public static final String ISBN="isbn";
    public static final String TITOLO="titolo";
    public static final String AUTORE="autore";
    
    public static List<Libro> ricercaLibroTramiteParametro(String keyword, String parametro) throws IOException {
        keyword=keyword.replace(" ", "%20");
        switch(parametro) {
            case ISBN: 
                return richiestaGoogleBooks(String.format(URL_RICHIESTA, API_KEY,URL_RICHIESTA_ISBN,keyword));
            case TITOLO:
                return richiestaGoogleBooks(String.format(URL_RICHIESTA, API_KEY,URL_RICHIESTA_TITOLO,keyword));
            case AUTORE:
                return richiestaGoogleBooks(String.format(URL_RICHIESTA, API_KEY,URL_RICHIESTA_AUTORE,keyword));
        }
    return null;
    }
    
    private static List<Libro> richiestaGoogleBooks(String urlRichiesta) throws MalformedURLException, IOException {
        URL googleBooks = new URL(urlRichiesta);
        URLConnection con = googleBooks.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String inputLine="";
	String response="";
        
	while ((inputLine = in.readLine()) != null) { 
	            response = response+inputLine;
	}
        System.out.println(response);
        JSONObject json = (JSONObject) JSONSerializer.toJSON(response);
	JSONArray risultatiRicercaGoogleBooks = json.getJSONArray("items");
	
        return convertiFormato(risultatiRicercaGoogleBooks);
    }
    
    
    //TODO
    private static List<Libro> convertiFormato(JSONArray risultatoGoogleBooks) {
    
    List<Libro> libriConvertiti = new ArrayList<>();    
    
    for(Object object: risultatoGoogleBooks){
        Libro libroConvertito = new Libro();  
      
        JSONObject volumeInfo = ((JSONObject)object).getJSONObject("volumeInfo");
        
        String titolo=((JSONObject) volumeInfo).getString("title");
        System.out.println(titolo);
        
        String autori=((JSONObject) volumeInfo).getString("authors");
        autori=autori.replace("\"","");
        autori=autori.replace("[","");
        autori=autori.replace("]","");
        System.out.println(autori);
        
        String dataPubblicazione=((JSONObject) volumeInfo).getString("publishedDate");
        System.out.println(dataPubblicazione);
        
        String casaEditrice = ((JSONObject) volumeInfo).getString("publisher");
        System.out.println(casaEditrice);
        
        //ISBN
        JSONArray identifiers = (JSONArray)((JSONObject) volumeInfo).get("industryIdentifiers");
        String isbn="";
        for(Object obj: identifiers){
            if(((JSONObject)obj).getString("type").equals("ISBN_13")){
             isbn= ((JSONObject)obj).getString("identifier"); 
             System.out.println(isbn);
            }
        }
        
        String urlCopertina= ((JSONObject) volumeInfo).getJSONObject("imageLinks").getString("thumbnail");
        System.out.println(urlCopertina);

        Libro libro = new Libro(isbn,titolo,autori,casaEditrice,dataPubblicazione,urlCopertina);
        libriConvertiti.add(libro);
    }
    
    return libriConvertiti;  
    }
    
}
