
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
public class RegistroVeiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistroVeiculo;
    
    @ManyToOne
    @JoinColumn(name = "FuncionariosID")
    private Funcionarios funcionarioId;
    
    private LocalDate dataRegistro;
    
    @ManyToMany(mappedBy = "registroVeiculo", cascade = CascadeType.PERSIST)
    private List<Veiculo> veiculos = new ArrayList<>();
    

    public Integer getIdRegistroVeiculo() {
        return idRegistroVeiculo;
    }

    public void setIdRegistroVeiculo(Integer idRegistroVeiculo) {
        this.idRegistroVeiculo = idRegistroVeiculo;
    }

    public Funcionarios getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionarios funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
