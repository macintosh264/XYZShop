/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.xyzcraft.net.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joey
 */
public abstract class MacDatabaseEngine {
        private MySQLConnectionPool sqlConnections;
    public MacDatabaseEngine(String url,String username, String password) throws SQLException{
        try {
            sqlConnections = new MySQLConnectionPool(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        sqlConnections.getConnection();
                
    }
    public void close() {
        sqlConnections.close();
    }
    public ResultSet executeMySql(String query) throws SQLException {
        Connection mysql = sqlConnections.getConnection();
        Statement st = mysql.createStatement();
        ResultSet rs = st.executeQuery(query);
        sqlConnections.close();
        return rs;
    }
}
