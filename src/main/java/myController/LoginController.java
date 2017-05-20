package myController;

import com.alibaba.fastjson.JSON;
import myEntity.ResultEntity;
import myEntity.StudentInfo;
import myInterface.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by KEASON on 2017/5/19.
 */
@Controller
public class LoginController {
    @Autowired
    private DataStorage dataStorage;

    @GetMapping("/myWeb/jsp/login_get")
    public String login_get(@RequestParam Long id
            ,@RequestParam  String pwd
//                             ,@RequestBody String body  使用RequestBody会报错的
            ,@ModelAttribute StudentInfo studentInfo
    ) {
//        for (StudentInfo info : dataStorage.getList()) {
//            if (info.getId().equals(id) && info.getPwd().equals(pwd)) {
//                return "redirect:student.jsp";
//            }
//        }
        return "登录失败！账号密码错误";
    }

    @PostMapping(value = "/myWeb/jsp/login_ajax_post_obj")
    @ResponseBody
    public String login_axax_post(@RequestParam Long id
                                 ,@RequestParam  String pwd
                                 ,@RequestBody String body
                                 ,@RequestHeader(name = "Content-Type") String header_type
                                 ,@ModelAttribute StudentInfo studentInfo
                                  ,@RequestAttribute(name = "attr") String strr
                                  ,HttpServletRequest request
                                  ,HttpServletResponse response
                            ) {
        for (StudentInfo info : dataStorage.getList()) {
            if (info.getId().equals(id) && info.getPwd().equals(pwd)) {
                return JSON.toJSONString(new ResultEntity("success",""));
            }
        }
        return JSON.toJSONString(new ResultEntity("error","用户不存在，请重新登陆！"));
    }

    @GetMapping("/myWeb/jsp/login_get_obj")
    public String login_get_obj(@RequestBody StudentInfo info) {
//        for (StudentInfo info : dataStorage.getList()) {
//            if (info.getId().equals(id) && info.getPwd().equals(pwd)) {
//                return "redirect:student.jsp";
//            }
//        }
        return "登录失败！账号密码错误";
    }

    @PostMapping("/myWeb/jsp/login_post")
    public String login_post(Long id,String pwd) {
//        for (StudentInfo info : dataStorage.getList()) {
//            if (info.getId().equals(id) && info.getPwd().equals(pwd)) {
//                return "redirect:student.jsp";
//            }
//        }
        return "登录失败！账号密码错误";
    }

    @PostMapping("/myWeb/jsp/login_post_obj")
    public String login_post_obj(@RequestParam Long id,
                                 @RequestParam String pwd,
                                 @ModelAttribute StudentInfo infoMode,
                                 @RequestBody String body,
//                                 @RequestAttribute  StudentInfo infoAttr,
                                 Map map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
//        返回一个Map<String,List<String>>的数组
//        Map<String,String[]> map = request.getParameterMap();


// for (StudentInfo info : dataStorage.getList()) {
//            if (info.getId().equals(id) && info.getPwd().equals(pwd)) {
//                return "redirect:student.jsp";
//            }
//        }
        return "登录失败！账号密码错误";
    }
}
