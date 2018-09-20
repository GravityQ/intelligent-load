package com.usst.load.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author junlin.qi on 2018/7/12
 */
@Data
@AllArgsConstructor
public class User {
	Integer id;
	@NotNull(message = "用户名不能为空")
	String userName;
	@NotNull(message = "密码不能为空")
	String password;

	private String email;

	private String phone;

	private Integer role;
	private Date createTime;
	private Date updateTime;
}
