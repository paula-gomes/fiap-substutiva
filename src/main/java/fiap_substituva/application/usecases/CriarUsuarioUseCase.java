package fiap_substituva.application.usecases;

import fiap_substituva.application.gateways.UserGateway;
import fiap_substituva.domain.User;

public class CriarUsuarioUseCase {

    private final UserGateway userGateway;

    public CriarUsuarioUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }


    public User criarUsuario(User user){
        return userGateway.createUser(user);
    }
}
