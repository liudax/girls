package com.lss.girls.service.impl;

import com.lss.girls.dao.GirlRepository;
import com.lss.girls.entity.Girl;
import com.lss.girls.exception.LssException;
import com.lss.girls.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Magic
 * @date 17:16 2018/2/11
 * @description
 */
@Service
public class GrilServiceImpl implements GirlService {



    @Autowired
    private GirlRepository girlRepository;

    @Override
    @CacheEvict(value = "girls",allEntries=true)
    public Girl addGirl(Girl girl) {
        return girlRepository.save(girl);
    }

    @Override
    @CacheEvict(value = "girls",allEntries=true)
    public Girl updateGirl(Girl girl) {
        if(girl.getId()==null){
            throw new LssException(1001,"缺少修改信息的ID信息");
        }
        return girlRepository.save(girl);
    }

    @Override
    @Cacheable(value="girls",key = "#id")
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }

    @Override
    @Cacheable(value = "girls")
    public List<Girl> findAll() {
        return girlRepository.query(1);
    }

    @Override
    @CacheEvict(value = "girls",allEntries=true)
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(List<Integer> ids) {
        List<Girl> girls = new ArrayList<>();
        ids.forEach(k->girls.add(new Girl(k,null,null)));
        girlRepository.delete(girls);
    }

    @Override
    public List<Girl> findByCupSizeAndAge(String cupSize, int age) {
        return girlRepository.findByCupSizeAndAge(cupSize,age);
    }
}
