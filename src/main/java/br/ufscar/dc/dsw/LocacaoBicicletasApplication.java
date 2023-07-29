package br.ufscar.dc.dsw;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class LocacaoBicicletasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletasApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, ILocadoraDAO locadoraDAO, IClienteDAO clienteDAO, ILocacaoDAO locacaoDAO) {
		return (args) -> {
			
			/*Usuario u1 = new Usuario();
			u1.setEmail("usuario1@gmail.com");
			u1.setPassword(encoder.encode("usuario1"));
			u1.setName("Cliente 1");
			u1.setRole("Cliente");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setEmail("usuario2@gmail.com");
			u2.setPassword(encoder.encode("usuario2"));
			u2.setName("Cliente 2");
			u2.setRole("Cliente");
			u2.setEnabled(true);
			usuarioDAO.save(u2);
			
			Usuario u3 = new Usuario();
			u3.setEmail("usuario3@gmail.com");
			u3.setPassword(encoder.encode("usuario3"));
			u3.setName("Locadora 1");
			u3.setRole("Locadora");
			u3.setEnabled(true);
			usuarioDAO.save(u3);

			Usuario u4 = new Usuario();
			u4.setEmail("usuario4@gmail.com");
			u4.setPassword(encoder.encode("usuario4"));
			u4.setName("Locadora 2");
			u4.setRole("Locadora");
			u4.setEnabled(true);
			usuarioDAO.save(u4);

			Usuario u5 = new Usuario();
			u5.setEmail("usuario5@gmail.com");
			u5.setPassword(encoder.encode("usuario5"));
			u5.setName("Usuario 5");
			u5.setRole("Admin");
			u5.setEnabled(true);
			usuarioDAO.save(u5);

			Usuario u6 = new Usuario();
			u6.setEmail("usuario6@gmail.com");
			u6.setPassword(encoder.encode("usuario6"));
			u6.setName("Locadora 3");
			u6.setRole("Locadora");
			u6.setEnabled(true);
			usuarioDAO.save(u6);*/
			
			Cliente c1 = new Cliente();
			c1.setEmail("usuario1@gmail.com");
			c1.setPassword("usuario1");
			c1.setName("Cliente 1");
			c1.setRole("Cliente");
			c1.setEnabled(true);
			c1.setCPF("012.345.678-90");
			c1.setTelefone("11111111");
			c1.setSexo("Masculino");
			c1.setDataNascimento(LocalDate.of(2000, 8, 19));
			clienteDAO.save(c1);
			
			Cliente c2 = new Cliente();
			c2.setEmail("usuario2@gmail.com");
			c2.setPassword("usuario2");
			c2.setName("Cliente 2");
			c2.setRole("Cliente");
			c2.setEnabled(true);
			c2.setCPF("985.849.614-10");
			c2.setTelefone("22222222");
			c2.setSexo("Feminino");
			c2.setDataNascimento(LocalDate.of(1985, 5, 10));
			clienteDAO.save(c2);

			Locadora l1 = new Locadora();
			l1.setEmail("usuario3@gmail.com");
			l1.setPassword("usuario3");
			l1.setName("Locadora 1");
			l1.setRole("Locadora");
			l1.setEnabled(true);
			l1.setCNPJ("55.789.390/0008-99");
			l1.setCidade("São Carlos");
			locadoraDAO.save(l1);

			Locadora l2 = new Locadora();
			l2.setEmail("usuario4@gmail.com");
			l2.setPassword("usuario4");
			l2.setName("Locadora 2");
			l2.setRole("Locadora");
			l2.setEnabled(true);
			l2.setCNPJ("71.150.470/0001-40");
			l2.setCidade("São Paulo");
			locadoraDAO.save(l2);

			Locadora l3 = new Locadora();
			l3.setEmail("usuario5@gmail.com");
			l3.setPassword("usuario5");
			l3.setName("Locadora 3");
			l3.setRole("Locadora");
			l3.setEnabled(true);
			l3.setCNPJ("32.106.536/0001-82");
			l3.setCidade("Bauru");
			locadoraDAO.save(l3);

			Locacao locacao1 = new Locacao();
			locacao1.setCliente(c1); 
			locacao1.setLocadora(l1); 
			locacao1.setDataHora(LocalDateTime.of(2023, 8, 28, 10, 0, 0));
			locacaoDAO.save(locacao1);

			Locacao locacao2 = new Locacao();
			locacao2.setCliente(c2); 
			locacao2.setLocadora(l2); 
			locacao2.setDataHora(LocalDateTime.of(2023, 8, 29, 14, 0, 0));
			locacaoDAO.save(locacao2); 
			
		};
	}
}