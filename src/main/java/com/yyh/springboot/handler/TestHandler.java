package com.yyh.springboot.handler;

import com.yyh.springboot.dao.DeptDao;
import com.yyh.springboot.po.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制类
 * @author YanYuHang
 * @create 2020-04-06-15:04
 */
@Controller
public class TestHandler {

    @RequestMapping("/testSpringBoot")
    @ResponseBody
    public String testSpringBoot(){
        return "测试SpringBoot";
    }
    @Autowired
    private DeptDao deptDao;
    @GetMapping("/testSelectAllDept")
    @ResponseBody
    public Object testSelectAllDept(){
        return deptDao.selectAll();
    }
    @GetMapping("/testSelectByIdDept")
    @ResponseBody
    public Object testSelectByIdDept(){
        return deptDao.selectById(2);
    }

    @GetMapping("/insert")
    @ResponseBody
    public Object insert(){
        Dept dept = new Dept();
        dept.setDept_name("202004063167");
        return deptDao.insert(dept)>0?"添加成功":"添加失敗";
    }
    @GetMapping("/update")
    @ResponseBody
    public Object update(){
        Dept dept = new Dept();
        dept.setDept_id(9);
        dept.setDept_name("修改測試3167");
        return deptDao.update(dept)>0?"修改成功":"修改失敗";
    }
    @GetMapping("/delete")
    @ResponseBody
    public Object delete(){
        return deptDao.delete(2)>0?"刪除成功":"刪除失敗";
    }
}
