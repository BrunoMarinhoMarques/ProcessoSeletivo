package Candidatura;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("Processo Seletivo");
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA"};

        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }

    }


    static void selecaoCandidatos(){
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA"};

        int candidatoSelecionados=0;
        int candidatosAtual=0;
        double salarioBase=2000.0;
        while(candidatoSelecionados < 5 && candidatosAtual < candidatos.length){
                String candidato = candidatos[candidatosAtual];
                double salarioPretendido = valorPretendido();
                
                System.out.println("O candidato "+candidato+ " solicitou este valor de salário "+salarioPretendido);
                if(salarioBase>=salarioPretendido){
                        System.out.println("O candidato " +candidato+ " foi selecionado para a vaga");
                        candidatoSelecionados++;
                }
                candidatosAtual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        }else if(salarioBase==salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }else{
            System.out.println("Aguardanod o resultado dos demais candidatos");
        }
    }

    static boolean atender(){
        //gera numeros randomicos de 1 a 3, caso for igual a 1 retorna true
        return new Random().nextInt(3)==1;
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas=1;
        boolean continuarTentando=true;
        boolean atendeu=false;
        do{
            atendeu = atender();
            //caso  "atender" a variavel continuarTentando recebe o valor oposto de atendeu, que no caso é false
            continuarTentando = !atendeu;

            if(continuarTentando)tentativasRealizadas++;
            else System.out.println("Contato realizado com sucesso");

        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu) System.out.println("Conseguimos contato com "+candidato+" na "+tentativasRealizadas+ " tentativa");
        else System.out.println("Não conseguimos contato com "+candidato+" na "+tentativasRealizadas+ " tentativa realizada");


    }   
}
