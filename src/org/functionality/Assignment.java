package org.functionality;

import java.time.LocalDateTime;

public class Assignment
{
	private String name;
	private LocalDateTime dueDate;
	private Classroom classroom;
	private String description;
	
	public Assignment(String name, LocalDateTime dueDate, Classroom classRoom, String description)
	{
		this.name = name;
		this.dueDate = dueDate;
		this.classroom = classRoom;
		this.description = description;
	}
	
	public String getName()
	{
		return name;
	}
	
	public LocalDateTime getDueDate()
	{
		return dueDate;
	}
	
	public Classroom getClassroom()
	{
		return classroom;
	}
}
