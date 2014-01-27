package com.gluten.api;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

import static com.gluten.filePath.APIPath.USER_XML;
import static com.gluten.filePath.APIPath.USER_JSON;
//import static com.gluten.filePath.APIPath.DATA_DIR;

//import static com.gluten.filePath.APIPath.USER_JSON;



import com.gluten.fileList.APIList;

public final class Api implements APIList{

	@SuppressWarnings({ "unused"})
	public static void main(String[] argv) {

		try {
			FileWriter fileWriter = null;
			FileOutputStream APIfop = null;
			XMLConfiguration config = new XMLConfiguration();
			
			JSONObject json = new JSONObject();
			fileWriter = new FileWriter(USER_JSON);
			
			List<String> APIlist = new ArrayList<String>();
			APIlist.add(UserName);
			APIlist.add(FirstName);
			APIlist.add(LastName);
			APIlist.add(Email);
			APIlist.add(ContactNumber);
			APIlist.add(Status);
			APIlist.add(Group);
			APIlist.add(ItemID);
			APIlist.add(ItemGroup);
			APIlist.add(ItemType);
			APIlist.add(ItemName);
			APIlist.add(ItemPrice);
			APIlist.add(ItemLocation);
			
			List<String> APIChildList = new ArrayList<String>();
			APIChildList.add(Role);

			for (String s : APIlist) {
				config.addProperty(s, "insert");
				for (String x: APIChildList) {
					config.addProperty(x, s);
				}
			}
			for(String e : APIlist) {
				json.put(e, "insert");
			}
			config.save(USER_XML);
			fileWriter.write(json.toString());
			fileWriter.close();
			String test = json.toString();
			
			System.out.println("File saved!");

		}catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JSONException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);

		}catch (NullPointerException e) {
			System.out.println(e);
		}
	}
}
