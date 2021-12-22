package com.irisi.immo.model.service.impl;

import com.irisi.immo.model.bean.User;
import com.irisi.immo.model.repository.UserDao;
import com.irisi.immo.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Override
    public User findByEmail(String email) throws IOException {
       return  userDao.get(email);
    }

    @Override
    public User save(User user) throws IOException {
        String id = userDao.persist(user);
        if (id != null) return userDao.get(id);
        return null;
    }
}
