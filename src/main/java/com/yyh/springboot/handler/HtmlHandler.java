package com.yyh.springboot.handler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yyh.springboot.dao.DeptDao;
import com.yyh.springboot.po.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author YanYuHang
 * @create 2020-04-08-14:43
 */
@Controller
@RequestMapping("/html")
public class HtmlHandler {

  //1.引入dao接口
    @Autowired
    private DeptDao deptDao;

    /**
     * 查询全部
     * @param model
     * @return
     */
    @GetMapping("/selectAll")
    public String selectAll(Model model){
        //1.执行查询操作
        List<Dept> depts = deptDao.selectAll();
        //2.放入作用域
        model.addAttribute("depts",depts);
        return "selectAll";
    }

    /**
     *
     * @PathVariable  路径参数
     *
     * @param dept_id
     * @return
     */
    @GetMapping("/delete/{dept_id}/*")
    public String delete(@PathVariable int dept_id){
        deptDao.delete(dept_id);
        return "redirect:/html/selectAll";
    }


    @PostMapping("/insert")
    public String insert(Dept dept){
        deptDao.insert(dept);
        return "redirect:/html/selectAll";
    }

    @PostMapping("/update")
    public String update(Dept dept){
        deptDao.update(dept);
        return "redirect:/html/selectAll";
    }

    @GetMapping("/selectById/{dept_id}/*")
    public String selectById(@PathVariable int dept_id,Model model){
        Dept dept = deptDao.selectById(dept_id);
        model.addAttribute("dept",dept);
        return "update";
    }








    @GetMapping("/toInsert")
    public String toInsert(){
        return "insert";
    }


}
