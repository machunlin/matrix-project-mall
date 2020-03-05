package matrix.project.mall.controller;

import matrix.module.common.bean.Result;
import matrix.project.mall.service.RegionService;
import matrix.project.mall.vo.RegionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangcheng
 * @date 2020-03-05
 */
@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regionTree")
    public Result regionTree() {
        return Result.success(regionService.regionTree());
    }

    @PostMapping("/saveRegion")
    public Result saveRegion(@RequestBody RegionVo regionVo) {
        return Result.success(regionService.saveRegion(regionVo));
    }


    @GetMapping("/removeRegion")
    public Result removeRegion(@RequestParam Long code) {
        return Result.success(regionService.removeRegion(code));
    }
}
