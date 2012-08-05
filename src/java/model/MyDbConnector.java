/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Vaibhav
 */
public class MyDbConnector {

    private Connection con;
    private ResultSet rs;
    private Statement st;

    public void connect() {
        try {
            String dbURL = "jdbc:derby://localhost:1527/blogDB";
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            con = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        MyDbConnector con=new MyDbConnector();
        con.connect();
    }

    ResultSet getResultSet(String query) {
        try {         
            int c = 0;
            st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    void execute(String query) {
       try {
            st = con.createStatement();
            st.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
