package sptech.school;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Você pode usar essa classe para testar o seu código se precisar.");
        Laboratorio lab1=new Laboratorio();
        lab1.setNome("laboratorio");
        Vacina vacina=new Vacina();
        vacina.setCodigo("122");
        vacina.setTipo("tipo1");
        vacina.setPreco(22.9);
        vacina.setNome("Gripe");
        vacina.setEficacia(75.00);
        vacina.setDataLancamento(LocalDate.now());
        lab1.adicionarVacina(vacina);
        System.out.println(lab1.buscarVacinaComMelhorEficacia());


    }
}