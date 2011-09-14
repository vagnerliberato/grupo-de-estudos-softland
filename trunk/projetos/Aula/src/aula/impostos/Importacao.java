/********************************************************/
/*                                                      */
/*   SOFTLAND INFORMATICA CONSULTORIA E SISTEMAS LTDA   */
/*                                                      */
/*              Copyright (c) 2001-2011                 */
/*                                                      */
/********************************************************/
package aula.impostos;

/**
 * Classe de estudos utilizada para calcular o Imposto de Importação.
 * 
 * @author Rosemeire do Carmo Oliveira
 * @version 1.0.0
 * @since 
 *        
 *        
 */
public class Importacao {

    private boolean CfopImportacao;
    private String SCodProduto;
    private double AliquotaII;
    private double VrTotalProduto;

    public void setCFOPImportacao(boolean BCFOPImp) {
        this.CfopImportacao = BCFOPImp;
    }

    public void setSCodProduto(String SCodProduto) {
        this.SCodProduto = SCodProduto;
    }

    public void setAliquotaII(double DAliquotaII) {
        this.AliquotaII = DAliquotaII;
    }

    public void setVrTotalProduto(double DVrTotalProduto) {
        this.VrTotalProduto = DVrTotalProduto;
    }

    public double CalcII() throws Exception {

        try {
            if (this.CfopImportacao) {
                return (this.GetBaseII() * this.AliquotaII / 100);
            } else {
                return 0;
            }

        } catch (Exception e) {

            throw new Exception("Erro ao calcular Imposto de importação do porduto: " + this.SCodProduto + "\n\n" + e.getMessage());

        }

    }

    public double CalcVrAduaneiro() {


        if (this.AliquotaII != 0) {

            return (this.VrTotalProduto / (1 + (this.AliquotaII / 100)));

        } else {
            return 0;
        }
    }

    public double GetVrAduaneiro() {


        if (this.CfopImportacao) {
            return this.CalcVrAduaneiro();
        }else {
            return 0;
        }
    }

    public double GetBaseII() throws Exception {

        try {

            return this.GetVrAduaneiro();


        } catch (Exception e) {

            throw new Exception("Erro ao calcular o Base de Imposto de importação do porduto: " + this.SCodProduto + "\n\n" + e.getMessage());
        }

    }
}
