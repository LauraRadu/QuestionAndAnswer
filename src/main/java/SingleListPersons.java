import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SingleListPersons {

    private List<IR> listofNames = new ArrayList<>();

    public void addInTheListOfNames(IR s) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        final String URL = "jdbc:postgresql://54.93.65.5:5432/laura7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pSt = conn.prepareStatement("INSERT INTO ir (intrebare, raspuns) VALUES (?,?)");
        pSt.setString(1, s.getIntrebare());
        pSt.setString(2, s.getRaspuns());

        int rowsInserted = pSt.executeUpdate();

        pSt.close();
        conn.close();
    }


    public List getListOfNames() throws ClassNotFoundException, SQLException{

        Class.forName("org.postgresql.Driver");

        final String URL = "jdbc:postgresql://54.93.65.5:5432/laura7";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        PreparedStatement pSt = conn.prepareStatement("SELECT intrebare, raspuns FROM ir");
        ResultSet rs = pSt.executeQuery();
        while(rs.next()) {
            IR ir = new IR();
            ir.setIntrebare(rs.getString("intrebare"));
            ir.setRaspuns(rs.getString("raspuns"));
            listofNames.add(ir);
        }

        pSt.close();
        conn.close();

        return listofNames;
    }

}





