package org.functionality;

import java.time.LocalDateTime;

public class Assignment
{
	private String name, description;
	private LocalDateTime dueDate;
	private Classroom classroom;
	
	public Assignment(String name, LocalDateTime dueDate, Classroom classroom, String description)
	{
		this.name = name;
		this.dueDate = dueDate;
		this.classroom = classroom;
		this.description = description;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public LocalDateTime getDueDate()
	{
		return dueDate;
	}
	
	public Classroom getClassroom()
	{
		return classroom;
	}
	
	public boolean isPastDue()
	{
		return LocalDateTime.now().isAfter(dueDate);
	}
}
