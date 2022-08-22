package org.sofka.tour.model.teams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
    private String id;
    private String nameTeams;
    private String code;               // Debe ser unico, alfanumerico maximo 3 digitos
    private String countryId;          // Relación con la entidad pais a traves de su id
    private List<Cyclists> cyclists;   // Maximo 8 corredores
}
