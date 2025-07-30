package fiap_substituva.infrasctruture.controllers.foto;

import fiap_substituva.application.usecases.foto.FotoUseCase;
import fiap_substituva.domain.Foto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    private final FotoUseCase fotoUseCase;

    public FotoController(FotoUseCase fotoUseCase) {
        this.fotoUseCase = fotoUseCase;
    }

    @PostMapping
    public FotoDTO adicionarFoto(@RequestBody FotoDTO fotoDTO) {
        Foto foto = fotoUseCase.adicionarFoto(
                new Foto(
                        fotoDTO.getId(),
                        fotoDTO.getUrl(),
                        fotoDTO.getIdEstabelecimento()
                )
        );
        return new FotoDTO(foto.getId(), foto.getUrl(), foto.getIdEstabelecimento());
    }

    @GetMapping("/{idEstabelecimento}")
    public List<FotoDTO> buscarFotos(@PathVariable Long idEstabelecimento) {
        return fotoUseCase.buscarFotosPorEstabelecimento(idEstabelecimento).stream()
                .map(foto -> new FotoDTO(foto.getId(), foto.getUrl(), foto.getIdEstabelecimento()))
                .toList();
    }

    @DeleteMapping("/{id}")
    public void excluirFoto(@PathVariable Long id){
        fotoUseCase.excluirFoto(id);
    }
}