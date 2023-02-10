package klapertart.lab.unitestrest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kurakuraninja
 * @since 10/02/23
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private long price;
}
