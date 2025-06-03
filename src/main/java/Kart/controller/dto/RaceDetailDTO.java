package Kart.controller.dto;

import Kart.model.Competitor;
import Kart.model.RaceTimeSlot;
import Kart.model.RaceWeather;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
@AllArgsConstructor

public class RaceDetailDTO {

    //@NotNull(message = "ID slot is required.")
    private Integer id;

    @NotNull(message = "Race time slot is required.")
    private RaceTimeSlot raceTimeSlot;

    @NotNull(message = "Race weather slot is required.")
    private RaceWeather raceWeather;

    @NotNull(message = "Attendance slot is required.")
    @Positive(message = "Attendance must be positive.")
    private Integer attendance;

    @NotNull(message = "We need an unlucky one.")
    private Integer unlucky;

    @NotNull(message = "We need a favored one.")
    private Integer fanFavorite;


}
