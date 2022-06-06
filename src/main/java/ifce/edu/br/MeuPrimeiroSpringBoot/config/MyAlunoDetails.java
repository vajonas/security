package ifce.edu.br.MeuPrimeiroSpringBoot.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ifce.edu.br.MeuPrimeiroSpringBoot.model.Aluno;

@SuppressWarnings("serial")
public class MyAlunoDetails implements UserDetails {
    private String username;
    private String password;
    private boolean active;
    private List<String> permissoes;
    
    public MyAlunoDetails(Aluno aluno) {
        this.username = aluno.getEmail();
        this.password = aluno.getSenha();
        this.active = aluno.isAtivo();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authority = new java.util.ArrayList<SimpleGrantedAuthority>();
        
        if (permissoes != null) {
            for (String permissao : permissoes) {
                authority.add(new SimpleGrantedAuthority(permissao));
            }
        }
        
        return authority;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return active;
    }
}
