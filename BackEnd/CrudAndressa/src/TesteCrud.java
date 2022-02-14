import br.com.crud.dao.ContatoDAO;
import br.com.crud.model.Contato;

public class TesteCrud {

	public static void main(String[] args) {
		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome ("Maria");
		contato.setEmail("maria@hotmail.com");
		contato.setDataCadastro("07/02/2022");
		
		
		contatoDAO.save(contato);
		

	}

}
