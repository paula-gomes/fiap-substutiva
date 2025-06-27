package fiap_substituva.infrasctruture.controllers;

import fiap_substituva.domain.User;

public class UserDTOMapper {
    CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.getUsername(), user.getEmail());
    }

    public User toUser(CreateUserRequest request) {
        return new User(request.getUsername(), request.getPassword(), request.getEmail());
    }
}
