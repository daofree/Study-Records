package cn.daofree.service;

import cn.daofree.domain.Province;

import java.util.List;

/**
 * @ClassName ProvinceService
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-02-25-16:17
 * @Version V1.0
 **/
public interface ProvinceService {
    public List<Province> fillAll();
    public String findAllJson();
}
