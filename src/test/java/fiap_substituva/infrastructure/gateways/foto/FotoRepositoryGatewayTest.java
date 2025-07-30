package fiap_substituva.infrastructure.gateways.foto;
import fiap_substituva.application.gateways.EstabelecimentoGateway;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.domain.Foto;
import fiap_substituva.infrasctruture.exception.CustomException;
import fiap_substituva.infrasctruture.gateways.foto.FotoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.foto.FotoEntity;
import fiap_substituva.infrasctruture.persistence.foto.FotoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FotoRepositoryGatewayTest {

    @Mock
    private FotoRepository fotoRepository;

    @Mock
    private EstabelecimentoGateway estabelecimentoGateway;

    @InjectMocks
    private FotoRepositoryGateway fotoRepositoryGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void adicionarFoto_DeveAdicionarFotoComSucesso() {
        Foto foto = new Foto(null, "http://example.com/foto.jpg", 1L);
        Estabelecimento estabelecimento = new Estabelecimento("Nome", "123456789", "Endereco", "123456789", List.of("Servico1"), List.of("Profissional1"), List.of("Foto1"));
        FotoEntity fotoEntity = new FotoEntity(null, "http://example.com/foto.jpg", 1L);
        FotoEntity savedEntity = new FotoEntity(1L, "http://example.com/foto.jpg", 1L);

        when(estabelecimentoGateway.buscarEstabelecimentoPorId(1L)).thenReturn(estabelecimento);
        when(fotoRepository.save(any(FotoEntity.class))).thenReturn(savedEntity);

        Foto result = fotoRepositoryGateway.adicionarFoto(foto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("http://example.com/foto.jpg", result.getUrl());
        verify(fotoRepository, times(1)).save(any(FotoEntity.class));
    }

    @Test
    void adicionarFoto_DeveLancarExcecaoQuandoFotoForNula() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fotoRepositoryGateway.adicionarFoto(null);
        });

        assertEquals("Foto or Estabelecimento ID cannot be null", exception.getMessage());
    }

    @Test
    void adicionarFoto_DeveLancarExcecaoQuandoEstabelecimentoNaoExistir() {
        Foto foto = new Foto(null, "http://example.com/foto.jpg", 1L);

        when(estabelecimentoGateway.buscarEstabelecimentoPorId(1L)).thenReturn(null);

        CustomException exception = assertThrows(CustomException.class, () -> {
            fotoRepositoryGateway.adicionarFoto(foto);
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("Estabelecimento not found", exception.getMessage());
    }

    @Test
    void excluirFoto_DeveExcluirFotoComSucesso() {
        when(fotoRepository.existsById(1L)).thenReturn(true);

        fotoRepositoryGateway.excluirFoto(1L);

        verify(fotoRepository, times(1)).deleteById(1L);
    }

    @Test
    void excluirFoto_DeveLancarExcecaoQuandoIdForNulo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fotoRepositoryGateway.excluirFoto(null);
        });

        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    void excluirFoto_DeveLancarExcecaoQuandoFotoNaoExistir() {
        when(fotoRepository.existsById(1L)).thenReturn(false);

        CustomException exception = assertThrows(CustomException.class, () -> {
            fotoRepositoryGateway.excluirFoto(1L);
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals("Foto not found", exception.getMessage());
    }

    @Test
    void buscarFotosPorEstabelecimento_DeveRetornarListaDeFotos() {
        FotoEntity fotoEntity = new FotoEntity(1L, "http://example.com/foto.jpg", 1L);
        when(fotoRepository.findByEstabelecimentoId(1L)).thenReturn(List.of(fotoEntity));

        List<Foto> fotos = fotoRepositoryGateway.buscarFotosPorEstabelecimento(1L);

        assertNotNull(fotos);
        assertEquals(1, fotos.size());
        assertEquals(1L, fotos.get(0).getId());
        assertEquals("http://example.com/foto.jpg", fotos.get(0).getUrl());
    }

    @Test
    void buscarFotosPorEstabelecimento_DeveLancarExcecaoQuandoIdEstabelecimentoForNulo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            fotoRepositoryGateway.buscarFotosPorEstabelecimento(null);
        });

        assertEquals("Estabelecimento ID cannot be null", exception.getMessage());
    }
}