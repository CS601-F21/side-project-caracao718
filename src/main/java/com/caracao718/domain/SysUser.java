package com.caracao718.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user
 * @author
 */
@Data
public class SysUser implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String snowTool;
    private Integer locationId;
}
