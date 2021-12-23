package com.irisi.immo.model.util;

import com.flipkart.hbaseobjectmapper.HBAdmin;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.irisi.immo.model.util.Constants.PROJECT_SOURCE_PATH;


public class HBaseUtils {
    private HBaseUtils() {
    }

    public static void generateTables(Connection connection, String beanPath) throws Exception {
        HBAdmin hbAdmin = HBAdmin.create(connection);
        File file = new File(PROJECT_SOURCE_PATH + beanPath);
        String[] files = file.list();
        for (int i = 0; i < files.length; i++) {
            String myFile = files[i];
            myFile = myFile.replace(".java", "");
            Class myClass = Class.forName(beanPath.replace("/", ".") + "." + myFile);
            if (!tableExists(connection, myFile)) {
                hbAdmin.createTable(myClass);
            }
        }

    }

    public static boolean tableExists(Connection connection, String myClassName) throws IOException {
        TableName tableName = TableName.valueOf(myClassName);
        Admin admin = connection.getAdmin();
        TableName[] tableNames = admin.listTableNames();
        return Arrays.asList(tableNames).contains(tableName);
    }
}
