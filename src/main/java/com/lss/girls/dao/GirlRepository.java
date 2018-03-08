package com.lss.girls.dao;

import com.lss.girls.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author Magic
 * @date 9:26 2018/2/11
 * @description
 */

public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     * 根据型号和年龄查找
     * @param cupSize
     * @param age
     * @return
     */
    List<Girl> findByCupSizeAndAge(String cupSize, int age);


    @Query(nativeQuery = true,value="select  s.*,r.role from girl s left join role r on s.id = r.userId  where s.id = ?1")
    List<Girl> query(int id);
}
