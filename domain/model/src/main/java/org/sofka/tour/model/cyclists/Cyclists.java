package org.sofka.tour.model.cyclists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cyclists {
    private String id;
    private String fullName;
    private String number;
    private String countryId;
}
