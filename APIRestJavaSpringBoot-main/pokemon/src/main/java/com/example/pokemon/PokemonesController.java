package com.example.pokemon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class PokemonesController {

    private final List<Pokemon> pokemones = List.of(
            new Pokemon(
                    "Pikachu",
                    List.of("Eléctrico"),
                    List.of("Electricidad Estática", "Pararrayos"),
                    "Nivel 25",
                    List.of("Impactrueno", "Rayo", "Placaje", "Onda Trueno"),
                    List.of("Tierra"),
                    List.of("Agua", "Acero", "Eléctrico"),
                    List.of("Evitar terrenos arenosos", "Entrenar velocidad", "Mantener en Pokéball si hay tormenta")
            ),
            new Pokemon(
                    "Charmander",
                    List.of("Fuego"),
                    List.of("Mar Llamas"),
                    "Nivel 18",
                    List.of("Ascuas", "Garra Metal", "Lanzallamas"),
                    List.of("Agua", "Roca", "Tierra"),
                    List.of("Planta", "Hielo", "Bicho"),
                    List.of("No mojar la cola", "Entrenar resistencia al calor", "Dar bayas ardientes")
            ),
            new Pokemon(
                    "Squirtle",
                    List.of("Agua"),
                    List.of("Torrente"),
                    "Nivel 20",
                    List.of("Pistola Agua", "Burbuja", "Giro Rápido"),
                    List.of("Eléctrico", "Planta"),
                    List.of("Fuego", "Tierra", "Roca"),
                    List.of("Mantener hidratado", "Entrenar defensa", "Evitar campos eléctricos")
            ),
            new Pokemon(
                    "Bulbasaur",
                    List.of("Planta", "Veneno"),
                    List.of("Espesura"),
                    "Nivel 16",
                    List.of("Látigo Cepa", "Drenadoras", "Hoja Afilada"),
                    List.of("Fuego", "Hielo", "Psíquico"),
                    List.of("Agua", "Tierra", "Roca"),
                    List.of("Dar exposición solar", "Evitar heladas", "Revisar hojas con frecuencia")
            ),
            new Pokemon(
                    "Eevee",
                    List.of("Normal"),
                    List.of("Fuga", "Adaptable"),
                    "Nivel 12",
                    List.of("Mordisco", "Ataque Rápido", "Refuerzo"),
                    List.of("Lucha"),
                    List.of("Fantasma", "Psíquico"),
                    List.of("Entrenamiento de amistad", "Estimulación mental", "Mantener ambiente estable")
            ),
            new Pokemon(
                    "Jigglypuff",
                    List.of("Normal", "Hada"),
                    List.of("Gran Encanto", "Tenacidad"),
                    "Nivel 14",
                    List.of("Canto", "Desarme", "Rayo de Hada"),
                    List.of("Veneno", "Acero"),
                    List.of("Dragón", "Lucha"),
                    List.of("Proteger las cuerdas vocales", "Evitar estrés", "Dormir suficientes horas")
            ),
            new Pokemon(
                    "Snorlax",
                    List.of("Normal"),
                    List.of("Inmunidad", "Gula"),
                    "Nivel 40",
                    List.of("Dormir", "Placaje", "Terremoto"),
                    List.of("Lucha"),
                    List.of("Fantasma"),
                    List.of("Controlar dieta", "Realizar ejercicio leve", "Espacio amplio para dormir")
            ),
            new Pokemon(
                    "Gengar",
                    List.of("Fantasma", "Veneno"),
                    List.of("Levitación", "Cuerpo Maldito"),
                    "Nivel 35",
                    List.of("Bola Sombra", "Lengüetazo", "Psíquico"),
                    List.of("Psíquico", "Fantasma"),
                    List.of("Planta", "Lucha", "Bicho"),
                    List.of("Evitar luz intensa", "Entrenar sigilo", "Ambiente oscuro")
            ),
            new Pokemon(
                    "Onix",
                    List.of("Roca", "Tierra"),
                    List.of("Cabeza Roca", "Robustez"),
                    "Nivel 28",
                    List.of("Lanzarrocas", "Excavar", "Cola Férrea"),
                    List.of("Agua", "Planta", "Hielo"),
                    List.of("Fuego", "Veneno", "Roca"),
                    List.of("Evitar agua", "Fortalecer estructura", "Terrenos amplios")
            ),
            new Pokemon(
                    "Psyduck",
                    List.of("Agua"),
                    List.of("Humedad", "Aclimatación"),
                    "Nivel 22",
                    List.of("Confusión", "Pistola Agua", "Hidropulso"),
                    List.of("Eléctrico", "Planta"),
                    List.of("Fuego", "Roca"),
                    List.of("Controlar estrés", "Evitar dolores de cabeza", "Ambientes tranquilos")
            )
    );


    @GetMapping("/")
    public String prueba(){
        return "hola mundo que se tranza ";
    }

    @GetMapping("/Pokemones")
    public List<Pokemon> listaDePokemones(){
        return pokemones;
    }


    @GetMapping("/debilidad")
    public List<Pokemon> debilidad(@RequestParam String debilidad){
        List<Pokemon> pokemonesConDebilidad = new ArrayList<>();

        for(Pokemon pokemon : pokemones){
            if(pokemon.getDebilidades().contains(debilidad)){
                pokemonesConDebilidad.add(pokemon);
            }
        }

        return pokemonesConDebilidad;
    }




}
