
package mainprojectpart2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Course;
import models.Student;
import models.Trainer;

public class Database {
    
    private static final String DB_URL = "localhost:3306";
    private static final String FULL_DB_URL = "jdbc:mysql://" + DB_URL + "/school?zeroDateTimeBehavior=convertToNull";
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "root2020";
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement pst = null;
    
    public static void setStatement(Statement aStatement) {
        statement = aStatement;
    }

    public Database() {
        getConnection();
    }
    
     public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ResultSet getResults(String query) { 
        try {
            setStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public static Statement getStatement() {
        return statement;
    }

    public Statement getStatementNonStatic() {
        return statement;
    }

    public static void setStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStatementNonStatic() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setPreparedStatement(String query) {
        try {
            pst = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static PreparedStatement getPreparedStatement() {
        return pst;
    }
    
    public static ResultSet getAllResultsFromTable(String tableName) { 
        try {
            setStatement();
            String query = "SELECT * FROM `" + tableName +"`";
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public static ResultSet getOneResultByField(String tableName, String fieldName, String fieldValue) {
        try {
            setStatement();
            String query = "SELECT * FROM `" + tableName + "` WHERE `" + fieldName + "`='" + fieldValue + "'";
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
     
          public static ResultSet getOneResultByTwoFields(String tableName, String fieldNameOne, String fieldValueOne, String fieldNameTwo, String fieldValueTwo) 
          {
        try {
            setStatement();
            String query = "SELECT * FROM `" + tableName + "` WHERE `" + fieldNameOne + "`='" + fieldValueOne + "' AND `" + fieldNameTwo + "`='" + fieldValueTwo + "'";
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
     public static int insertRecordToCourses(Course course) {
        int result = 0;
        String course_data = "'" + course.getTitle() + "','" + course.getStream() + "','" + course.getType() + "','" + course.getStartDate() + "','" + course.getEndDate() + "'";
        String query = "INSERT INTO `courses` (`title`,`stream`,`type`, `start_date`, `end_date`) VALUES (" + course_data + ");";
        try {
            setStatement();
            result = statement.executeUpdate(query);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }

    }
     
     public static int insertRecordToStudents(Student student) {
        int result = 0;
        String student_data = "'" + student.getName() + "','" + student.getLastname() + "','" + student.getFees() + "','" + student.getDateOfBirth() +"'";
        String query = "INSERT INTO `students` (`first_name`,`last_name`,`fees`, `date_of_birth`) VALUES (" + student_data + ");";
        try {
            setStatement();
            result = statement.executeUpdate(query);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }

    }
     
     public static int insertRecordToTrainers(Trainer trainer) {
        int result = 0;
        String trainer_data = "'" + trainer.getName() + "','" + trainer.getLastname() + "','" + trainer.getSubject() +"'";
        String query = "INSERT INTO `trainers` (`first_name`,`last_name`,`subject`) VALUES (" + trainer_data + ");";
        try {
            setStatement();
            result = statement.executeUpdate(query);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }

    }
     
      
}
