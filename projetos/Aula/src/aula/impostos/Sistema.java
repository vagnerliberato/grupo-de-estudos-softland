package aula.impostos;

public class Sistema {

    public static void main(String args[]) {

        ItemFiscal item = new ItemFiscal();

        item.setValorNota(2500.35);

        Incnfisc inc = new Incnfisc(item);

        //mostrar valor de icms já calculado
        System.out.println(item.getValorIcms());
    }
}
