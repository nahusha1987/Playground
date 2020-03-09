package com.home.nash.spotify.tracks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Code to retrieve liked songs list using Spotify Developer API and 
 * write it out to an XLS sheet
 */
public class App 
{
	private static final String FILE_NAME = "/home/nahusha/MySongsList.xlsx";
	Map <String, Object[]>  trackDetails = new TreeMap <String, Object[]>();
	
	public static void main( String[] args )
    {
        App app = new App();
        app.getTracks();
        try {
			app.writeToExcel();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private void writeToExcel() throws IOException {
    	XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Track list");
        Set<String> keyid = trackDetails.keySet();
        int rowid = 0;
        XSSFRow row;

        for (String key : keyid) {
           row = sheet.createRow(rowid++);
           Object [] objectArr = trackDetails.get(key);
           int cellid = 0;
           
           for (Object obj : objectArr){
              Cell cell = row.createCell(cellid++);
              cell.setCellValue((String)obj);
           }
        }
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(
           new File(FILE_NAME));
        
        workbook.write(out);
        out.close();
        workbook.close();
	}

	private void getTracks() {
    	String uri = "https://api.spotify.com/v1/me/tracks?limit=50&market=IN&offset=";
    	RestTemplate restTemplate = new RestTemplate();
    	HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer BQCOyDNu_hblCB3MvOOgUu9VcbEAsCRRPK7RmXk1F0FlxM-GJ2suOBjb4WGJX8sIV5c9jYMcVdLZkTo8GshH5Y7IuLXOQ7dNSM1voInS07gf6zgS9Kl7KFBDmpvmf_0OqSo2p5MnyCDdFuhnLgHvXenKJNxVFld8w0kABIhlasxO_Gi4NhY3IUmYzOekepRaP7zo0QOljANF");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
        int index = 1;
        for (int i = 0; i < 250; i+=50) {
        	String spotifyUri = uri + String.valueOf(i);
        	ResponseEntity<String> result = restTemplate.exchange(spotifyUri, HttpMethod.GET, entity, String.class);
        	JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();
        	JsonArray jsonArray = jsonObject.get("items").getAsJsonArray();
        	for (JsonElement elem : jsonArray) {
        		JsonObject obj = elem.getAsJsonObject().get("track").getAsJsonObject();
        		String trackName = obj.get("name").getAsString();
        		String artistName = obj.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString();
        		String albumName = obj.getAsJsonObject().get("album").getAsJsonObject().get("name").getAsString();
        		trackDetails.put(String.valueOf(index++), new Object[] {trackName, artistName, albumName});
        	}
        }
    }
}
