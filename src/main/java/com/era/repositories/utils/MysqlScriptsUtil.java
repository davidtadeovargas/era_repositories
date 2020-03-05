/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.repositories.utils;

import com.era.repositories.exceptions.DBEraSQLFileNotFoundException;
import com.era.repositories.exceptions.MysqldumpNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import com.era.logger.LoggerUtility;
import com.era.repositories.models.HibernateConfigModel;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class MysqlScriptsUtil {

    private static MysqlScriptsUtil MysqlScriptsUtil;
    
    private MysqlScriptsUtil(){
        
    }
    
    
    final public static MysqlScriptsUtil getInstance(){
        if(MysqlScriptsUtil==null){
            MysqlScriptsUtil = new MysqlScriptsUtil();
        }
        return MysqlScriptsUtil;
    }
    
    
    public boolean testDatabaseConnection(String database, String user, String password, String instance, int port) throws Exception {
        
        //Create the database        
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        boolean exists;
        try (Connection conn = DriverManager.getConnection(sCon)) {
            Statement st = conn.createStatement();
            ResultSet rs = conn.getMetaData().getCatalogs();
            exists = false;
            while(rs.next()){
                String catalogs = rs.getString(1);
                if(database.equals(catalogs)){
                    exists = true;
                    break;
                }
            }
        }
        catch(Exception e){
            exists = false;
        }
        return exists;
    }
    
    
    public boolean testSysConnection(String user, String password, String instance, int port) throws Exception {
        return testDatabaseConnection("sys",user,password,instance,port);         
    }
    
    public int creaDB(final String database, String user, String password, String instance, int port) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Creating database " + database);

        //Create the database
        String query = "CREATE DATABASE " + database;
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        Connection conn = DriverManager.getConnection(sCon);
        Statement st = conn.createStatement();
        st.execute(query);

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " created");

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Populating database with schemas");

        final HibernateConfigModel HibernateConfigModel = HibernateUtil.getSingleton().getHibernateConfigModel();
        HibernateUtil.getSingleton().buildSessionFactoryFromHibernateConfigModelCreate(HibernateConfigModel);

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Finished populating schemas");

        //Load catalogs
        Process p = null;
        Runtime runtime = Runtime.getRuntime();
        String mysqldumpExecutable = getMySQLPATH(user, password, instance, port).concat("bin\\mysql.exe");
        if(!new File(mysqldumpExecutable).exists()){
            throw new MysqldumpNotFoundException();
        }       
        String dbEmpresasSQLPath = "catalogs.sql";
        if(!new File(dbEmpresasSQLPath).exists()){
            throw new DBEraSQLFileNotFoundException();
        }                   
        String exec = mysqldumpExecutable + " --host=" + instance + " --user=" + user +  " --password=" + password + "  " + database + " --execute=\"source " + dbEmpresasSQLPath + "\"";

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " running exec " + exec);

        p = runtime.exec(exec);
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((reader.readLine()) != null) {}

        int processComplete = p.waitFor();

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, "processComplete " + processComplete);

        if(processComplete!=0){
            LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, "Catalogs not created");
            
            System.out.println("Failed to execute the following command: " + exec + " due to the following error(s):");
            try (final BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
               String line;
               while ((line = b.readLine()) != null)
                   System.out.println(line);
            } catch (final IOException e) {
               LoggerUtility.getSingleton().logError(MysqlScriptsUtil.class, e);
           }   
        }        

        return processComplete;
    }
    
    public boolean existsDBEmpresasDatabase(String user, String password, String instance, int port) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " checking if dbempresas exists");
                
        boolean exists = false;
        
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        try(Connection conn = DriverManager.getConnection(sCon)){
            
            String query = "select * from information_schema.schemata where schema_name = 'dbempresas';";
            ResultSet rs = null;
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {            
               
                LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " dbempresas exists");
                
                exists = true;
            }
        }                    
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " returning  " + exists);
                
        return exists;
    }
            
    public int creaDBDBEmpresas(String user, String password, String instance, int port) throws Exception {
        
        int result = creaDB("dbempresas", user, password, instance, port);
        
        return result;
    }
    
    public void rollbackDBEmpresas(String user, String password, String instance, int port) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Rolling back ");

        //Create the database
        String query = "DROP DATABASE dbempresas";
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        Connection conn = DriverManager.getConnection(sCon);
        Statement st = conn.createStatement();
        st.execute(query);

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " finished");
    }
    
    public void creaDBEmpresas(String user, String password, String instance, int port) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Creatin simple dbempresas");
        creaDBJDBC("dbempresas",user, password, instance, port);        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " finished");
    }
    
    public void creaDBJDBC(final String database, String user, String password, String instance, int port) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Creatin simple dbempresas");

        //Create the database
        String query = "CREATE DATABASE " + database;
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        Connection conn = DriverManager.getConnection(sCon);
        Statement st = conn.createStatement();
        st.execute(query);

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " finished");
    }
    
    public String getMySQLPATH(String user, String password, String instance, int port) throws SQLException{
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " getting mysql path");
        
        String rutaMysql = null;
        
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        try(Connection conn = DriverManager.getConnection(sCon)){
            
            String query = "select @@basedir as dir";
            ResultSet rs = null;        
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {            
               rutaMysql = rs.getString("dir");
               rutaMysql = rutaMysql.replace("\\", "\\\\");
            }
        }                    
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " rutaMysql = " + rutaMysql);
                
        return rutaMysql;
    }
}
