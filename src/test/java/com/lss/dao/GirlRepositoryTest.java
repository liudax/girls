package com.lss.dao;

import com.lss.girls.dao.GirlRepository;
import com.lss.girls.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Magic
 * @date 9:27 2018/2/11
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlRepositoryTest {

    @Autowired
    private GirlRepository girlRepository;

    @Test
    public void findGirlById() throws Exception {
        Girl girl = girlRepository.findOne(1);
        Assert.assertEquals("B",girl.getCupSize());
    }

    @Test
    public void save() throws Exception {
        Girl girl = new Girl(1,"G",17);
        girlRepository.save(girl);
        //Assert.assertEquals(new Integer(3),girlRepository.save(girl).getId());
        //Assert.assertEquals("B",girlRepository.findById(2));
    }

    @Test
    public void findByCupSizeAndAge() throws Exception{
        List<Girl> girls = girlRepository.findByCupSizeAndAge("M",33);
        Assert.assertEquals(1,girls.size());
    }



}