package org.functionality.generators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.utils.Utils;

public class NameGenerator
{
	private static final String FIRST_NAME_FILE = "config/first_names.txt";
	private static final String LAST_NAME_FILE = "config/last_names.txt";
	
	private List<String> firstNames = new ArrayList<>();
	private List<String> lastNames = new ArrayList<>();
	
	public NameGenerator()
	{
		loadNames(false);
		loadNames(true);
		System.out.println(firstNames.size() + " first names were loaded");
		System.out.println(lastNames.size() + " last names were loaded");
	}
	
	private void loadNames(boolean first)
	{
		try
		(
			FileReader fr = new FileReader(first ? FIRST_NAME_FILE : LAST_NAME_FILE);
			BufferedReader br = new BufferedReader(fr);
		)
		{
			String line;
			while((line = br.readLine()) != null)
			{
				String capitalizedName = line.split(" ")[0];
				String fixedName = capitalizedName.charAt(0) + capitalizedName.substring(1).toLowerCase();
				if(first)
					firstNames.add(fixedName);
				else
					lastNames.add(fixedName);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getRandomFirst()
	{
		return firstNames.get(Utils.randomInt(0, firstNames.size() - 1));
	}
	
	public String getRandomLast()
	{
		return lastNames.get(Utils.randomInt(0, lastNames.size() - 1));
	}
}
