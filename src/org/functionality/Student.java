package org.functionality;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Student
{
	private String firstName, lastName;
	private List<Classroom> classes;
	private List<Assignment> currentAssignments;
	private List<Assignment> completedAssignments;
	
	public Student(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		currentAssignments = new ArrayList<>();
		completedAssignments = new ArrayList<>();
		classes = new ArrayList<>();
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public List<Classroom> getClasses()
	{
		return classes;
	}
	
	public List<Assignment> getCurrentAssignments()
	{
		return currentAssignments;
	}
	
	public List<Assignment> getCompletedAssignments()
	{
		return completedAssignments;
	}
	
	public List<Assignment> getLateAssignments()
	{
		List<Assignment> lateAssignments = new ArrayList<>();
		for(Assignment a : currentAssignments)
			if(LocalDateTime.now().isAfter(a.getDueDate()))
				lateAssignments.add(a);
		
		return lateAssignments;
	}
	
	public void addAssignment(Assignment a)
	{
		if(!currentAssignments.contains(a))
			currentAssignments.add(a);
	}
	
	public void completeAssignment(Assignment a)
	{
		System.out.println("CurrentAssignments size before completion: " + currentAssignments.size());
		currentAssignments.remove(a);
		System.out.println("CurrentAssignments size after completion: " + currentAssignments.size());
		completedAssignments.add(a);
	}
}
