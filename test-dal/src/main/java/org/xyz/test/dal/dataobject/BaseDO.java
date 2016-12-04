
package org.xyz.test.dal.dataobject;



import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
/**
 * Created by yizhenn on 2016/12/4.
 */
public class BaseDO {

    private Date gmtCreate;

    private Date gmtModified;

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
