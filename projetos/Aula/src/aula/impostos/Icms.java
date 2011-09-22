package aula.impostos;

public class Icms implements InterfaceImpostos {

    //Apenas exemplos, na aplicação real, esses valores viriam do banco de dados.

    @Override
    public double getBaseDeCalculo() {
        return 25.45;
    }

    @Override
    public double getAliquota() {
        return 0.5;
    }
}
