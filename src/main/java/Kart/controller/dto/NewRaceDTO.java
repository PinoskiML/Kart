package Kart.controller.dto;

import Kart.model.RaceType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
//pojo
public class NewRaceDTO {

    private Integer id;  //albeit autogen

    @NotNull (message = "Name can't be empty")
    private String name;
    @NotNull (message = "Race date can't be empty")
    private LocalDate raceDate;

    @NotNull (message = "Race type can't be empty")
    @Enumerated(EnumType.STRING)
    private RaceType raceType;

    @NotNull (message = "Number of laps can't be empty")
    private Integer numberOfLaps;

    private RaceDetailDTO raceDetail;  //
    private Integer trackId;

}
