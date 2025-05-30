package Kart.controller.dto;

import Kart.model.Competitor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
//pojo
public class CompetitorBasicDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer racerNumber;

    public static CompetitorBasicDTO from (Competitor competitor){
        if (competitor == null) return null;

        return new CompetitorBasicDTO(
                competitor.getId(),
                competitor.getFirstName(),
                competitor.getLastName(),
                competitor.getRacerNumber()

        );

    }

}
