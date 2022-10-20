package app.services;

import app.dtos.FuncionarioDTO;
import app.entities.Funcionario;
import app.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static java.time.Period.*;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> listarTodos() {
        List<FuncionarioDTO> FuncionarioDTO = new ArrayList<FuncionarioDTO>();
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
            FuncionarioDTO.add(funcionarioDTO);
        });
        return FuncionarioDTO;
    }

    public FuncionarioDTO buscaFuncionarioPorId(Long FuncionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(FuncionarioId);
        if (funcionario == null)
            throw new RuntimeException("Funcionario nao existe na base de dados");
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        return funcionarioDTO;
    }

    public FuncionarioDTO salvarNovoFuncionario(FuncionarioDTO funcionarioDTO) {

        Funcionario funcionarioQueVaiSerGravado;

        if (funcionarioDTO.getId() != null) {
            Funcionario verificaSeExisteFuncionario = funcionarioRepository.findById(funcionarioDTO.getId());
            if (verificaSeExisteFuncionario != null)
                throw new RuntimeException("Funcionario ja existe na base de dados");

        }

        funcionarioQueVaiSerGravado = new Funcionario();

        return this.registrarFuncionario(funcionarioQueVaiSerGravado, funcionarioDTO);
    }

    public FuncionarioDTO atualizarFuncionario(FuncionarioDTO funcionarioDTO) {

        if (funcionarioDTO.getId() == null)
            throw new RuntimeException("Funcionario nao existe na base de dados");

        Funcionario funcionarioQueVaiSerAtualizado = funcionarioRepository.findById(funcionarioDTO.getId());

        if (funcionarioQueVaiSerAtualizado == null) {
            throw new RuntimeException("Funcionario nao existe na base de dados");
        }

        boolean podeAlterar = this.validarAlteracaoFuncionario(funcionarioQueVaiSerAtualizado,
                2);

        if (podeAlterar) {

            funcionarioQueVaiSerAtualizado.setDataAtualizacao(LocalDateTime.now());

            return this.registrarFuncionario(funcionarioQueVaiSerAtualizado, funcionarioDTO);

        } else
            throw new RuntimeException("Funcionario nao pode ser alterado");

    }

    public void deletarFuncionario(Long FuncionarioId) {

        Funcionario funcionarioQueVaiSerDeletado = funcionarioRepository.findById(FuncionarioId);

        if (funcionarioQueVaiSerDeletado == null) {
            throw new RuntimeException("Funcionario não existe na base de dados");
        }

        boolean podeAlterar = this.validarAlteracaoFuncionario(funcionarioQueVaiSerDeletado,
                2);

        if (podeAlterar) {

            funcionarioQueVaiSerDeletado.setDataAtualizacao(LocalDateTime.now());

            this.funcionarioRepository.delete(funcionarioQueVaiSerDeletado);
        } else
            throw new RuntimeException("Funcionario nao pode ser alterado");

    }

    private FuncionarioDTO registrarFuncionario(Funcionario funcionarioQueVaiSerGravado,
            FuncionarioDTO funcionarioDTO) {

        funcionarioQueVaiSerGravado.setNome(funcionarioDTO.getNome());
        funcionarioQueVaiSerGravado.setSobrenome(funcionarioDTO.getSobrenome());
        funcionarioQueVaiSerGravado.setUsuario(funcionarioDTO.getUsuario());
        funcionarioQueVaiSerGravado.setSenha(funcionarioDTO.getSenha());

        funcionarioRepository.save(funcionarioQueVaiSerGravado);
        funcionarioDTO.setId(funcionarioQueVaiSerGravado.getId());

        return funcionarioDTO;
    }

    private boolean validarAlteracaoFuncionario(Funcionario funcionario, int prazoEmDiasParaAlteracao) {

        Period diff = between(funcionario.getDataCriacao().toLocalDate(),
                LocalDate.now());
        return (diff.getDays() <= prazoEmDiasParaAlteracao) ? true : false;

    }

}
