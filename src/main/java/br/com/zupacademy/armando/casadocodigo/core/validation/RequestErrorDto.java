package br.com.zupacademy.armando.casadocodigo.core.validation;

public class RequestErrorDto {

    private String campo;
    private String erro;

    public RequestErrorDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

}
