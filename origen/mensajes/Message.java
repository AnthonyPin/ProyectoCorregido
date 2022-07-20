package Mensajes;

public class Message {

private int id;
	private String de;
	private String para;
	private String hora;
	private String mens;
	
	public Message(int id, String de, String para, String hora, String mens) {
		this.id = id;
		this.de = de;
		this.para = para;
		this.hora = hora;
		this.mens = mens;
	}
	public Message(String para, String hora, String mens) {
		this.para = para;
		this.hora = hora;
		this.mens = mens;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMens() {
		return mens;
	}
	public void setContent(String mens) {
		this.mens = mens;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", de=" + de + ", para=" + para + ", hora=" + hora + ", mens=" + mens + "]";
	}
}

