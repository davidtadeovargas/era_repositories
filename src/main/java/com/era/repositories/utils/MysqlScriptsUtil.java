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
import com.era.utilities.FilesUtility;
import com.era.utilities.UtilitiesFactory;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//set global max_allowed_packet=1000000000;

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
    
    private int loadCatalogFileIntoDatabase(final String catalogFile,final String database, String user, String password, String instance, int port) throws Exception {
        
        final FilesUtility FilesUtility = UtilitiesFactory.getSingleton().getFilesUtility();
        String connectionFile = "config.cnf";
        final String appPath = System.getProperty("user.dir");
        connectionFile = appPath + "\\" + connectionFile;        
        FilesUtility.createNewFile(connectionFile);
        final String text = "[mysql]\n" +
                            "user = " + user + "\n"+
                            "password = " + password + "\n" +
                            "host = " + instance + "\n";        
        FilesUtility.writeToExistingFile(connectionFile, text);
        
        //Load catalogs
        Process p = null;
        Runtime runtime = Runtime.getRuntime();
        String mysqldumpExecutable = getMySQLPATH(user, password, instance, port).concat("bin\\mysql.exe");
        if(!new File(mysqldumpExecutable).exists()){
            throw new MysqldumpNotFoundException();
        }       
        String dbEmpresasSQLPath = catalogFile;
        if(!new File(dbEmpresasSQLPath).exists()){
            throw new DBEraSQLFileNotFoundException(dbEmpresasSQLPath);
        }                   
        String exec = mysqldumpExecutable + " --defaults-extra-file=\"" + connectionFile + "\" --max_allowed_packet=100M " + database + " --execute=\"source " + dbEmpresasSQLPath + "\"";

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

        FilesUtility.deleteFile(connectionFile);
        
        return processComplete;
    }
    
    public int loadDBEmpresasCatalogFileIntoDatabase(final String database, String user, String password, String instance, int port) throws Exception {
        return loadCatalogFileIntoDatabase("base_catalogs.sql",database, user, password, instance, port);       
    }
    
    public int loadLocalCatalogFileIntoDatabase(final String database, String user, String password, String instance, int port) throws Exception {
        return loadCatalogFileIntoDatabase("catalogs.sql",database, user, password, instance, port);       
    }
        
    public void creaDB(final String database, String user, String password, String instance, int port) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " Creating database " + database);
        
        //Create the database
        String query = "CREATE DATABASE " + database;
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        Connection conn = DriverManager.getConnection(sCon);
        Statement st = conn.createStatement();
        st.execute(query);

        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " created");        
    }
    
    public boolean existsDB(String database, String user, String password, String instance, int port) throws Exception {
        
        LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, " checking if dbempresas exists");
                
        boolean exists = false;
        
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        try(Connection conn = DriverManager.getConnection(sCon)){
            
            String query = "select * from information_schema.schemata where schema_name = '" + database + "';";
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
            
    public void creaDBDBEmpresas(String user, String password, String instance, int port) throws Exception {
        
        creaDB("dbempresas", user, password, instance, port);                
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
    
    public boolean backupDatabase(  final String user,
                                    final String password,
                                    final String instance,
                                    int port,
                                    final String dbName,
                                    final String fileName) throws Exception {
        
        final String mysqlPaht = getMySQLPATH(user,password,instance,port);
        
        Runtime runtime = Runtime.getRuntime();
        String mysqldumpExecutable = mysqlPaht.concat("bin\\mysqldump.exe");
        final String exec = mysqldumpExecutable + " --host=" + instance + " --user=" + user + " --password=" + password + " " + dbName + " --result-file=" + fileName;
        Process p = runtime.exec(exec);
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((reader.readLine()) != null) {}
        
        int processComplete = p.waitFor();
        
        if(processComplete!=0){
            LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, "backupDatabase failed");
            
            System.out.println("Failed to execute the following command: " + exec + " due to the following error(s):");
            try (final BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
               String line;
               while ((line = b.readLine()) != null)
                   System.out.println(line);
            } catch (final IOException e) {
               LoggerUtility.getSingleton().logError(MysqlScriptsUtil.class, e);
           }   
        }
        
        return processComplete==0;
    }
    
    
    public boolean importBackupDatabase(final String user,
                                        final String password,
                                        final String instance,
                                        int port,
                                        final String dbName,
                                        final String fileName) throws Exception {
        
        final String mysqlPaht = getMySQLPATH(user,password,instance,port);
        
        final FilesUtility FilesUtility = UtilitiesFactory.getSingleton().getFilesUtility();
                
        String connectionFile = "config.cnf";
        final String appPath = System.getProperty("user.dir");
        connectionFile = appPath + "\\" + connectionFile;        
        FilesUtility.createNewFile(connectionFile);
        final String text = "[mysql]\n" +
                            "user = " + user + "\n"+
                            "password = " + password + "\n" +
                            "host = " + instance + "\n";
        FilesUtility.writeToExistingFile(connectionFile, text);
        
        Runtime runtime = Runtime.getRuntime();
        String mysqldumpExecutable = mysqlPaht.concat("bin\\mysql.exe");
        final String exec = mysqldumpExecutable + " --defaults-extra-file=\"" + connectionFile + "\" " + dbName + " --execute=\"source " + fileName + "\"";
        Process p = runtime.exec(exec);
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = reader.readLine();
        while (line != null) {
            String test = "";
            line = reader.readLine();
        }
        
        int processComplete = p.waitFor();
        
        if(processComplete!=0){
            LoggerUtility.getSingleton().logInfo(MysqlScriptsUtil.class, "importBackupDatabase falied!");
            
            System.out.println("Failed to execute the following command: " + exec + " due to the following error(s):");
            try (final BufferedReader b = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
               while ((line = b.readLine()) != null)
                   System.out.println(line);
            } catch (final IOException e) {
               LoggerUtility.getSingleton().logError(MysqlScriptsUtil.class, e);
           }   
        }
        
        FilesUtility.deleteFile(connectionFile);
        
        return processComplete==0;
    }
    
    
    public boolean deleteDatabase(  final String user,
                                    final String password,
                                    final String instance,
                                    int port,
                                    final String dbName) throws Exception {
     
        //Create the database
        String query = "DROP DATABASE " + dbName;
        String sCon = "jdbc:mysql://" + instance + ":" + port + "/sys?user=" + user + "&password=" + password + "&verifyServerCertificate=false&useSSL=false";
        Connection conn = DriverManager.getConnection(sCon);
        Statement st = conn.createStatement();
        st.execute(query);
        
        return true;
    }
}
