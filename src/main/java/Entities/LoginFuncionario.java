
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
    
    private String Login;
    private String Senha;

    public Integer getIdLoginFuncionario() {
        return idLoginFuncionario;
    }

    public void setIdLoginFuncionario(Integer idLoginFuncionario) {
        this.idLoginFuncionario = idLoginFuncionario;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
