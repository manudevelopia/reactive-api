package info.developia.reactive.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(@JsonProperty("name") String name) {
}
