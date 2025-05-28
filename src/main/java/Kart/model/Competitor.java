package Kart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Competitor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    //add pattern to include space
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    private Integer racerNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CompetitorClass competitorClass;

    @NotNull
    private Integer totalRaces;


    public Competitor(String firstName, String lastName, Integer racerNumber, CompetitorClass competitorClass, Integer totalRaces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.racerNumber = racerNumber;
        this.competitorClass = competitorClass;
        this.totalRaces = totalRaces;
    }
}
