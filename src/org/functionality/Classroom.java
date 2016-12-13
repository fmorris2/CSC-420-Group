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
	
	public void addStudent(Student s, boolean random)
	{
		if(!students.contains(s))
		{	
			s.getClasses().add(this);
			students.add(s);
			for(Assignment a : assignments)
				s.addAssignment(a, random);
		}
	}
	
	public void addAssignment(Assignment a, boolean random)
	{
		if(!assignments.contains(a))
		{
			assignments.add(a);
			for(Student s : students)
				s.addAssignment(a, random);
		}
	}
	
	public List<Student> getStudents()
	{
		return students;
	}
	
	public List<Assignment> getAssignments()
	{
		return assignments;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
}
