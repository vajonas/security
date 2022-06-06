package ifce.edu.br.MeuPrimeiroSpringBoot.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ifce.edu.br.MeuPrimeiroSpringBoot.model.Aluno;
import ifce.edu.br.MeuPrimeiroSpringBoot.model.Perfil;
import ifce.edu.br.MeuPrimeiroSpringBoot.repository.Alunos;

@Service
public class MyAlunoDetailsService implements UserDetailsService {

    @Autowired
    private Alunos service;
    
    @Override @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno aluno = service.findByAlunoEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario " + username + "não encontrado"));
        return new Aluno(aluno.getEmail(), aluno.getSenha(),
                AuthorityUtils.createAuthorityList(getAuthorities(aluno.getPerfis())));
    }
    
    private String[] getAuthorities(List<Perfil> perfis) {
        String[] authorities = new String[perfis.size()];
        
        for (int i = 0; i < perfis.size(); i++) {
            authorities[i] = perfis.get(i).getDesc();
        }
        return authorities;
    }

}
