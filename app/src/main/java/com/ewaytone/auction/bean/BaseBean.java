package com.ewaytone.auction.bean;

import java.io.Serializable;

/**
 * Created by Xhz on 2015/12/18.
 */
public class BaseBean implements Serializable{

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
