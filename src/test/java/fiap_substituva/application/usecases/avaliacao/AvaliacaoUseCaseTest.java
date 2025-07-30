package fiap_substituva.application.usecases.avaliacao;


import fiap_substituva.application.gateways.AvaliacaoGateway;
import fiap_substituva.domain.Avaliacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AvaliacaoUseCaseTest {

    @Mock
    private AvaliacaoGateway avaliacaoGateway;

    @InjectMocks
    private AvaliacaoUseCase avaliacaoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateProfessionalEvaluationSuccessfully() {

        Avaliacao avaliacao = createProfessionalAvaliacao();
        when(avaliacaoGateway.criarAvaliacaoProfissional(avaliacao)).thenReturn(avaliacao);

        Avaliacao result = avaliacaoUseCase.criarAvaliacaoProfissional(avaliacao);

        assertNotNull(result);
        assertEquals("Excelente serviço", result.getComentario());
        assertEquals(5, result.getEstrelas());
        verify(avaliacaoGateway, times(1)).criarAvaliacaoProfissional(avaliacao);
    }

    @Test
    void shouldThrowExceptionWhenCreatingNullProfessionalEvaluation() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            avaliacaoUseCase.criarAvaliacaoProfissional(null);
        });
        assertEquals("Avaliacao cannot be null", exception.getMessage());
    }

    @Test
    void shouldCreateEstablishmentEvaluationSuccessfully() {

        Avaliacao avaliacao = createEstablishmentAvaliacao();
        when(avaliacaoGateway.criarAvaliacaoEstabelecimento(avaliacao)).thenReturn(avaliacao);

        Avaliacao result = avaliacaoUseCase.criarAvaliacaoEstabelecimento(avaliacao);

        assertNotNull(result);
        assertEquals("Ótimo ambiente", result.getComentario());
        assertEquals(4, result.getEstrelas());
        verify(avaliacaoGateway, times(1)).criarAvaliacaoEstabelecimento(avaliacao);
    }

    @Test
    void shouldThrowExceptionWhenCreatingNullEstablishmentEvaluation() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            avaliacaoUseCase.criarAvaliacaoEstabelecimento(null);
        });
        assertEquals("Avaliacao cannot be null", exception.getMessage());
    }

    @Test
    void shouldListProfessionalEvaluationsSuccessfully() {

        Long profissionalId = 1L;
        List<Avaliacao> avaliacoes = List.of(
                createProfessionalAvaliacao(),
                new Avaliacao(2L, 1L, 4, "Muito bom", null, profissionalId)
        );
        when(avaliacaoGateway.listarAvaliacoesProfissionais(profissionalId)).thenReturn(avaliacoes);

        List<Avaliacao> result = avaliacaoUseCase.listarAvaliacoesProfissionais(profissionalId);


        assertNotNull(result);
        assertEquals(2, result.size());
        verify(avaliacaoGateway, times(1)).listarAvaliacoesProfissionais(profissionalId);
    }

    @Test
    void shouldListEstablishmentEvaluationsSuccessfully() {

        Long estabelecimentoId = 1L;
        List<Avaliacao> avaliacoes = List.of(
                createEstablishmentAvaliacao(),
                new Avaliacao(2L, 1L, 4, "Bom", estabelecimentoId, null)
        );
        when(avaliacaoGateway.listarAvaliacoesEstabelecimentos(estabelecimentoId)).thenReturn(avaliacoes);

        List<Avaliacao> result = avaliacaoUseCase.listarAvaliacoesEstabelecimentos(estabelecimentoId);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(avaliacaoGateway, times(1)).listarAvaliacoesEstabelecimentos(estabelecimentoId);
    }

    private Avaliacao createProfessionalAvaliacao() {
        return new Avaliacao(1L, 1L, 5, "Excelente serviço", null, 1L);
    }

    private Avaliacao createEstablishmentAvaliacao() {
        return new Avaliacao(1L, 1L, 4, "Ótimo ambiente", 1L, null);
    }
}