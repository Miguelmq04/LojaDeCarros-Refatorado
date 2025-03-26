
package Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RegistroVenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistroVenda;
    
    @ManyToOne
    @JoinColumn(name = "ClienteID")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "FuncionariosID")
    private Funcionarios funcionario;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "VeiculoHasRegistroVenda",
            joinColumns = @JoinColumn (name = "RegistroVendaID"),
            inverseJoinColumns = @JoinColumn(name = "veiculoID")
    )
    List<Veiculo> veiculos = new ArrayList<>();
    
    private LocalDate dataRegistro;
    

    public Integer getIdRegistroVenda() {
        return idRegistroVenda;
    }

    public void setIdRegistroVenda(Integer idRegistroVenda) {
        this.idRegistroVenda = idRegistroVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }


    
}
