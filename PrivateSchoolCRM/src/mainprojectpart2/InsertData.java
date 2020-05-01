
package mainprojectpart2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import models.Course;
import models.Student;
import models.Trainer;

/**
 *
 * @author akasemaj
 */
public class InsertData {

    public static void insertCourses(Database db) throws SQLException {

        String keepgoing;
        do {
            System.out.println("\nPlease insert Courses data");
            Scanner input = new Scanner(System.in);

            String inputTitle;
            String inputStream;
            String inputType;
            String inputStartDate;
            String inputEndDate;

            System.out.println("Please insert title of the COURSE");
            input = new Scanner(System.in);
            inputTitle = input.next();

            System.out.println("Please insert the stream of the COURSE");
            input = new Scanner(System.in);
            inputStream = input.next();

            System.out.println("Please insert the type of the course(full time or part time)");
            input = new Scanner(System.in);
            inputType = input.next();

            System.out.println("Please insert the start date of the course (YYYY-MM-DD)");
            input = new Scanner(System.in);
            inputStartDate = input.next();

            System.out.println("Please insert the end date of the course (YYYY-MM-DD)");
            input = new Scanner(System.in);
            inputEndDate = input.next();

            Course c1 = new Course(inputTitle, inputStream, inputType, LocalDate.parse(inputStartDate), LocalDate.parse(inputEndDate));
            db.getOneResultByField("courses", "title", inputTitle);
            ResultSet entryrs = db.getOneResultByField("courses", "title", inputTitle);
            if (entryrs.next() == false) {
                db.insertRecordToCourses(c1);
            } else {
                System.out.println("This course already exist");
            }

            System.out.println("Would you like to insert another course, Yes or No ?");
            input = new Scanner(System.in);
            keepgoing = input.next();
        } while (keepgoing.toUpperCase().equals("YES"));

    }

    public static void insertStudents(Database db) throws SQLException {

        String keepgoing;
        do {
            System.out.println("Please insert Student data");
            Scanner input = new Scanner(System.in);

            String inputName;
            String inputLastName;
            String inputFees;
            String inputDateOfBirth;

            System.out.println("Please insert name of the student");
            input = new Scanner(System.in);
            inputName = input.next();

            System.out.println("Please insert lastname of the student");
            input = new Scanner(System.in);
            inputLastName = input.next();

            System.out.println("Please insert fees for this student");
            input = new Scanner(System.in);
            inputFees = input.next();

            System.out.println("Please insert date of the birth for this student (YYYY-MM-DD)");
            input = new Scanner(System.in);
            inputDateOfBirth = input.next();

            Student s1 = new Student(inputName, inputLastName, Integer.parseInt(inputFees), LocalDate.parse(inputDateOfBirth));
            ResultSet entryrs = db.getOneResultByTwoFields("students", "first_name", inputName, "last_name", inputLastName);
            if (entryrs.next() == false) {
                db.insertRecordToStudents(s1);
            } else {
                System.out.println("The student already exist");
            }

            System.out.println("Would you like to insert another student, Yes or No ?");
            input = new Scanner(System.in);
            keepgoing = input.next();
        } while (keepgoing.toUpperCase().equals("YES"));

    }

    public static void insertTrainers(Database db) throws SQLException {
        String keepgoing;
        do {
            System.out.println("Please insert Trainer data");
            Scanner input = new Scanner(System.in);
            
        String inputName;
        String inputLastName;
        String inputSubject;

        System.out.println("Please insert name of the trainer");
        input = new Scanner(System.in);
        inputName = input.next();

        System.out.println("Please insert lastname of the trainer");
        input = new Scanner(System.in);
        inputLastName = input.next();

        System.out.println("Please insert the subject of the trainer");
        input = new Scanner(System.in);
        inputSubject = input.next();

        Trainer t1 = new Trainer(inputName, inputLastName, inputSubject);
        ResultSet entryrs = db.getOneResultByTwoFields("trainers", "first_name", inputName, "last_name", inputLastName);
            if (entryrs.next() == false) {
                db.insertRecordToTrainers(t1);
            } else {
                System.out.println("The trainer already exist");
            }

            System.out.println("Would you like to insert another trainer, Yes or No ?");
            input = new Scanner(System.in);
            keepgoing = input.next();
        } while (keepgoing.toUpperCase().equals("YES"));
    }
    
}
