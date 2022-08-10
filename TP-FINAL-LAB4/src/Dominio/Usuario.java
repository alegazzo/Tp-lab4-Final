package Dominio;

public class Usuario {
		private int idUsuario;
		private String user_Name;
		private String pass;
		private TipoUsuario tipoUsuario;
		private int referencia;
		private boolean estado;
		
	
		public Usuario() {
			super();
			idUsuario = 0;
			user_Name = null;
			pass = null;
			tipoUsuario = null;
			referencia = 0;
			estado = false;
		}

		@Override
		public String toString() {
			return "Usuario [idUsuario=" + idUsuario + ", user_Name=" + user_Name + ", pass=" + pass + ", tipoUsuario="
					+ tipoUsuario.getIdTipoUsuario() + ", referencia=" + referencia + ", estado=" + estado + "]";
		}

		public Usuario(int idUsuario, String user_Name, String pass, TipoUsuario tipoUsuario, int referencia,
				boolean estado) {
			super();
			this.idUsuario = idUsuario;
			this.user_Name = user_Name;
			this.pass = pass;
			this.tipoUsuario = tipoUsuario;
			this.referencia = referencia;
			this.estado = estado;
		}
		
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}
		public String getUser_Name() {
			return user_Name;
		}
		public void setUser_Name(String user_Name) {
			this.user_Name = user_Name;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public TipoUsuario getTipoUsuario() {
			return tipoUsuario;
		}
		public void setTipoUsuario(TipoUsuario tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}
		public int getReferencia() {
			return referencia;
		}
		public void setReferencia(int referencia) {
			this.referencia = referencia;
		}
		public boolean getEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado = estado;
		}
		
		
		
}
