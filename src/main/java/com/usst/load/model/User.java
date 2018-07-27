package com.usst.load.model;


import javax.validation.constraints.NotNull;

/**
 * @author junlin.qi on 2018/7/12
 */
public class User {
	Integer id;
	@NotNull
	String name;
	@NotNull
	String password;
}
