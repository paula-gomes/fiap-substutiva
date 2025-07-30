package fiap_substituva.domain.enums;

import java.util.Arrays;

public enum DiasDaSemanaEnum {
    DOMINGO("Domingo"),
    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado");

    private final String descricao;

    DiasDaSemanaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static DiasDaSemanaEnum fromDescricao(String descricao) {
        return Arrays.stream(DiasDaSemanaEnum.values())
                .filter(dia -> dia.descricao.equalsIgnoreCase(descricao))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid day description: " + descricao));
    }
}