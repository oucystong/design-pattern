package com.ouc.server;

import com.ouc.entity.Allusers;

public interface UserAggregate {
    void addUser(Allusers allusers);

    void removeUser(Allusers allusers);

    UserIterator getUserIterator();
}
