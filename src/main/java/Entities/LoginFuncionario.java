
package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginFuncionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoginFuncionario;
    
    private String login;
    private String senha;

    public Integer getIdLoginFuncionario() {
        return idLoginFuncionario;
    }

    public void setIdLoginFuncionario(Integer idLoginFuncionario) {
        this.idLoginFuncionario = idLoginFuncionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String Login) {
        this.login = Login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String Senha) {
        this.senha = Senha;
    }
}
