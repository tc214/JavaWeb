package org.tc.bean;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private Long userId;
    private String userName;


}
