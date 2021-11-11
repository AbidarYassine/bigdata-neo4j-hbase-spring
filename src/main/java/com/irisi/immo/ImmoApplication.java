package com.irisi.immo;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class ImmoApplication {

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

}
