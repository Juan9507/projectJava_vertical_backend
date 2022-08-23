package org.sofka.tour.mongo.cyclists.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class CyclistsDocument {
    @Id
    private String id;
    private String fullName;
    @Indexed(unique = true, background = true)
    private Integer number;
    private String countryId; // Id para asociar con el pais de nacionalidad

}
