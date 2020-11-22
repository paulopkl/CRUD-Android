package up.edu.br.exemplocrud;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private Integer Id;
    private String Nome;
    private String CPF;
    private String Logradouro;
    private Integer NumeroCasa;
    private Integer CEP;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private Integer NumeroTelefone;
    private Integer DDD;
    private String TipoTelefone;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCpf() {
        return CPF;
    }
    public void setCpf(String cpf) {
        this.CPF = cpf;
    }

    public String getLogradouro() { return Logradouro; }
    public void setLogradouro(String logradouro) { Logradouro = logradouro; }

    public Integer getNumeroCasa() { return NumeroCasa; }
    public void setNumeroCasa(Integer numeroCasa) { NumeroCasa = numeroCasa; }

    public Integer getCEP() { return CEP; }
    public void setCEP(Integer CEP) { this.CEP = CEP; }

    public String getBairro() { return Bairro; }
    public void setBairro(String bairro) { Bairro = bairro; }

    public String getCidade() { return Cidade; }
    public void setCidade(String cidade) { Cidade = cidade; }

    public String getEstado() { return Estado; }
    public void setEstado(String estado) { Estado = estado; }

    public Integer getNumeroTelefone() { return NumeroTelefone; }
    public void setNumeroTelefone(Integer numeroTelefone) { NumeroTelefone = numeroTelefone; }

    public Integer getDDD() { return DDD; }
    public void setDDD(Integer DDD) { this.DDD = DDD; }

    public String getTipoTelefone() { return TipoTelefone; }
    public void setTipoTelefone(String tipoTelefone) { TipoTelefone = tipoTelefone; }

    @Override
    public String toString() { return Id + " - " + Nome; }
}
