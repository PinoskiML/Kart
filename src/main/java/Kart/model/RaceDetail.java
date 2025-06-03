package Kart.model;


import Kart.controller.dto.CompetitorBasicDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fan_favorite_id")
    private Competitor fanFavorite;

    // In RaceDetail.java
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unlucky_id")
    private Competitor unlucky;

    @OneToOne(mappedBy = "raceDetail")
    @JsonBackReference
    @ToString.Exclude
    private Race race;

  /*  @JsonProperty("fan_favorite")
    public CompetitorBasicDTO getFanFavoriteDTO() {
        return CompetitorBasicDTO.from(fanFavorite);
    }

    @JsonProperty("unlucky")
    public CompetitorBasicDTO getUnluckyDTO() {
        return CompetitorBasicDTO.from(unlucky);
    }
*/
/*  @JsonProperty("fan_favorite")
  public CompetitorBasicDTO getFanFavoriteDTO() {
      return fanFavorite != null ? CompetitorBasicDTO.from(fanFavorite) : null;
  }*/

    @JsonProperty("unlucky")
    public CompetitorBasicDTO getUnluckyDTO() {
        return unlucky != null ? CompetitorBasicDTO.from(unlucky) : null;
    }



    public RaceDetail(RaceTimeSlot raceTimeSlot, RaceWeather raceWeather, Integer attendance, Competitor fanFavorite, Competitor unlucky) {
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
