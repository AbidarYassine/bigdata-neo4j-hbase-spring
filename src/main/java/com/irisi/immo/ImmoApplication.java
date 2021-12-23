package com.irisi.immo;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.flipkart.hbaseobjectmapper.HBAdmin;
import com.irisi.immo.model.bean.Annonce;
import com.irisi.immo.model.util.HBaseUtils;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class ImmoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ImmoApplication.class, args);
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dye0ygkxm",
                "api_key", "126716589298932",
                "api_secret", "y644M0lSkNXvJaJUfkCnJykpWuA"));
    }


    @Bean
    Connection getConnection() throws IOException {
        System.setProperty("hadoop.home.dir", "C:/winutils");
        return ConnectionFactory.createConnection(HBaseConfiguration.create());
    }

    @Override
    public void run(String... args) throws Exception {
        HBaseUtils.generateTables(getConnection(), "com/irisi/immo/model/bean");
    }

}
