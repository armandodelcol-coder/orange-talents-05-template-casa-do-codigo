package br.com.zupacademy.armando.casadocodigo.config.exceptionhandler;

public class RequestFieldErrorDto {

    private String campo;
    private String erro;

    public RequestFieldErrorDto(String campo, String erro) {
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
