package com.lss.girls.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Magic
 * @date 9:24 2018/2/11
 * @description
 */
@Entity
@ApiModel
public class Girl implements Serializable {

    @GeneratedValue
    @Id
    @ApiModelProperty(hidden = true)
    private Integer id;
    private String cupSize;
    private Integer age;

    public Girl(){

    }

    public Girl(String cupSize,Integer age){
        this.cupSize = cupSize;
        this.age = age;
    }
    public Girl(int id, String cupSize,Integer age){
        this.id = id;
        this.cupSize = cupSize;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
