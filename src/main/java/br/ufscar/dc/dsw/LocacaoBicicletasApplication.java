package br.ufscar.dc.dsw;

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
					
			Cliente c1 = new Cliente();
			c1.setEmail("usuario1@gmail.com");
			c1.setPassword(encoder.encode("usuario1"));
			c1.setName("Cliente 1");
			c1.setRole("ROLE_Cliente");
			c1.setEnabled(true);
			c1.setCPF("012.345.678-90");
			c1.setTelefone("11111111");
			c1.setSexo("Masculino");
			//c1.setDataNascimento(LocalDate.of(2000, 8, 19));
			c1.setDataNascimento("2000-08-19");
			clienteDAO.save(c1);
			
			Cliente c2 = new Cliente();
			c2.setEmail("usuario2@gmail.com");
			c2.setPassword(encoder.encode("usuario2"));
			c2.setName("Cliente 2");
			c2.setRole("ROLE_Cliente");
			c2.setEnabled(true);
			c2.setCPF("985.849.614-10");
			c2.setTelefone("22222222");
			c2.setSexo("Feminino");
			//c2.setDataNascimento(LocalDate.of(1985, 5, 10));
			c2.setDataNascimento("1985-05-10");
			clienteDAO.save(c2);

			Locadora l1 = new Locadora();
			l1.setEmail("usuario3@gmail.com");
			l1.setPassword(encoder.encode("usuario3"));
			l1.setName("Locadora 1");
			l1.setRole("ROLE_Locadora");
			l1.setEnabled(true);
			l1.setCNPJ("55.789.390/0008-99");
			l1.setCidade("São Carlos");
			locadoraDAO.save(l1);

			Locadora l2 = new Locadora();
			l2.setEmail("usuario4@gmail.com");
			l2.setPassword(encoder.encode("usuario4"));
			l2.setName("Locadora 2");
			l2.setRole("ROLE_Locadora");
			l2.setEnabled(true);
			l2.setCNPJ("71.150.470/0001-40");
			l2.setCidade("São Paulo");
			locadoraDAO.save(l2);

			Locadora l3 = new Locadora();
			l3.setEmail("usuario5@gmail.com");
			l3.setPassword(encoder.encode("usuario5"));
			l3.setName("Locadora 3");
			l3.setRole("ROLE_Locadora");
			l3.setEnabled(true);
			l3.setCNPJ("32.106.536/0001-82");
			l3.setCidade("Bauru");
			locadoraDAO.save(l3);

			Locacao locacao1 = new Locacao();
			locacao1.setCliente(c1); 
			locacao1.setLocadora(l1); 
			locacao1.setData("2023-08-28");
			locacao1.setHora("10:00:00");
			locacaoDAO.save(locacao1);

			Locacao locacao2 = new Locacao();
			locacao2.setCliente(c2); 
			locacao2.setLocadora(l2); 
			locacao2.setData("2023-08-29");
			locacao2.setHora("14:00:00");
			locacaoDAO.save(locacao2); 

			Usuario u6 = new Usuario();
			u6.setEmail("usuario6@gmail.com");
			u6.setPassword(encoder.encode("usuario6"));
			u6.setName("Usuario 6");
			u6.setRole("ROLE_Admin");
			u6.setEnabled(true);
			usuarioDAO.save(u6);
			
		};
	}
}