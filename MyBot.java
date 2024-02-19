package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    public MyBot() {
        super("6504725857:AAHLXd2XEECOP3PCFsqkqVDSR8iMlLPQnzw");
    }

    @Override
    public void onUpdateReceived(Update update) {
        var chatId = update.getMessage().getChatId();
        var text = update.getMessage().getText();

        try {
        var message = new SendMessage();
        message.setChatId(chatId);

        if (text.equals("/start")) {
            message.setText("Hello, welcome!");
        } else if (text.equals("btc")) {
            var price = CryptoPrice.spotPrice("BTC");
            message.setText("BTC price: " + price.getAmount().doubleValue());
        } else if (text.equals("eth")) {
            var price = CryptoPrice.spotPrice("ETH");
            message.setText("ETH price: " + price.getAmount().doubleValue());
        } else if (text.equals("bnb")) {
            var price = CryptoPrice.spotPrice("BNB");
            message.setText("BNB price: " + price.getAmount().doubleValue());
        } else if (text.equals("usdt")) {
            var price = CryptoPrice.spotPrice("USDT");
            message.setText("USDT price: " + price.getAmount().doubleValue());
        } else if (text.equals("btc,eth")) {
            var price1 = CryptoPrice.spotPrice("BTC");
            var price2 = CryptoPrice.spotPrice("ETH");
            message.setText("BTC price: " + price1.getAmount().doubleValue() + "\n" + "ETH price: " + price2.getAmount().doubleValue());

        } else if (text.equals("eth,btc,doge")) {
            var price1 = CryptoPrice.spotPrice("BTC");
            var price2 = CryptoPrice.spotPrice("ETH");
            var price3 = CryptoPrice.spotPrice("DOGE");
            message.setText("BTC price: " + price1.getAmount().doubleValue() + "\n" + "ETH price: " + price2.getAmount().doubleValue() + "\n" + "DOGE price: " + price3.getAmount().doubleValue());

        } else if (text.equals("/all")) {

            var price1 = CryptoPrice.spotPrice("BTC");
            var price2 = CryptoPrice.spotPrice("ETH");
            var price3 = CryptoPrice.spotPrice("BNB");
            var price4 = CryptoPrice.spotPrice("USDT");
            var price5 = CryptoPrice.spotPrice("DOGE");

            message.setText ("BTC price: " + price1.getAmount().doubleValue() + "\n" + "ETH price: " + price2.getAmount().doubleValue() + "\n" + "BNB price: " + price3.getAmount().doubleValue() + "\n" + "USDT price: " + price4.getAmount().doubleValue() + "\n" + "DOGE price: " + price3.getAmount().doubleValue());
        } else {
            message.setText("Unknown command!");
        }

            execute(message);
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public String getBotUsername() {
        return "SoNat1_bot";
    }
}
