package Kart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor

public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private LocalDate raceDate;

    @Enumerated(EnumType.STRING)
    private RaceType raceType;

    @NotNull
    private Integer numberOfLaps;

    @ManyToOne
    @JoinColumn(name = "track_id")
    @JsonBackReference
    private Track track;

    public Integer getTrackId() {
        return track != null ? track.getId() : null;
    }


    public Race(String name, LocalDate raceDate, RaceType raceType, Integer numberOfLaps, Track track) {
        this.name = name;
        this.raceDate = raceDate;
        this.raceType = raceType;
        this.track = track;
        this.numberOfLaps = numberOfLaps;
    }
}
