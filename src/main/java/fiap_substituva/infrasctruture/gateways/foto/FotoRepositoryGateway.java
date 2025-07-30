package fiap_substituva.infrasctruture.gateways.foto;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.FotoGateway;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.domain.Foto;
import fiap_substituva.infrasctruture.exception.CustomException;
import fiap_substituva.infrasctruture.persistence.foto.FotoEntity;
import fiap_substituva.infrasctruture.persistence.foto.FotoRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

public class FotoRepositoryGateway implements FotoGateway {
    private final FotoRepository fotoRepository;
    private final EstabelecimentoGateway estabelecimentoGateway;

    public FotoRepositoryGateway(FotoRepository fotoRepository, EstabelecimentoGateway estabelecimentoGateway) {
        this.fotoRepository = fotoRepository;
        this.estabelecimentoGateway = estabelecimentoGateway;
    }

    @Override
    public Foto adicionarFoto(Foto foto) {
        if (foto == null || foto.getIdEstabelecimento() == null) {
            throw new IllegalArgumentException("Foto or Estabelecimento ID cannot be null");
        }

        Estabelecimento estabelecimento = estabelecimentoGateway.buscarEstabelecimentoPorId(foto.getIdEstabelecimento());
        if (estabelecimento == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Estabelecimento not found");
        }

        FotoEntity fotoEntity = FotoMapper.toEntity(foto);
        FotoEntity savedEntity = fotoRepository.save(fotoEntity);

        return FotoMapper.toDomain(savedEntity);
    }

    @Override
    public void excluirFoto(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (!fotoRepository.existsById(id)) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Foto not found");
        }
        fotoRepository.deleteById(id);
    }

    @Override
    public List<Foto> buscarFotosPorEstabelecimento(Long idEstabelecimento) {
        if (idEstabelecimento == null) {
            throw new IllegalArgumentException("Estabelecimento ID cannot be null");
        }

        return fotoRepository.findByEstabelecimentoId(idEstabelecimento).stream()
                .map(FotoMapper::toDomain)
                .collect(Collectors.toList());
    }
}