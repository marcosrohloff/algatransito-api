package br.com.algatransito.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.algatransito.domain.exception.NegocioException;
import br.com.algatransito.domain.model.Proprietario;
import br.com.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;
    
    public Proprietario buscar(Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new NegocioException("Proprietário não encontrado"));
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();
        if (emailEmUso) {
            throw new NegocioException("Já existe um proprietário cadastrado com este e-mail");
        }
        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long proprietarioId) {
        proprietarioRepository.findById(proprietarioId)
               .orElseThrow(() -> new NegocioException("Proprietário não encontrado"));
        proprietarioRepository.deleteById(proprietarioId);
    }
 }
