import java.util.Scanner;
import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[10];

        System.out.print("Quantas pessoas deseja cadastrar (1 a 10)? ");
        int quantidade = entrada.nextInt();
        entrada.nextLine();

        if (quantidade < 1 || quantidade > 10) {
            System.out.println("Quantidade invalida.");
            entrada.close();
            return;
        }

        for (int i = 0; i < quantidade; i++) {

            System.out.println("\nCadastro da pessoa " + (i + 1));
            System.out.println("1 - Pessoa Fisica");
            System.out.println("2 - Pessoa Juridica");
            System.out.print("Escolha o tipo: ");

            int tipo = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("Endereco: ");
            String endereco = entrada.nextLine();

            if (tipo == 1) {

                System.out.print("CPF: ");
                String cpf = entrada.nextLine();

                PessoaFisica pessoa = new PessoaFisica();
                pessoa.setNome(nome);
                pessoa.setEndereco(endereco);
                pessoa.setCpf(cpf);

                pessoas[i] = pessoa;

            } else if (tipo == 2) {

                System.out.print("CNPJ: ");
                String cnpj = entrada.nextLine();

                PessoaJuridica pessoa = new PessoaJuridica();
                pessoa.setNome(nome);
                pessoa.setEndereco(endereco);
                pessoa.setCnpj(cnpj);

                pessoas[i] = pessoa;

            } else {
                System.out.println("Tipo invalido. Tente novamente.");
                i--;
            }
        }

        System.out.println("\n===== PESSOAS CADASTRADAS =====");

        for (int i = 0; i < quantidade; i++) {
            if (pessoas[i] != null) {
                System.out.println(pessoas[i].toString());
            }
        }

        entrada.close();
    }
}

