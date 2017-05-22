package myController;

import com.alibaba.fastjson.JSON;
import myEntity.StudentInfo;
import myInterface.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KEASON on 2017/5/20.
 */
@Controller
@RequestMapping("/controller/student")
public class StudentController {
    @Autowired
    DataStorage dataStorage;

    @PostMapping("/data/list")
    @ResponseBody
    public String listStudent(@ModelAttribute StudentInfo info) {
        Map<String,List> map = new HashMap<String,List>();
        map.put("data",dataStorage.getList());
        return JSON.toJSONString(map);
    }

    @PostMapping("/data/param/list")
    @ResponseBody
    public String listParaStudent(@ModelAttribute StudentInfo info) {
        Map<String,List> map = new HashMap<String,List>();
        map.put("data",dataStorage.getListByParam(info));
        return JSON.toJSONString(map);
    }
}
