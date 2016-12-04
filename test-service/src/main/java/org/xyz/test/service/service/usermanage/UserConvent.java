
package org.xyz.test.service.service.usermanage;

import org.xyz.test.common.common.userservice.RoleEnum;
import org.xyz.test.common.common.userservice.UserCreateReqDTO;
import org.xyz.test.common.common.userservice.UserDTO;
import org.xyz.test.dal.dataobject.UserDO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhenn on 2016/12/4.
 */

public class UserConvent {

    public static UserDTO conventToUserDTO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setAccount(userDO.getAccount());
        userDTO.setUserName(userDO.getUsername());
        userDTO.setRole(RoleEnum.getRoleByStatus(userDO.getRole()));

        return userDTO;
    }

    public static List<UserDTO> conventToUserDTOList(List<UserDO> userDOList) {
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        if (userDOList == null) {
            return userDTOList;
        }

        for (UserDO userDO : userDOList) {
            userDTOList.add(conventToUserDTO(userDO));
        }
        return userDTOList;
    }

    public static UserDO conventToUserDO(UserCreateReqDTO userCreateReqDTO) {
        if (userCreateReqDTO == null) {
            return null;
        }

        UserDO userDO = new UserDO();
        userDO.setAccount(userCreateReqDTO.getAccount());
        userDO.setPassword(userCreateReqDTO.getPassword());
        userDO.setRole(userCreateReqDTO.getRole().getStatus());
        userDO.setUsername(userCreateReqDTO.getUserName());
        return userDO;
    }
}
