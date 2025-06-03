package Kart.model;

import Kart.controller.dto.TrackDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "track_id")
    //@JsonManagedReference
    //@JsonIgnore
    private Track track;

    @JsonProperty("track")
    public TrackDTO getTrackDTO(){
        return TrackDTO.fromTrack(track);
    }

    public Integer getTrackId() {
        return track != null ? track.getId() : null;
    }


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "race_detail_id")
    @JsonManagedReference
    @ToString.Exclude
    private RaceDetail raceDetail;



    public Race(String name, LocalDate raceDate, RaceType raceType, Integer numberOfLaps, Track track, RaceDetail raceDetail) {
        this.name = name;
        this.raceDate = raceDate;
        this.raceType = raceType;
        this.track = track;
        this.numberOfLaps = numberOfLaps;
        this.setRaceDetail(raceDetail);
    }

    // bi  review
    public void setRaceDetail(RaceDetail raceDetail){
        this.raceDetail = raceDetail;
        if (raceDetail != null && raceDetail.getRace() != this){
            raceDetail.setRace(this);
        }
    }



}
