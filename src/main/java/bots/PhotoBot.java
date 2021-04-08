package bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.util.Comparator;
import java.util.List;

public class PhotoBot extends TelegramLongPollingBot {
	private final String BOT_USERNAME = "Boatdhatch_test2_photobot";	
	private final String TOKEN = "1759774997:AAFwEpswY4hL1Ol7pfDbzTUi3qEUyphmh8Y";	
	
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			String inputMessageText = update.getMessage().getText();
			SendMessage message = new SendMessage();
			message.setChatId(update.getMessage().getChatId().toString());
			message.setText(inputMessageText);
			
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasMessage() && update.getMessage().hasPhoto()) {
			String chatId = update.getMessage().getChatId().toString();
			
			List<PhotoSize> photos = update.getMessage().getPhoto();
			
			String fileId = photos.stream()
					.sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
					.findFirst().orElse(null).getFileId();
			
			int photoWidth = photos.stream()
					.sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
					.findFirst().orElse(null).getWidth();
			
			int photoHeight = photos.stream()
                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                    .findFirst()
                    .orElse(null).getHeight();
			
			String caption = "file_id: " + fileId + "\nwidth: " + Integer.toString(photoWidth) + "\nheight: " + Integer.toString(photoHeight);
			
			SendPhoto photoMessage = new SendPhoto();
			photoMessage.setChatId(chatId);
			photoMessage.setPhoto(new InputFile(fileId));
			photoMessage.setCaption(caption);
			
			try {
				execute(photoMessage);
			} catch (TelegramApiException e) {
				e.printStackTrace();
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
