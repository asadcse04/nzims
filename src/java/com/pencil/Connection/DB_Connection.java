/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencil.Connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Mahfuj
 */
public class DB_Connection implements Serializable
{
    private Connection con=null;
    
    private DataSource dataSource;
    
    public Connection getConnection()
    {
        try
        {
            Context initContext  = new InitialContext();
            
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            
            dataSource = (DataSource)envContext.lookup("jdbc/pncldb");
            
            con = dataSource.getConnection();
            
            return con;
        }
        catch(NamingException e)
        {
            System.out.println(e);
        } 
        catch (SQLException ee)
        {
            System.out.println(ee);
        }
        
        return null;
    }
    
    public Connection getSms_db_Connection()
    {
        try
        {
            Context initContext  = new InitialContext();
            
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            
            dataSource = (DataSource)envContext.lookup("jdbc/testdb");
            
            con = dataSource.getConnection();
            
            return con;
        }
        catch(NamingException e)
        {
            System.out.println(e);
        } 
        catch (SQLException ee)
        {
            System.out.println(ee);
        }
        
        return null;
    }

}
