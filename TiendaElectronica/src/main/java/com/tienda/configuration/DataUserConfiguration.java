package com.tienda.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
@EnableWebSecurity
@Configuration
public class DataUserConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from Usuarios where username=?")
			.authoritiesByUsernameQuery("select u.username, p.nombre from Usuario_Perfiles up " +  "inner join Usuarios u on u.username = up.username " +
	"inner join Perfiles p on p.id_perfil = up.id_Perfil " +  "where u.username = ?");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable().authorizeHttpRequests()
			// Los directorios estáticos no requieren autenticacion
			.requestMatchers("/bootstrap/**",  "/images/**", "/css/**", "js/**").permitAll()
			.requestMatchers("/rest/demo-bcrypt/**").permitAll()
			
			// Las vistas públicas no requieren autenticación
			.requestMatchers("/", "/login", "/logout", "/registro","/search", "/app/producto/verUno/**").permitAll()
			
			// Las autorizaciones sobre urls para ROLES
			.requestMatchers("/app/producto/**").hasAnyAuthority("ROLE_GESTOR","ROLE_ADMINISTRADOR")
			.requestMatchers("/app/usuarios/**").hasAnyAuthority("ROLE_GESTOR","ROLE_ADMINISTRADOR")
			.requestMatchers("/app/perfiles/**").hasAnyAuthority("ROLE_ADMINISTRADOR")
			.requestMatchers("/app/tipos/**").hasAnyAuthority("ROLE_GESTOR")
			
			// Todas las demás URLs de la Aplicación requieren autenticación
			.anyRequest().authenticated()
			// El formulario de Login no requiere autenticacion
			.and().formLogin().permitAll()
			// El formulario de logout no requiere autenticacion
	//		.and().logout().permitAll()
			;	
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
*/
