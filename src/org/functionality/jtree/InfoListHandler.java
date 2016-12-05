package org.functionality.jtree;

import java.util.List;

import org.functionality.Assignment;
import org.functionality.Classroom;
import org.functionality.Student;
import org.functionality.jtree.node.InfoNode;
import org.main_components.main_pane_displays.HomeDisplay;
import org.main_components.main_pane_displays.info_displays.AssignmentsOverview;
import org.main_components.main_pane_displays.info_displays.ClassesOverview;
import org.main_components.main_pane_displays.info_displays.StudentsOverview;

public class InfoListHandler
{
	public final InfoNode OVERALL_ROOT = new InfoNode("Info", new HomeDisplay());
	public final InfoNode CLASSES_ROOT = new InfoNode("Classes", new ClassesOverview());
	public final InfoNode ASSIGNMENTS_ROOT = new InfoNode("Assignments", new AssignmentsOverview());
	public final InfoNode STUDENTS_ROOT = new InfoNode("Students", new StudentsOverview());
	
	public InfoListHandler(List<Classroom> classes, List<Student> students, List<Assignment> assignments)
	{
		OVERALL_ROOT.add(CLASSES_ROOT);
		OVERALL_ROOT.add(ASSIGNMENTS_ROOT);
		OVERALL_ROOT.add(STUDENTS_ROOT);
		loadClasses(classes);
		loadStudents(students);
		loadAssignments(assignments);
	}
	
	private void loadClasses(List<Classroom> classes)
	{
		
	}
	
	private void loadStudents(List<Student> students)
	{
		
	}
	
	private void loadAssignments(List<Assignment> assignments)
	{
		
	}
}
