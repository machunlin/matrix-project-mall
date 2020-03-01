package matrix.project.mall.controller;

import matrix.module.common.bean.Result;
import matrix.project.mall.annotation.NotNeedUserVerify;
import matrix.project.mall.service.AdminUserService;
import matrix.project.mall.utils.LoginUtil;
import matrix.project.mall.vo.AdminUserVo;
import matrix.project.mall.vo.LoginUserVo;
import matrix.project.mall.vo.QueryAdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangcheng
 * @date 2020-02-28
 */
@RestController
@RequestMapping("/admin-user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @NotNeedUserVerify
    @PostMapping("/login")
    public Result login(@RequestBody LoginUserVo loginUserVo) {
        return Result.success(adminUserService.login(loginUserVo));
    }

    @PostMapping("/countUser")
    public Result countUser(@RequestBody QueryAdminUserVo queryAdminUserVo) {
        return Result.success(adminUserService.countUser(queryAdminUserVo));
    }

    @PostMapping("/listUser")
    public Result listUser(@RequestBody QueryAdminUserVo queryAdminUserVo) {
        return Result.success(adminUserService.listUser(queryAdminUserVo));
    }

    @GetMapping("/getUser")
    public Result getUser() {
        return Result.success(LoginUtil.getAdminUser());
    }

    @PostMapping("/saveUser")
    public Result saveUser(@RequestBody AdminUserVo adminUserVo) {
        return Result.success(adminUserService.saveUser(adminUserVo));
    }

    @GetMapping("/removeUser")
    public Result removeUser(@RequestParam String userId) {
        return Result.success(adminUserService.removeUser(userId));
    }
}
