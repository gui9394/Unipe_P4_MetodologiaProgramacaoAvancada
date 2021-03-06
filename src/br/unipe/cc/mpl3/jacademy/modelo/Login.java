package br.unipe.cc.mpl3.jacademy.modelo;
import br.unipe.cc.mpl3.jacademy.persistencia.RepositorioLogin;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulo
 */
public class Login {
    private String usuario;
    private String senha;
    private String id;

    private final RepositorioLogin repositorioLogin = new RepositorioLogin();

    public Login() {
    }

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean validar() {
        try {
            return repositorioLogin.validarLogin(usuario, senha);
        } catch (NoSuchAlgorithmException ex) {
            return false;
        } catch (UnsupportedEncodingException ex) {
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public static List<Login> getUsuarios(){
        
        RepositorioLogin repositorioLogin = new RepositorioLogin();
        
        return repositorioLogin.getUsuarios();
    }
}
