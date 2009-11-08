package sipsa.dominio;

public abstract class Usuario {

    private String usuario;
    private char[] password;

    public boolean isValido(){
        if (this.usuario.equals("sipsa")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(char[] password) {
        this.password = password;
    }
}
