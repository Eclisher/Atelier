package hei.shool.atelier.Repository;

import hei.shool.atelier.DabaseConfig;
import hei.shool.atelier.Model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository {
    private  final DabaseConfig dabaseConfig;

    public StudentRepository(DabaseConfig dabaseConfig) {
        this.dabaseConfig = dabaseConfig;
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";

        try (
                Connection connection = dabaseConfig.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des étudiants", e);
        }

        return students;
    }


    public Student findById(int id) {
        String query = "SELECT * FROM student WHERE id = ?";
        try (Connection conn = dabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void save(Student student) {
        String query = "INSERT INTO student (nom, email) VALUES (?, ?)";

        try (Connection conn = dabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, student.getNom());
            pstmt.setString(2, student.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM student WHERE id = ?";

        try (Connection conn = dabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}