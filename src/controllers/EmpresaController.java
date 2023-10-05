package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Empresa;
import entities.Funcionario;

public class EmpresaController {
	public void cadastrarEmpresa() {
		Scanner scanner = new Scanner(System.in);
		try {
			Empresa empresa = new Empresa();
			empresa.setId(UUID.randomUUID());
			System.out.print("NOME FANTASIA DA EMPRESA..: ");
			empresa.setNomeFantasia(scanner.nextLine());
			System.out.print("RAZÃO SOCIAL DA EMPRESA...: ");
			empresa.setRazaoSocial(scanner.nextLine());
			System.out.print("CNPJ DA EMPRESA...........: ");
			empresa.setCnpj(scanner.nextLine());
			System.out.print("QTD DE FUNCIONÁRIOS.......: ");
			Integer qtd = Integer.parseInt(scanner.nextLine());
			if (qtd > 0) {
				// inicializando a lista
				// de funcionários (abrindo
				// espaço em memória)
				empresa.setFuncionarios(new ArrayList<Funcionario>());
				for (int i = 1; i <= qtd; i++) {
					Funcionario funcionario = new Funcionario();
					funcionario.setId(UUID.randomUUID());
					System.out.println("\nINFORME O " + i + "o FUNCIONÀRIO:");
					System.out.print("NOME DO FUNCIONÁRIO.......: ");
					funcionario.setNome(scanner.nextLine());
					System.out.print("CPF DO FUNCIONÁRIO........: ");
					funcionario.setCpf(scanner.nextLine());
					System.out.print("SALÁRIO DO FUNCIONÁRIO....: ");
					funcionario.setSalario(Double.parseDouble(scanner.nextLine()));
					// adicionando um funcionário
					// dentro da lista
					empresa.getFuncionarios().add(funcionario); 

				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println("\nErro de validação:");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar empresa:");
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
