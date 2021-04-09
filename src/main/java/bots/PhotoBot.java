package bots;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PhotoBot extends TelegramLongPollingBot {
	private final String BOT_USERNAME = "Boatdhatch_test2_photobot";	
	private final String TOKEN = "1759774997:AAFwEpswY4hL1Ol7pfDbzTUi3qEUyphmh8Y";	
	
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			String inputMessageText = update.getMessage().getText();
			String chatId = update.getMessage().getChatId().toString();
			
			
			if ("/start".equals(inputMessageText)) {
				SendMessage message = new SendMessage();
				message.setChatId(update.getMessage().getChatId().toString());
				message.setText("Bot is running!");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if ("/pic".equals(inputMessageText)) {
				SendPhoto photoMessage = new SendPhoto();
				photoMessage.setChatId(chatId);
				photoMessage.setPhoto(new InputFile("AgACAgIAAxkBAAMGYG9mGexCSq5DQGexyO_N0IB_CtcAArixMRtlfoFLxOK1sSnWecmRKyWbLgADAQADAgADeAADOwMGAAEeBA"));
				photoMessage.setCaption("Photo");
				
				try {
					execute(photoMessage);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else if ("/markup".equals(inputMessageText)) {
			    SendMessage message = new SendMessage();
			    message.setChatId(chatId);
			    message.setText("Here is your keyboard!");
			    
			    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
			    
			    List<KeyboardRow> keyboardSpace = new ArrayList<>();
			    KeyboardRow keyboardRow = new KeyboardRow();
			    
			    keyboardRow.add("Row 1 Button 1");
			    keyboardRow.add("Row 1 Button 2");
			    keyboardRow.add("Row 1 Button 3");
			    
			    keyboardSpace.add(keyboardRow);
			    
			    keyboardRow = new KeyboardRow();
                
                keyboardRow.add("Row 2 Button 1");
                keyboardRow.add("Row 2 Button 2");
                keyboardRow.add("Row 2 Button 3");
                
                keyboardSpace.add(keyboardRow);
                
                keyboardRow = new KeyboardRow();
                
                keyboardRow.add("Row 3 Button 1");
                keyboardRow.add("Row 3 Button 2");
                keyboardRow.add("Row 3 Button 3");
                
                keyboardSpace.add(keyboardRow);
                
                keyboardMarkup.setKeyboard(keyboardSpace);
                
                message.setReplyMarkup(keyboardMarkup);
                
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
			    
			} else if ("/hide".equals(inputMessageText)){
			    SendMessage message = new SendMessage();
			    message.setChatId(chatId);
			    message.setText("Keyboard is hidden");
			    
			    ReplyKeyboardRemove remove = new ReplyKeyboardRemove();
			    remove.setRemoveKeyboard(true);
			    message.setReplyMarkup(remove);
			    
			    
			    try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
			} else {
				SendMessage message = new SendMessage();
				message.setChatId(update.getMessage().getChatId().toString());
				message.setText("Unknown command!");
				try {
					execute(message);
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
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
