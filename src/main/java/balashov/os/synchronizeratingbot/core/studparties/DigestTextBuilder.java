package balashov.os.synchronizeratingbot.core.studparties;

import balashov.os.synchronizeratingbot.core.eventposts.ports.usecases.GetMessageLinkForEventPost;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases.GetActualLink;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class DigestTextBuilder {
    private final List<String> emojis = List.of("🦄", "🐒", "🤯", "🤗", "😱", "🙄", "🫶", "🤭", "😈", "😘", "🫀", "🤷‍♀️", "👀", "⚡️", "😎", "♥️");
    private final GetMessageLinkForEventPost getMessageLink;
    private final GetActualLink getActualLink;
    private StringBuilder digestBuilder;

    @PostConstruct
    public void clear() {
        digestBuilder = new StringBuilder();
    }

    public void addTitle(LocalDate date) {
        String emoji = getRandomEmoji();
        String title = "||" + getDayOfTheWeek(date) + "||" + " вечірок";
        digestBuilder.append("Дайджест").append(emoji).append("\n\n").append(title).append("\n");
    }

    public void addTitle(LocalDate firstDate, LocalDate lastDate) {
        String emoji = getRandomEmoji();
        String title = switch (firstDate.getDayOfWeek()) {
            case MONDAY -> "Найважливіші заходи тижня";
            case FRIDAY -> "Найцікавіші вечірки вихідних";
            case SATURDAY -> "Найкрутіші туси вікенду";
            default -> "Цікаві вечірки найближчих днів";
        };
        digestBuilder.append("Дайджест").append(emoji).append("\n\n").append(title).append("\n");
    }

    public void addEventDay(LocalDate date) {
        digestBuilder.append("\n")
                .append(getDayOfTheWeek(date))
                .append(" (")
                .append(date.format(DateTimeFormatter.ofPattern("dd.MM")))
                .append(")")
                .append(getRandomEmoji())
                .append("\n\n");
    }

    public void addEvent(EventDto event) {
        StringBuilder organizersBuilder = new StringBuilder();
        for (OrganizerDto organizer : event.organizers()) {
            if (!organizersBuilder.isEmpty()) {
                organizersBuilder.append(", ");
            }
            organizersBuilder.append("[").append(organizer.name()).append("]");

            var link = getActualLink.getActualLink(organizer);
            organizersBuilder.append("(").append(link).append(")");
        }

        digestBuilder.append("◽️ ").append("[").append(event.title()).append("]")
                .append("(").append(event.link()).append(")")
                .append(" від ").append(organizersBuilder)
                .append(" о ").append(event.time().format(DateTimeFormatter.ofPattern("HH:mm"))).append(" в ")
                .append("[").append(event.location().name()).append("]")
                .append("(").append(event.location().googleMapsLink()).append(")")
                .append("[\\(пост\\)]").append("(").append(getMessageLink.getMessageLink(event)).append(")")
                .append("\\(").append(event.additionalInfo()).append("\\)").append("\n");
    }

    public String getDigestText() {
        return digestBuilder.toString();
    }

    private String getRandomEmoji() {
        Random random = new Random();
        return emojis.get(random.nextInt(emojis.size()));
    }

    private String getDayOfTheWeek(LocalDate date) {
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("uk"));
        return dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1);
    }
}
