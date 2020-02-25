package cn.daofree.dao.impl;

import cn.daofree.dao.ProvinceDao;
import cn.daofree.domain.Province;
import cn.daofree.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName ProvinceDaoImpl
 * @Description: TODO
 * @Author DaoTianXia
 * @Date 2020-02-25-16:16
 * @Version V1.0
 **/
public class ProvinceDaoImpl implements ProvinceDao {

    // 1.声明成员变量 jdbctemplement
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> fillAll() {
        //1.定义sql
        String sql = "select * from province";
        //2.执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return list;
    }
}
