package Model;

import POJO.Login;
import implement.LoginImplement;

public class LoginModel {
    public static LoginModel getInstance() {
        return new LoginModel();
    }
    public boolean check_login(String username,String password){
     POJO.Login lg = LoginImplement.getInstance().get(username);
     if(lg.getPassword()!=null&&lg.getPassword().equals(password)){

         return true;
     }else {return false;}

    }
    public boolean check_register(Login lg){
        if(LoginImplement.getInstance().add(lg)){
return true;
        }
        return false;
    }

    }

