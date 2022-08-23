package org.sofka.tour.mongo.team.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
public class TeamsDocument {
    @Id
    private String id;
    private String nameTeams;
    @Indexed(unique = true, background = true)
    private String code;                        // Debe ser unico, alfanumerico maximo 3 digitos
    private String countryId;                   // Relación con la entidad pais a traves de su id
    private List<Cyclists> cyclists;            // Maximo 8 corredores
}
