package Kart.controller.dto;

import Kart.model.Track;
import Kart.model.TrackType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
//pojo
public class TrackDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Double totalLength;
    @NotNull
    private Integer numberTurns;

    @NotNull
    private TrackType trackType;

    //Factory
    public static TrackDTO fromTrack(Track track){
        if (track == null) return  null;
        return new TrackDTO(
                track.getId(),
                track.getName(),
                track.getTotalLength(),
                track.getNumberTurns(),
                track.getTrackType()
        );
    }
   //rel
}
