/********************************************************/
/*                                                      */
/*   SOFTLAND INFORMATICA CONSULTORIA E SISTEMAS LTDA   */
/*                                                      */
/*              Copyright (c) 2001-2011                 */
/*                                                      */
/********************************************************/

package aula.impostos;

/**
 * Classe de estudos utilizada para calcular 
 * a Substituição Tributária de uma nota fiscal.
 *
 * @author Arthemus C. Moreira
 * @version 1.0.0
 * @since Para correto funcionamento do calculo de substituição tributaria,
 *        ao instanciar a classe, devem ser preenchidos obrigatoriamente os
 *        atributos: DTotalProduto, DIcms, DIpi, SNcm, SEmpresa e SCodProduto.
 */
public class SubTributaria {

    private String SCodProduto;
    private String SEmpresa;
    private String SUf;
    private String SNcm;
    private boolean BDestaca;
    private double DAliqInterna;
    private double DIpi;
    private double DTotalProduto;
    private double DIcms;

    /**
     *
     * @param sUfCliente Estado do endereço do cliente para o qual se destina a nota.
     */
    public SubTributaria(String sUfCliente) {

        if (!sUfCliente.equals(getNossoUf()) || getSubstituto()) {

            this.BDestaca = true;

            this.SUf = sUfCliente;

            this.DAliqInterna = getAliqInterna(sUfCliente);

        } else {
            this.BDestaca = false;
        }
    }

    public void setDIcms(double DIcms) {
        this.DIcms = DIcms;
    }

    public void setDIpi(double DIpi) {
        this.DIpi = DIpi;
    }

    public void setDTotalProduto(double DTotalProduto) {
        this.DTotalProduto = DTotalProduto;
    }

    public void setSCodProduto(String SCodProduto) {
        this.SCodProduto = SCodProduto;
    }

    public void setSEmpresa(String SEmpresa) {
        this.SEmpresa = SEmpresa;
    }

    public void setSNcm(String SNcm) {
        this.SNcm = SNcm;
    }

    /**
     *
     * @param sUfCliente Estado do cliente.
     * @return Aliquota de Icms interna do estado.
     */
    private double getAliqInterna(String sUfCliente) {
        return (18 / 100);
    }

    /**
     *
     * @return Estado da Empresa atual.
     */
    private String getNossoUf() {
        return "SP";
    }

    /**
     *
     * @return Parametro que determina se a Empresa é um contribuinte passivel de
     *         substituição ou um contribuinte Substituído.
     */
    private boolean getSubstituto() {
        return false;
    }

    public boolean isBDestaca() {
        return BDestaca;
    }

    /**
     *
     * @return Valor de Icms de Substituição tributaria.
     * @throws java.lang.Exception
     */
    public double getIcmsST() throws Exception {

        try {

            return (getBaseST() * this.DAliqInterna) - (this.DTotalProduto * this.DIcms);

        } catch (Exception e) {

            throw new Exception("Erro ao calcular o Icms de Substituição Tributária para o produto: " + this.SCodProduto + "\n\n" + e.getMessage());
        }
    }

    /**
     *
     * @return Base de calculo para o Icms de Substituição tributaria.
     * @throws java.lang.Exception
     */
    private double getBaseST() throws Exception {

        try {

            return (this.DTotalProduto + this.DIpi) * getIva(this.SCodProduto, this.SNcm, this.SEmpresa, this.SUf);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    /**
     *
     * @param sCodProduto Codigo do Produto atual.
     * @param sNcm Nomenclatura Comum do Mercosul. (Classificação Fiscal)
     * @param sEmpresa Empresa atual.
     * @param sUf Estado de destino da nota fiscal.
     * @return Estima de acressimo de valor que a mercadoria terá até a venda ao consumidor final.
     */
    private double getIva(String sCodProduto, String sNcm, String sEmpresa, String sUf) {
        return 53.23;
    }
}