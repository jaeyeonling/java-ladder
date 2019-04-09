package ladder;

import java.util.List;
import java.util.stream.IntStream;

import static ladder.PlayerName.MAXIMUM_NAME_LENGTH;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        points.forEach(point -> str.append(changePointToString(point)).append("|"));

        return String.valueOf(str);
    }

    private String changePointToString(Boolean point) {
        String str = " ";
        if (point) {
            str = "-";
        }
        StringBuilder stringBuilder = makePrintLadderLine(str);
        return String.valueOf(stringBuilder);
    }

    private StringBuilder makePrintLadderLine(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, MAXIMUM_NAME_LENGTH)
            .mapToObj(length -> str)
            .forEach(stringBuilder::append);
        return stringBuilder;
    }
}