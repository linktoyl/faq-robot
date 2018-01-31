package cn.vitco.sr.api;

import cn.vitco.sr.entity.FAQ_Moudle;
import cn.vitco.sr.mapper.FAQ_MoudleMapper;
import cn.vitco.sr.web.result.JsonResult;
import cn.vitco.sr.web.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 授权 API 接口
 * Created by Sterling on 2018/1/29.
 */
@RestController
@RequestMapping("/faq")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private FAQ_MoudleMapper moudleMapper;

    @RequestMapping("/auth")
    public JsonResult auth(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){

        String key = map.get("key");
        if(key!=null && key!="") {
            log.debug(key);
        }
        List<FAQ_Moudle> list = moudleMapper.getAllMoudle();

        return new JsonResult(ResultCode.SUCCESS, "登录成功！", list);
    }


}
