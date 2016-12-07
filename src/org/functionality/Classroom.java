package org.functionality;

import java.util.ArrayList;
import java.util.List;

public class Classroom
{
	private String name;
	private List<Student> students;
	private List<Assignment> assignments;
	
	public Classroom(String name)
	{
		this.name = name;
		students = new ArrayList<>();
		assignments = new ArrayList<>();
	}
	
	public void addStudent(Student s)
	{
		if(!students.contains(s))
		{	
			students.add(s);
			for(Assignment a : assignments)
				s.addAssignment(a);
		}
	}
	
	public void addAssignment(Assignment a)
	{
		if(!assignments.contains(a))
		{
			assignments.add(a);
			for(Student s : students)
				s.addAssignment(a);
		}
	}
	
	public String getName()
	{
		return name;
	}
}
