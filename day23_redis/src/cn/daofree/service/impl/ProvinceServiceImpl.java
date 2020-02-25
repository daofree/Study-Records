package cn.daofree.service.impl;

import cn.daofree.dao.ProvinceDao;
import cn.daofree.dao.impl.ProvinceDaoImpl;
import cn.daofree.domain.Province;
import cn.daofree.service.ProvinceService;

import java.util.List;

/**
 * @ClassName ProvinceServiceImpl
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-02-25-16:18
 * @Version V1.0
 **/
public class ProvinceServiceImpl implements ProvinceService {
    // 声明DAO
    private ProvinceDao provinceDao = new ProvinceDaoImpl();
    @Override
    public List<Province> fillAll() {
        return provinceDao.fillAll();
    }
}
