package mainprojectpart2;

import java.sql.SQLException;

public class MainProjectPart2 {

    public static void main(String[] args) throws SQLException {
        Database db = new Database();

        PrintData.printingDatabaseData(db);

        InsertData.insertCourses(db);
        InsertData.insertStudents(db);
        InsertData.insertTrainers(db);

    }

}
