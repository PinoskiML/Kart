package Kart.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RaceDetailUnluckyDTO {
    @NotNull (message = "New unlucky one can't be empty: ")
    private Integer unlucky;

}
