package com.ouc.server.impl;

import com.ouc.entity.Allusers;
import com.ouc.server.UserAggregate;
import com.ouc.server.UserIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SenseChuang
 */
public class UserAggregateImpl implements UserAggregate {

    private List<Allusers> list = new ArrayList<>();
    @Override
    public void addUser(Allusers allusers) {
        this.list.add(allusers);
    }

    @Override
    public void removeUser(Allusers allusers) {
        this.list.remove(allusers);
    }

    @Override
    public UserIterator getUserIterator() {
        return new UserIteratorImpl(list);
    }
}
