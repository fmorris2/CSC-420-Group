package org.functionality;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.utils.Utils;

public class Student
{
	private String firstName, lastName;
	private List<Classroom> classes;
	private List<Assignment> incompleteAssignments;
	private List<Assignment> completedAssignments;
	
	public Student(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		incompleteAssignments = new ArrayList<>();
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
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public List<Classroom> getClasses()
	{
		return classes;
	}
	
	public List<Assignment> getIncompleteAssignments()
	{
		return incompleteAssignments;
	}
	
	public List<Assignment> getCompletedAssignments()
	{
		return completedAssignments;
	}
	
	public List<Assignment> getLateAssignments()
	{
		List<Assignment> lateAssignments = new ArrayList<>();
		for(Assignment a : incompleteAssignments)
			if(LocalDateTime.now().isAfter(a.getDueDate()))
				lateAssignments.add(a);
		
		return lateAssignments;
	}
	
	public void addAssignment(Assignment a)
	{
		if(!incompleteAssignments.contains(a) && !completedAssignments.contains(a))
		{
			//FOR RANDOMIZATION WITH GENERATION
			if(Utils.randomInt(0, 3) > 0)
				completedAssignments.add(a);
			else
				incompleteAssignments.add(a);
		}
	}
	
	public void completeAssignment(Assignment a)
	{
		System.out.println("CurrentAssignments size before completion: " + incompleteAssignments.size());
		incompleteAssignments.remove(a);
		System.out.println("CurrentAssignments size after completion: " + incompleteAssignments.size());
		completedAssignments.add(a);
	}
	
	public String toString()
	{
		return getName();
	}
}
