package telegrambot.boardhatch;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import bots.PhotoBot;

public class Main {
	public static void main(String[] args) {
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			//botsApi.registerBot(new MyAmazingBot());
			botsApi.registerBot(new PhotoBot());
		} catch (TelegramApiException e) {
			System.err.println("Error in main method: "+e.getMessage());
		}
		System.out.println("Bot has successfully started!");
	}
}
