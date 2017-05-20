package myController;

import com.alibaba.fastjson.JSON;
import myInterface.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String listStudent() {
        return JSON.toJSONString(dataStorage.getList());
    }
}
