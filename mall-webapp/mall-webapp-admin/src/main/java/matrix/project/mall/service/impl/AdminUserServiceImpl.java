package matrix.project.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import matrix.module.common.helper.Assert;
import matrix.module.common.helper.encrypt.MD5;
import matrix.module.common.utils.RandomUtil;
import matrix.project.mall.constants.Constant;
import matrix.project.mall.entity.AdminUser;
import matrix.project.mall.mapper.AdminUserMapper;
import matrix.project.mall.service.AdminUserService;
import matrix.project.mall.vo.LoginUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author wangcheng
 * @date 2020-02-28
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void changePwd(String username, String originPassword, String newPassword) {
        AdminUser user = queryByUsername(username);
        Assert.state(user != null, "用户不存在");
        assert user != null;
        Assert.state(user.getStatus().equals(Constant.ENABLED), "用户被禁用");
        Assert.state(user.getPassword().equals(MD5.get32(originPassword)), "密码错误");
        user.setPassword(MD5.get32(newPassword))
                .setUpdateTime(new Date());
        updateById(user);
    }

    @Override
    public String login(LoginUserVo loginUserVo) {
        Assert.state(!StringUtils.isEmpty(loginUserVo.getUsername()), "用户名不允许为空");
        Assert.state(!StringUtils.isEmpty(loginUserVo.getPassword()), "密码不允许为空");
        AdminUser user = queryByUsername(loginUserVo.getUsername());
        Assert.state(user != null, "用户不存在");
        assert user != null;
        Assert.state(user.getStatus().equals(Constant.ENABLED), "用户被禁用");
        Assert.state(user.getPassword().equals(MD5.get32(loginUserVo.getPassword())), "密码错误");
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String accessToken = RandomUtil.getUUID();
        String key = "login:" + accessToken;
        valueOperations.set(key, user.getUserId(), Constant.LOGIN_EXPIRE_TIME, TimeUnit.MINUTES);
        return accessToken;
    }

    @Override
    public void refreshAccessToken(String accessToken) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "login:" + accessToken;
        String value = valueOperations.get(key);
        Assert.state(!StringUtils.isEmpty(value), "Access-Token 已过期请重新获取");
        valueOperations.set(key, value, Constant.LOGIN_EXPIRE_TIME, TimeUnit.MINUTES);
    }

    @Override
    public AdminUser getUser(String accessToken) {
        String key = "login:" + accessToken;
        String userId = redisTemplate.opsForValue().get(key);
        return queryByUserId(userId);
    }

    @Override
    public AdminUser queryByUsername(String username) {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STATUS", Constant.ENABLED)
                .eq("USERNAME", username);
        return getOne(queryWrapper, false);
    }

    @Override
    public AdminUser queryByUserId(String userId) {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("STATUS", Constant.ENABLED)
                .eq("USER_ID", userId);
        return getOne(queryWrapper, false);
    }
}
