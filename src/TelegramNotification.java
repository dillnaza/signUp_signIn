import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramNotification extends TelegramLongPollingBot {
    private final String BOT_NAME = "dill";
    private final String BOT_TOKEN = "5695792784:AAEPMFRgGwvHnqQpWzeAN_CLYKlL10WiwRk";
    private final String CHAT_ID = "1273572840";

    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    public void setAnswer(String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(CHAT_ID);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
