public class Clinica {
    String nome;
    String cnpj;
    Paciente[] pacientes;
    int pacientes_cad; //contador de pacientes cadastrados

    public Clinica(int n_pacientes) {
        this.pacientes_cad = 0;
        this.pacientes = new Paciente[n_pacientes];
    }
    //Exibe o relatório da clínica
    public void relatorio() {
        System.out.println("RALATÓRIO DA CLÍNICA");
        System.out.println("Quantidade de pacientes: " + pacientes_cad);
        System.out.println("Idade média dos homens: " + idadeMedia("m"));
        System.out.println("Quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70: " + quantidadeAlturaPeso("f", 1.60, 1.70, 70));
        System.out.println("Quantidade de pessoas com idade entre 18 e 25: " + quantidadeIdade(18, 25));
        System.out.println("Nome do paciente mais velho: " + pacienteMaisVelho());
        System.out.println("Nome da mulher mais baixa: " + pacienteMaisBaixo("f"));
    }
    //Aumenta a quantidade de pacientes que podem ser cadastrados (de acordo com o parâmetro)
    public void maisPacientes(int quantidade) {
        int novoTamanho = this.pacientes.length + quantidade;
        Paciente[] novoVetor = new Paciente[novoTamanho];
        for (int i = 0; i < this.pacientes.length; i++) {
            novoVetor[i] = this.pacientes[i];
        }
        this.pacientes = novoVetor;
    }
    //Adiciona um paciente (já existe) na clínica
    public void adcPaciente(Paciente novo) {
        if (this.pacientes.length > this.pacientes_cad) {
            this.pacientes[this.pacientes_cad] = novo;
        } else {
            maisPacientes(1);
            this.pacientes[this.pacientes_cad] = novo;
        }
        this.pacientes_cad++;
    }
    //Cria um paciente e adiciona na clínica.
    public void novoPaciente(String nome, String sexo, double peso, double altura, int idade) {
        Paciente novo = new Paciente();
        novo.setInformacoes(nome, sexo, peso, altura, idade);
        adcPaciente(novo);
    }
    //Retorna a idade média de pacientes de acordo com o sexo
    public double idadeMedia(String sexo) {
        double media = 0;
        int n_sexo = 0;
        for (int i = 0; i < this.pacientes_cad; i++) {
            if(this.pacientes[i].sexo.equalsIgnoreCase(sexo)) {
                media += this.pacientes[i].idade;
                n_sexo++;
            }
        }
        if (n_sexo != 0)
            media /= n_sexo;
        return media;
    }
    //Retorna a quantidade de pessoas do "sexo" com altura entre "alturaMin" e "alturaMax" e peso acima de "pesoMin"
    public int quantidadeAlturaPeso(String sexo, double alturaMin, double alturaMax, double pesoMin) {
        int quantidade = 0;
        for (int i = 0; i < this.pacientes_cad; i++) {
            if (this.pacientes[i].sexo.equalsIgnoreCase(sexo)) {
                if ((this.pacientes[i].altura >= alturaMin) || (this.pacientes[i].altura <= alturaMax)){
                    if (this.pacientes[i].peso > pesoMin)
                        quantidade++;
                }
            }
        }
        return quantidade;
    }
    //Retorna a quantidade de pessoas entre "idadeMin" e "idadeMax"
    public int quantidadeIdade(int idadeMin, int idadeMax) {
        int quantidade = 0;
        for (int i = 0; i < this.pacientes_cad; i++) {
            if ((this.pacientes[i].idade >= idadeMin) && (this.pacientes[i].idade <= idadeMax))
                quantidade++;
        }
        return quantidade;
    }
    //Retorna o nome do paciente mais velho
    public String pacienteMaisVelho() {
        String nome = "";
        int idade = 0;
        for (int i = 0; i < this.pacientes_cad; i++) {
            if (idade < this.pacientes[i].idade) {
                idade = this.pacientes[i].idade;
                nome = this.pacientes[i].nome;
            }
        }
        return nome;
    }
    //Retorna o nome do paciente "sexo" mais baixo
    public String pacienteMaisBaixo(String sexo) {
        String nome = "";
        double altura = this.pacientes[0].altura;
        for (int i = 0; i < this.pacientes_cad; i++) {
            if (this.pacientes[i].sexo.equalsIgnoreCase(sexo))
                if (altura >= this.pacientes[i].altura) {
                altura = this.pacientes[i].altura;
                nome = this.pacientes[i].nome;
                }
        }
        return nome;
    }
}
