package ifce.edu.br.MeuPrimeiroSpringBoot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_perfil")
public class Perfil {

    @OneToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
    
    @Column (name = "email")
    private String email;
    
    @Column (name = "senha")    
    private String senha;
    
    @Column (name = "estaAtivo")
    private boolean ativo;
    
    @Column (name = "desc")
    private String desc;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
