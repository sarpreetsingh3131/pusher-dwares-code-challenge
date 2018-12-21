package org.pusher.dwarves.code.challenge.dto;

import lombok.Data;
import lombok.NonNull;
import org.pusher.dwarves.code.challenge.model.Dwarf;

@Data
public class DwarfDto {

    @NonNull
    private Dwarf dwarf;
}
