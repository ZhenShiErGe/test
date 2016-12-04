
package org.xyz.test.common.common.userservice;

/**
 * Created by yizhenn on 2016/12/4.
 */
public enum RoleEnum {
    STUDENT(1, "学生"),
    TEACHER(2, "教师"),
    ADMIN(3, "管理员");

    private int    status;
    private String desc;

    public static RoleEnum getRoleByStatus(int status) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getStatus() == status) {
                return roleEnum;
            }
        }
        return null;
    }

    private RoleEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
