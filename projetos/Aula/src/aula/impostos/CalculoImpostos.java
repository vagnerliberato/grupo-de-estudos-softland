package aula.impostos;

public class CalculoImpostos {

    private InterfaceImpostos objeto = null;

    public CalculoImpostos(InterfaceImpostos objeto) {
        this.objeto = objeto;
    }

    public InterfaceImpostos getObjeto() {
        return objeto;
    }
}
