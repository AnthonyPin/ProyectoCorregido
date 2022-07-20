package ListaChats;

import java.util.ArrayList;

import java.util.List;

import Mensajes.Message;

public class Listachats {

	private List<Message> messages = new ArrayList<>();
	
	
	private List<Message> listUser = new ArrayList<>();
	
	public Listachats() {
		
		
		messages.add(new Message(1, "Julissa", "Anthony", " 10:10 ", "¿Como estas?"));
		messages.add(new Message(2, "Anthony", "Julissa", " 10:11 ", "¿Que hay?"));
		messages.add(new Message(3, "Anthony", "Johanna", " 10:12 ", "¿Me pudes hacer un gran favor?"));
		messages.add(new Message(4, "Julissa", "Jorge", " 10:13 ", "¿Como has estado?"));
		messages.add(new Message(5, "Anthony", "Miguel", " 10:10 ", "Hola, buenos dias"));
		messages.add(new Message(6, "Julissa", "Vanessa", " 10:11 ", "Hola, como asi?"));
		messages.add(new Message(7, "Julissa", "Juan", " 10:11 ", "Si, ha pasado mucho tiempo"));
		messages.add(new Message(8, "Julissa", "Carolina", " 10:10 ", "Hola compañero"));
		messages.add(new Message(9, "Julissa", "Maria", " 10:11 ", "Hola como esta?"));
		messages.add(new Message(10, "Julissa", "Luis", " 10:11 ", "Muy Bien gracias, y tu?"));
		messages.add(new Message(11, "Ricardo", "Julissa", " 10:10 ", "Holaaa, como has estado?"));
		messages.add(new Message(12, "Julissa", "Ricardo", " 10:11 ", "Hola buenas tardes, muy bien"));
		messages.add(new Message(13, "Ricardo", "Julissa", " 10:11 ", ":D que bueno"));
		messages.add(new Message(14, "Andres", "Julissa", " 10:10 ", "Hola, te puedo pedir un favor?"));
		messages.add(new Message(15, "Julissa", "Andres", " 10:11 ", "Si, claro, con mucho gusto"));
		messages.add(new Message(16, "Andresr", "Julissa", " 10:11 ", "Me puedes ayudar con la tarea?"));
		messages.add(new Message(17, "Johanna", "Julissa", " 10:10 ", "Hola, buenas tardes"));
		messages.add(new Message(18, "Julissa", "Johanna", " 10:11 ", "Hola, disculpe, con quien hablo?"));
		messages.add(new Message(19, "Johanna", "Julissa", " 10:11 ", "No te acuerdas? :o"));
	}
	
	public List<Message> getMessage(String de, String para){
		List<Message> result = new ArrayList<>();
		
		for(Message msg: messages) {
			if((msg.getDe().equals(de) && msg.getPara().equals(para))
					|| (msg.getDe().equals(de) && msg.getPara().equals(de))) {
				result.add(msg);
			}
		}
		
		return result;
	}
	
	public List<Message> getUser(){
		List<Message> result = new ArrayList<>();
		
		for(Message us: messages) {
			result.add(us);
		   }
		
		return result;
	    }
}