package com.usst.load.model;

import lombok.Data;

import java.util.Date;
@Data
public class Room {
    private Long id;
    /**
     * 空间代号
     */
    private String code;
    /**
     * x轴方向,长
     */
    private Integer xLength;
    /**
     * Y轴方向,宽
     */
    private Integer yLength;
    /**
     * z轴方向 高
     */
    private Integer zLength;

    private Date createTime;

    private Date updateTime;


}