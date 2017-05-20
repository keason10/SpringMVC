package myEntity;

/**
 * Created by KEASON on 2017/5/20.
 */
public class ResultEntity {
    String code;
    String msg;

    public ResultEntity(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
