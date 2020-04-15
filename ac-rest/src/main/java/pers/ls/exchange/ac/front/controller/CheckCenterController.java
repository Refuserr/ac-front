package pers.ls.exchange.ac.front.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.ls.exchange.ac.front.config.WebSocketServer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {
    /**
     *
     * @param cid
     * @return
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid, HttpServletRequest request) {
        ModelAndView mav=new ModelAndView("/webSocket.html");
        mav.addObject("basePath",request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口
     * @param cid
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public RestResult pushToWeb(@PathVariable String cid, Student student) {
        RestResult restResult = new RestResult();
        try {
            WebSocketServer.sendInfo(JSON.toJSONString(student),cid);
        } catch (IOException e) {
            e.printStackTrace();
            restResult.setCode("1");
            restResult.setValue("失败");
            return restResult;
        }
        return restResult;
    }

    @Scheduled(cron="0/1 * *  * * ? ")
    public void shulder(){
        try {
            Student student = new Student();
            student.setName("张三");
            student.setAddress("中国");
            WebSocketServer.sendInfo(JSON.toJSONString(student),"1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
