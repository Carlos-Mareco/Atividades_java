public class Paciente {
    String nome;
    String sexo;
    double peso;
    double altura;
    int idade;

    public void setInformacoes(String nome, String sexo, double peso, double altura, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        if (sexo.equalsIgnoreCase("masculino"))
            this.sexo = "M";
        else if (sexo.equalsIgnoreCase("feminino"))
            this.sexo = "F";
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }
}
