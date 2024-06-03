package balashov.os.synchronizeratingbot.infrastracure.mapstruct;

import balashov.os.synchronizeratingbot.infrastructure.jpa.mappers.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhotoMapperTest {
    @Autowired
    private PhotoMapper photoMapper;
}