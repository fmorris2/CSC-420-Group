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
import org.main_components.main_pane_displays.info_displays.AssignmentsOverview;
import org.main_components.main_pane_displays.info_displays.ClassesOverview;
import org.main_components.main_pane_displays.info_displays.StudentsOverview;
import org.utils.Utils;

public class InfoListHandler
{
	public static final int NUM_STUDENTS = 30;
	public static final int MAX_ASSIGNMENTS_PER_CLASS = 10;
	
	public final InfoNode OVERALL_ROOT = new InfoNode("Info", new HomeDisplay());
	public final InfoNode CLASSES_ROOT = new InfoNode("Classes", new ClassesOverview());
	public final InfoNode ASSIGNMENTS_ROOT = new InfoNode("Assignments", new AssignmentsOverview());
	public final InfoNode STUDENTS_ROOT = new InfoNode("Students", new StudentsOverview());
	
	private List<ClassNode> classNodes = new ArrayList<>();
	private List<AssignmentNode> assignmentNodes = new ArrayList<>();
	private List<StudentNode> studentNodes = new ArrayList<>();
	
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
	}
	
	private void loadClasses()
	{
		for(Classroom c : classroomGen.getClasses())
		{
			ClassNode classNode = new ClassNode(c);
			classNodes.add(classNode);
			CLASSES_ROOT.add(classNode);
		}
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
				if(Utils.randomInt(0, 3) > 0)
					randomTime = randomTime.plusDays(Utils.randomInt(1, 30));
				else
					randomTime = randomTime.minusDays(Utils.randomInt(1, 30));
				
				Assignment a = new Assignment((c.getClassroom().getName() + " assignment " + (i + 1)), randomTime, c.getClassroom());
				AssignmentNode aNode = new AssignmentNode(a);
				AssignmentNode aNodeClone = new AssignmentNode(a);
				assignmentNodes.add(aNode);
				ASSIGNMENTS_ROOT.add(aNode);
				c.getAssignments().add(aNodeClone);
				c.getClassroom().addAssignment(a);
			}
		}
	}
}
