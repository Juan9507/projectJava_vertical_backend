package org.sofka.tour.mongo.countries.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class CountryDocument {
    @Id
    private String id;
    private String code;
    private String name;
}
