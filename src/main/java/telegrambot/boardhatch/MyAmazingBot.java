package telegrambot.boardhatch;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot{
	
	private final String BOT_USERNAME = "Boatdhatch_test1_bot";
	private final String TOKEN = "1735239141:AAE-KO9qlYSiiGYvnrFK5whfqUJasTVnXcE";

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage();
			message.setChatId(update.getMessage().getChatId().toString());
			message.setText("You are dick!");
			
			try {
				execute(message);
			} catch (TelegramApiException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public String getBotUsername() {
		return BOT_USERNAME;
	}

	@Override
	public String getBotToken() {
		return TOKEN;
	}
	
}
