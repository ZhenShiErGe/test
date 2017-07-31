package org.xyz.test.service.service.rpcmanage;

import org.springframework.stereotype.Service;
import org.xyz.test.client.service.IRpcService;

/**
 * Created by yizhenn on 2017/7/26.
 */
@Service("rpcService")
public class RpcService implements IRpcService{

    @Override
    public String service() {
        return "this is one test about security httpinvoker";
    }
}
