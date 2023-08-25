package com.pkslow.ai;

import com.pkslow.ai.domain.Answer;
import com.pkslow.ai.domain.AnswerStatus;
import com.pkslow.ai.util.NetworkUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class GoogleBardExample {
    public static void main(String[] args) {
        //NetworkUtils.setUpProxy("localhost", "7890");
        String token = "aQgUskUB1uJq0j1WQOtnp8jYgYv1UhTARjcAZVPRlvQo5snuR_DgdhLAh8zGVKDXC_ataw.;sidts-CjEBSAxbGV7bESmZFEyF6UaIJxpSZluF2REUJnzSno3ChCcLD7ePa8ENvUcJki2-cswyEAA";
        AIClient client = new GoogleBardClient(token, Duration.ofMinutes(10));

        printChosenAnswer(client.ask("今天是几号？이 무슨뜻이야?"));
    }

    private static void printChosenAnswer(Answer answer) {
        if (answer.getStatus() == AnswerStatus.OK) {
            log.info("Markdown Output: \n {}", answer.markdown());
        } else {
            log.info("No Answer: {}", answer);
        }
    }
}