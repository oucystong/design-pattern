package com.ouc.server;

import com.ouc.entity.Allusers;

public interface UserIterator {
    boolean hasNext();
    Allusers next();
}
