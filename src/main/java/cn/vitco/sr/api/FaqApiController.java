package cn.vitco.sr.api;

import cn.vitco.sr.entity.FAQ_Buss;
import cn.vitco.sr.entity.FAQ_Jc;
import cn.vitco.sr.entity.FAQ_Moudle;
import cn.vitco.sr.entity.FAQ_SR_QA;
import cn.vitco.sr.mapper.FAQ_MoudleMapper;
import cn.vitco.sr.mapper.FAQ_QAMapper;
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
 * @author Streling(linktoyl@163.com)
 */
@RestController
@RequestMapping("/api")
public class FaqApiController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private FAQ_MoudleMapper moudleMapper;
    @Autowired
    private FAQ_QAMapper qaMapper;

    @GetMapping("moudlelist")
    public JsonResult moudlelist(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        ResultCode code = ResultCode.SUCCESS;
        String msg = "查询成功";
        List<FAQ_Moudle> list = null;
        try {
            list = moudleMapper.getAllMoudle();
            if(list == null||list.size()<1){
                msg = "空数据";
            }
        } catch (Exception e) {
            code = ResultCode.EXCEPTION;
            msg = e.getMessage();
        }

        return new JsonResult(code, msg, list);
    }

    @GetMapping("busslist")
    public JsonResult busslist(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        ResultCode code = ResultCode.SUCCESS;
        String msg = "查询成功";
        String moudle_id = map.get("moudleID");
        List<FAQ_Buss> list = null;
        try {
            list = moudleMapper.getAllBuss(moudle_id);
            if(list == null||list.size()<1){
                msg = "空数据";
            }
        } catch (Exception e) {
            code = ResultCode.EXCEPTION;
            msg = e.getMessage();
        }

        return new JsonResult(code, msg, list);
    }

    @GetMapping("jclist")
    public JsonResult jclist(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        ResultCode code = ResultCode.SUCCESS;
        String msg = "查询成功";
        String buss_id = map.get("bussID");
        String jc_dm = map.get("jcDM");

        List<FAQ_Jc> list = null;
        try {
            list = moudleMapper.getAllJc(buss_id, jc_dm);
            if(list == null||list.size()<1){
                msg = "空数据";
            }
        } catch (Exception e) {
            code = ResultCode.EXCEPTION;
            msg = e.getMessage();
        }

        return new JsonResult(code, msg, list);
    }

    @GetMapping("qalist")
    public JsonResult qalist(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        ResultCode code = ResultCode.SUCCESS;
        String msg = "查询成功";
        String jc_dm = map.get("jcDM");

        List<FAQ_SR_QA> list = null;
        try {
            list = qaMapper.getQAList(jc_dm);
            if(list == null||list.size()<1){
                msg = "空数据";
            }
        } catch (Exception e) {
            code = ResultCode.EXCEPTION;
            msg = e.getMessage();
        }

        return new JsonResult(code, msg, list);
    }

    @PutMapping("qalist")
    public JsonResult qaupdate(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        ResultCode code = ResultCode.SUCCESS;
        String msg = "更新成功";
        String qa_id = map.get("qa_id");
        if(qa_id ==null || qa_id.isEmpty()){
            code = ResultCode.PARAMS_ERROR;
            msg = "缺失更新参数ID";
        }else{
            try {
                qaMapper.updateQA(map);
            } catch (Exception e) {
                code = ResultCode.EXCEPTION;
                msg = e.getMessage();
            }
        }

        return new JsonResult(code, msg, null);
    }

    @PostMapping("qalist")
    public JsonResult qaadd(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        ResultCode code = ResultCode.SUCCESS;
        String msg = "添加成功";
        boolean flag = map.containsKey("jc_dm")&&map.containsKey("question")&&map.containsKey("answer");
        if(!flag){
            code = ResultCode.PARAMS_ERROR;
            msg = "请仔细检查参数配置是否有误";
        }else{
            try {
                qaMapper.addQA(map);
            } catch (Exception e) {
                code = ResultCode.EXCEPTION;
                msg = e.getMessage();
            }
        }

        return new JsonResult(code, msg, null);
    }


}
