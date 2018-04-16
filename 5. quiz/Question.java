package com.android.amrit.quizapp;

public class Question {

    public String questions[] = {"Which one of the following is the first fully supported 64-bit operating system?",
            "Computer Hard Disk was first introduced in 1956 by","Which protocol is used to send e-mail?"
    };

    public String choices[][] = {{"Windows Vista", "Linux", "Mac", "Windows XP"},
            {"Dell", "Apple", "Microsoft", "IBM"},{"HTTP", "POP3", "SMTP", "SSH"}
    };

    public String correctAnswer[] = {"Linux","IBM","SMTP"};

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
