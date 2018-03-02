package cn.vitco.mybatis.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sterling on 2018/2/5.
 */
public class Page implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1969180630306261448L;
    private int showCount; //每页显示记录数
    private int totalPage;		//总页数
    private int totalResult;	//总记录数
    private int currentPage;	//当前页
    private int currentResult;	//当前记录起始索引
    private boolean entityOrField;	//true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
    //private String pageStr;		//最终页面显示的底部翻页导航，详细见：getPageStr();
    private Map params = new HashMap<String, Object>();



    public Page(){
        this.showCount = 15;
    }

    public int getTotalPage() {
        if(totalResult%showCount==0){
            totalPage = totalResult/showCount;
        }
        else{
            totalPage = totalResult/showCount+1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getCurrentPage() {
        if(currentPage<=0){
            currentPage = 1;
        }
        if(currentPage>getTotalPage()){
            currentPage = getTotalPage();
        }
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {

        this.showCount = showCount;
    }

    public int getCurrentResult() {
        currentResult = (getCurrentPage()-1)*getShowCount();
        if(currentResult<0){
            currentResult = 0;
        }
        return currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

    public boolean isEntityOrField() {
        return entityOrField;
    }

    public void setEntityOrField(boolean entityOrField) {
        this.entityOrField = entityOrField;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}
