package com.Inw.projectBDiA;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {
    private static DataSource dataSource;
    private DataSourceProvider(){};


    public static DataSource getDataSource() throws NamingException {

        if(dataSource == null){
            Context initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext.lookup("java:comp/env/");
            dataSource = (DataSource) environmentContext.lookup("jdbc/SimpleBank");
        }
        return dataSource;
    }
}
