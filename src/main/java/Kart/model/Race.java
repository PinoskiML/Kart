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

    @ManyToOne
    @JoinColumn(name = "track_id")
    @JsonBackReference
    private Track track;
}
