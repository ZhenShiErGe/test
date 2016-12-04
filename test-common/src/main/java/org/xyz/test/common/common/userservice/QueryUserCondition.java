
package org.xyz.test.common.common.userservice;

import java.io.Serializable;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class QueryUserCondition implements Serializable {

    private static final long serialVersionUID = 1708961263436328093L;

    private String            account;

    private String            username;

    private RoleEnum          role;

    private int               offset           = 0;

    private int               limit            = 10;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        if (offset >= 0) {
            this.offset = offset;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit > 0) {
            this.limit = limit;
        }
    }

}
