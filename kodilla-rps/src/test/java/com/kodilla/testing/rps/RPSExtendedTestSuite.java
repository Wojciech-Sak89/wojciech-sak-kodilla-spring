package com.kodilla.testing.rps;

import com.kodilla.rps.extension.ProcessGame;
import com.kodilla.rps.logic.Player;
import org.junit.*;

import java.util.Random;

public class RPSExtendedTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("PREPARING TO EXECUTE TEST #" + testCounter);
    }

    //Testing method: cpuSetResponse()
    @Test
    public void testCpuSetResponse_PlayerWillWin() {
        //Given
        String winWithLizard1 = "SCISSORS";
        String winWithLizard2 = "ROCK";
        String winWithRock1 = "SPOCK";
        String winWithRock2 = "PAPER";
        String winWithSpock = "LIZARD";

        int optionPlayerWins = 1;

        //When
        String cpuLoses1_1 = ProcessGame.cpuSetResponse(winWithLizard1, optionPlayerWins);
        String cpuLoses1_2 = ProcessGame.cpuSetResponse(winWithLizard2, optionPlayerWins);
        String cpuLoses2_1 = ProcessGame.cpuSetResponse(winWithRock1, optionPlayerWins);
        String cpuLoses2_2 = ProcessGame.cpuSetResponse(winWithRock2, optionPlayerWins);
        String cpuLoses3 = ProcessGame.cpuSetResponse(winWithSpock, optionPlayerWins);

        //Then
            //Player wins
            Assert.assertEquals("LIZARD", cpuLoses1_1);
            Assert.assertEquals("LIZARD", cpuLoses1_2);
            Assert.assertEquals("ROCK", cpuLoses2_1);
            Assert.assertEquals("ROCK", cpuLoses2_2);
            Assert.assertEquals("SPOCK", cpuLoses3);

    }

    @Test
    public void testCpuSetResponse_CPUWillWin() {
        //Given
        Random random = new Random();

        String loseWithSpock1 = "SCISSORS";
        String loseWithSpock2 = "ROCK";
        String loseWithLizard1 = "SPOCK";
        String loseWithLizard2 = "PAPER";
        String loseWithScissors = "LIZARD";

        int optionCPUWins = random.nextInt(2) + 3; // 3 or 4

        //When

        String cpuWins1_1 = ProcessGame.cpuSetResponse(loseWithSpock1, optionCPUWins);
        String cpuWins1_2 = ProcessGame.cpuSetResponse(loseWithSpock2, optionCPUWins);
        String cpuWins2_1 = ProcessGame.cpuSetResponse(loseWithLizard1, optionCPUWins);
        String cpuWins2_2 = ProcessGame.cpuSetResponse(loseWithLizard2, optionCPUWins);
        String cpuWins3 = ProcessGame.cpuSetResponse(loseWithScissors, optionCPUWins);

        //Then
        Assert.assertEquals("SPOCK", cpuWins1_1);
        Assert.assertEquals("SPOCK", cpuWins1_2);
        Assert.assertEquals("LIZARD", cpuWins2_1);
        Assert.assertEquals("LIZARD", cpuWins2_2);
        Assert.assertEquals("SCISSORS", cpuWins3);
    }

    @Test
    public void testCpuSetResponse_Draw() {
        //Given
        String makeADraw = "CPUShouldMakeSameResponse";
        int optionDraw = 2;

        //When
        String draw = ProcessGame.cpuSetResponse(makeADraw, optionDraw);

        //Then
        Assert.assertEquals("CPUShouldMakeSameResponse", draw);
    }

    @Test
    public void testCpuSetResponse_InvalidInput() {
        //Given
        String invalidInput = "something";
        int optionPlayerWins = 1;

        //When
        String invalid = ProcessGame.cpuSetResponse(invalidInput, optionPlayerWins);

        //Then
        Assert.assertEquals("Invalid CPU response!", invalid);
    }

    //Testing method: choiceName()
    @Test
    public void testChoiceName_Weapon() {
        //Given
        String rock = "rOcK";
        String rockDigit = "1";
        String paper = "PAPer";
        String paperDigit = "2";
        String scissors = "scissors";
        String scissorsDigit = "3";
        String spock = "spOck";
        String spockDigit = "4";
        String lizard = "LIZaRD";
        String lizardDigit = "5";

        //When
        String testRock = ProcessGame.choiceName(rock);
        String testRockDigit = ProcessGame.choiceName(rockDigit);
        String testPaper = ProcessGame.choiceName(paper);
        String testPaperDigit = ProcessGame.choiceName(paperDigit);
        String testScissors = ProcessGame.choiceName(scissors);
        String testScissorsDigit = ProcessGame.choiceName(scissorsDigit);
        String testSpock = ProcessGame.choiceName(spock);
        String testSpockDigit = ProcessGame.choiceName(spockDigit);
        String testLizard = ProcessGame.choiceName(lizard);
        String testLizardDigit = ProcessGame.choiceName(lizardDigit);

        //Then
        Assert.assertEquals("ROCK", testRock);
        Assert.assertEquals("ROCK", testRockDigit);
        Assert.assertEquals("PAPER", testPaper);
        Assert.assertEquals("PAPER", testPaperDigit);
        Assert.assertEquals("SCISSORS", testScissors);
        Assert.assertEquals("SCISSORS", testScissorsDigit);
        Assert.assertEquals("SPOCK", testSpock);
        Assert.assertEquals("SPOCK", testSpockDigit);
        Assert.assertEquals("LIZARD", testLizard);
        Assert.assertEquals("LIZARD", testLizardDigit);
    }

    @Test
    public void testChoiceName_Menu() {
        //Given
        String quit = "x";
        String newGame = "n";
        String controls = "c";
        String help = "h";

        //When
        String testQuit = ProcessGame.choiceName(quit);
        String testNewGame = ProcessGame.choiceName(newGame);
        String testControls = ProcessGame.choiceName(controls);
        String testHelp = ProcessGame.choiceName(help);

        //Then
        Assert.assertEquals("x", testQuit);
        Assert.assertEquals("n", testNewGame);
        Assert.assertEquals("c", testControls);
        Assert.assertEquals("h", testHelp);
    }

    @Test
    public void testChoiceName_InvalidInput() {
        //Given
        String invalid = "someInvalidInput";

        //When
        String testInvalid = ProcessGame.choiceName(invalid);

        //Then
        Assert.assertEquals("Invalid choice!", testInvalid);
    }

    //Testing method: whoWinsTheRound()
    @Test
    public void testWhoWinsTheRound_PlayerWins() {
        //Given
        Player player = new Player("PlayerOne");

        String inputPlayerRock = "ROCK";
        String inputPlayerPaper = "PAPER";
        String inputPlayerScissors = "SCISSORS";
        String inputPlayerSpock = "SPOCK";
        String inputPlayerLizard = "LIZARD";

        String inputCPURock = "ROCK";
        String inputCPUPaper = "PAPER";
        String inputCPUScissors = "SCISSORS";
        String inputCPUSpock = "SPOCK";
        String inputCPULizard = "LIZARD";

        //When
        String playerWins1 = ProcessGame.whoWinsTheRound(inputPlayerRock, inputCPUScissors, player);
        String playerWins2 = ProcessGame.whoWinsTheRound(inputPlayerRock, inputCPULizard, player);
        String playerWins3 = ProcessGame.whoWinsTheRound(inputPlayerPaper, inputCPURock, player);
        String playerWins4 = ProcessGame.whoWinsTheRound(inputPlayerPaper, inputCPUSpock, player);
        String playerWins5 = ProcessGame.whoWinsTheRound(inputPlayerScissors, inputCPUPaper, player);
        String playerWins6 = ProcessGame.whoWinsTheRound(inputPlayerScissors, inputCPULizard, player);
        String playerWins7 = ProcessGame.whoWinsTheRound(inputPlayerSpock, inputCPUScissors, player);
        String playerWins8 = ProcessGame.whoWinsTheRound(inputPlayerSpock, inputCPURock, player);
        String playerWins9 = ProcessGame.whoWinsTheRound(inputPlayerLizard, inputCPUPaper, player);
        String playerWins10 = ProcessGame.whoWinsTheRound(inputPlayerLizard, inputCPUSpock, player);

        //Then
        Assert.assertEquals("playerWins", playerWins1);
        Assert.assertEquals("playerWins", playerWins2);
        Assert.assertEquals("playerWins", playerWins3);
        Assert.assertEquals("playerWins", playerWins4);
        Assert.assertEquals("playerWins", playerWins5);
        Assert.assertEquals("playerWins", playerWins6);
        Assert.assertEquals("playerWins", playerWins7);
        Assert.assertEquals("playerWins", playerWins8);
        Assert.assertEquals("playerWins", playerWins9);
        Assert.assertEquals("playerWins", playerWins10);

    }

    @Test
    public void testWhoWinsTheRound_CPUWins() {
        //Given
        Player player = new Player("PlayerOne");

        String inputCPURock = "ROCK";
        String inputCPUPaper = "PAPER";
        String inputCPUScissors = "SCISSORS";
        String inputCPUSpock = "SPOCK";
        String inputCPULizard = "LIZARD";

        String inputPlayerRock = "ROCK";
        String inputPlayerPaper = "PAPER";
        String inputPlayerScissors = "SCISSORS";
        String inputPlayerSpock = "SPOCK";
        String inputPlayerLizard = "LIZARD";

        //When
        String cpuWins1 = ProcessGame.whoWinsTheRound(inputPlayerScissors, inputCPURock, player);
        String cpuWins2 = ProcessGame.whoWinsTheRound(inputPlayerLizard, inputCPURock, player);
        String cpuWins3 = ProcessGame.whoWinsTheRound(inputPlayerRock, inputCPUPaper, player);
        String cpuWins4 = ProcessGame.whoWinsTheRound(inputPlayerSpock, inputCPUPaper, player);
        String cpuWins5 = ProcessGame.whoWinsTheRound(inputPlayerPaper, inputCPUScissors, player);
        String cpuWins6 = ProcessGame.whoWinsTheRound(inputPlayerLizard, inputCPUScissors, player);
        String cpuWins7 = ProcessGame.whoWinsTheRound(inputPlayerScissors, inputCPUSpock, player);
        String cpuWins8 = ProcessGame.whoWinsTheRound(inputPlayerRock, inputCPUSpock, player);
        String cpuWins9 = ProcessGame.whoWinsTheRound(inputPlayerPaper, inputCPULizard, player);
        String cpuWins10 = ProcessGame.whoWinsTheRound(inputPlayerSpock, inputCPULizard, player);

        //Then
        Assert.assertEquals("CPUWins", cpuWins1);
        Assert.assertEquals("CPUWins", cpuWins2);
        Assert.assertEquals("CPUWins", cpuWins3);
        Assert.assertEquals("CPUWins", cpuWins4);
        Assert.assertEquals("CPUWins", cpuWins5);
        Assert.assertEquals("CPUWins", cpuWins6);
        Assert.assertEquals("CPUWins", cpuWins7);
        Assert.assertEquals("CPUWins", cpuWins8);
        Assert.assertEquals("CPUWins", cpuWins9);
        Assert.assertEquals("CPUWins", cpuWins10);
    }

    @Test
    public void testWhoWinsTheRound_Draw() {
        //Given
        Player player = new Player("PlayerOne");

        String inputCPU = "anything";
        String inputPlayer = "anything";

        //When
        String testDraw = ProcessGame.whoWinsTheRound(inputPlayer, inputCPU, player);

        //Then
        Assert.assertEquals("draw", testDraw);

    }
}
