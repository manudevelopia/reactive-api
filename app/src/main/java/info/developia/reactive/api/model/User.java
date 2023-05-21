package info.developia.reactive.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(
        @JsonProperty("id") long id,
        @JsonProperty("name") String name
) {
}
