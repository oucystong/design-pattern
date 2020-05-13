package com.ouc.server.impl;

import com.ouc.entity.Allusers;
import com.ouc.server.UserIterator;

import java.util.List;

/**
 * @author SenseChuang
 */
public class UserIteratorImpl implements UserIterator {
    private List<Allusers> list;
    private int position = 0;
    private  Allusers currentAllUser;

    public UserIteratorImpl(List<Allusers> list){
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Allusers next() {
        currentAllUser = list.get(position);
        position++;
        return currentAllUser;
    }
}
