package cn.vitco.sr.exception;

/**
 * Created by Sterling on 2018/1/31.
 */
public class VtException extends Exception {
    private static final long serialVersionUID = -281279508054638372L;

    private VT_EXCEPTION_TYPE type;
    private String errorCode;
    private String errorMsg;

    public VtException(String msg){
        this.type = VT_EXCEPTION_TYPE.SYSTEM;
        this.errorCode = "0000";
        this.errorMsg = msg;
    }

    public VtException(VT_EXCEPTION_TYPE type, String msg){
        this.type = type;
        this.errorMsg = msg;
        this.errorCode = "0000";
    }
    public VtException(String msg, String code){
        this.errorCode = code;
        this.type = VT_EXCEPTION_TYPE.SYSTEM;
        this.errorMsg = msg;
    }

    public VtException(VT_EXCEPTION_TYPE type, String msg, String code){
        this.errorCode = code;
        this.type = type;
        this.errorMsg = msg;
    }

    @Override
    public String getMessage() {
        return type.toString()+":("+errorCode+")"+errorMsg;
    }
}
