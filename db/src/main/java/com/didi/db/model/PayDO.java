package com.didi.db.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayDO {
    private Integer id;

    private Integer userId;

    private Integer pay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }
}