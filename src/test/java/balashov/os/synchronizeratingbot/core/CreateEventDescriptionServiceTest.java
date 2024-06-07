package balashov.os.synchronizeratingbot.core;

import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases.GetActualLink;
import balashov.os.synchronizeratingbot.core.studparties.CreateEventDescriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreateEventDescriptionServiceTest {

    @Mock
    private GetActualLink getActualLink;

    private CreateEventDescriptionService createEventDescriptionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        createEventDescriptionService = new CreateEventDescriptionService(getActualLink);
        createEventDescriptionService.clear();
    }

    @Test
    public void testClear() {
        createEventDescriptionService.addTitle("Test Title");

        createEventDescriptionService.clear();

        String description = createEventDescriptionService.getDescription();
        assertEquals("", description);
    }

    @Test
    public void testAddTitle() {
        String expectedTitle = "Test Title";

        createEventDescriptionService.addTitle(expectedTitle);

        String description = createEventDescriptionService.getDescription();
        assertTrue(description.contains("[" + expectedTitle + "]"));
    }

    @Test
    public void testAddLink() {
        String expectedLink = "https://test-link.com";

        createEventDescriptionService.addLink(expectedLink);

        String description = createEventDescriptionService.getDescription();
        assertTrue(description.contains("(" + expectedLink + ")"));
    }

    @Test
    public void testAddEventDate() {
        LocalDate expectedDate = LocalDate.of(2022, 12, 31);

        createEventDescriptionService.addEventDate(expectedDate);

        String description = createEventDescriptionService.getDescription();
        assertTrue(description.contains("\n\n" + expectedDate.format(DateTimeFormatter.ofPattern("dd\\.MM"))));
    }

    @Test
    public void testAddEventTime() {
        LocalTime expectedTime = LocalTime.of(23, 59);

        createEventDescriptionService.addEventTime(expectedTime);

        String description = createEventDescriptionService.getDescription();
        assertTrue(description.contains(" о " + expectedTime.format(DateTimeFormatter.ofPattern("HH:mm"))));
    }

    @Test
    public void testAddOrganizer() {
        OrganizerDto organizer = OrganizerDto.builder()
                .name("Test Organizer")
                .instagramLink("https://instagram.com")
                .build();

        String expectedLink = "https://actual-link.com";
        when(getActualLink.getActualLink(organizer)).thenReturn(expectedLink);

        createEventDescriptionService.clear();

        createEventDescriptionService.addOrganizer(organizer);

        String description = createEventDescriptionService.getDescription();
        assertTrue(description.contains("[" + organizer.name() + "]"));
        assertTrue(description.contains("(" + expectedLink + ")"));
    }

    @Test
    public void testAddTicketLink() {
        String expectedTicketLink = "https://tickets.com";
        createEventDescriptionService.addIsFree(false);
        createEventDescriptionService.addIsCharity(false);

        createEventDescriptionService.addTicketLink(expectedTicketLink);

        String description = createEventDescriptionService.getDescription();
        assertTrue(description.contains("\n[Квиточки](" + expectedTicketLink + ")"));
    }

    @Test
    public void testAddLocation() {
        LocationDto location = LocationDto.builder()
                .name("Test Location")
                .googleMapsLink("https://google-maps.com")
                .build();

        createEventDescriptionService.addLocation(location);

        String description = createEventDescriptionService.getDescription();
        assertTrue(description.contains("[" + location.name() + "](" + location.googleMapsLink() + ")\n"));
    }

    @Test
    public void testCreateEventDescription() {
        String expectedTitle = "Jungle Dynamica";
        String expectedLink = "https://t.me/dynamicafoundation/188";
        String expectedTicketLink = "@tickets";
        String expectedDescription = """
        [%s](%s)
        
        19\\.04 о 17:00 в [Otel’](https://maps.app.goo.gl/QhE9nHmJpCdCahP7A)
        
        Квиточки: %s""".formatted(expectedTitle, expectedLink, expectedTicketLink);
        var location = LocationDto.builder()
                .name("Otel’")
                .googleMapsLink("https://maps.app.goo.gl/QhE9nHmJpCdCahP7A")
                .build();

        createEventDescriptionService.clear();

        createEventDescriptionService.addTitle(expectedTitle);
        createEventDescriptionService.addLink(expectedLink);
        createEventDescriptionService.addEventDate(LocalDate.of(2023, 4, 19));
        createEventDescriptionService.addEventTime(LocalTime.of(17, 0));
        createEventDescriptionService.addLocation(location);
        createEventDescriptionService.addIsFree(false);
        createEventDescriptionService.addIsCharity(false);
        createEventDescriptionService.addTicketLink(expectedTicketLink);

        String description = createEventDescriptionService.getDescription();

        assertEquals(expectedDescription, description);
    }
}
