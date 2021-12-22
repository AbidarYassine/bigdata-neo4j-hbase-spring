package com.irisi.immo.model.service;

import com.irisi.immo.model.bean.User;

import java.io.IOException;

public interface UserService {

    User findByEmail(String id) throws IOException;

    User save(User user) throws IOException;
}
