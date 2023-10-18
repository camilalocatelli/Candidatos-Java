package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu=atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else    
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while(continuarTentando && tentativasRealizadas <3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA!" );
        else 
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADAS! TENTE NOVAMENTE MAIS TARDE");
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionado() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Lista de candidatos informando o indicie do elemento: ");

        for(int indicie=0; indicie < candidatos.length; indicie++){
            System.out.println("O candidato de nº" + indicie + " é " + candidatos[indicie]);
        }

    }

    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        
        int CandidatosSelecionados = 0;
        int candidatosAtual = 0;
        double SalarioBase=2000.0;
        while(CandidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou esse valor de salário: R$ " + salarioPretendido );
            if(SalarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                CandidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
        static double valorPretendido(){
            return ThreadLocalRandom.current().nextDouble(1800, 2200);
        }

    static void analisarCandidato(double salarioPretendido) {
        double SalarioBase = 2000.0;
        if (SalarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");

        }else if(SalarioBase == salarioPretendido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");

        else {
            System.out.println("AGUARDANDO O RESULTADO DE TODOS OS CANDIDATOS");
        }
    }
}
