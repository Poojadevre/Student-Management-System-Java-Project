
import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students VALUES(?,?,?,?)");
            ps.setInt(1, s.id);
            ps.setString(2, s.name);
            ps.setString(3, s.course);
            ps.setInt(4, s.age);
            ps.executeUpdate();
            con.close();
            System.out.println("Student added successfully.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            System.out.println("\nID | Name | Course | Age");
            while(rs.next()) {
                System.out.println(
                    rs.getInt(1)+" | "+rs.getString(2)+" | "+
                    rs.getString(3)+" | "+rs.getInt(4));
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String name) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=? WHERE id=?");
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            con.close();
            System.out.println("Student updated successfully.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
            System.out.println("Student deleted successfully.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
