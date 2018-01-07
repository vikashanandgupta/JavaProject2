/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author VIKASH ANAND BABU
 */
public class DBConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement addResult, getResult, getAllResult, deleteResult, updateResult;
    public static PreparedStatement checkedAdmin, changePassword, getAllResultLike;
    
    static
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student_r_s","student_r_s");
            Statement st=c.createStatement();
            addResult=c.prepareStatement("insert into result values(?,?,?,?,?,?,?,?)");
            getResult=c.prepareStatement("select * from result where roll_no=?");
            getAllResult=c.prepareStatement("select * from result");
            updateResult=c.prepareStatement("update result set name=?,fathers_name=?, maths=?,"+
                    "english=?,computer=?,science=?,sst=? where roll_no=? ");
            deleteResult=c.prepareStatement("delete from result where roll_no=?");
            checkedAdmin=c.prepareStatement("select * from admin where aid=? and password=?");
            
            changePassword=c.prepareStatement("update admin set password=? where aid=? and password=?");
            
            getAllResultLike=c.prepareStatement("select * from result name like ?");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
