package Kart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    //a s
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
    @Positive (message = "Cant be a negative number")
    private Integer totalRaces;


    public Competitor(String firstName, String lastName, Integer racerNumber, CompetitorClass competitorClass, Integer totalRaces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.racerNumber = racerNumber;
        this.competitorClass = competitorClass;
        this.totalRaces = totalRaces;
    }
}
