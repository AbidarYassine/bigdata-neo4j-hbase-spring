package com.irisi.immo.model.bean;

import com.flipkart.hbaseobjectmapper.Family;
import com.flipkart.hbaseobjectmapper.HBColumn;
import com.flipkart.hbaseobjectmapper.HBRecord;
import com.flipkart.hbaseobjectmapper.HBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@HBTable(name = "User", families = {
        @Family(name = "User")
})
public class User implements HBRecord<String>, Serializable {


    private String id;
    @HBColumn(family = "User", column = "mobile")
    private String mobile;
    @HBColumn(family = "User", column = "email")
    private String email;
    @HBColumn(family = "User", column = "fullName")
    private String fullName;
    @HBColumn(family = "User", column = "password")
    private String password;

    @Override
    public String composeRowKey() {
        return email;
    }

    @Override
    public void parseRowKey(String s) {
        this.id = s;
    }
}
