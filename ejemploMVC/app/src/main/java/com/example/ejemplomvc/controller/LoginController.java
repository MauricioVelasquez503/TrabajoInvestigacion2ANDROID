
package com.example.ejemplomvc.controller;
import com.example.ejemplomvc.Model.User;
import com.example.ejemplomvc.View.ILoginView;

public class LoginController implements IloginController {
    ILoginView loginView;
    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValid();
        if(loginCode == 0)
        {
            loginView.OnLoginError("Ingrese Email");
        }else  if (loginCode == 1){
            loginView.OnLoginError("Ingrese un correo valido");
        } else  if (loginCode == 2)
        {
            loginView.OnLoginError("Ingrese contraseña");
        }else  if(loginCode == 3){
            loginView.OnLoginError("Ingrese contraseña de mas de 6 caracteres");
        }
        else {
            loginView.OnLoginSuccess("Ha ingresado con exito");
        }
    }
}