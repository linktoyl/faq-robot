package cn.vitco.sr.api;

import cn.vitco.sr.web.result.JsonResult;
import cn.vitco.sr.web.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Sterling on 2018/1/29.
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping("/auth")
    public JsonResult auth(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> map){

        String key = map.get("key");
        if(key!=null && !key.isEmpty()) {
            log.debug(key);
        }

        return new JsonResult(ResultCode.SUCCESS, "登录成功！", null);
    }


}
