package cz.osu.pesa.swi224;

import cz.osu.pesa.swi224.Model.ChatRoomRepository;
import cz.osu.pesa.swi224.Model.db.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Swi224Application implements CommandLineRunner {

	@Autowired
	private ChatRoomRepository chatRoomRepo;

	public static void main(String[] args) {
		SpringApplication.run(Swi224Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.setChatName("Public");

		if (chatRoomRepo.existsByChatNameIgnoreCase("Public")) {
			System.out.println("Chat room 'Public' already exists.");
		} else {
			chatRoomRepo.save(chatRoom);
			System.out.println("Chat room 'Public' created.");
		}
	}
}
