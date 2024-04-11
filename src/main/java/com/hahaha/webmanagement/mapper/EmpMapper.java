package com.hahaha.webmanagement.mapper;


import com.hahaha.webmanagement.anno.MyLog;
import com.hahaha.webmanagement.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 查询总记录数
     * @return
     */
    //@Select("select count(*) from emp")
    //public Long count();

    /**
     * 分页查询,获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 员工信息查询
     * @return
     */
    //@Select("select * from emp")
    @MyLog

    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    @MyLog
    void delete(List<Integer> ids);

    @MyLog

    @Insert("insert into emp(username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{username} ,#{password} ,#{name} ,#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);


    @MyLog
    @Select("select *from emp where id=#{id}")
    Emp getById(Integer id);

    @MyLog
    void update(Emp e);


    @Select("select *from emp where username=#{username} and password=#{password} ")
    Emp login(Emp emp);

    @MyLog
    @Delete("delete from emp where dept_id=#{id}")
    void deleteByDeptId(Integer id);

//@Select("select * from webmanagement.emp limit #{start},#{count}")
//    List<Emp> list1(Integer count, Integer start);
    
}
