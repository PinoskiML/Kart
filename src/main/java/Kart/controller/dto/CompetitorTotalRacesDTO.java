package Kart.controller.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class CompetitorTotalRacesDTO {
    @NotNull
    @Positive(message = "Cant be a negative number")
    private Integer totalRaces;



}
