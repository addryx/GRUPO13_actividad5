package com.tienda.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class DataUserConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email, contrasena, enabled from Usuarios where email=?")
				.authoritiesByUsernameQuery("select u.email, r.nombre_rol from Usuario_Roles up "
						+ "inner join Usuarios u on u.id_usuario = up.id_usuario "
						+ "inner join Roles r on r.id_rol = up.id_Rol " + "where u.email = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests()
				// Los directorios estáticos no requieren autenticacion
				.antMatchers("/bootstrap/**", "/images/**", "/css/**", "js/**").permitAll()
				.antMatchers("/rest/demo-bcrypt/**").permitAll()
				.antMatchers("/error").permitAll()

				// Las vistas públicas no requieren autenticación
				.antMatchers("/", "/rest/**", "/login", "/logout", "/registro", "/catalogo", 
				"/producto/verDetalle/**", "/producto/busqueda", "/producto/filtrar").permitAll()

				// Las autorizaciones sobre urls para ROLES
				.antMatchers("/producto/**").hasAnyAuthority("ROLE_CLIENTE", "ROLE_ADMON")
				.antMatchers("/usuarios/**").hasAnyAuthority("ROLE_ADMON")

				// Todas las demás URLs de la Aplicación requieren autenticación
				.anyRequest().authenticated()
				
				// El formulario de Login no requiere autenticacion
				.and().formLogin().permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}