import java.sql.*;
import java.util.Scanner; // import the Scanner class 

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbc"; // this is my db name , if you want to use it, just change the
                                                         // jdbc behind 3306
        Scanner myObj = new Scanner(System.in);
        // Scanner myObj2 = new Scanner(System.in);
        System.out.println("insert username:");
        String username = myObj.nextLine();
        System.out.println("insert password:");
        String password = myObj.nextLine();
        System.out.println("username : " + username + " password:" + password);
        System.out.println("insert sql query:");
        String query = myObj.nextLine();

        Connection con = DriverManager.getConnection(url, username, password);
        // this is for get the value from databae 
        // Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery(query);

        // String userData = "";

        // while (rs.next()) {
        //     userData = "name : " + rs.getString(1) + "\n age : " + rs.getString(2);
        //     System.out.println(userData);
        // }

        // this is for adding the value 2 databae 

        PreparedStatement st = con.prepareStatement(query);
        // st.setString(1, "Tiger");
        // st.setString(2, "88");
        int count =  st.executeUpdate();

        System.out.println("success! "+ count+" row affected");



        st.close();
        con.close();
    }
}
