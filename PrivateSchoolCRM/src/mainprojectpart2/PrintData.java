
package mainprojectpart2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PrintData {
    
    
  public static void printingDatabaseData(Database db){
      
        System.out.println("****Printing Students****");
        ResultSet rs = db.getAllResultsFromTable("students");
        printStudentResults(rs);
      
        System.out.println("\n****Printing Trainers****");
        ResultSet rs1 = db.getAllResultsFromTable("trainers");
        printTrainerResults(rs1);
        
        System.out.println("\n****Printing Assignments****");
        ResultSet rs2 = db.getAllResultsFromTable("assignments");
        printAsignmentResults(rs2);
        
        System.out.println("\n****Printing Courses****");
        ResultSet rs3 = db.getAllResultsFromTable("courses");
        printCourseResults(rs3);
       
        String studentspercourse = "SELECT first_name,last_name,date_of_birth,title as course_title,stream as course_stream FROM students_per_course "
                              +"join students on students_per_course.student_id = students.id "
                             +"join courses on students_per_course.course_id = courses.id";
        System.out.println("\n****Printing Students Per Course****");                     
        ResultSet rs4 = db.getResults(studentspercourse);
        printStudentsPerCourseResults(rs4);
       
        String trainerpercourse = "SELECT first_name, last_name, `subject`,title as course_title,stream as course_stream FROM trainers_per_course\n" +
                                   "join trainers on trainers_per_course.trainer_id = trainers.id\n" +
                                   "join courses on trainers_per_course.course_id = courses.id";
        System.out.println("\n****Printing Trainers Per Course****");  
        ResultSet rs5 = db.getResults(trainerpercourse);
        printTrainersPerCourseResults(rs5);
      
        String assignmentspercourse = "SELECT assignments.title,`description`, sub_date_time,courses.title as course_title,stream as course_stream FROM assignments\n" +
                                      "join courses on assignments.course_id = courses.id;";
        System.out.println("\n****Printing Assignments Per Course****");
        ResultSet rs6 = db.getResults(assignmentspercourse);
        printAssignmentsPerCourseResults(rs6);
        
        String assignmentspercourseperstudent = "SELECT assignments.title,`description`,sub_date_time, c.title as course_title,stream,first_name, last_name, date_of_birth as course_stream FROM assignments_per_student\n" +
                                              "join assignments on assignments.id = assignments_per_student.assignment_id\n" +
                                              "join courses c on assignments.course_id = c.id\n" +
                                              "join students on students.id = assignments_per_student.student_id";
        System.out.println("\n****Printing Assignments Per Course Per Students****");
        ResultSet rs7 = db.getResults(assignmentspercourseperstudent);
        printAssignmentsPerCoursePerStudentsResults(rs7);
      
        System.out.println("\n****Printing Students Enroll in More than One Course****");
        String studentsiimorecourses = "SELECT concat(first_name,' ',last_name) as fullname,date_of_birth, count(students.id) FROM students_per_course \n" +
                                       "join students on students_per_course.student_id = students.id\n" +
                                       "join courses on students_per_course.course_id = courses.id\n" +
                                       "GROUP BY fullname having count(students.id)>1";
        ResultSet rs8 = db.getResults(studentsiimorecourses);
        printStudentsInMoreCoursesResults(rs8);
      
  } 
    
    public static void printStudentResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Student Id: " + rs.getString(1)
                        + ", First Name: " + rs.getString(2)
                        + ", Last Name: " + rs.getString(3)
                        + ", Fees: " + rs.getString(4)
                        + ", Date of Birth: " + rs.getString(5)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
         public static void printTrainerResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Trainer Id: " + rs.getString(1)
                        + ", First Name: " + rs.getString(2)
                        + ", Last Name: " + rs.getString(3)
                        + ", Subject: " + rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
          public static void printAsignmentResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Assignment Id: " + rs.getString(1)
                        + ", Title: " + rs.getString(2)
                        + ", Description: " + rs.getString(3)
                        + ", Sub Date Time: " + rs.getString(4)
                        + ", Total Mark: " + rs.getString(5)
                       + ", Course Id Enrolled: " + rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
          public static void printCourseResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Assignment Id: " + rs.getString(1)
                        + ", Title: " + rs.getString(2)
                        + ", Stream: " + rs.getString(3)
                        + ", Type: " + rs.getString(4)
                        + ", Start Date: " + rs.getString(5)
                       + ", End Date: " + rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
           public static void printStudentsPerCourseResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Student : " + rs.getString(1)
                        + " " + rs.getString(2)
                        + ", Date Birth: " + rs.getString(3)
                        + ", Enroll in Course : " + rs.getString(4)
                        + ", and Stream: " + rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
           public static void printTrainersPerCourseResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Trainer : " + rs.getString(1)
                        + " " + rs.getString(2)
                        + ", With Subject: " + rs.getString(3)
                        + ", Enroll in Course : " + rs.getString(4)
                        + ", and Stream: " + rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
              public static void printAssignmentsPerCourseResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Assignment Title : " + rs.getString(1)
                        + ", Description " + rs.getString(2)
                        + ", Sub Date: " + rs.getString(3)
                        + ", Enroll in Course : " + rs.getString(4)
                        + ", and Stream: " + rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          public static void printAssignmentsPerCoursePerStudentsResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Assignment: " + rs.getString(1)
                        + "Description " + rs.getString(2)
                        + ", Sub Date: " + rs.getString(3)
                        + ", Enroll in Course: " + rs.getString(4)
                        + ", and Stream: " + rs.getString(5)
                        + ", have Student: " + rs.getString(6)
                        + " " + rs.getString(7)
                        + " born in " + rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public static void printStudentsInMoreCoursesResults(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println(
                        "Student: " + rs.getString(1)
                        + ", born in " + rs.getString(2)
                        + ", Enroll in: " + rs.getString(3)
                        + " Courses" );
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainProjectPart2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
    
}
