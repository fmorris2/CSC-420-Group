package org.functionality;

import java.time.LocalDateTime;

public class Assignment
{
	private String name;
	private LocalDateTime dueDate;
	private Classroom classroom;
	
	public Assignment(String name, LocalDateTime dueDate, Classroom classRoom)
	{
		this.name = name;
		this.dueDate = dueDate;
		this.classroom = classRoom;
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
