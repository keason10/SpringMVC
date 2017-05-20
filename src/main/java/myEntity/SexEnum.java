package myEntity;

/**
 * Created by KEASON on 2017/5/19.
 */
public enum  SexEnum {
    MAN("男"),WOMAN("女");
    private String sexName;
    SexEnum(String sexName) {
        this.sexName = sexName;
    }

    public String getSexName() {
        return sexName;
    }
}
