package fiap_substituva.infrasctruture.controllers;

import fiap_substituva.application.usecases.CriarUsuarioUseCase;
import fiap_substituva.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(CriarUsuarioUseCase criarUsuarioUseCase,
                          UserDTOMapper userDTOMapper) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.userDTOMapper = userDTOMapper;
    }


    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User userBusinessObj = userDTOMapper.toUser(request);
        User user = criarUsuarioUseCase.criarUsuario(userBusinessObj);
        return userDTOMapper.toResponse(user);
    }
}