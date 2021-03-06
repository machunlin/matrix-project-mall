package matrix.project.mall.controller;

import matrix.module.common.bean.Result;
import matrix.module.oplog.annotation.OpLog;
import matrix.project.mall.service.CategoryService;
import matrix.project.mall.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangcheng
 * @date 2020-03-01
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categoryTree")
    public Result menuTree() {
        return Result.success(categoryService.queryTree());
    }

    @PostMapping("/saveTree")
    @OpLog("保存分类树")
    public Result saveTree(@RequestBody CategoryVo categoryVo) {
        return Result.success(categoryService.saveTree(categoryVo));
    }

    @GetMapping("/removeTree")
    @OpLog("移除分类树")
    public Result removeTree(@RequestParam String categoryId) {
        return Result.success(categoryService.removeTree(categoryId));
    }
}
