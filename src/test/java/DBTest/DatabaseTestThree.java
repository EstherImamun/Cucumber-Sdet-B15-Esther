package DBTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTestThree {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        // we need to establish the connection to the database

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            // create a statement to send sql queries
            Statement statement = conn.createStatement();
            String query = "select * from person;";
            ResultSet rset =statement.executeQuery(query);
            ResultSetMetaData rsmdata= rset.getMetaData();

            // resultSet contains the object and information of the resultSet you are getting from your database through your query
           // resultSetMetaData contains split or segregated information, like how many columns or how many rows, name of
            // the column or row, nature of the column or row etc.
            // so that's the difference between ResultSet and ResultSetMetaData

            // extract data from resultSet and store it in java data structure
            List<Map<String,String>> listFromRset=new ArrayList<>();
            // iterate through the rows
            while(rset.next()){
                Map<String, String> map = new LinkedHashMap<>();
                //iterate over columns
                for (int i = 1; i <=rsmdata.getColumnCount(); i++) {
                    // fetching key and value from the columns
                    String key = rsmdata.getColumnName(i);
                    String value =rset.getString(key);
                    map.put(key,value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
