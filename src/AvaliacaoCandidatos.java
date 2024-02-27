import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AvaliacaoCandidatos{
    public static void main(String[] args) {
        System.out.println("Processo seletivo!");
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do{
			atendeu= atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
            tentativasRealizadas++;
        else
            System.out.println("CONTATO REALIZADO COM SUCESSO");
        } while (continuarTentando && tentativasRealizadas <3);
        if(atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }
    //método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;	
	}
    //Criar o método de avaliação
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o Candidato!");
        } else if (salarioBase == salarioPretendido){
            System.out.println("Ligar para o Candidato com contraproposta!");
        }else{
            System.out.println("AGUARDANDO DEMAIS CANDIDATURAS");
        }
    }
    //Metodo para selecionar os candidatos
    static void selecionarCandidatos(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato" + candidato + "Solicitou este valor de salário" + salarioPretendido);
            if(salarioBase>=salarioPretendido){
                System.out.println("O candidato " + candidato+ "foi selecionado para o vaga!");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
     return ThreadLocalRandom.current().nextDouble(1800, 2200);
}
}