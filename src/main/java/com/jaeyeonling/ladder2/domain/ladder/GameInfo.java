package com.jaeyeonling.ladder2.domain.ladder;

import com.jaeyeonling.ladder2.domain.Index;
import com.jaeyeonling.ladder2.domain.reword.LadderReword;
import com.jaeyeonling.ladder2.domain.reword.LadderRewords;
import com.jaeyeonling.ladder2.domain.user.Username;
import com.jaeyeonling.ladder2.domain.user.Users;
import com.jaeyeonling.ladder2.exception.NotEqualsUserSizeAndRewordSizeException;
import com.jaeyeonling.ladder2.view.StringVisualizable;

import java.util.stream.IntStream;

public class GameInfo implements StringVisualizable {

    private final Users users;
    private final LadderRewords ladderRewords;

    private GameInfo(final Users users,
                     final LadderRewords ladderRewords) {
        this.users = users;
        this.ladderRewords = ladderRewords;
    }

    static GameInfo with(final Users users,
                         final LadderRewords ladderRewords) {
        if (users.size() != ladderRewords.size()) {
            throw new NotEqualsUserSizeAndRewordSizeException(users.size(), ladderRewords.size());
        }

        return new GameInfo(users, ladderRewords);
    }

    @Override
    public String visualize() {
        return users.visualize() + "\n%s\n" + ladderRewords.visualize();
    }

    IntStream range() {
        return IntStream.range(0, users.size());
    }

    Username findUsernameBy(final Index index) {
        return users.findUsernameBy(index.getIndex());
    }

    LadderReword findLadderRewordBy(final Index index) {
        return ladderRewords.findLadderRewordBy(index.getIndex());
    }
}