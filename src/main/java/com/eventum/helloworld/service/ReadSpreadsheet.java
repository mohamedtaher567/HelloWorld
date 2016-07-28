package com.eventum.helloworld.service;

 
import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;
@Service
public class ReadSpreadsheet {
 
    public static final String GOOGLE_ACCOUNT_USERNAME = "mohamedtaher567@gmail.com"; // Fill in google account username
      public static final String GOOGLE_ACCOUNT_PASSWORD = "77799910"; // Fill in google account password
      public static final String SPREADSHEET_URL = "https://docs.google.com/spreadsheets/d/1beaRpFbwJLB0Xo-DRubU3tc9RyNus0Od3drTCRIOVgo/edit?usp=sharing"; //Fill in google spreadsheet URI
 
      public String getSheet() throws IOException, ServiceException
      {
        /** Our view of Google Spreadsheets as an authenticated Google user. */
        SpreadsheetService service = new SpreadsheetService("Print Google Spreadsheet Demo");
 
        // Login and prompt the user to pick a sheet to use.
        service.setUserCredentials(GOOGLE_ACCOUNT_USERNAME, GOOGLE_ACCOUNT_PASSWORD);
 
        // Load sheet
        URL metafeedUrl = new URL(SPREADSHEET_URL);
        SpreadsheetEntry spreadsheet = service.getEntry(metafeedUrl, SpreadsheetEntry.class);
        URL listFeedUrl = ((WorksheetEntry) spreadsheet.getWorksheets().get(0)).getListFeedUrl();
 
        // Print entries
        ListFeed feed = (ListFeed) service.getFeed(listFeedUrl, ListFeed.class);
        String str = "";
        for(ListEntry entry : feed.getEntries())
        {
    	  str = str + "new row\n";
          for(String tag : entry.getCustomElements().getTags())
          {
        	  str = str + "     "+tag + ": " + entry.getCustomElements().getValue(tag)+"\n";
          }
        }
        return str;
      }
}