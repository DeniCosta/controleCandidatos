package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};

        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
        
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu =false;

        do{
            atendeu=atender();
            continuarTentando=!atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }

        }while(continuarTentando && tentativasRealizadas<3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM "+ candidato + "NA " + tentativasRealizadas + " TENTATIVA");
        }else{
            System.out.println("NÃO CONSEGUIMOS CONTATO COM "+ candidato + ", NÚMERO MÁXIMO TENTATIVAS "+ tentativasRealizadas + " REALIZADA");
        }

    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        System.err.println("Imprimindo a lista de candidatos informando o índice do elemento");

        for(int indice=0; indice<candidatos.length;indice++){
            System.out.println("O candidato de nº " + (indice+1) + candidatos[indice]);
        }
        System.out.println("Iteração For each");
        for(String candidato : candidatos){
            System.out.println("O candidato selecionado foi "+ candidato);
        }


    }
    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA","DANIELA", "JORGE"};
        
        double salarioBase= 2000.00;
        int candidatosSelecionados = 0;
        int candidatoAtual= 0;

        while (candidatosSelecionados<5 && candidatoAtual<candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato "+candidato+ "solicitou o valor de "+salarioPretendido);
            if(salarioBase>=salarioPretendido){
            System.out.println("O candidato "+candidato+" foi selecionado para a vaga.");
            candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1000,2200);
    }

    static void analizarCandidato(double salarioPretendido){
        double salarioBase= 2000.00;
        if(salarioBase>salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");   
        } else if(salarioBase==salarioPretendido){
            System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA"); 
        }else{
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS"); 
        }
    }
}
