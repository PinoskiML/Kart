package Kart.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Track {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Double totalLength;
    @NotNull
    private Integer numberTurns;

    @Enumerated(EnumType.STRING)
    private TrackType trackType;


    @OneToMany(mappedBy = "track")
    @JsonIgnore
    private List<Race> races;


    //race IDs
    @JsonProperty ("raceIds")
    public List<Integer> getRaceIds() {
        if (races == null) {
            return new ArrayList<>();
        }
        return races.stream()
                .map(Race::getId)
                .collect(Collectors.toList());
    }

}
