package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Excecoes.CampoVazioException;
import Excecoes.CnpjExistenteException;
import Excecoes.CnpjInvalidoException;
import Excecoes.ConexaoException;
import Excecoes.DadoDuplicadoException;
import Excecoes.DadosInvalidosException;
import Excecoes.FuncionarioExistenteException;
import Excecoes.GeralException;
import Excecoes.LoginExistenteException;
import Excecoes.cpfExistenteException;
import Excecoes.cpfInvalidoException;
import Negocio.ClassesBasicas.Cliente;
import Negocio.ClassesBasicas.Fornecedor;
import Negocio.ClassesBasicas.Funcionario;
import Negocio.ClassesBasicas.ListaVenda;
import Negocio.ClassesBasicas.ListaVendaProduto;
import Negocio.ClassesBasicas.Produto;
import Negocio.ClassesBasicas.Usuario;
import Negocio.ClassesBasicas.Venda;
import Negocio.RegrasNegocio.ControladorCliente;
import Negocio.RegrasNegocio.ControladorFornecedor;
import Negocio.RegrasNegocio.ControladorFuncionario;
import Negocio.RegrasNegocio.ControladorProduto;
import Negocio.RegrasNegocio.ControladorUsuario;
import Negocio.RegrasNegocio.ControladorVenda;

public class Fachada {

	// region Junior
	ControladorUsuario controladorUsuario = new ControladorUsuario();

	/**
	 * Autentica um usuario ja cadastrado no banco de dados
	 * 
	 * @param Login
	 *            Login de um usuario
	 * @param Senha
	 *            Senha de um usuario
	 * @return Retorna o acesso ao programa caso o login e senha sejam confirmados
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */
	public boolean AutenticarUsuario(String Login, String Senha) throws ConexaoException {
		return controladorUsuario.AutenticarUsuario(Login, Senha);
	}

	/**
	 * Cadastra um usuario no banco
	 * 
	 * @param usu
	 *            Objeto com todos dados do cliente
	 * @throws CampoVazioException
	 *             Trata o erro quando o campo estiver vazio
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 * @throws LoginExistenteException
	 *             Trata o erro caso usuario ja esteja cadastrado
	 */
	public void InserirUsuario(Usuario usu) throws CampoVazioException, ConexaoException, LoginExistenteException {
		controladorUsuario.InserirUsuario(usu);
	}

	/**
	 * ArrayList com todos os usuarios
	 * 
	 * @return Retorna uma lista com usuarios pela ordem do ID
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */
	public ArrayList<Usuario> GetListaUsuarios() throws ConexaoException {
		return controladorUsuario.GetListaUsuarios();
	}

	/**
	 * Seleciona o dados de um usuario
	 * 
	 * @param ID
	 *            identifica o usuario
	 * @return Retorna todos os dados de um usuario a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	public Usuario getUsuario(int ID) throws ConexaoException {
		return controladorUsuario.getUsuario(ID);
	}

	/**
	 * Deleta um usuario cadastrado no banco
	 * 
	 * @param ID
	 *            Identifica um usuario cadastro no banco
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	public void DeletarUsuario(int ID) throws ConexaoException {
		controladorUsuario.DeletarUsuario(ID);
	}

	// endregion
	// region Antonio
	ControladorFornecedor cnpjFornecedor = new ControladorFornecedor();

	// Metodo para inserir um novo fornecedor
	public void InserirFornecedor(Fornecedor novoForn)
			throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {
		cnpjFornecedor.InserirFornecedor(novoForn);
	}

	// Metodo para listar todos os fornecedores ativos
	public ArrayList<Fornecedor> ListagemFornecedor() throws ConexaoException {
		return cnpjFornecedor.ListagemFornecedor();
	}

	// Metodo para verificar se um fornecedor existe
	public Fornecedor consultaFornecedor(int ID) throws ConexaoException {
		return cnpjFornecedor.consultaFornecedor(ID);
	}

	// Metodo para excluir um fornecedor
	public void ExcluirFornecedor(int ID) throws ConexaoException {
		cnpjFornecedor.ExcluirFornecedor(ID);
	}

	// endregion
	// Region Leonardo
	ControladorFuncionario controladorFuncionario = new ControladorFuncionario();

	/**
	 * Salva o registro de um funcionário
	 *
	 * @param f
	 *            Objeto contendo todas as informações do Funcionário
	 * @throws CampoVazioException
	 *             Trata o erro quando o campo estiver vazio
	 * @throws DadosInvalidosException
	 *             Trata o erro quando os dados estiverem inválidos
	 * @throws cpfExistenteException
	 *             Trata o erro quando o cpf estiver em duplicidade no BD
	 * @throws cpfInvalidoException
	 *             Trata o erro quando o cpf estiver inválido
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 * @throws DadoDuplicadoException
	 *             Trata o erro quando os dados estiverem com duplicidade no BD
	 * @throws GeralException
	 *             Trata erro comuns do sistema
	 * @throws FuncionarioExistenteException
	 *             Trata o erro quando existir um registro de Funcionário com dados
	 *             inválidos
	 */
	public void salvarFuncionario(Funcionario f)
			throws CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
			ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {
		controladorFuncionario.verificaCampo(f);
		controladorFuncionario.validacaoCpf(f);
		controladorFuncionario.incluirFuncionario(f);

	}

	/**
	 * Altera um registro na tabela Funcionário
	 *
	 * @param f
	 *            Objeto contendo todas as informações
	 * @throws GeralException
	 *             Trata erro comuns do sistema
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	public void alterarFuncionario(Funcionario f) throws GeralException, ConexaoException, SQLException {
		controladorFuncionario.alterarFuncionario(f);
	}

	/**
	 * Exclui um funcionário no BD
	 *
	 * @param id
	 *            Identificação da chave primária do registro
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 * @throws GeralException
	 *             Trata erro comuns do sistema
	 */
	public void excluirFuncionario(Integer id) throws GeralException, ConexaoException, SQLException {
		controladorFuncionario.excluirFuncionario(id);
	}

	/**
	 * Lista todos os Funcionários
	 *
	 * @return Um ArrayList contendo todos os Funcionários
	 * @throws GeralException
	 *             Trata erro comuns do sistema
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	public ArrayList<Funcionario> listarFuncionario() throws GeralException, ConexaoException, SQLException {
		return controladorFuncionario.listarFuncionario();
	}

	/**
	 * Retorna o objeto com os dados da tabela
	 *
	 * @param id
	 *            Chave primária
	 * @return Retorna um funcionário a partir do seu id
	 * @throws GeralException
	 *             Trata erro comuns do sistema
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	public Funcionario getFuncionario(Integer id) throws GeralException, ConexaoException, SQLException {
		return controladorFuncionario.getFuncionario(id);
	}

	/**
	 * Faz uma busca na tabela funcionário pelo valor digitado no campo Nome
	 *
	 * @param nome
	 *            Nome do Funcionário
	 * @return retorna um funcionario através do nome
	 * @throws GeralException
	 *             Trata erro comuns do sistema
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	public Funcionario consultarFuncionario(String nome) throws GeralException, ConexaoException, SQLException {
		return controladorFuncionario.consultarFuncionario(nome);
	}

	// endregion
	// Region Carlos
	ControladorCliente controladorCli = new ControladorCliente();

	/**
	 * Verifica se campos de cadastro cliente são nulos ou vazio Valida todo
	 * conteúdo do cadastro cliente Cadastra o cliente no banco de dados
	 * 
	 * @param cli
	 *            objeto com todos os dados do cliente
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws CampoVazioException
	 *             Trata o erro de campo vazio
	 * @throws cpfExistenteException
	 *             Trata o erro caso o cpf ja esteja cadastrado
	 * @throws DadosInvalidosException
	 *             Trata o erro dos dados invalidos
	 */
	public void CadastraCliente(Cliente cli)
			throws ConexaoException, CampoVazioException, cpfExistenteException, DadosInvalidosException {
		controladorCli.VerificaCliente(cli);
		controladorCli.ValidaCliente(cli);
		controladorCli.CadastraCliente(cli);
	}

	/**
	 * Altera os Dados do Cliente ja cadastrado
	 * 
	 * @param cli
	 *            Objeto contendo todos os dados de um cliente
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public void AlteraCliente(Cliente cli) throws ConexaoException {
		controladorCli.AlteraCliente(cli);
	}

	/**
	 * Seleciona a partir de um ArrayList todos os dados de um cliente
	 * 
	 * @return Retorna os dados do Cliente em uma lista a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public ArrayList<Cliente> getlistaCliente() throws ConexaoException {
		return controladorCli.getlistaCliente();

	}

	/**
	 * Retorna todos os dados de Cliente
	 * 
	 * @param id
	 *            Identifica o Cliente a partir do seu ID
	 * @return Retorna todos os dados de Cliente a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public Cliente getCliente(int id) throws ConexaoException {
		return controladorCli.getCliente(id);
	}

	/**
	 * Deleta um cliente cadastrado do banco de dados
	 * 
	 * @param id
	 *            Identifica o cliente no registro do banco
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public void DeletaCliente(int id) throws ConexaoException {
		controladorCli.DeletaCliente(id);
	}

	// endregion
	// Region Rafael
	ControladorProduto controladorProd = new ControladorProduto();

	public void inserirProduto(Produto p) throws CampoVazioException, ConexaoException {
		controladorProd.verificarProduto(p);
		controladorProd.inserirProduto(p);
	}

	public void alterarProduto(Produto p) throws ConexaoException {
		controladorProd.alterar(p);
	}

	public void deletarProduto(Integer IDProduto) throws ConexaoException {
		controladorProd.deletarProduto(IDProduto);
	}

	public ArrayList<Produto> getListaProduto() throws ConexaoException {
		return controladorProd.getListaProduto();

	}

	public Produto getProduto(Integer IDProduto) throws ConexaoException {
		return controladorProd.getProduto(IDProduto);
	}

	public ArrayList<Produto> getListaProdutoFornecedor(int idFornecedor) throws ConexaoException {
		return controladorProd.getListaProdutoFornecedor(idFornecedor);

	}
	// endregion

	// VENDA
	ControladorVenda controladorVenda = new ControladorVenda();

	/**
	 * Cadastra a venda no banco de dados
	 * 
	 * @param v
	 *            Objeto contendo os dados da venda
	 * @return Insere um venda no banco
	 * @throws CampoVazioException
	 *             Trata o erro de campo vazio
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public int InserirVenda(Venda v) throws CampoVazioException, ConexaoException {
		return controladorVenda.InserirVenda(v);
	}

	/**
	 * Insere os produtos selecionados na tabela Venda
	 * 
	 * @param IDVenda
	 *            Identifica a Venda
	 * @param IDProduto
	 *            Identifica o produto cadastrado no banco
	 * @param Quantidade
	 *            Identifica a quantidade do produto
	 * @param ValorProdutos
	 *            identifica os valores de cada produto
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public void InserirVendaProduto(int IDVenda, int IDProduto, int Quantidade, double ValorProdutos)
			throws ConexaoException {
		controladorVenda.InserirVendaProduto(IDVenda, IDProduto, Quantidade, ValorProdutos);
	}

	/**
	 * Arraylist de todas as vendas realizadas
	 * 
	 * @return Retorna uma lista com todos os dados das vendas
	 * @throws GeralException
	 *             Trata erro comuns do sistema
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws SQLException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public ArrayList<ListaVenda> listarVenda() throws GeralException, ConexaoException, SQLException {
		return controladorVenda.listarVenda();
	}

	/**
	 * ArrayList com os dados complementares de um produto (Descrição, Quantidade)
	 * 
	 * @param ID
	 *            Identifica uma venda a partir do ID
	 * @return retorna um lista com todos os produtos por venda
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public ArrayList<ListaVendaProduto> ListarVendaProduto(int ID) throws ConexaoException {
		return controladorVenda.ListarVendaProduto(ID);
	}
}
