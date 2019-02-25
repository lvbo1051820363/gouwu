package cn.itsource.gouwu.controller;

import cn.itsource.gouwu.domain.Employee;
import cn.itsource.util.AjaxResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody Employee employee){
        if ("admin".equals(employee.getName())&&"admin".equals(employee.getPassword())){
            return AjaxResult.me().setSuccess(true).setMsg("登录成功");
        }else {
            return AjaxResult.me().setSuccess(false).setMsg("登录失败");
        }
    }
}
