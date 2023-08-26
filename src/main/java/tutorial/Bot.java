package tutorial;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return "6545417428:AAEFKwIEyFvUr5iwyKmlQtsv5iR2MuCRDW8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        if (msg.isCommand()) {
            switch (msg.getText()) {
                case "/start" -> {
                    sendText(id, "Добро пожаловать!");
                    sendText(id, "Для проверки сайта на доступность отправьте мне адрес сайта.");
                }
                case "/help" -> sendText(id, "Проверяю доступность сайтов.");
            }
            return;
        }

        String stringURL = msg.getText();
        sendText(id, checkSite.check(stringURL));

    }

    @Override
    public String getBotUsername() {
        return "DownD_rBot";
    }

    public void sendText (Long who, String what) {
        SendMessage sm = SendMessage.builder().chatId(who.toString()).text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
