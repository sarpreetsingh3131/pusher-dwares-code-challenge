package org.pusher.dwarves.code.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class Dwarf {

    @NonNull
    private String name;

    @NonNull
    private String birth;

    @NonNull
    private String death;

    @NonNull
    private String culture;
}
