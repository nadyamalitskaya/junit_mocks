package com.nixsolutons.mocks;

import com.nixsolutions.mocks.Program;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class) public class ProgramMockTest {
    private Program program = new Program();

    private File mockedCoordinateFile = Mockito.mock(File.class);

    @Test public void shouldCalculateRightCoordinates() {
        // given
        when(mockedCoordinateFile.getPath())
                .thenReturn("testingCoordinates.txt");
        String rightAnswerCoordinates = "0.0 -0.1 -0.2 -0.1 -0.2 -0.1 0.0 0.1";

        // when
        program.setCoordinateFilePath(mockedCoordinateFile.getPath());
        program.generateCoordinates("lffrflfrrfff");
        String testCoordinates = program
                .readCoordinatesFromFile(mockedCoordinateFile.getPath()).trim();
        // then
        assertEquals(rightAnswerCoordinates, testCoordinates);
    }

    @After public void deleteMockFile() throws IOException {
        Files.deleteIfExists(Paths.get(mockedCoordinateFile.getPath()));
    }
}
