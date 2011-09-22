package aula.impostos;

public class Incnfisc {

    public Incnfisc(ItemFiscal item) {

        CalculoImpostos calculo = new CalculoImpostos(new Icms());

        double valorDaNotaCalculadoComIcms = item.getValorNota() * calculo.getObjeto().getAliquota();

        item.setValorIcms(valorDaNotaCalculadoComIcms);
    }
}
