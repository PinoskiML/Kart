package Kart.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private Double totalLength;
    private Integer numberTurns;

    @Enumerated(EnumType.STRING)
    private TrackType trackType;
    //rel
    @JsonManagedReference
    @OneToMany(mappedBy = "track")
    private List<Race> races;

}
