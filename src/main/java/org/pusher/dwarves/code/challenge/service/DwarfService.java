package org.pusher.dwarves.code.challenge.service;

import org.pusher.dwarves.code.challenge.dto.DwarfDto;
import org.pusher.dwarves.code.challenge.dto.DwarvesDto;
import org.pusher.dwarves.code.challenge.model.Dwarf;
import org.pusher.dwarves.code.challenge.utils.DwarvesResponseFromPusher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DwarfService {

    public DwarvesDto findAllNames() {
        return new DwarvesDto(fetchDwarves()
                .stream()
                .map(dwarf -> dwarf.getName())
                .collect(Collectors.toList()));
    }

    public DwarfDto findByName(String name) throws Exception {
        return new DwarfDto(fetchDwarves()
                .stream()
                .filter(dwarf -> dwarf.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new Exception("No dwarf with name = " + name)));
    }

    private List<Dwarf> fetchDwarves() {
        return new RestTemplate()
                .getForObject("https://thedwarves.pusherplatform.io/api/dwarves", DwarvesResponseFromPusher.class)
                .getDwarves();
    }
}
