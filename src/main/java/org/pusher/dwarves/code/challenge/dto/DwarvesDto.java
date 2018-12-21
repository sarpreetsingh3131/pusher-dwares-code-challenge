package org.pusher.dwarves.code.challenge.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class DwarvesDto {

    @NonNull
    private List<String> dwarves;
}
