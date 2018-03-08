package com.lss.girls.service;

import com.lss.girls.entity.Girl;

import java.util.List;

/**
 * @author Magic
 * @date 17:16 2018/2/11
 * @description
 */
public interface GirlService {

    Girl addGirl(Girl girl);

    Girl updateGirl(Girl girl);

    Girl findOne(Integer id);

    List<Girl> findAll();

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    List<Girl> findByCupSizeAndAge(String cupSize,int age);
}
