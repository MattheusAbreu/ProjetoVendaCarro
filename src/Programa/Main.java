package Programa;

import java.util.Scanner;

import Entidades.Caixa;
import Entidades.Carro;
import Entidades.Cliente;
import Entidades.Marca;
import Entidades.Modelo;
import Enum.Categoria;
import Servicos.CaixaBO;
import Servicos.CarroBO;
import Servicos.ClienteBO;
import Servicos.MarcaBO;
import Servicos.ModeloBO;
import Utils.BancoDeDadosCarros;
import Utils.BancoDeDadosCliente;
import Utils.BancoDeDadosMarca;
import Utils.BancoDeDadosModelos;
import Utils.Menu;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcaoEscolhida = -1;

		while (opcaoEscolhida != 0) {

			Menu.menuInicial();
			opcaoEscolhida = sc.nextInt();

			if (opcaoEscolhida == 1) {

				System.out.println("\n\nCadastro de Clientes");
				System.out.print("Nome: ");
				sc.nextLine();
				String nome = sc.nextLine();

				System.out.print("CPF: ");
				String cpf = sc.next();

				while (!Utils.Validacoes.validaCpf(cpf)) {
					System.out.print("Cpf invalido.\nDigite seu CPF: ");
					cpf = sc.next();

				}

				if (BancoDeDadosCliente.buscarCpf(cpf)) {
					System.out.println("CPF já cadastrado, retornando ao menu inicial");
					continue;

				}

				ClienteBO clienteBO = new ClienteBO();

				Cliente cliente = clienteBO.cadastrarCliente(nome.toLowerCase(), cpf);
				System.out.println("Cliente Cadastrado com Sucesso!");
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("CPF: " + cliente.getCpf());

			}

			else if (opcaoEscolhida == 2) {

				System.out.println("\n\nCadastro de Marcas");
				System.out.print("Marca: ");
				sc.nextLine();
				String nome = sc.nextLine();

				if (BancoDeDadosMarca.buscaMarca(nome)) {
					System.out.println("Marca já cadastrada, retornando ao menu inicial");
					continue;

				}

				MarcaBO marcaBO = new MarcaBO(nome.toLowerCase());

				System.out.println("Marca Cadastrada com Sucesso!");
				System.out.println(marcaBO.getMarca().getDescricao());

			}

			else if (opcaoEscolhida == 3) {

				System.out.println("\n\nCadastro de Modelos");
				System.out.print("Modelo: ");
				sc.nextLine();
				String nome = sc.nextLine();

				if (BancoDeDadosModelos.buscaModelo(nome)) {
					System.out.println("Modelo já cadastrado, retornando ao menu inicial");
					continue;

				}

				ModeloBO modeloBO = new ModeloBO(nome.toLowerCase());

				System.out.println("Modelo Cadastrado com Sucesso!");
				System.out.println(modeloBO.getModelo().getDescricao());

			} else if (opcaoEscolhida == 4) {

				System.out.println("\n\nCadastro de Veiculos");
				System.out.print("Veiculo Novo ou Seminovo (n/s)?  ");
				Categoria categoria;
				char cat = sc.next().charAt(0);
				while (cat != 'n' && cat != 's') {
					System.out.println("Caractere invalido.");
					System.out.print("Digite se o veiculo é Novo ou Seminovo (n/s): ");
					cat = sc.next().charAt(0);

				}
				if (cat == 'n') {
					categoria = Categoria.NOVO;

				} else {
					categoria = Categoria.SEMINOVO;
				}

				System.out.print("Valor: R$");
				double valor = sc.nextDouble();

				System.out.print("Ano: ");
				String ano = sc.next();
				System.out.print("Modelo: ");
				sc.nextLine();
				String model = sc.nextLine();
				Modelo modelo = BancoDeDadosModelos.buscarModeloDesc(model);
				if (modelo == null) {

					System.out.print(model + " não cadastrado, gostaria de cadastra-lo? (s/n):  ");
					char resp = sc.next().charAt(0);
					if (resp == 's') {
						ModeloBO modeloBO = new ModeloBO(model.toLowerCase());
						modelo = modeloBO.getModelo();
						sc.nextLine();

					} else {
						System.out.println("Voltando ao menu inicial.");
						continue;

					}
				}

				System.out.print("Marca: ");
				
				String marc = sc.nextLine();

				Marca marca = BancoDeDadosMarca.buscarMarcaDesc(marc);
				if (marca == null) {

					System.out.print(marc + " não cadastrado, gostaria de cadastra-lo? (s/n):  ");
					char resp = sc.next().charAt(0);
					if (resp == 's') {
						MarcaBO marcaBO = new MarcaBO(marc.toLowerCase());
						marca = marcaBO.getMarca();

					} else {
						System.out.println("Voltando ao menu inicial.");
						continue;

					}
				}

				CarroBO carroBO = new CarroBO(valor, ano, modelo, marca, categoria);
				System.out.print("Veiculo Cadastrado com Sucesso");
				System.out.println(carroBO.getCarro());

			}
			
			
			else if (opcaoEscolhida == 5) {
				
				System.out.print("Digite o ID do veiculo que será alterado: ");
				int idVeic = sc.nextInt();
				
				Carro carro = BancoDeDadosCarros.buscarCarroId(idVeic);
				
				if(carro==null) {
					System.out.print("ID invalido, voltando ao menu inicial");
					continue;
					
					
				}
				
				if(carro.isDisponivel()==false) {
					System.out.print("Carro indisponivel, voltando ao menu inicial");
					continue;
					
					
				}
				System.out.print("Veiculo Novo ou Seminovo (n/s)?  ");
				Categoria categoria;
				char cat = sc.next().charAt(0);
				while (cat != 'n' && cat != 's') {
					System.out.println("Caractere invalido.");
					System.out.print("Digite se o veiculo é Novo ou Seminovo (n/s): ");
					cat = sc.next().charAt(0);

				}
				if (cat == 'n') {
					categoria = Categoria.NOVO;

				} else {
					categoria = Categoria.SEMINOVO;
				}

				System.out.print("Valor: R$");
				double valor = sc.nextDouble();

				System.out.print("Ano: ");
				String ano = sc.next();
				System.out.print("Modelo: ");
				sc.nextLine();
				String model = sc.nextLine();
				Modelo modelo = BancoDeDadosModelos.buscarModeloDesc(model);
				if (modelo == null) {

					System.out.print(model + " não cadastrado, gostaria de cadastra-lo? (s/n):  ");
					char resp = sc.next().charAt(0);
					if (resp == 's') {
						ModeloBO modeloBO = new ModeloBO(model.toLowerCase());
						modelo = modeloBO.getModelo();

					} else {
						System.out.println("Voltando ao menu inicial.");
						continue;

					}
				}

				System.out.print("Marca: ");
				sc.nextLine();
				String marc = sc.nextLine();

				Marca marca = BancoDeDadosMarca.buscarMarcaDesc(marc);
				if (marca == null) {

					System.out.print(marc + " não cadastrado, gostaria de cadastra-lo? (s/n):  ");
					char resp = sc.next().charAt(0);
					if (resp == 's') {
						MarcaBO marcaBO = new MarcaBO(marc.toLowerCase());
						marca = marcaBO.getMarca();

					} else {
						System.out.println("Voltando ao menu inicial.");
						continue;

					}
				}
				
				carro.setAno(ano);
				carro.setCategoria(categoria);
				carro.setMarca(marca);
				carro.setModelo(modelo);
				carro.setValor(valor);
				BancoDeDadosCarros.inserirCarro(carro);
				System.out.println("Veiculo Atualizado com Sucesso.");
				
				
				
				
			}
			
			else if (opcaoEscolhida == 6) {
				
				System.out.print("Digite o ID do veiculo que será excluido: ");
				int idVeic = sc.nextInt();
				
				Carro carro = BancoDeDadosCarros.buscarCarroId(idVeic);
				
				if(carro==null) {
					System.out.print("ID invalido, voltando ao menu inicial");
					continue;
				}
				if(carro.isDisponivel()==false) {
					System.out.print("Carro indisponivel, voltando ao menu inicial");
					continue;
					
					
				}
				BancoDeDadosCarros.deletaCarroId(idVeic);
				System.out.println("Veiculo Excluido com Sucesso");
				
				
				
				
			}
			else if (opcaoEscolhida == 7) {
				System.out.println("Carros Disponiveis para venda:");
				
				BancoDeDadosCarros.exibirCarrosDisponiveis();
				
				
				
				
			}
			else if (opcaoEscolhida == 8) {
				System.out.println("Venda de Veiculo: ");
				System.out.print("Digite o CPF do cliente: ");
				String cpf = sc.next();
				
				Cliente cliente = BancoDeDadosCliente.buscarClienteCPF(cpf);
				if(cliente==null) {
					System.out.print("CPF não cadastrado, gostaria de cadastra-lo agora? (s/n)  ");
					char resp = sc.next().charAt(0);
					if(resp=='s') {
						System.out.print("Digite o nome do cliente: ");
						sc.nextLine();
						String nome = sc.nextLine();
						ClienteBO clienteBO = new ClienteBO();
						cliente = clienteBO.cadastrarCliente(nome, cpf);
						
						
					}
					else {
						System.out.println("Voltando ao menu inicial.");
						continue;
					}
				}
				
				if(cliente.isPrimeiraCompra()) {
					System.out.println("Por ser a primeira compra do cliente, ele receberá um desconto de 1%!");
				}
				
				System.out.print("Digite o id do veiculo que será vendido: ");
				int idVeic = sc.nextInt();
				Carro carro = BancoDeDadosCarros.buscarCarroId(idVeic);
				
				if(carro==null) {
					System.out.print("ID invalido, voltando ao menu inicial");
					continue;
				}
				if(carro.isDisponivel()==false) {
					System.out.print("Carro indisponivel, voltando ao menu inicial");
					continue;
					
					
				}
				
				System.out.println("Dados do Veiculo: ");
				System.out.println(carro);
				if(cliente.isPrimeiraCompra()) {
					System.out.println("Valor com desconto: R$"+(carro.getValor()-(carro.getValor()*0.01)));
				}
				System.out.println("\n\nConfirmar Compra ? (s/n) ");
				char respCompra = sc.next().charAt(0);
				
				if(respCompra=='s') {
					CaixaBO caixaBO = new CaixaBO();
					if(cliente.isPrimeiraCompra()) {
						caixaBO.realizarVenda(carro.getValor(), 0.01);
						
					}
					else {
						caixaBO.realizarVenda(carro.getValor());
					}
					
					System.out.println("Venda Realizada com Sucesso!");
					carro.setDisponivel(false);
					carro.setCliente(cliente);
					cliente.setPrimeiraCompra(false);
					
					
					
					
				}
				
				
				
				
				
			}
			
			
			else if (opcaoEscolhida == 9) {
				System.out.println("Carros Vendidos:");
				
				BancoDeDadosCarros.exibirCarrosVendidos();
				
				
				
				
			}
			
			else if (opcaoEscolhida == 10) {
				
				System.out.println("Valor em Caixa: R$"+Caixa.getValorEmCaixa());
				
				
				
				
			}
			else if (opcaoEscolhida == 0) {
				
				continue;
				
				
				
			}
			else {
				System.out.println("Opcao Invalida");
				continue;
			}
			
			
			
			

		}
		System.out.println("Finalizando Sistema.");
		sc.close();

	}

}
