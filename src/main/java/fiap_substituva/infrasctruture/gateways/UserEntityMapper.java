package fiap_substituva.infrasctruture.gateways;

import fiap_substituva.domain.User;
import fiap_substituva.infrasctruture.persistence.UserEntity;

public class UserEntityMapper {
    public UserEntity toEntity(User userDomainObj) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDomainObj.getUsername());
        userEntity.setPassword(userDomainObj.getPassword());
        userEntity.setEmail(userDomainObj.getEmail());
                return userEntity;

    }

    public User toDomain(UserEntity userEntity) {
        User user = new User();

        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        return user;
    }



}