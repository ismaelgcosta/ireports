package br.com.javatar.to;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.sql.Date;

import static org.apache.commons.lang.StringUtils.isEmpty;
import static org.apache.commons.lang.StringUtils.trimToEmpty;
import static org.apache.commons.lang.StringUtils.upperCase;

public class ExampleTO {

    private long numeroOrdem;
    private long numeroRegistro;
    private Date dataEmissao;
    private Date dataVencimento;
    private int favorecidoKey;
    private String nomeFavorecido;
    private String enderecoLogradouro;
    private String enderecoNumero;
    private String municipio;
    private String uf;
    private BigDecimal valor;
    private int bancoKey;
    private String bancoDescricao;
    private Date dataQuitacao;
    private String pagarReceber;
    private boolean cancelada;

    private int page;

    public String getSituacao() {
        if (cancelada) {
            return "CL";
        }

        if (dataQuitacao == null) {
            return "AB";
        } else {
            return "LQ";
        }
    }

    public String getEndereco() {
        if(isEmpty(enderecoLogradouro)){
            return "";
        }
        return upperCase(StringUtils.substring(trimToEmpty(enderecoLogradouro), 0, 78) + ", " + trimToEmpty(enderecoNumero));
    }

    public String getBanco() {
        return isEmpty(bancoDescricao) ? "" : upperCase(StringUtils.leftPad(String.valueOf(this.bancoKey), 3, '0') + "-" + this.bancoDescricao);
    }

    public long getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(long numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public long getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(long numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getFavorecidoKey() {
        return favorecidoKey;
    }

    public void setFavorecidoKey(int favorecidoKey) {
        this.favorecidoKey = favorecidoKey;
    }

    public String getNomeFavorecido() {
        return upperCase(nomeFavorecido);
    }

    public void setNomeFavorecido(String nomeFavorecido) {
        this.nomeFavorecido = nomeFavorecido;
    }

    public String getEnderecoLogradouro() {
        return enderecoLogradouro;
    }

    public int logradouroSize() {
        return getEndereco().length() / 24;
    }

    public void setEnderecoLogradouro(String enderecoLogradouro) {
        this.enderecoLogradouro = enderecoLogradouro;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getMunicipio() {
        return trimToEmpty(upperCase(municipio));
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return trimToEmpty(uf);
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getBancoKey() {
        return bancoKey;
    }

    public void setBancoKey(int bancoKey) {
        this.bancoKey = bancoKey;
    }

    public String getBancoDescricao() {
        return bancoDescricao;
    }

    public void setBancoDescricao(String bancoDescricao) {
        this.bancoDescricao = bancoDescricao;
    }

    public Date getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(Date dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }

    public String getPagarReceber() {
        return pagarReceber;
    }

    public void setPagarReceber(String pagarReceber) {
        this.pagarReceber = pagarReceber;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public boolean naoCancelada() {
        return !cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}