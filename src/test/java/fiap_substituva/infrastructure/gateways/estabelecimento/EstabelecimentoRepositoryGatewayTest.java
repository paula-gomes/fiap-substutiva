package fiap_substituva.infrastructure.gateways.estabelecimento;
import fiap_substituva.domain.Estabelecimento;
import fiap_substituva.infrasctruture.gateways.estabelecimento.EstabelecimentoRepositoryGateway;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoEntity;
import fiap_substituva.infrasctruture.persistence.estabelecimento.EstabelecimentoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EstabelecimentoRepositoryGatewayTest {

    @Mock
    private EstabelecimentoRepository estabelecimentoRepository;

    @InjectMocks
    private EstabelecimentoRepositoryGateway estabelecimentoRepositoryGateway;

    public EstabelecimentoRepositoryGatewayTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarEstabelecimento() {

        Estabelecimento estabelecimento = new Estabelecimento("Nome", "123456789", "Endereco", "123456789", List.of("Servico1"), List.of("Profissional1"), List.of("Foto1"));
        EstabelecimentoEntity entity = new EstabelecimentoEntity(1L, "Nome", "123456789", "Endereco", "123456789", List.of("Servico1"), List.of("Profissional1"), List.of("Foto1"));
        when(estabelecimentoRepository.save(any(EstabelecimentoEntity.class))).thenReturn(entity);


        Estabelecimento result = estabelecimentoRepositoryGateway.criarEstabelecimento(estabelecimento);


        assertNotNull(result);
        assertEquals("Nome", result.getNome());
        verify(estabelecimentoRepository, times(1)).save(any(EstabelecimentoEntity.class));
    }

    @Test
    void testBuscarEstabelecimentoPorId() {

        Long id = 1L;
        EstabelecimentoEntity entity = new EstabelecimentoEntity(id, "Nome", "123456789", "Endereco", "123456789", List.of("Servico1"), List.of("Profissional1"), List.of("Foto1"));
        when(estabelecimentoRepository.findById(id)).thenReturn(Optional.of(entity));

        Estabelecimento result = estabelecimentoRepositoryGateway.buscarEstabelecimentoPorId(id);

        assertNotNull(result);
        assertEquals("Nome", result.getNome());
        verify(estabelecimentoRepository, times(1)).findById(id);
    }

    @Test
    void testBuscarEstabelecimentoPorNome() {

        String nome = "Nome";
        EstabelecimentoEntity entity = new EstabelecimentoEntity(1L, nome, "123456789", "Endereco", "123456789", List.of("Servico1"), List.of("Profissional1"), List.of("Foto1"));
        when(estabelecimentoRepository.findByNome(nome)).thenReturn(Optional.of(entity));


        Estabelecimento result = estabelecimentoRepositoryGateway.buscarEstabelecimentoPorNome(nome);


        assertNotNull(result);
        assertEquals(nome, result.getNome());
        verify(estabelecimentoRepository, times(1)).findByNome(nome);
    }

    @Test
    void testEditarEstabelecimento() {

        Estabelecimento estabelecimento = new Estabelecimento("Nome", "987654321", "Novo Endereco", "987654321", List.of("Servico2"), List.of("Profissional2"), List.of("Foto2"));
        EstabelecimentoEntity existingEntity = new EstabelecimentoEntity(1L, "Nome", "123456789", "Endereco", "123456789", List.of("Servico1"), List.of("Profissional1"), List.of("Foto1"));
        EstabelecimentoEntity updatedEntity = new EstabelecimentoEntity(1L, "Nome", "987654321", "Novo Endereco", "987654321", List.of("Servico2"), List.of("Profissional2"), List.of("Foto2"));

        when(estabelecimentoRepository.findByNome(estabelecimento.getNome())).thenReturn(Optional.of(existingEntity));
        when(estabelecimentoRepository.save(existingEntity)).thenReturn(updatedEntity);

        Estabelecimento result = estabelecimentoRepositoryGateway.editarEstabelecimento(estabelecimento);

        assertNotNull(result);
        assertEquals("Novo Endereco", result.getEndereco());
        assertEquals("987654321", result.getTelefone());
        verify(estabelecimentoRepository, times(1)).findByNome(estabelecimento.getNome());
        verify(estabelecimentoRepository, times(1)).save(existingEntity);
    }
}
