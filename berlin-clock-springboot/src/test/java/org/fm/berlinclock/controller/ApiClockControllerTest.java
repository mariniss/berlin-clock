package org.fm.berlinclock.controller;

import org.fm.berlinclock.model.BerlinTimeModel;
import org.fm.berlinclock.service.TimeRepresentationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiClockControllerTest {

    @MockBean
    private TimeRepresentationService timeRepresentationServiceMock;

    @Autowired
    private ApiClockController controller;

    @Test
    public void getBerlinRepresentationTest() {
        BerlinTimeModel model = new BerlinTimeModel();
        given(this.timeRepresentationServiceMock.getBerlinRepresentation(anyObject())).willReturn(model);

        BerlinTimeModel result = controller.getBerlinTimeRepresentation();
        assertThat(result).isEqualTo(model);
    }

}
