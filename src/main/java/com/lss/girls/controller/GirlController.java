package com.lss.girls.controller;

import com.lss.girls.entity.Girl;
import com.lss.girls.service.GirlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Magic
 * @date 9:02 2018/2/12
 * @description
 */
@Api(tags = {"girl相关"},description = "girl的新增、删除、查询等接口")
@RestController
public class GirlController {

    @Autowired
    private GirlService service;


    @ApiOperation(value="集群测试接口",notes = "相同路劲，两个项目返回不同数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="p2",value="参数p2")
    })
    @GetMapping("/ppp")
    public String hello(@RequestParam(required = true) String p2){
        return "girl！";
    }

    @GetMapping("/girls")
    public List<Girl> girls(){
        return service.findAll();
    }

    @GetMapping("/girl/{id}")
    public Girl findOne(@PathVariable("id") Integer id){

        return service.findOne(id);
    }

    @ApiOperation(value="添加girl对象接口",notes = "根据年龄，罩杯添加girl")
    @ApiImplicitParams({
            @ApiImplicitParam(name="cupSize",value="罩杯",required = true),
            @ApiImplicitParam(name="age",value="年龄",required = true)
    })
    @PostMapping("/girl")
    public Girl addGirl(Girl girl){
        return service.addGirl(girl);
    }

    @DeleteMapping("girl/{id}")
    public String delete(@PathVariable("id")Integer id){
        service.delete(Arrays.asList(new Integer[]{id}));
        return "delete success";
    }

}
