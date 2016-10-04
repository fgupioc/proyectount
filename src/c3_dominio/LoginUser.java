/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c3_dominio;

import c3_dominio.Personal;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Franz
 */
public class LoginUser {

    private static LoginUser login;
    private Personal personal;

    private LoginUser() {
    }

    public static LoginUser getInstancia() {
        if (login == null) {
            login = new LoginUser();
        }
        return login;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String encryptPass(String pass) { 
        return DigestUtils.md5Hex(pass);   
    }
}
