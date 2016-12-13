package org.functionality.jtree;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.functionality.Assignment;
import org.functionality.Classroom;
import org.functionality.Student;
import org.functionality.generators.ClassroomGenerator;
import org.functionality.generators.NameGenerator;
import org.functionality.jtree.node.InfoNode;
import org.functionality.jtree.node.impl.AssignmentNode;
import org.functionality.jtree.node.impl.ClassNode;
import org.functionality.jtree.node.impl.StudentInClassNode;
import org.functionality.jtree.node.impl.StudentNode;
import org.main_components.main_pane_displays.HomeDisplay;
import org.main_components.main_pane_displays.info_displays.jtree_displays.AssignmentsOverview;
import org.main_components.main_pane_displays.info_displays.jtree_displays.ClassesOverview;
import org.main_components.main_pane_displays.info_displays.jtree_displays.StudentsOverview;
import org.utils.Utils;

public class InfoListHandler
{
	public static final int NUM_STUDENTS = 30;
	public static final int MAX_ASSIGNMENTS_PER_CLASS = 10;
	
	public final InfoNode OVERALL_ROOT = new InfoNode("Info");
	public final static InfoNode CLASSES_ROOT = new InfoNode("Classes");
	public final InfoNode ASSIGNMENTS_ROOT = new InfoNode("Assignments");
	public final InfoNode STUDENTS_ROOT = new InfoNode("Students");
	
	public static List<ClassNode> classNodes = new ArrayList<>();
	public static List<AssignmentNode> assignmentNodes = new ArrayList<>();
	public static List<StudentNode> studentNodes = new ArrayList<>();
	
	private ClassroomGenerator classroomGen = new ClassroomGenerator();
	private NameGenerator nameGen = new NameGenerator();
	
	public InfoListHandler()
	{
		OVERALL_ROOT.add(CLASSES_ROOT);
		OVERALL_ROOT.add(ASSIGNMENTS_ROOT);
		OVERALL_ROOT.add(STUDENTS_ROOT);
		loadClasses();
		loadAssignments();
		loadStudents();
		
		OVERALL_ROOT.setDisplay(new HomeDisplay());
		CLASSES_ROOT.setDisplay(new ClassesOverview());
		ASSIGNMENTS_ROOT.setDisplay(new AssignmentsOverview());
		STUDENTS_ROOT.setDisplay(new StudentsOverview());
	}
	
	private void loadClasses()
	{
		for(Classroom c : classroomGen.getClasses())
			addClass(c, false);
	}
	
	private void loadStudents()
	{
		for(int i = 0; i < NUM_STUDENTS; i++)
		{
			Student s = new Student(nameGen.getRandomFirst(), nameGen.getRandomLast());
			StudentNode studentNode = new StudentNode(s);
			studentNodes.add(studentNode);
			STUDENTS_ROOT.add(studentNode);
			
			for(ClassNode c : classNodes)
			{
				if(Utils.randomInt(0, 4) == 0)
					continue;
				
				StudentInClassNode studentNodeClone = new StudentInClassNode(s, c.getClassroom());
				c.getStudentsNode().add(studentNodeClone);
				c.getClassroom().addStudent(s);
			}
			
			studentNode.loadAssignments();
		}
	}
	
	private void loadAssignments()
	{
		for(ClassNode c : classNodes)
		{
			int randomAssignmentNumber = Utils.randomInt(1, MAX_ASSIGNMENTS_PER_CLASS);
			for(int i = 0; i < randomAssignmentNumber; i++)
			{
				LocalDateTime randomTime = LocalDateTime.now();
				if(Utils.randomInt(0, 3) > 1)
					randomTime = randomTime.plusDays(Utils.randomInt(1, 30));
				else
					randomTime = randomTime.minusDays(Utils.randomInt(1, 30));
				
				Assignment a = new Assignment((c.getClassroom().getName() + " assignment " + (i + 1)), randomTime, c.getClassroom(), "N/A");
				AssignmentNode aNode = new AssignmentNode(a);
				AssignmentNode aNodeClone = new AssignmentNode(a);
				assignmentNodes.add(aNode);
				ASSIGNMENTS_ROOT.add(aNode);
				c.getAssignments().add(aNodeClone);
				c.getClassroom().addAssignment(a);
			}
		}
	}
	
	public static void addClass(Classroom c, boolean fillStudentNodes)
	{
		System.out.println("Adding classroom " + c);
		ClassNode classNode = new ClassNode(c);
		classNodes.add(classNode);
		CLASSES_ROOT.add(classNode);
		
		if(fillStudentNodes)
		{
			for(Student s : c.getStudents())
				classNode.getStudentsNode().add(new StudentInClassNode(s, c));
		}
	}
}
