package reflectionAndAnnotation.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: maven_1
 * @description:
 * @author: Erebus
 * @create: 2021-03-30 19:01
 */
@DBConnection(url = "jdbc:mysql://127.0.0.1:3306/db_user",driverClass = "com.mysql.jdbc.Driver")
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class c=Test.class;

        DBConnection dbc= (DBConnection) c.getDeclaredAnnotation(DBConnection.class);

        String driverClass=dbc.driverClass();
        String url=dbc.url();
        String user=dbc.user();
        String password=dbc.password();

        Class.forName(driverClass);
        Connection con= DriverManager.getConnection(url,user,password);

        System.out.println(con);



    }
}
