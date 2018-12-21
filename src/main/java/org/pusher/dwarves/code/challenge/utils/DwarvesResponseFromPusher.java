package org.pusher.dwarves.code.challenge.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.pusher.dwarves.code.challenge.model.Dwarf;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class DwarvesResponseFromPusher {

    @NonNull
    private List<Dwarf> dwarves;
}
