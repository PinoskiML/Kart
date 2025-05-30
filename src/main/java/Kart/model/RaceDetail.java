package Kart.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class RaceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RaceTimeSlot raceTimeSlot;

    @Enumerated(EnumType.STRING)
    private RaceWeather raceWeather;
    private Integer attendance;
    private Integer fanFavorite;
    private Integer unlucky;

    @OneToOne(mappedBy = "raceDetail")
    @JsonBackReference
    @ToString.Exclude
    private Race race;

    public RaceDetail(RaceTimeSlot raceTimeSlot, RaceWeather raceWeather, Integer attendance, Integer fanFavorite, Integer unlucky) {
        this.raceTimeSlot = raceTimeSlot;
        this.raceWeather = raceWeather;
        this.attendance = attendance;
        this.fanFavorite = fanFavorite;
        this.unlucky = unlucky;
    }

    public void setRace(Race race){
        this.race = race;
        if (race != null && race.getRaceDetail() != this){
            race.setRaceDetail(this);
        }
    }
}
