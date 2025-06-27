package fiap_substituva.infrasctruture.gateways;

import fiap_substituva.domain.User;

public class UserRepositoryGateway {

    // Aqui você pode implementar métodos que interagem com o UserRepository
    // e utilizam o UserEntityMapper para converter entre User e UserEntity.
    // Por exemplo, você pode ter métodos como salvarUsuario, buscarUsuarioPorId, etc.

    // Exemplo de método:
     public User salvarUsuario(User user) {

         return user; // ou converter de volta para User se necessário
     }
}
