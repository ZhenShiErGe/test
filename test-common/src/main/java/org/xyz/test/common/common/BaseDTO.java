
package org.xyz.test.common.common;



import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 336439024770228552L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
