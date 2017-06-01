package testrecogercsv;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hpasarin
 */
public class UsuarioPerfilTaiga {
    String UserName;
    String FullName;
    String Email;
    String Password;

    public UsuarioPerfilTaiga(String UserName, String FullName, String Email, String Password) {
        this.UserName = UserName;
        this.FullName = FullName;
        this.Email = Email;
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
