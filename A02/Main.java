import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica(10);
        Scanner ler = new Scanner(System.in);
        boolean continuar = true;

        /*//Quantidade teste
          clinica.novoPaciente("Carlos", "m", 65, 1.69, 19);
          clinica.novoPaciente("Maria", "f", 72, 1.64, 24);
          clinica.novoPaciente("Joana", "f", 62, 1.67, 18);
          clinica.novoPaciente("Michael", "m", 80, 1.75, 50);
        */
        while (continuar) {
            String nome, sexo;
            double peso, altura;
            int idade;

            System.out.println("Pacientes cadastrados: " + clinica.pacientes_cad);
            System.out.print("Insira o nome do paciente: ");
            nome = ler.next();
            if (nome.equalsIgnoreCase("fim")) {
                continuar = false;
                ler.close();
                System.out.println("Lista finalizada!\n");
            } else {
                System.out.print("Insira o sexo do paciente <m/f>: ");
                sexo = ler.next();
                System.out.print("Insira o peso do paciente: ");
                peso = ler.nextDouble();
                System.out.print("Insira a altura do paciente: ");
                altura = ler.nextDouble();
                System.out.print("Insira a idade do paciente: ");
                idade = ler.nextInt();
                clinica.novoPaciente(nome, sexo, peso, altura, idade);
                System.out.println("Paciente cadastrado com sucesso!\n");
            }
        }
        clinica.relatorio(); //exibe o relatorio (veja a classe Clinica)
    }

}
