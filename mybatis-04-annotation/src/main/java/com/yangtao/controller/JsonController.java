package com.yangtao.controller;

import com.yangtao.entity.JsonModel;
import com.yangtao.mapper.JsonModelMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kante_yang
 * @Date: 2023/12/15
 */

@RestController
public class JsonController {

    @Autowired
    private JsonModelMapper jsonModelMapper;

    @GetMapping("/jsons")
    public List<JsonModel> getJsons() {

        return jsonModelMapper.getAllModels();
    }
}
