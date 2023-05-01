package info.developia.reactive.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Menu(@JsonProperty("title") String title) {
}
