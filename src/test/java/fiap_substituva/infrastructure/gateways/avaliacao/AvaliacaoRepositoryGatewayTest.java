package fiap_substituva.infrastructure.gateways.avaliacao;
import fiap_substituva.domain.Avaliacao;
import fiap_substituva.infrasctruture.gateways.avaliacao.AvaliacaoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.avaliacao.AvaliacaoEntity;
import fiap_substituva.infrasctruture.persistence.avaliacao.AvaliacaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AvaliacaoRepositoryGatewayTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private AvaliacaoRepositoryGateway avaliacaoRepositoryGateway;

    public AvaliacaoRepositoryGatewayTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarAvaliacaoProfissional() {

        Avaliacao avaliacao = new Avaliacao(1L, 2L, 5, "Great service!", null, 3L);
        AvaliacaoEntity entity = new AvaliacaoEntity(1L, 2L, 5, "Great service!", null, 3L);
        when(avaliacaoRepository.save(any(AvaliacaoEntity.class))).thenReturn(entity);

        Avaliacao result = avaliacaoRepositoryGateway.criarAvaliacaoProfissional(avaliacao);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(5, result.getEstrelas());
        assertEquals("Great service!", result.getComentario());
        verify(avaliacaoRepository, times(1)).save(any(AvaliacaoEntity.class));
    }

    @Test
    void testCriarAvaliacaoEstabelecimento() {

        Avaliacao avaliacao = new Avaliacao(1L, 2L, 4, "Good place!", 3L, null);
        AvaliacaoEntity entity = new AvaliacaoEntity(1L, 2L, 4, "Good place!", 3L, null);
        when(avaliacaoRepository.save(any(AvaliacaoEntity.class))).thenReturn(entity);

        Avaliacao result = avaliacaoRepositoryGateway.criarAvaliacaoEstabelecimento(avaliacao);


        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(4, result.getEstrelas());
        assertEquals("Good place!", result.getComentario());
        verify(avaliacaoRepository, times(1)).save(any(AvaliacaoEntity.class));
    }

    @Test
    void testListarAvaliacoesProfissionais() {

        Long idProfissional = 3L;
        List<AvaliacaoEntity> entities = Arrays.asList(
                new AvaliacaoEntity(1L, 2L, 5, "Great service!", null, 3L),
                new AvaliacaoEntity(2L, 4L, 4, "Good experience!", null, 3L)
        );
        when(avaliacaoRepository.findByIdProfissional(idProfissional)).thenReturn(entities);

        List<Avaliacao> result = avaliacaoRepositoryGateway.listarAvaliacoesProfissionais(idProfissional);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(5, result.get(0).getEstrelas());
        assertEquals("Great service!", result.get(0).getComentario());
        verify(avaliacaoRepository, times(1)).findByIdProfissional(idProfissional);
    }

    @Test
    void testListarAvaliacoesEstabelecimentos() {

        Long idEstabelecimento = 3L;
        List<AvaliacaoEntity> entities = Arrays.asList(
                new AvaliacaoEntity(1L, 2L, 5, "Great place!", 3L, null),
                new AvaliacaoEntity(2L, 4L, 3, "Average experience.", 3L, null)
        );
        when(avaliacaoRepository.findByIdEstabelecimento(idEstabelecimento)).thenReturn(entities);


        List<Avaliacao> result = avaliacaoRepositoryGateway.listarAvaliacoesEstabelecimentos(idEstabelecimento);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(5, result.get(0).getEstrelas());
        assertEquals("Great place!", result.get(0).getComentario());
        verify(avaliacaoRepository, times(1)).findByIdEstabelecimento(idEstabelecimento);
    }
}