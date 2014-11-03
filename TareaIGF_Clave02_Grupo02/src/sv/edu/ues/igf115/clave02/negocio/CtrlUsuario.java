package sv.edu.ues.igf115.clave02.negocio;

import sv.edu.ues.igf115.clave02.dominio.Usuario;

public interface CtrlUsuario {
Usuario findByUsuario(String idusuario);
}
