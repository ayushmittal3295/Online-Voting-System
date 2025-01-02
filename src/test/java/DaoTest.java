import com.Dao.Dao;
import com.Model.Model;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DaoTest {

    @Test
    public void testLoginValidation() throws SQLException {
        String sql = "SELECT * FROM admin WHERE username='Aafi' AND password='password123'";
        ResultSet rs = Dao.loginValidation(sql);
        assertTrue(rs.next());
    }

    @Test
    public void testAdminValid() throws SQLException {
        Model model = new Model();
        model.setUserName("Aafi");
        model.setPass("password123");
        ResultSet rs = Dao.adminValid(model);
        assertTrue(rs.next());
    }

    @Test
    public void testVoterValid() throws SQLException {
        Model model = new Model();
        model.setVoterId("11111111");
        model.setPass("11111111");
        ResultSet rs = Dao.voterValid(model);
        assertTrue(rs.next());
    }

    @Test
    public void testRegister() throws SQLException {
        Model model = new Model();
        model.setVoterId("987654321");
        model.setFullName("John Doe");
        model.setUserName("johndoe");
        model.setGender("Male");
        model.setDob("1990-01-01");
        model.setEmail("johndoe@example.com");
        model.setPass("password123");
        int result = Dao.register(model);
        assertEquals(1, result);
    }

    @Test
    public void testContact() throws SQLException {
        Model model = new Model();
        model.setFullName("Jane Doe");
        model.setCompanyName("CompanyX");
        model.setEmail("janedoe@example.com");
        model.setMessage("Hello, this is a test message.");
        int result = Dao.contact(model);
        assertEquals(1, result);
    }

    @Test
    public void testDeleteVoter() throws SQLException {
        String voterId = "987654321";
        int result = Dao.deleteVoter(voterId);
        assertEquals(1, result);
    }
}
