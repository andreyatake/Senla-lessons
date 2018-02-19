package com.daoAPI;

import com.daoAPI.IBaseDAO;
import com.model.User;
import com.model.UserData;

public interface IUserDataDAO extends IBaseDAO<UserData> {
    UserData getDataByUser(User user)throws Exception;
}