package com.hbgc.loudbbs.loudbbs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbgc.loudbbs.json.Json;
import com.hbgc.loudbbs.loudbbs.entity.TCategory;
import com.hbgc.loudbbs.loudbbs.mapper.TCategoryMapper;
import com.hbgc.loudbbs.loudbbs.service.TCategoryService;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gaofer
 * @since 2019-12-13
 */
@RestController
@RequestMapping("/category")
public class TCategoryController {


    @Resource
    private TCategoryService categoryService;
    @Resource
    private TCategoryMapper categoryMapper;


    /**
     * 查询所有类别
     * @return
     */
    @GetMapping("/")
    public Map<String,Object> getAll(){
        List<TCategory> categoryList=null;
        try{
            categoryList=categoryService.list();
            if(categoryList!=null){
                return Json.success(categoryList,"查询成功");
            }
            return Json.fail("查询失败");

        }catch (Exception e){
            e.printStackTrace();
            return Json.fail("查询失败");
        }
    }

    /**
     * 添加新类别
     * @param category
     * @return
     */
    @PostMapping("/")
    public Map<String,Object> addCategory(@RequestBody TCategory category){
        try{
            boolean b = categoryService.save(category);
            if(b) {
                return Json.success("","添加成功"); //注册成功
            }else{
                return Json.fail("添加失败"); //注册失败
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return Json.fail("添加失败"); //注册失败
        }

    }

    /**
     * 根据类别编号修改类别
     * @param category
     * @return
     */
    @PostMapping("/update")
    public Map<String,Object> updateCategory(@RequestBody TCategory category){
        try{
            boolean b = categoryService.updateById(category);
            if(b) {
                return Json.success("","修改成功"); //注册成功
            }else{
                return Json.fail("修改失败"); //注册失败
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return Json.fail("修改失败"); //注册失败
        }

    }

    /**
     * 根据类别编号删除类别
     * @param cid
     * @return
     */
    @DeleteMapping("/{cid}")
    public Map<String,Object> deleteCategory(@PathVariable("cid") int cid){
        QueryWrapper<TCategory> logWrapper = new QueryWrapper<>();
        logWrapper.eq("cid",cid);
        try{
            boolean b = categoryService.remove(logWrapper);
            if(b) {
                return Json.success("","删除成功");
            }else{
                return Json.fail("删除失败");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return Json.fail("删除失败");
        }

    }

}

