package Dados;

import java.util.ArrayList;

import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.Fornecedor;

public interface IPersistenciaFornecedor {

	// Metodo para verificar se um fornecedor existe
	public boolean VerificarCnpj(String cnpj) throws ConexaoException;

	// Metodo para inserir um novo fornecedor
	public void InserirFornecedor(Fornecedor novoForn) throws ConexaoException;

	// Metodo para listar todos os fornecedores ativos
	public ArrayList<Fornecedor> ListagemFornecedor() throws ConexaoException;

	// Metodo para verificar se um fornecedor existe
	public Fornecedor consultaFornecedor(int ID) throws ConexaoException;

	// Metodo para alterar um fornecedor existente
	public void AlterarFornecedor(Fornecedor novoForn) throws ConexaoException;

	// Metodo para excluir um fornecedor
	public void ExcluirFornecedor(int ID) throws ConexaoException;

}