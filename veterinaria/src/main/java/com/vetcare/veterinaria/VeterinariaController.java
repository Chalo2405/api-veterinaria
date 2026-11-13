package com.vetcare.veterinaria;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeterinariaController {

    @GetMapping("/mascota/{id}")
    public Map<String, Object> consultarMascota(
            @PathVariable(name = "id") int id) {

        Map<String, Object> mascota = new HashMap<>();

        mascota.put("id", id);
        mascota.put("nombre", "Mascota " + id);
        mascota.put("especie", "Perro");
        mascota.put("edad", 3);
        mascota.put("propietario", "Luis");

        return mascota;
    }

    @PostMapping("/mascotas/nueva")
    public Map<String, Object> registrarMascota(
            @RequestBody Map<String, Object> nueva) {

        Date ahora = new Date();

        nueva.put("id", ahora.getTime());

        return nueva;
    }
}
