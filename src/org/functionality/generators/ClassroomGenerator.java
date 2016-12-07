package org.functionality.generators;

import java.util.ArrayList;
import java.util.List;

import org.functionality.Classroom;

public class ClassroomGenerator
{
	public static final String[] CLASS_NAMES = { "Language Arts", "Reading",
			"Math", "Science", "Social Studies"};
	
	private List<Classroom> classes = new ArrayList<>();
	
	public ClassroomGenerator()
	{
		for(String c : CLASS_NAMES)
			classes.add(new Classroom(c));
	}
	
	public List<Classroom> getClasses()
	{
		return classes;
	}
}
