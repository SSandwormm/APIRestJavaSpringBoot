package com.aplication.Usuario;

import com.aplication.Usuario.model.Usuario;
import com.aplication.Usuario.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsuarioRepository usuarioRepository) {
		return (args) -> {
			// Guardar un usuario de prueba
			Usuario u1 = new Usuario("Carlos Rodríguez", "carlos@email.com", "123456");
			usuarioRepository.save(u1);

			// Mostrar todos los usuarios en consola
			usuarioRepository.findAll().forEach(usuario -> {
				System.out.println(usuario.getId() + " - " + usuario.getNombre() + " - " + usuario.getEmail());
			});
		};
	}
}