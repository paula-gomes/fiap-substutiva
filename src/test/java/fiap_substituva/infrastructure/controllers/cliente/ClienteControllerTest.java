package fiap_substituva.infrastructure.controllers.cliente;


import fiap_substituva.application.usecases.cliente.ClienteUseCase;
import fiap_substituva.domain.Cliente;
import fiap_substituva.infrasctruture.controllers.cliente.ClienteController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



public class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClienteUseCase clienteUseCase;
    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    void testGetClientePorCpf() throws Exception {

        Cliente cliente = new Cliente("John Doe", "johndoe@example.com", "12345678955", "12345678900");
        when(clienteUseCase.buscarClientePorCpf("12345678955")).thenReturn(cliente);

        mockMvc.perform(get("/clientes/12345678955"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("John Doe"))
                .andExpect(jsonPath("$.email").value("johndoe@example.com"))
                .andExpect(jsonPath("$.cpf").value("12345678955"))
                .andExpect(jsonPath("$.telefone").value("12345678900"));

        verify(clienteUseCase, times(1)).buscarClientePorCpf("12345678955");
    }

    @Test
    void testCriaCliente() throws Exception {
        // Arrange
        Cliente cliente = new Cliente("John Doe", "johndoe@example.com", "123456789", "12345678900");
        Cliente savedCliente = new Cliente("John Doe", "johndoe@example.com", "123456789", "12345678900");
        when(clienteUseCase.criarCliente(Mockito.any(Cliente.class))).thenReturn(savedCliente);

        String requestBody = """
            {
                "nome": "John Doe",
                "email": "johndoe@example.com",
                "telefone": "12345678900",
                "cpf": "123456789"
            }
            """;

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("John Doe"))
                .andExpect(jsonPath("$.email").value("johndoe@example.com"))
                .andExpect(jsonPath("$.cpf").value("123456789"))
                .andExpect(jsonPath("$.telefone").value("12345678900"));

        verify(clienteUseCase, times(1)).criarCliente(Mockito.any(Cliente.class));
    }
}
