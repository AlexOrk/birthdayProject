package telegramBot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {

    private static final Logger log = LoggerFactory.getLogger(MyBot.class);

    private final Helper helper = new Helper();
    private long current_chat_id;
    private final String startText = "Привет. Я специальный бот с секретной миссией)\n" +
            "Введите фамилию и имя для регистрации.";
    private final String helpText = "Привет:З Я ждал тебя) С Днем Рождения! Сейчас мы с тобой " +
            "попробуем пройти небольшой квест. Будь честна и старайся не подглядывать правильные " +
            "ответы:D Ну хотя бы не всегда)\n" +
            "Но прежде чем начать, правильно ответь на два вопроса.";

    public MyBot(){
        super();
    }

    // ответы в виде кнопок
    private boolean var1;
    private boolean var2;
    private boolean var3;

    // подсказки
    private int hintCount = 0;

    // счетчик видео
    private int videoCount = 0;

    // вход в ветку с голосовыми вопросами
    private boolean isQuestion1;
    private boolean isQuestion2;

    // номер подсказки для ответа по аудио-вопросу
    int hint = 1;

    public void onUpdateReceived(Update update) {
        new Thread(() -> {
            log.info("A new thread was created.");
            // receive the id of this chat (where we take the message)
            if (update.hasMessage()) {
                long chat_id = update.getMessage().getChatId();
                SendMessage message = new SendMessage();
                String userMessage = update.getMessage().getText();

                if (userMessage != null && userMessage.equals("/start")) {

                    if (chat_id == current_chat_id)
                        message.setChatId(chat_id).setText("Авторизация уже была успешно произведена.");
                    else {
                        message.setChatId(chat_id).setText(startText);
                        log.info("New user connected.");
                    }
                    sendMessage(message);

                } else if (chat_id == current_chat_id) {
                    if (update.hasMessage() && update.getMessage().hasText()) {

                        // Ветка аудио_1
                        if (isQuestion1) {

                            if (userMessage.equalsIgnoreCase("Answer 1.1")) {
                                log.info("Audio-question_1.1 was passed");
                                message.setChatId(chat_id).setText("Правильно! Это было слишком легко) Давай попробуем " +
                                        "еще раз!");
                                sendMessage(message);

                                // Первый вопрос пройден. Теперь подсказка нужна для второго вопроса
                                hint = 2;

                                // отправляется второй вопрос из аудио_1
                                sendAudio("1.2.mp3", chat_id);

                            } else if (userMessage.equalsIgnoreCase("Answer 1.2")) {
                                log.info("Audio-question_1.2 was passed");
                                message.setChatId(chat_id).setText("Опять верно) Ладно, секретное слово для ввода: " +
                                        "Бипа");
                                sendMessage(message);

                                // Второй вопрос пройден. Больше вопросов нет, подсказка возвращается к начальному номеру
                                hint = 1;

                                // Ветка с аудио_1 закончена, возвращаемся
                                isQuestion1 = false;

                            } else if (userMessage.equalsIgnoreCase("подсказка") && hint == 1) {
                                message.setChatId(chat_id).setText("Hint 1.1");
                                sendMessage(message);

                            } else if (userMessage.equalsIgnoreCase("подсказка") && hint == 2) {
                                message.setChatId(chat_id).setText("Hint 1.2");
                                sendMessage(message);

                            } else {
                                message.setChatId(chat_id).setText("Неверно, возможно я ожидаю, что ты напишешь по-другому. " +
                                        "Можешь воспользоваться подсказкой, для этого введи команду \"подсказка\"");
                                sendMessage(message);
                            }

                            // Ветка аудио_2
                        } else if (isQuestion2) {

                            if (userMessage.equalsIgnoreCase("Answer 2.1")) {
                                log.info("Audio-question_2.1 was passed");
                                message.setChatId(chat_id).setText("Молодец! Давай ответим еще на один вопрос, " +
                                        "тогда точно узнаешь секретное слово)");
                                sendMessage(message);

                                // Первый вопрос пройден. Теперь подсказка нужна для второго вопроса
                                hint = 2;

                                // отправляется второй вопрос из аудио_1
                                sendAudio("2.2.mp3", chat_id);

                            } else if (userMessage.equalsIgnoreCase("Answer 2.2")) {
                                log.info("Audio-question_2.2 was passed");
                                message.setChatId(chat_id).setText("Опять верно! Ну хорошо, секретное слово для ввода: " +
                                        "Алиса");
                                sendMessage(message);

                                // Второй вопрос пройден. Больше вопросов нет, подсказка возвращается к начальному номеру
                                hint = 1;

                                // Ветка с аудио_2 закончена, возвращаемся
                                isQuestion2 = false;

                            } else if (userMessage.equalsIgnoreCase("подсказка") && hint == 1) {
                                message.setChatId(chat_id).setText("Hint 2.1");
                                sendMessage(message);

                            } else if (userMessage.equalsIgnoreCase("подсказка") && hint == 2) {
                                message.setChatId(chat_id).setText("Hint 2.2");
                                sendMessage(message);

                            } else {
                                message.setChatId(chat_id).setText("Неверно, возможно я ожидаю, что ты напишешь по-другому. " +
                                        "Можешь воспользоваться подсказкой, для этого введи команду \"подсказка\"");
                                sendMessage(message);
                            }

                        } else if (userMessage.equalsIgnoreCase("help")) {
                            log.info("\"help\" command selected.");
                            message.setChatId(chat_id).setText("Введи номер вопроса, на который хочешь " +
                                    "получить подсказку. Напоминаю, что ты можешь использовать только " +
                                    "2 подсказки!");
                            sendMessage(message);

                        } else if (userMessage.equalsIgnoreCase("прошла")) {
                            // ветка прохождения с друзьями, аудио-вопрос

                            log.info("The branch with friends was chosen");

                            message.setChatId(chat_id).setText("Молодец! Неплохо справилась)\n" +
                                    "А мы уже почти закончили. Осталось лишь просмотреть подарок!");
                            sendMessage(message);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            message.setChatId(chat_id).setText("Но чтобы получить на него ссылку, нужно " +
                                    "вписать секретное слово, которым станет ответ на следующий вопрос)");
                            sendMessage(message);

                            // отправляется первый вопрос из аудио_1
                            sendAudio("1.1.mp3", chat_id);

                            // включается ветка, ожидающая ответы на аудио_1
                            isQuestion1 = true;

                        } else if (userMessage.equalsIgnoreCase("идеально")) {
                            // ветка прохождения со мной, аудио-вопрос

                            log.info("The branch with me was chosen");

                            message.setChatId(chat_id).setText("Я знал, что ты справишься на отлично)\n" +
                                    "Держи ссылку:");
                            sendMessage(message);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            message.setChatId(chat_id).setText("Ой, ссылка не находится. Но если ты впишешь " +
                                    "секретное слово, то я смогу ее найти! А секретным словом будет ответ на следующий " +
                                    "вопрос");
                            sendMessage(message);

                            // отправляется первый вопрос из аудио_2
                            sendAudio("2.1.mp3", chat_id);

                            // включается ветка, ожидающая ответы на аудио_2
                            isQuestion2 = true;

                            // ----- ПОДСКАЗКИ -----
                        } else if (userMessage.equals("1") && hintCount < 2) {
                            log.info("Hint_1 was chosen");
                            message.setChatId(chat_id).setText("Hint_1");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("2") && hintCount < 2) {
                            log.info("Hint_2 was chosen");
                            message.setChatId(chat_id).setText("Hint_2");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("3") && hintCount < 2) {
                            log.info("Hint_3 was chosen");
                            message.setChatId(chat_id).setText("Hint_3");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("4") && hintCount < 2) {
                            log.info("Hint_4 was chosen");
                            message.setChatId(chat_id).setText("Hint_4");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("5") && hintCount < 2) {
                            log.info("Hint_5 was chosen");
                            message.setChatId(chat_id).setText("Hint_5");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("6") && hintCount < 2) {
                            log.info("Hint_6 was chosen");
                            message.setChatId(chat_id).setText("Hint_6");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("7") && hintCount < 2) {
                            log.info("Hint_7 was chosen");
                            message.setChatId(chat_id).setText("Hint_7");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("8") && hintCount < 2) {
                            log.info("Hint_8 was chosen");
                            message.setChatId(chat_id).setText("Hint_8");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("9") && hintCount < 2) {
                            log.info("Hint_9 was chosen");
                            message.setChatId(chat_id).setText("Hint_9");
                            sendMessage(message);
                            hintCount++;

                        } else if (userMessage.equals("10") && hintCount < 2) {
                            log.info("Hint_10 was chosen");
                            message.setChatId(chat_id).setText("Hint_10");
                            sendMessage(message);
                            hintCount++;

                        } else if ((userMessage.equals("1") ||
                                userMessage.equals("2") ||
                                userMessage.equals("3") ||
                                userMessage.equals("4") ||
                                userMessage.equals("5") ||
                                userMessage.equals("6") ||
                                userMessage.equals("7") ||
                                userMessage.equals("8") ||
                                userMessage.equals("9") ||
                                userMessage.equals("10")
                                ) && hintCount >= 2) {
                            message.setChatId(chat_id).setText("Ты использовала все подсказки, " +
                                    "догадайся сама)");
                            sendMessage(message);
                            // ----- Конец подсказок -----

                        } else if (userMessage.equalsIgnoreCase("бипа")) {
                            // Концовка 1: видео с друзьями

                            log.info("The ending with friends was chosen");

                            videoCount++;
                            message.setChatId(chat_id).setText("Принято! Лови ссылку)");
                            sendMessage(message);
                            message.setChatId(chat_id).setText("ending_url_with_friends");
                            sendMessage(message);

                            if (videoCount == 2) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                log.info("The special ending was chosen");
                                message.setChatId(chat_id).setText("Тут нашлась еще одна секретная ссылка!");
                                sendMessage(message);
                                message.setChatId(chat_id).setText("ending_url_with_special");
                                sendMessage(message);
                            }

                        } else if (userMessage.equalsIgnoreCase("алиса")) {
                            // Концовка 2: видео со мной

                            log.info("The ending with me was chosen");

                            videoCount++;
                            message.setChatId(chat_id).setText("Верно, держи ссылку)");
                            sendMessage(message);
                            message.setChatId(chat_id).setText("ending_url_with_me");
                            sendMessage(message);

                            if (videoCount == 2) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                log.info("The special ending was chosen");
                                message.setChatId(chat_id).setText("Тут нашлась еще одна секретная ссылка!");
                                sendMessage(message);
                                message.setChatId(chat_id).setText("ending_url_with_special");
                                sendMessage(message);
                            }

                        } else if (userMessage.equalsIgnoreCase("повторить")) {
                            // Пройти тест еще раз
                            log.info("The replay of the story was chosen");

                            message.setChatId(chat_id).setText("Попробуй пройти тест еще раз:");
                            sendMessage(message);
                            message.setChatId(chat_id).setText("url/showForm");
                            sendMessage(message);
                        }
                    }

                } else if (userMessage != null && helper.verify(userMessage)) {
                    // Успешное прохождение авторизации

                    log.info("Verification successful.");
                    // If the user has entered the correct information,
                    // then send the welcome text and the help text.
                    current_chat_id = chat_id;
                    message.setChatId(chat_id).setText(helpText);
                    sendMessage(message);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message.setChatId(chat_id).setText("Первый: на сколько сильно ты меня любишь?\n" +
                            "Кликай правильный вариант;)")
                            .setReplyMarkup(getInlineMessageButtons(1));
                    sendMessage(message);

                } else {
                    // Провал прохождения авторизации

                    log.info("Verification failed");
                    // Or inform that the user entered incorrect data
                    message.setChatId(chat_id).setText("Извини, в доступе отказано.\n" +
                            "Для доступа нужно ввести необходимые данные пользователя.");
                    sendMessage(message);
                }

            } else if (update.hasCallbackQuery()) {
                // Вопросы с кнопками

                CallbackQuery buttonQuery = update.getCallbackQuery();
                SendMessage message = new SendMessage();
                long chat_id = buttonQuery.getMessage().getChatId();

                if (buttonQuery.getData().equals("buttonSoMuch") && !var1) {
                    message.setChatId(chat_id).setText("Ну конечно, так я тебе и поверил)\n" +
                            "Давай, нажимай правильный ответ!");
                    sendMessage(message);

                } else if (buttonQuery.getData().equals("buttonAsEating") && !var1) {
                    message.setChatId(chat_id).setText("А я так и знал!) Ладно, переходим ко " +
                            "второму вопросу.");
                    sendMessage(message);
                    var1 = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message.setChatId(chat_id).setText("Что ты любишь сильнее?")
                            .setReplyMarkup(getInlineMessageButtons(2));
                    sendMessage(message);

                } else if (buttonQuery.getData().equals("buttonEating") && !var2 ||
                        buttonQuery.getData().equals("buttonSleeping") && !var2) {
                    message.setChatId(chat_id).setText("Буууу) Неправильно, здесь есть секретный вариант!\n")
                            .setReplyMarkup(getInlineMessageButtons(3));
                    sendMessage(message);
                    var2 = true;

                } else if (buttonQuery.getData().equals("buttonEatingAndSleeping") && !var3) {
                    message.setChatId(chat_id).setText("Все верно, теперь ты отвечаешь честно!\n" +
                            "\\(^o^)/\n" +
                            "Вот теперь мы можем начать)");
                    sendMessage(message);
                    var3 = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sendPhoto("fun-photo.png", chat_id);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    message.setChatId(chat_id).setText("Для начала перейди по этой ссылке:");
                    sendMessage(message);

                    log.info("The story was started");

                    message.setChatId(chat_id).setText("start_url");
                    sendMessage(message);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    message.setChatId(chat_id).setText("Я постарался адаптировать все под смартфон, но " +
                            "если что-то поплывет, попробуй зайти с компа) Есть вероятность, что если ты " +
                            "просто кликнешь тут по ссылке, то она откроется во встроенном браузере смарта " +
                            "и будет не такой красивой :(\n" +
                            "Зависит от настроек твоего смартфона. Лучше скопируй ее и открой в браузере хрома)");
                    sendMessage(message);

                } else {
                    message.setChatId(chat_id).setText("Мы уже выяснили правильный ответ:Р");
                    sendMessage(message);
                }
            }
        }).start();
    }


    // Method for sending a text message
    private synchronized void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.error("Message failed to send.");
            log.error(e.getMessage());
        }
    }

    // Method for sending the image
    private synchronized void sendPhoto(String name, long chat_id) {
        SendPhoto sendPhoto = new SendPhoto().setChatId(chat_id).setPhoto(
                new File("/app/src/main/resources/appData/" + name)
        );
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.error("Photo failed to send.");
            log.error(e.getMessage());
        }
    }

    private synchronized void sendAudio(String name, long chat_id) {
        SendAudio sendAudio = new SendAudio().setChatId(chat_id).setAudio(
                new File("/app/src/main/resources/appData/" + name)
        );
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.error("Audio failed to send.");
            log.error(e.getMessage());
        }
    }

    private InlineKeyboardMarkup getInlineMessageButtons(int var) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton buttonSoMuch = new InlineKeyboardButton().setText("Очень сильно!");
        InlineKeyboardButton buttonAsEating = new InlineKeyboardButton().setText("Как пожрать!");

        InlineKeyboardButton buttonEating = new InlineKeyboardButton().setText("Пожрать!");
        InlineKeyboardButton buttonSleeping = new InlineKeyboardButton().setText("Поспать!");

        InlineKeyboardButton buttonEatingAndSleeping = new InlineKeyboardButton()
                .setText("Пожрать и поспать (и лучше со мной)!");

        buttonSoMuch.setCallbackData("buttonSoMuch");
        buttonAsEating.setCallbackData("buttonAsEating");

        buttonEating.setCallbackData("buttonEating");
        buttonSleeping.setCallbackData("buttonSleeping");

        buttonEatingAndSleeping.setCallbackData("buttonEatingAndSleeping");

        List<InlineKeyboardButton> keyboardButtonRow = new ArrayList<>();
        if (var == 1) {
            keyboardButtonRow.add(buttonSoMuch);
            keyboardButtonRow.add(buttonAsEating);
        } else if (var == 2) {
            keyboardButtonRow.add(buttonEating);
            keyboardButtonRow.add(buttonSleeping);
        } else if (var == 3) {
            keyboardButtonRow.add(buttonEatingAndSleeping);
        }
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>(1);
        rowList.add(keyboardButtonRow);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    public String getBotUsername() {
        return System.getenv().get("USERNAME");
    }

    public String getBotToken() {
        return System.getenv().get("TOKEN");
    }
}