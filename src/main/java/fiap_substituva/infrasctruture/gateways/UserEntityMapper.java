package fiap_substituva.infrasctruture.gateways;

import fiap_substituva.domain.User;
import fiap_substituva.infrasctruture.persistence.UserEntity;

public class UserEntityMapper {
    UserEntity toEntity(User userDomainObj) {
        return new UserEntity(
                userDomainObj.getUsername(),
                userDomainObj.getPassword(),
                userDomainObj.getEmail()
        );
    }

    User toDomainObj(UserEntity userEntity) {
        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail());
    }

}