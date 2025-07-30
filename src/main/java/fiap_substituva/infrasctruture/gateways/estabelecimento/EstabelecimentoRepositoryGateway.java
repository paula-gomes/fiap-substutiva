package fiap_substituva.infrasctruture.gateways.estabelecimento;

import fiap_substituva.application.gateways.EstabelecimentoGateway;

import fiap_substituva.domain.Estabelecimento;

import fiap_substituva.domain.Profissional;
import fiap_substituva.infrasctruture.exception.CustomException;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoEntity;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoRepository;
import fiap_substituva.infrasctruture.persistence.profissional.ProfissionalEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public class EstabelecimentoRepositoryGateway implements EstabelecimentoGateway {

    private final EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoRepositoryGateway(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento) {
        EstabelecimentoEntity estabelecimentoEntity = EstabelecimentoMapper.toEntity(estabelecimento);

        EstabelecimentoEntity savedEntity = estabelecimentoRepository.save(estabelecimentoEntity);

        return EstabelecimentoMapper.toDomain(savedEntity);
    }
    @Override
    public Estabelecimento buscarEstabelecimentoPorId(Long id) {
        return estabelecimentoRepository.findById(id)
                .map(EstabelecimentoMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Estabelecimento not found with id: " + id));
    }
    @Override
    public Estabelecimento buscarEstabelecimentoPorNome(String nome) {
        return estabelecimentoRepository.findByNome(nome)
                .map(EstabelecimentoMapper::toDomain)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Estabelecimento not found with nome: " + nome));
    }

    @Override
    public Estabelecimento editarEstabelecimento(Estabelecimento estabelecimento) {
        EstabelecimentoEntity existingEntity = estabelecimentoRepository.findByNome(estabelecimento.getNome())
                                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Estabelecimento not found with nome: " + estabelecimento.getNome()));

        existingEntity.setNome(estabelecimento.getNome());
        existingEntity.setCnpj(estabelecimento.getCnpj());
        existingEntity.setEndereco(estabelecimento.getEndereco());
        existingEntity.setTelefone(estabelecimento.getTelefone());
        existingEntity.setServicos(estabelecimento.getServicos());
        existingEntity.setProfissionais(estabelecimento.getProfissionais());
        existingEntity.setFotos(estabelecimento.getFotos());

        EstabelecimentoEntity updatedEntity = estabelecimentoRepository.save(existingEntity);

           if (updatedEntity == null) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update Estabelecimento");
        }     return EstabelecimentoMapper.toDomain(updatedEntity);
    }

}