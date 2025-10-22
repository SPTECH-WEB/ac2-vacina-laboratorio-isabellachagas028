package sptech.school;
import sptech.school.exception.ArgumentoInvalidoException;
import sptech.school.exception.VacinaInvalidaException;
import sptech.school.exception.VacinaNaoEncontradaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Laboratorio {
    private String nome;



    private List<Vacina> vacinas =new ArrayList<>();
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Laboratorio() {
        vacinas =new ArrayList<>();
    }
    public void adicionarVacina(Vacina vacina){
        if(vacina==null){
        throw new VacinaInvalidaException("Vacina não pode ser nula");
        }
        if(vacina.getCodigo()==null||vacina.getCodigo().isEmpty()){
            throw new VacinaInvalidaException("O codigo da vacina não pode ser nulo ou vazio");

        }
        if(vacina.getNome()==null||vacina.getNome().isEmpty()){
            throw new VacinaInvalidaException("O Nome da vacina não pode ser nulo ou vazio");

        }
        if(vacina.getTipo()==null||vacina.getTipo().isEmpty()){
            throw new VacinaInvalidaException("O Tipo da vacina não pode ser nulo ou vazio");

        }
        if(vacina.getPreco()==null||vacina.getPreco()<=0){
            throw new VacinaInvalidaException("O pREÇO da vacina não pode ser nulo, menor ou igual a zero");

        }
        if(vacina.getEficacia()==null||vacina.getEficacia()<0||vacina.getEficacia()>100){
            throw new VacinaInvalidaException("A eficacia não pode ser nula e deve estar em um intervalo de 0 a 100");

        }
        if(vacina.getDataLancamento()==null||vacina.getDataLancamento().isAfter(LocalDate.now())){
            throw new VacinaInvalidaException("A data de lançamento não pode ser nula ou futura");

        }
        vacinas.add(vacina);
    }
    public Vacina buscarVacinaPorCodigo(String codigo){
        if (codigo==null||codigo.isEmpty()||codigo.isBlank()){
            throw new ArgumentoInvalidoException("Codigo invalido");
        }
        for(Vacina vacina1:vacinas){
            if (vacina1.getNome().equals(codigo)){
                return vacina1;
            }

        }throw new VacinaNaoEncontradaException();
    }
    public void removerVacinaPorCodigo(String codigo){
        if (codigo==null||codigo.isEmpty()||codigo.isBlank()){
            throw new ArgumentoInvalidoException("Codigo invalido");
        }
        for(Vacina vacina1:vacinas){
            if (vacina1.getNome().equals(codigo)){
                vacinas.remove(vacina1);
                return;
            }
            throw new VacinaNaoEncontradaException();

    }

}
public  Vacina buscarVacinaComMelhorEficacia(){
        if (vacinas.isEmpty()){
            throw new VacinaNaoEncontradaException("Lista de vacinas vazia");
        }
        Vacina maior=vacinas.get(0);
        for (Vacina vacina1:vacinas){
            if (vacina1.getEficacia()>maior.getEficacia()){
                maior=vacina1;

            }
            if (vacina1.getEficacia().equals(maior.getEficacia())){
                if(vacina1.getDataLancamento().isAfter(maior.getDataLancamento())){
                    maior=vacina1;
                }
            }

        }
    return maior;
}
public List<Vacina> buscarVacinaPorPeriodo(LocalDate dataInicio, LocalDate dataFim){
        if (dataInicio.isAfter(dataFim)||dataFim==null||dataInicio==null){
            throw new ArgumentoInvalidoException("Datas inválidas");
        }
        List<Vacina>vacinasEncontradas=new ArrayList<>();
        for (Vacina vacina1:vacinas){
            if (vacina1.getDataLancamento().isAfter(dataInicio)&&vacina1.getDataLancamento().isBefore(dataFim)||vacina1.getDataLancamento().isEqual(dataInicio)||vacina1.getDataLancamento().isEqual(dataFim)){
                vacinasEncontradas.add(vacina1);
            }
        }
        return vacinasEncontradas;
}
}