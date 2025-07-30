package fiap_substituva.infrasctruture.gateways.servico;

import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.application.gateways.ServicoGateway;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.domain.Servico;
import fiap_substituva.infrasctruture.exception.CustomException;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoEntity;
import fiap_substituva.infrasctruture.persistence.servico.ServicoEntity;
import fiap_substituva.infrasctruture.persistence.servico.ServicoRepository;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class ServicoRepositoryGateway implements ServicoGateway {

    private final ServicoRepository servicoRepository;
    private final EstabelecimentoGateway estabelecimentoGateway;

    public ServicoRepositoryGateway(ServicoRepository servicoRepository, EstabelecimentoGateway estabelecimentoGateway) {
        this.servicoRepository = servicoRepository;
        this.estabelecimentoGateway = estabelecimentoGateway;
    }

    @Override
    public Servico criarServico(Servico servico) {

        ServicoEntity servicoEntity = SerivcoMapper.toEntity(servico);

        ServicoEntity savedEntity = servicoRepository.save(servicoEntity);
        if (savedEntity == null) {
            throw new CustomException(HttpStatus.SERVICE_UNAVAILABLE,"Failed to save Servico");
        }
        return SerivcoMapper.toDomain(savedEntity);
    }


}