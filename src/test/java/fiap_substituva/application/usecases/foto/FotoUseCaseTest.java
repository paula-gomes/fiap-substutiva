package fiap_substituva.application.usecases.foto;

import fiap_substituva.application.gateways.FotoGateway;
import fiap_substituva.domain.Foto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FotoUseCaseTest {

    @Mock
    private FotoGateway fotoGateway;

    @InjectMocks
    private FotoUseCase fotoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAddFotoSuccessfully() {

        Foto foto = createFoto();
        when(fotoGateway.adicionarFoto(foto)).thenReturn(foto);

        Foto result = fotoUseCase.adicionarFoto(foto);


        assertNotNull(result);
        assertEquals("http://example.com/foto.jpg", result.getUrl());
        verify(fotoGateway, times(1)).adicionarFoto(foto);
    }

    @Test
    void shouldDeleteFotoSuccessfully() {

        Long fotoId = 1L;
        doNothing().when(fotoGateway).excluirFoto(fotoId);

        fotoUseCase.excluirFoto(fotoId);

        verify(fotoGateway, times(1)).excluirFoto(fotoId);
    }

    @Test
    void shouldRetrieveFotosByEstabelecimentoSuccessfully() {

        Long idEstabelecimento = 1L;
        List<Foto> fotos = List.of(createFoto());
        when(fotoGateway.buscarFotosPorEstabelecimento(idEstabelecimento)).thenReturn(fotos);

        List<Foto> result = fotoUseCase.buscarFotosPorEstabelecimento(idEstabelecimento);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(fotoGateway, times(1)).buscarFotosPorEstabelecimento(idEstabelecimento);
    }

    private Foto createFoto() {
        return new Foto(1L, "http://example.com/foto.jpg", 1L);
    }
}