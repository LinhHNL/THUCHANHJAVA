package DAO;

import POJO.Login;

public interface LoginDAO {
    public Login get(String username);
    public boolean add(Login lg);
}
