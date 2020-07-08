package user.service.impl;

import user.model.Login;
import user.model.User;

public interface IUserService {
    User checkLogin(Login login);
}
