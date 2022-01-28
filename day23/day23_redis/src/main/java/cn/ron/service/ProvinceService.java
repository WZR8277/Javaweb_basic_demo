package cn.ron.service;

import cn.ron.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();
}
