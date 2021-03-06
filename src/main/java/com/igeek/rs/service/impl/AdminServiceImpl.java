package com.igeek.rs.service.impl;

import com.igeek.rs.dao.AdminDao;
import com.igeek.rs.entity.Admin;
import com.igeek.rs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-07-13 15:07:05
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired(required = false)
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public Admin queryById(Integer id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.adminDao.deleteById(id) > 0;
    }

    public Admin login(Admin admin) {
        Admin ad = adminDao.findNameAndPwd(admin);
        return ad;
    }


}