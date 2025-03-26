
package Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Funcionarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncionario;
    
    private String NomeFuncionario;
    private String Telefone;
    private String CPF;
    
    @OneToOne
    @JoinColumn(name = "FuncionarioidLogin")
    private LoginFuncionario loginFuncionario;
    
    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.PERSIST)
    private Cargo cargo;

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LoginFuncionario getLoginFuncionario() {
        return loginFuncionario;
    }

    public void setLoginFuncionario(LoginFuncionario loginFuncionario) {
        this.loginFuncionario = loginFuncionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString(){
        return this.NomeFuncionario;
    }
}
