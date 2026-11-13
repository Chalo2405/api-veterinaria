
package com.vetcare.veterinaria;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class VeterinariaController {

    private final Map<Integer, Map<String, Object>> mascotas = new HashMap<>();
    private int siguienteId = 1;

    @GetMapping("/mascota/{id}")
    public Map<String, Object> consultarMascota(@PathVariable int id) {

        Map<String, Object> mascota = mascotas.get(id);

        if (mascota == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Mascota no encontrada"
            );
        }

        return mascota;
    }
)

    @PostMapping("/mascotas/nueva")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> registrarMascota(
            @RequestBody Map<String, Object> nueva) {

        int id = siguienteId++;

        nueva.put("id", id);
        mascotas.put(id, nueva);

        return nueva;
    }
}
