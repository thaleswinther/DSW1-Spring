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
public class LivrariaMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaMvcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder, ILocadoraDAO locadoraDAO, IClienteDAO clienteDAO, ILocacaoDAO locacaoDAO) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setEmail("usuario1@gmail.com");
			u1.setPassword(encoder.encode("usuario1"));
			u1.setName("Cliente 1");
			u1.setRole("Cliente");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u1.setEmail("usuario2@gmail.com");
			u1.setPassword(encoder.encode("usuario2"));
			u1.setName("Cliente 2");
			u1.setRole("Cliente");
			u1.setEnabled(true);
			usuarioDAO.save(u2);
			
			Usuario u3 = new Usuario();
			u1.setEmail("usuario3@gmail.com");
			u1.setPassword(encoder.encode("usuario3"));
			u1.setName("Locadora 1");
			u1.setRole("Locadora");
			u1.setEnabled(true);
			usuarioDAO.save(u3);

			Usuario u4 = new Usuario();
			u1.setEmail("usuario4@gmail.com");
			u1.setPassword(encoder.encode("usuario4"));
			u1.setName("Locadora 2");
			u1.setRole("Locadora");
			u1.setEnabled(true);
			usuarioDAO.save(u4);

			Usuario u5 = new Usuario();
			u1.setEmail("usuario5@gmail.com");
			u1.setPassword(encoder.encode("usuario5"));
			u1.setName("Usuario 5");
			u1.setRole("Admin");
			u1.setEnabled(true);
			usuarioDAO.save(u5);

			Usuario u6 = new Usuario();
			u1.setEmail("usuario6@gmail.com");
			u1.setPassword(encoder.encode("usuario6"));
			u1.setName("Locadora 3");
			u1.setRole("Locadora");
			u1.setEnabled(true);
			usuarioDAO.save(u6);
			
			Cliente c1 = new Cliente();
			c1.setId(u1.getId());
			c1.setCPF("012.345.678-90");
			c1.setTelefone("11111111");
			c1.setSexo("Masculino");
			c1.setDataNascimento(LocalDate.of(2000, 8, 19));
			clienteDAO.save(c1);
			
			Cliente c2 = new Cliente();
			c2.setId(u2.getId());
			c2.setCPF("985.849.614-10");
			c2.setTelefone("22222222");
			c2.setSexo("Feminino");
			c2.setDataNascimento(LocalDate.of(1985, 5, 10));
			clienteDAO.save(c2);

			Locadora l1 = new Locadora();
			l1.setId(u3.getId());
			l1.setCNPJ("55.789.390/0008-99");
			l1.setCidade("São Carlos");
			locadoraDAO.save(l1);

			Locadora l2 = new Locadora();
			l2.setId(u4.getId());
			l2.setCNPJ("71.150.470/0001-40");
			l2.setCidade("São Paulo");
			locadoraDAO.save(l2);

			Locadora l3 = new Locadora();
			l3.setId(u6.getId());
			l3.setCNPJ("32.106.536/0001-82");
			l3.setCidade("Bauru");
			locadoraDAO.save(l3);

			Locacao locacao1 = new Locacao();
			locacao1.getCliente().setCPF(c1.getCPF());
			locacao1.getLocadora().setCNPJ(l1.getCNPJ());
			locacao1.setDataHora(LocalDateTime.of(2023, 8, 28, 10, 0, 0));
			locacaoDAO.save(locacao1);

			Locacao locacao2 = new Locacao();
			locacao2.getCliente().setCPF(c2.getCPF());
			locacao2.getLocadora().setCNPJ(l2.getCNPJ());
			locacao2.setDataHora(LocalDateTime.of(2023, 8, 29, 14, 0, 0));
			locacaoDAO.save(locacao2);
			
		};
	}
}