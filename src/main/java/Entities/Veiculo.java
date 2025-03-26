
package Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.Year;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVeiculo;
    
    private String MarcaVeiculo;
    private String ModeloVeiculo;
    private String CorVeiculo;
    private String CambioVeiculo;
    private Year AnoVeiculo;
    private String Acessorios;
    private Double Quilometragem;
    private String CondicaoVeiculo;
    private String StatusManutencao;
    private Double PrecoVeiculo;
    private String Garantia;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
           name = "VeiculohasRegistroVeiculo",
           joinColumns = @JoinColumn(name = "VeiculoID"),
           inverseJoinColumns  = @JoinColumn(name = "RegistroVeiculoID")
    )
    private List<RegistroVeiculo> registroVeiculo = new ArrayList<>();

    @ManyToMany(mappedBy = "veiculos")
    List<RegistroVenda> registroVenda = new ArrayList<>();
    
    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarcaVeiculo() {
        return MarcaVeiculo;
    }

    public void setMarcaVeiculo(String MarcaVeiculo) {
        this.MarcaVeiculo = MarcaVeiculo;
    }

    public String getModeloVeiculo() {
        return ModeloVeiculo;
    }

    public void setModeloVeiculo(String ModeloVeiculo) {
        this.ModeloVeiculo = ModeloVeiculo;
    }

    public String getCorVeiculo() {
        return CorVeiculo;
    }

    public void setCorVeiculo(String CorVeiculo) {
        this.CorVeiculo = CorVeiculo;
    }

    public String getCambioVeiculo() {
        return CambioVeiculo;
    }

    public void setCambioVeiculo(String CambioVeiculo) {
        this.CambioVeiculo = CambioVeiculo;
    }

    public Year getAnoVeiculo() {
        return AnoVeiculo;
    }

    public void setAnoVeiculo(Year AnoVeiculo) {
        this.AnoVeiculo = AnoVeiculo;
    }

    public String getAcessorios() {
        return Acessorios;
    }

    public void setAcessorios(String Acessorios) {
        this.Acessorios = Acessorios;
    }

    public Double getQuilometragem() {
        return Quilometragem;
    }

    public void setQuilometragem(Double Quilometragem) {
        this.Quilometragem = Quilometragem;
    }

    public String getCondicaoVeiculo() {
        return CondicaoVeiculo;
    }

    public void setCondicaoVeiculo(String CondicaoVeiculo) {
        this.CondicaoVeiculo = CondicaoVeiculo;
    }

    public String getStatusManutencao() {
        return StatusManutencao;
    }

    public void setStatusManutencao(String StatusManutencao) {
        this.StatusManutencao = StatusManutencao;
    }

    public Double getPrecoVeiculo() {
        return PrecoVeiculo;
    }

    public void setPrecoVeiculo(Double PrecoVeiculo) {
        this.PrecoVeiculo = PrecoVeiculo;
    }

    public String getGarantia() {
        return Garantia;
    }

    public void setGarantia(String Garantia) {
        this.Garantia = Garantia;
    }

    public List<RegistroVeiculo> getRegistroVeiculo() {
        return registroVeiculo;
    }

    public void setRegistroVeiculo(List<RegistroVeiculo> registroVeiculo) {
        this.registroVeiculo = registroVeiculo;
    }

    public List<RegistroVenda> getRegistroVenda() {
        return registroVenda;
    }

    public void setRegistroVenda(List<RegistroVenda> registroVenda) {
        this.registroVenda = registroVenda;
    }

    @Override
    public String toString(){
        return MarcaVeiculo + " " + ModeloVeiculo;
    }
}
