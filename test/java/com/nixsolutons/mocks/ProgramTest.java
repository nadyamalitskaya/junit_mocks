package com.nixsolutons.mocks;

import com.nixsolutions.mocks.Program;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ProgramTest {
    private Program program = new Program();
    @Rule public TemporaryFolder folder = new TemporaryFolder();

    @Test public void shouldFillFileWithRightCoordinates() throws IOException {
        // given
        File coordinates = folder.newFile("testCoordinate.txt");
        String rightAnswerCoordinates = "0.0 -0.1 -0.2 -0.1 -0.2 -0.1 0.0 0.1";

        // when
        program.setCoordinateFilePath(coordinates.getPath());
        program.generateCoordinates("lffrflfrrfff");

        // then
        assertEquals(rightAnswerCoordinates,
                program.readCoordinatesFromFile(coordinates.getPath()));
    }
}
