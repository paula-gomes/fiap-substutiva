package fiap_substituva.infrastructure.controllers.foto;

import fiap_substituva.application.usecases.foto.FotoUseCase;
import fiap_substituva.domain.Foto;
import fiap_substituva.infrasctruture.controllers.foto.FotoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FotoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FotoUseCase fotoUseCase;

    @InjectMocks
    private FotoController fotoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(fotoController).build();
    }

    @Test
    void testAdicionarFoto() throws Exception {
        Foto foto = new Foto(1L, "http://example.com/foto.jpg", 2L);
        when(fotoUseCase.adicionarFoto(any(Foto.class))).thenReturn(foto);

        String requestBody = """
            {
                "id": 1,
                "url": "http://example.com/foto.jpg",
                "idEstabelecimento": 2
            }
            """;

        mockMvc.perform(post("/fotos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.url").value("http://example.com/foto.jpg"))
                .andExpect(jsonPath("$.idEstabelecimento").value(2));

        verify(fotoUseCase, times(1)).adicionarFoto(any(Foto.class));
    }

    @Test
    void testBuscarFotos() throws Exception {
        Foto foto = new Foto(1L, "http://example.com/foto.jpg", 2L);
        when(fotoUseCase.buscarFotosPorEstabelecimento(2L)).thenReturn(List.of(foto));

        mockMvc.perform(get("/fotos/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].url").value("http://example.com/foto.jpg"))
                .andExpect(jsonPath("$[0].idEstabelecimento").value(2));

        verify(fotoUseCase, times(1)).buscarFotosPorEstabelecimento(2L);
    }

    @Test
    void testExcluirFoto() throws Exception {
        doNothing().when(fotoUseCase).excluirFoto(1L);

        mockMvc.perform(delete("/fotos/1"))
                .andExpect(status().isOk());

        verify(fotoUseCase, times(1)).excluirFoto(1L);
    }
}