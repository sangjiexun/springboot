package net.codingme.boot.controller;

import net.codingme.boot.domain.Resource;
import net.codingme.boot.domain.Result;
import net.codingme.boot.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * @Author niujinpeng
 * @Date 2018/8/23 22:31
 */

@RequestMapping(value = "/spring")
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("")
    public String springboot() {
        return "Hello Spring boot!";
    }

    /**
     * 取请求路径中的值
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public String showName(@PathVariable("name") String name) {
        return "name:" + name;
    }

    /**
     * required = false 不是必要参数
     * defaultValue 默认值
     *
     * @param version
     * @return
     */
    @GetMapping(value = "/version")
    public String getName(@RequestParam(value = "version", required = false, defaultValue = "2.0") String version) {
        return "version:" + version;
    }

    /**
     * 获取配置中的信息
     *
     * @return
     */
    @GetMapping(value = "/resource")
    public Result getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return ResultUtil.success(bean);
    }

}