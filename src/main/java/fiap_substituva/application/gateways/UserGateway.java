package fiap_substituva.application.gateways;

import fiap_substituva.domain.User;

public interface UserGateway {
    User createUser(User userDomainObj);
}
