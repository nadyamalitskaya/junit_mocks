package com.nixsolutions.mocks;

import java.io.*;

public class Program {

    private String coordinateFilePath;
    private Robot robot = new Robot();
    private StringBuilder path = new StringBuilder();

    public Program() {
    }

    public Program(String coordinateFilePath) {
        this.coordinateFilePath = coordinateFilePath;
    }

    public void setCoordinateFilePath(String coordinatesPath) {
        this.coordinateFilePath = coordinatesPath;
    }

    private void setInitialPath() {
        path.append("0.0");
    }

    public void generateCoordinates(String navigation) {
        navigation = navigation.replace("\u0000", "");
        setInitialPath();
        for (int i = 0; i < navigation.length(); i++) {
            switch (navigation.charAt(i)) {
            case 'l': {
                robot.setTurnLeft(true);
                robot.setTurnRight(false);
                break;
            }
            case 'r': {
                robot.setTurnLeft(false);
                robot.setTurnRight(true);
                break;
            }
            case 'f': {
                robot.stepForward();
                path.append(" ").append(robot.getxCoordinate());
            }
            }
        }
        PrintWriter pw;
        try (FileWriter fileWriter = new FileWriter(coordinateFilePath)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            pw = new PrintWriter(bufferedWriter);
            pw.print(path.toString());
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readCoordinatesFromFile(String coordinateFilePath) {
        StringBuilder coordinates = new StringBuilder();
        try (FileReader fileReader = new FileReader(coordinateFilePath)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                coordinates.append(string);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return coordinates.toString();
    }
}
