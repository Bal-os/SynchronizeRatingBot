package balashov.os.synchronizeratingbot.core.studparties;

import balashov.os.synchronizeratingbot.core.events.events.ports.usecases.CreateEventDescription;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases.GetActualLink;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class CreateEventDescriptionService implements CreateEventDescription {
    private final GetActualLink getActualLink;
    private StringBuilder descriptionBuilder;
    private int organizersCount;
    private boolean isCharity;
    private boolean isFree;

    public void clear() {
        descriptionBuilder = new StringBuilder();
        organizersCount = 0;
        isCharity = false;
        isFree = false;
    }

    public void addTitle(String title) {
        descriptionBuilder.append("[").append(title).append("]");
    }

    public void addLink(String link) {
        descriptionBuilder.append("(").append(link).append(")");
    }

    public void addEventDate(LocalDate date) {
        var dateString = date.format(new DateTimeFormatterBuilder().appendPattern("dd\\.MM").toFormatter());
        descriptionBuilder.append("\n\n").append(dateString);
    }

    public void addEventTime(LocalTime time) {
        var timeString = time.format(new DateTimeFormatterBuilder().appendPattern("HH:mm").toFormatter());
        descriptionBuilder.append(" о ").append(timeString); // "at" in Ukrainian
    }

    public void addOrganizer(OrganizerDto organizer) {
        var organizerLink = getActualLink.getActualLink(organizer);

        this.organizersCount++;

        StringBuilder separatorBuilder = new StringBuilder();
        if (organizersCount == 1) {
            separatorBuilder.append(" від: "); // "by" in Ukrainian
        } else if (organizersCount == 2) {
            separatorBuilder.append("та "); // "and" in Ukrainian
        } else {
            separatorBuilder.append(", "); // Comma for the rest of the organizers
        }

        descriptionBuilder.append(separatorBuilder).append(getLink(organizer.name(), organizerLink));
    }

    public void addTicketLink(String ticketLink) {
        if (ticketLink.isEmpty()) {
            return;
        }

        String ticketType;
        if (isFree) {
            ticketType = "Реєстрація"; // Registration
        } else {
            ticketType = "Квиточки"; // Tickets
            if (isCharity) {
                ticketType += " за донат"; // Tickets for donation
            }
        }

        boolean isUserLink = ticketLink.startsWith("@");
        descriptionBuilder.append("\n")
                .append(isUserLink ? "" : "[") // External link has brackets
                .append(ticketType)
                .append(isUserLink ? ": " : "](") // Add brackets only for external links
                .append(ticketLink)
                .append(isUserLink ? "" : ")"); // User link has no brackets
    }

    public void addLocation(LocationDto location) {
        descriptionBuilder.append(" в ").append(getLink(location.name(), location.googleMapsLink())).append("\n");
    }

    public void addIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public void addIsCharity(Boolean isCharity) {
        this.isCharity = isCharity;
    }

    public void addAdditionalInfo(String info) {
        descriptionBuilder.append(" ").append("\\(").append(info).append("\\)");
    }

    public String getDescription() {
        return descriptionBuilder.toString();
    }

    private String getLink(String nameOfLink, String link) {
        return "[%s](%s)".formatted(nameOfLink, link);
    }
}
